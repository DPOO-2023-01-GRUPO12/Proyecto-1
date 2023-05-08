package console;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Map;

import persistencia.Cargador;

import model.Factura;

import model.Habitacion;
import model.Huesped;
import model.PMS;
import model.Reserva;

import model.TarifaCuarto;

import java.text.ParseException;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class MenuRecepcionista {
    private Cargador cargador;
    private PMS pms;

    public MenuRecepcionista(Cargador car, PMS pms) {
        cargador = car;
        this.pms = pms;
    }

    public void consultarInventarioHabitaciones() {
        String res = "";
        Map<String, Habitacion> inventario = pms.getInventarioHabitaciones();
        for (Map.Entry<String, Habitacion> entry : inventario.entrySet()) {
            res += entry.getValue().toString();
        }
        System.out.println(res);

    }

    public Reserva RealizarReservaHuesped(String huespedDoc, int cantidad, String fechaIn, String fechaOut) {
        Huesped huesped = pms.getHuespedes().get(huespedDoc);
        Reserva reserva = new Reserva(huesped, cantidad, fechaIn, fechaOut);
        pms.agregarReserva(reserva);
        pms.agregarFechas(reserva);
        return reserva;
    }

    public Huesped realizarRegistro(String nombre, String documento, String celular, String correo, int edad) {
        Huesped huesped = new Huesped(nombre, documento, celular, correo, edad);
        pms.agregarHuesped(huesped);
        return huesped;
    }

    public double configurarTarifaTotal(String fechaIn, String fechaOut, int cantidadHues, Reserva res)
            throws ParseException {
        String rangoString = fechaIn.trim() + "-" + fechaOut.trim();
        // System.out.println(rangoString);
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        double tarifaTotal = 0;

        for (Map.Entry<String, Habitacion> entry : pms.getInventarioHabitaciones().entrySet()) {
            Habitacion habitacion = entry.getValue();
            Calendar calendario = new GregorianCalendar();

            Date inicioReserva = formato.parse(fechaIn);
            calendario.setTime(inicioReserva);

            Calendar calendario2 = new GregorianCalendar();

            Date finReserva = formato.parse(fechaOut);
            calendario2.setTime(finReserva);

            tarifaTotal += tarifaSeparada(res, habitacion, rangoString, inicioReserva, finReserva, cantidadHues);
        }

        return tarifaTotal;
    }

    private double tarifaSeparada(Reserva res, Habitacion habitacion, String rangoString, Date inicioReserva,
            Date finReserva, int cantidadHues) throws ParseException {
        TimeUnit time = TimeUnit.DAYS;
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        double tarifaTotal = 0;
        long cantidadTiempo = inicioReserva.getTime() - finReserva.getTime();
        int cantidadDias = (int) time.convert(cantidadTiempo, TimeUnit.MILLISECONDS);
        Calendar calendario = new GregorianCalendar();
        Calendar calendario2 = new GregorianCalendar();
        for (TarifaCuarto tar : habitacion.getTipoHabitacion().getTarifas()) {
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
            long difeTarifaTiempo = finTarifa.getTime() - inicioTarifa.getTime();
            int difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);

            if (!habitacion.getFechasBloqueadas().contains(rangoString)) {
                if (habitacion.getCapacidad() >= cantidadHues) {
                    if (inicioTarifa.compareTo(inicioReserva) < 0) {
                        if (finTarifa.compareTo(finReserva) > 0) {
                            tarifaTotal += tar.getValor() * cantidadDias;
                            habitacion.agregarFechaBloqueada(rangoString);
                            res.agregarHabitacion(habitacion);
                            return tarifaTotal;
                        } else if (finTarifa.compareTo(finReserva) == 0) {
                            tarifaTotal += tar.getValor() * cantidadDias;
                            habitacion.agregarFechaBloqueada(rangoString);
                            res.agregarHabitacion(habitacion);
                            return tarifaTotal;
                        } else {
                            difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                            tarifaTotal += tar.getValor() * difeTarifaDias;
                            cantidadDias -= (difeTarifaDias + 1);
                            calendario.setTime(inicioReserva);
                            calendario.add(Calendar.DATE, difeTarifaDias + 1);
                            inicioReserva = calendario.getTime();

                        }
                    } else if (inicioTarifa.compareTo(inicioReserva) == 0) {
                        if (finTarifa.compareTo(finReserva) > 0) {
                            tarifaTotal += tar.getValor() * cantidadDias;
                            habitacion.agregarFechaBloqueada(rangoString);
                            res.agregarHabitacion(habitacion);
                            return tarifaTotal;
                        } else if (finTarifa.compareTo(finReserva) == 0) {
                            tarifaTotal += tar.getValor() * cantidadDias;
                            habitacion.agregarFechaBloqueada(rangoString);
                            res.agregarHabitacion(habitacion);
                            return tarifaTotal;
                        } else {
                            difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                            tarifaTotal += tar.getValor() * difeTarifaDias;
                            cantidadDias -= (difeTarifaDias + 1);
                            calendario.setTime(inicioReserva);
                            calendario.add(Calendar.DATE, difeTarifaDias + 1);
                            inicioReserva = calendario.getTime();

                        }
                    } else { // inicioTarifa.compareTo(inicioReserva)>0
                        if (finTarifa.compareTo(finReserva) > 0) {
                            difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                            tarifaTotal += tar.getValor() * difeTarifaDias;
                            cantidadDias -= (difeTarifaDias + 1);
                            calendario2.setTime(finReserva);
                            calendario2.add(Calendar.DATE, -(difeTarifaDias + 1));
                            finReserva = calendario2.getTime();

                        } else if (finTarifa.compareTo(finReserva) == 0) {
                            difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                            tarifaTotal += tar.getValor() * difeTarifaDias;
                            cantidadDias -= (difeTarifaDias + 1);
                            calendario2.setTime(finReserva);
                            calendario2.add(Calendar.DATE, -(difeTarifaDias + 1));
                            finReserva = calendario2.getTime();
                        } else {
                            difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                            calendario2.setTime(inicioTarifa);
                            calendario2.add(Calendar.DATE, -1);
                            tarifaTotal += tar.getValor() * difeTarifaDias;
                            tarifaTotal += tarifaSeparada(res, habitacion, rangoString, inicioReserva,
                                    calendario2.getTime(), cantidadHues);
                            calendario2.clear();
                            calendario2.setTime(finTarifa);
                            calendario2.add(Calendar.DATE, 1);
                            tarifaTotal += tarifaSeparada(res, habitacion, rangoString, calendario2.getTime(),
                                    finReserva, cantidadHues);

                        }
                    }
                } else {
                    if (inicioTarifa.compareTo(inicioReserva) < 0) {
                        if (finTarifa.compareTo(finReserva) > 0) {
                            tarifaTotal += tar.getValor() * cantidadDias;
                            cantidadHues -= habitacion.getCapacidad();
                            habitacion.agregarFechaBloqueada(rangoString);
                            res.agregarHabitacion(habitacion);
                            break;
                        } else if (finTarifa.compareTo(finReserva) == 0) {
                            tarifaTotal += tar.getValor() * cantidadDias;
                            cantidadHues -= habitacion.getCapacidad();
                            habitacion.agregarFechaBloqueada(rangoString);
                            res.agregarHabitacion(habitacion);
                            break;
                        } else {
                            difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                            tarifaTotal += tar.getValor() * difeTarifaDias;
                            cantidadDias -= (difeTarifaDias + 1);
                            calendario.setTime(inicioReserva);
                            calendario.add(Calendar.DATE, difeTarifaDias + 1);
                            inicioReserva = calendario.getTime();

                        }
                    } else if (inicioTarifa.compareTo(inicioReserva) == 0) {
                        if (finTarifa.compareTo(finReserva) > 0) {
                            tarifaTotal += tar.getValor() * cantidadDias;
                            cantidadHues -= habitacion.getCapacidad();
                            habitacion.agregarFechaBloqueada(rangoString);
                            res.agregarHabitacion(habitacion);
                            break;
                        } else if (finTarifa.compareTo(finReserva) == 0) {
                            tarifaTotal += tar.getValor() * cantidadDias;
                            cantidadHues -= habitacion.getCapacidad();
                            habitacion.agregarFechaBloqueada(rangoString);
                            res.agregarHabitacion(habitacion);
                            break;
                        } else {
                            difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                            tarifaTotal += tar.getValor() * difeTarifaDias;
                            cantidadDias -= (difeTarifaDias + 1);
                            calendario.setTime(inicioReserva);
                            calendario.add(Calendar.DATE, difeTarifaDias + 1);
                            inicioReserva = calendario.getTime();

                        }
                    } else {
                        if (finTarifa.compareTo(finReserva) > 0) {
                            difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                            tarifaTotal += tar.getValor() * difeTarifaDias;
                            cantidadDias -= (difeTarifaDias + 1);
                            calendario2.setTime(finReserva);
                            calendario2.add(Calendar.DATE, -(difeTarifaDias + 1));
                            finReserva = calendario2.getTime();

                        } else if (finTarifa.compareTo(finReserva) == 0) {
                            difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                            tarifaTotal += tar.getValor() * difeTarifaDias;
                            cantidadDias -= (difeTarifaDias + 1);
                            calendario2.setTime(finReserva);
                            calendario2.add(Calendar.DATE, -(difeTarifaDias + 1));
                            finReserva = calendario2.getTime();
                        } else {

                            difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);
                            calendario2.setTime(inicioTarifa);
                            calendario2.add(Calendar.DATE, -1);
                            tarifaTotal += tar.getValor() * difeTarifaDias;
                            tarifaTotal += tarifaSeparada(res, habitacion, rangoString, inicioReserva,
                                    calendario2.getTime(), cantidadHues);
                            calendario2.clear();
                            calendario2.setTime(finTarifa);
                            calendario2.add(Calendar.DATE, 1);
                            tarifaTotal += tarifaSeparada(res, habitacion, rangoString, calendario2.getTime(),
                                    finReserva, cantidadHues);

                        }
                    }

                }
            } else {
                break;
            }
            calendario2.clear();
            calendario.clear();

        }

        pms.agregarHabitacion(habitacion);
        pms.agregarReserva(res);
        return tarifaTotal;

    }

    public void cancelarReserva(String documento) {
        for (Map.Entry<String, Reserva> entry : pms.getReservas().entrySet()) {
            Reserva res = entry.getValue();
            Huesped huesped = res.getHuespedEncargado();
            if (huesped.getDocumento().equals(documento)) {
                res.setCancelada(true);
                for (Habitacion hab : res.getHabitacionesReservadas()) {
                    hab.eliminarFechaBloqueada(res.getRango());
                    pms.agregarHabitacion(hab);
                }
                pms.agregarReserva(res);
            }
        }
    }

    public String realizarCheckOut(String documentoHuesped) {
        String facturacheckOut ="No se encontro la reserva";
        for (Map.Entry<String, Reserva> entry : pms.getReservas().entrySet()) {
            Reserva res = entry.getValue();
            Huesped huesped = res.getHuespedEncargado();
            

            if (huesped.getDocumento().equals(documentoHuesped)) {
                res.setCheckin(false);

                for (Habitacion hab : res.getHabitacionesReservadas()) {
                    Factura factHab = new Factura(hab);
                    factHab.generarTextoFactura();
                    res.agregarFacturaHabitacion(factHab);
                }

                facturacheckOut = res.mostrarFacturaCheckout();
                pms.agregarReserva(res);
                

            }
        

    }return facturacheckOut;
}

    public void generarLogGrupo(String documentoHuesped) {
        for (Map.Entry<String, Reserva> entry : pms.getReservas().entrySet()) {
            Reserva res = entry.getValue();
            Huesped huesped = res.getHuespedEncargado();
            if (huesped.getDocumento().equals(documentoHuesped)) {
                res.generarLogGrupo();
            }
        }

    }

}
