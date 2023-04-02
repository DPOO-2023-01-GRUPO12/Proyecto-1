package console;

import java.lang.reflect.GenericDeclaration;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Cargador;
import model.Consumo;
import model.Factura;
import model.Grupo;
import model.Habitacion;
import model.Huesped;
import model.InformacionHotel;
import model.Reserva;
import model.Tarifa;
import model.TarifaCuarto;
import model.TipoHabitacion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MenuRecepcionista {
    private Cargador cargador;
    private InformacionHotel informacionHotel;

    public MenuRecepcionista(Cargador car, InformacionHotel info){
        cargador = car;
        informacionHotel = info;
    }

    public void consultarInventarioHabitaciones(){
        Map<String, Habitacion> inventario = informacionHotel.getInventarioHabitaciones();
        for(Map.Entry<String,Habitacion> entry: informacionHotel.getInventarioHabitaciones().entrySet()){
            entry.getValue().toString();
        }

    }

    public Reserva RealizarReservaHuesped(Huesped huesped, int cantidad, String fechaIn, String fechaOut){
        Reserva reserva = new Reserva(huesped, cantidad, fechaIn, fechaOut);
        return reserva;
    }

    public Huesped realizarRegistro(String nombre, String documento, String celular, String correo, int edad){
        Huesped huesped = new Huesped(nombre, documento, celular, correo, edad);
        return huesped;
    }

    public double configurarTarifaTotal(String fechaIn, String fechaOut, int cantidadHues,Reserva res) throws ParseException{
        String rangoString = fechaIn.trim() + "-" + fechaOut.trim();
        
        TimeUnit time = TimeUnit.DAYS; 
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        
        double tarifaTotal = 0;
        long dife;
        int difeTarifaDias;

        for(Map.Entry<String,Habitacion> entry: informacionHotel.getInventarioHabitaciones().entrySet()){
            Habitacion habitacion = entry.getValue();
            boolean dispon = habitacion.hasDisponibilidad();
            TipoHabitacion tipo = habitacion.getTipoHabitacion();
            int cantidadPersonas = habitacion.getCapacidad();
            ArrayList<TarifaCuarto> tarifas = tipo.getTarifas();
            Calendar calendario= new GregorianCalendar();

            Date inicioReserva = formato.parse(fechaIn);
            calendario.setTime(inicioReserva);

            Calendar calendario2= new GregorianCalendar();

            Date finReserva = formato.parse(fechaOut);
            calendario2.setTime(finReserva);



            long cantidadTiempo = inicioReserva.getTime()-finReserva.getTime();
            int cantidadDias = (int) time.convert(cantidadTiempo, TimeUnit.MILLISECONDS);

            for(TarifaCuarto tar: tarifas){
                String rangoFechas = tar.getRangoFechas();
                String[] fechas = rangoFechas.split("-");
                String fechaInTarifa = fechas[0];
                fechaInTarifa = fechaInTarifa.trim();
                fechaInTarifa = fechaInTarifa.replace("de ", "");
                fechaInTarifa = fechaInTarifa.replace(" ", "/");
                String fechaFinTarifa = fechas[1];
                fechaFinTarifa = fechaFinTarifa.trim();
                fechaFinTarifa = fechaFinTarifa.replace("de ", "");
                fechaFinTarifa = fechaFinTarifa.replace(" ", "/");

                

                Date inicioTarifa = formato.parse(fechaInTarifa);
                Date finTarifa = formato.parse(fechaFinTarifa);
                long difeTarifaTiempo = finTarifa.getTime()-inicioTarifa.getTime();
                difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);

                if(!habitacion.getFechasBloqueadas().contains(rangoString)){
                    if(cantidadPersonas>=cantidadHues){
                        if(inicioTarifa.compareTo(inicioReserva)<0){
                            if(finTarifa.compareTo(finReserva)>0){
                                tarifaTotal = tar.getValor()*cantidadDias;
                                habitacion.agregarFechaBloqueada(rangoString);
                                res.agregarHabitacion(habitacion);
                                return tarifaTotal;
                            } else if(finTarifa.compareTo(finReserva)==0) {
                                tarifaTotal = tar.getValor()*cantidadDias;
                                habitacion.agregarFechaBloqueada(rangoString);
                                res.agregarHabitacion(habitacion);
                                return tarifaTotal;
                            } else{
                                dife = finTarifa.getTime()-inicioReserva.getTime();
                                difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                                tarifaTotal+=tar.getValor()*difeTarifaDias;
                                cantidadDias-=(difeTarifaDias+1);
                                calendario.add(Calendar.DATE,difeTarifaDias+1);
                                inicioReserva = calendario.getTime();
                                
                            }
                        } else if(inicioTarifa.compareTo(inicioReserva)==0){
                            if(finTarifa.compareTo(finReserva)>0){
                                tarifaTotal = tar.getValor()*cantidadDias;
                                habitacion.agregarFechaBloqueada(rangoString);
                                res.agregarHabitacion(habitacion);
                                return tarifaTotal;
                            } else if(finTarifa.compareTo(finReserva)==0) {
                                tarifaTotal = tar.getValor()*cantidadDias;
                                habitacion.agregarFechaBloqueada(rangoString);
                                res.agregarHabitacion(habitacion);
                                return tarifaTotal;
                            } else{
                                dife = finTarifa.getTime()-inicioTarifa.getTime();
                                difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                                tarifaTotal+=tar.getValor()*difeTarifaDias;
                                cantidadDias-=(difeTarifaDias+1);
                                calendario.add(Calendar.DATE,difeTarifaDias+1);
                                inicioReserva = calendario.getTime();
                                
                            }
                        } else{ //inicioTarifa.compareTo(inicioReserva)>0
                            if(finTarifa.compareTo(finReserva)>0){
                                dife = finReserva.getTime()-inicioTarifa.getTime();
                                difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                                tarifaTotal+=tar.getValor()*difeTarifaDias;
                                cantidadDias-=(difeTarifaDias+1);
                                calendario2.add(Calendar.DATE,-(difeTarifaDias+1));
                                finReserva = calendario2.getTime();
                                
                                
                            } else if(finTarifa.compareTo(finReserva)==0) {
                                dife = finReserva.getTime()-inicioTarifa.getTime();
                                difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                                tarifaTotal+=tar.getValor()*difeTarifaDias;
                                cantidadDias-=(difeTarifaDias+1);
                                calendario2.add(Calendar.DATE,-(difeTarifaDias+1));
                                finReserva = calendario2.getTime();
                            } else{
                                dife = finTarifa.getTime()-inicioTarifa.getTime();
                                difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                                tarifaTotal+=tar.getValor()*difeTarifaDias;
                                //TODO: raro
                            }
                        }
                    } else{
                        if(inicioTarifa.compareTo(inicioReserva)<0){
                            if(finTarifa.compareTo(finReserva)>0){
                                tarifaTotal+=tar.getValor()*cantidadDias;
                                cantidadHues-=cantidadPersonas;
                                habitacion.agregarFechaBloqueada(rangoString);
                                res.agregarHabitacion(habitacion);
                                break;
                            } else if(finTarifa.compareTo(finReserva)==0) {
                                tarifaTotal+=tar.getValor()*cantidadDias;
                                cantidadHues-=cantidadPersonas;
                                habitacion.agregarFechaBloqueada(rangoString);
                                res.agregarHabitacion(habitacion);
                                break;
                            } else{
                                dife = finTarifa.getTime()-inicioReserva.getTime();
                                difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                                tarifaTotal+=tar.getValor()*difeTarifaDias;
                                cantidadDias-=(difeTarifaDias+1);
                                calendario.add(Calendar.DATE,difeTarifaDias+1);
                                inicioReserva = calendario.getTime();
                                
                            }
                        } else if(inicioTarifa.compareTo(inicioReserva)==0){
                            if(finTarifa.compareTo(finReserva)>0){
                                tarifaTotal+=tar.getValor()*cantidadDias;
                                cantidadHues-=cantidadPersonas;
                                habitacion.agregarFechaBloqueada(rangoString);
                                res.agregarHabitacion(habitacion);
                                break;
                            } else if(finTarifa.compareTo(finReserva)==0) {
                                tarifaTotal+=tar.getValor()*cantidadDias;
                                cantidadHues-=cantidadPersonas;
                                habitacion.agregarFechaBloqueada(rangoString);
                                res.agregarHabitacion(habitacion);
                                break;
                            } else{
                                dife = finTarifa.getTime()-inicioTarifa.getTime();
                                difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                                tarifaTotal+=tar.getValor()*difeTarifaDias;
                                cantidadDias-=(difeTarifaDias+1);
                                calendario.add(Calendar.DATE,difeTarifaDias+1);
                                inicioReserva = calendario.getTime();
                                
                            }
                        } else{ //inicioTarifa.compareTo(inicioReserva)>0
                            if(finTarifa.compareTo(finReserva)>0){
                                dife = finReserva.getTime()-inicioTarifa.getTime();
                                difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                                tarifaTotal+=tar.getValor()*difeTarifaDias;
                                cantidadDias-=(difeTarifaDias+1);
                                calendario2.add(Calendar.DATE,-(difeTarifaDias+1));
                                finReserva = calendario2.getTime();
                                
                                
                            } else if(finTarifa.compareTo(finReserva)==0) {
                                dife = finReserva.getTime()-inicioTarifa.getTime();
                                difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                                tarifaTotal+=tar.getValor()*difeTarifaDias;
                                cantidadDias-=(difeTarifaDias+1);
                                calendario2.add(Calendar.DATE,-(difeTarifaDias+1));
                                finReserva = calendario2.getTime();
                            } else{
                                dife = finTarifa.getTime()-inicioTarifa.getTime();
                                difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                                tarifaTotal+=tar.getValor()*difeTarifaDias;
                                //TODO: raro
                            }
                        }

                    }



                } else{
                    break;
                }



                

            }
        }
        return tarifaTotal;
    }
    
    public void cancelarReserva(String documento){
        for(Map.Entry<String,Reserva> entry: informacionHotel.getReserva().entrySet()){
            Reserva res = entry.getValue();
            Huesped huesped = res.getHuespedEncargado();
            if(huesped.getDocumento().equals(documento)){
                res.setCancelada(true);
                for(Habitacion hab: res.getHabitacionesReservadas()){
                    hab.eliminarFechaBloqueada(res.getRango());
                }
            }
        }
    }

    public void realizarCheckOut(String documentoHuesped) {
        for(Map.Entry<String,Reserva> entry: informacionHotel.getReserva().entrySet()){
            Reserva res = entry.getValue();
            Huesped huesped = res.getHuespedEncargado();
            if(huesped.getDocumento().equals(documentoHuesped)){
                res.setCheckin(false);

                for(Habitacion hab: res.getHabitacionesReservadas()){
                    Factura factHab = new Factura(hab);
                    factHab.generarTextoFactura();
                    res.agregarFacturaHabitacion(factHab);
                }

                String facturacheckOut = res.mostrarFacturaCheckout();
                System.out.println(facturacheckOut);

            
            } else{
                System.out.println("No se encontro la reserva");
            }
        }
    }


}
