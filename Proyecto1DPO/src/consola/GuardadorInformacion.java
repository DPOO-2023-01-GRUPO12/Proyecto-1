package consola;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import hotel.Cama;
import hotel.Consumo;
import hotel.Habitacion;
import hotel.Huesped;
import hotel.Menu;
import hotel.ProductoMenu;
import hotel.Reserva;
import hotel.Restaurante;
import hotel.Servicio;
import hotel.Tarifa;
import hotel.TipoHabitacion;

public class GuardadorInformacion
{
    private Habitacion habitacion;
    private File habitaciones;
    private File tarifas;
    private File reservas;
    private File servicios;
    private File productosMenu;
    private File huespedes;
    
    private String escribirHabitacion(Habitacion habitacion){
        String habitacionString = "";
        habitacionString += habitacion.getIdentificador();
        habitacionString += ";";
        habitacionString += habitacion.getUbicacion();
        habitacionString += ";";
        habitacionString += habitacion.getCapacidad();
        habitacionString += ";";
        habitacionString += habitacion.geTipoHabitacion().getTipo();
        habitacionString += ";";
        habitacionString += habitacion.geTipoHabitacion().hasVista();
        habitacionString += ";";
        habitacionString += habitacion.geTipoHabitacion().hasBalcon();
        habitacionString += ";";
        habitacionString += habitacion.geTipoHabitacion().hasCocina();
        habitacionString += ";";
        habitacionString += habitacion.hasDisponibilidad();
        for(Cama cama: habitacion.getCamas()){
            habitacionString += ";";
            habitacionString += cama.getTamanio();
            habitacionString += ";";
            habitacionString += cama.getCantidadPersonas();
            habitacionString += ";";
            habitacionString += cama.hasNinios();
        }
        for(Tarifa tar: habitacion.getTarifas()){
            habitacionString += ";";
            habitacionString += escribirTarifa(tar);
        }

        for(Consumo con: habitacion.getCobros()){
            habitacionString += ";";
            habitacionString += escribirConsumo(con);
        }

        for(Reserva res: habitacion.getReservas()){
            habitacionString += ";";
            habitacionString += escribirReserva(res);
        }

        habitacionString += ";";
        habitacionString += escribirReserva(habitacion.getReservaActual());

        return habitacionString;
    }

    public String escribirConsumo(Consumo con){
        String consumoString = "";
        consumoString += con.getIdentificador();
        consumoString += ";";
        consumoString += con.getTipoCobro();
        consumoString += ";";
        consumoString += con.isPagoInmediato();
        consumoString += ";";
        consumoString += con.getDescripcion();
        consumoString += ";";
        consumoString += con.getFecha();
        consumoString += ";";
        consumoString += con.getValor();
        consumoString += ";";
        consumoString += con.isPagado();

        return consumoString;
    }
    
    public File guardarHabitacionCreada(Habitacion habitacion) {
        try{
            File file = new File("data\\Habitacion"+Habitacion.getContadorHabitaciones()+".txt");
            if(file.createNewFile()){
                PrintWriter writer = new PrintWriter(file);
                writer.println(escribirHabitacion(habitacion));
                writer.close();
                return file;
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e){
            System.out.println("An error ocurred");
        }
        
        return null;
    }
    
    public File guardarHabitaciones(ArrayList<Habitacion> habitaciones) {
        try{
            File file = new File("data\\Habitaciones.txt");
            if(file.createNewFile()){
                PrintWriter writer = new PrintWriter(file);
                for(Habitacion hab: habitaciones){
                    writer.println(escribirHabitacion(hab));
                } 
                writer.close();
                return file;
            } else {
                file.delete();
                File file2 = new File("data\\Habitaciones.txt");
                PrintWriter writer = new PrintWriter(file2);
                for(Habitacion hab: habitaciones){
                    writer.println(escribirHabitacion(hab));
                } 
                writer.close();
                return file2;
            }

            
        } catch (IOException e){
            System.out.println("An error ocurred");
        }
        return null;
    }
    
    
    private String escribirTarifa(Tarifa tarifa){
        String tarifaString = "";
        tarifaString += tarifa.getIdentificador();
        tarifaString += ";";
        tarifaString += tarifa.getTipoCuarto();
        tarifaString += ";";
        for(int i = 0;i<tarifa.getRangoFechas().size();i++){
            if(i<tarifa.getRangoFechas().size()-1){
                tarifaString += tarifa.getRangoFechas().get(i);
                tarifaString += ",";
            } else{
                tarifaString += tarifa.getRangoFechas().get(i);
            }
        }
        tarifaString += ";";
        for(int j = 0;j<tarifa.getDiasSemana().size();j++){
            if(j<tarifa.getDiasSemana().size()-1){
                tarifaString += tarifa.getDiasSemana().get(j);
                tarifaString += ",";
            } else{
                tarifaString += tarifa.getDiasSemana().get(j);
            }
        }
        tarifaString += ";";
        tarifaString += tarifa.getValor();
        for(Habitacion hab: tarifa.getHabitaciones()){
            tarifaString += ";";
            tarifaString += escribirHabitacion(hab);
        }
        return tarifaString;
    }
    
    public File guardarTarifas(ArrayList<Tarifa> tarifas) {
        try{
            File file = new File("data\\Habitaciones.txt");
            if(file.createNewFile()){
                PrintWriter writer = new PrintWriter(file);
                for(Tarifa tar: tarifas){
                    writer.println(escribirTarifa(tar));
                } 
                writer.close();
                return file;
            } else {
                file.delete();
                File file2 = new File("data\\Habitaciones.txt");
                PrintWriter writer = new PrintWriter(file2);
                for(Tarifa tar: tarifas){
                    writer.println(escribirTarifa(tar));
                } 
                writer.close();
                return file2;
            }

            
        } catch (IOException e){
            System.out.println("An error ocurred");
        }
        return null;
	
    }
    

    private String escribirReserva(Reserva reserva){
        String reservaString = "";
        reservaString += reserva.getIdentificador();
        reservaString += ";";
        reservaString += reserva.getCantidadHuesped();
        reservaString += ";";
        reservaString += reserva.getTarifaTotal();
        reservaString += ";";
        reservaString += reserva.isCancelada();
        reservaString += ";";
        for(Huesped hues: reserva.getHuespedesAlojados()){
            reservaString += ";";
            reservaString += escribirHuesped(hues);
        }
        reservaString += ";";
        reservaString += escribirHuesped(reserva.getEncargadoReserva());
        reservaString += ";";
        reservaString += escribirHabitacion(reserva.getHabitacionReserva());
        reservaString += ";";
        reservaString += reserva.getFechaIngreso();
        reservaString += ";";
        reservaString += reserva.getFechaSalida();
        reservaString += ";";

        return reservaString;
    }

    public File guardarReservas(ArrayList<Reserva> reservas) {
        try{
            File file = new File("data\\Habitaciones.txt");
            if(file.createNewFile()){
                PrintWriter writer = new PrintWriter(file);
                for(Reserva res: reservas){
                    writer.println(escribirReserva(res));
                } 
                writer.close();
                return file;
            } else {
                file.delete();
                File file2 = new File("data\\Habitaciones.txt");
                PrintWriter writer = new PrintWriter(file2);
                for(Reserva res: reservas){
                    writer.println(escribirReserva(res));
                } 
                writer.close();
                return file2;
            }

            
        } catch (IOException e){
            System.out.println("An error ocurred");
        }
        return null;
	
    }
    
    
    

    public String escribirRestaurante(Restaurante res){
        String restauranteString = "";
        restauranteString += res.getUbicacion();
        for(Map.Entry<String,ArrayList<String>> entry: res.getDisponibilidad().entrySet()){
            restauranteString += ";";
            restauranteString += entry.getKey();
            for(String str: entry.getValue()){
                if(entry.getValue().indexOf(str) == 0){
                    restauranteString += ":";
                    restauranteString += str;
                } else{
                    restauranteString += ",";
                    restauranteString += str;
                }   
            }
        }
        for(Menu men: res.getMenus()){
            restauranteString += ";";
            restauranteString += escribirMenu(men);
        }
        return restauranteString;
    }

    

    public String escribirProductoMenu(ProductoMenu prod){
        String productoMenuString = "";
        productoMenuString += prod.getNombre();
        productoMenuString += ";";
        productoMenuString += prod.getPrecio();
        productoMenuString += ";";
        productoMenuString += prod.isBebida();
        productoMenuString += ";";
        for(String str: prod.getDisponibilidad()){
            if(prod.getDisponibilidad().indexOf(str)==0){
                productoMenuString += str;    
            } else{
                productoMenuString += ",";
                productoMenuString += str;
            }
        }
        return productoMenuString;
    }
    
    
    private String escribirServicio(Servicio servicio){
        String servicioString = "";
        servicioString += servicio.getTipo();
        servicioString += ";";
        servicioString += servicio.getFormaPago();
        servicioString += ";";
        servicioString += servicio.getTipoCobro();
        servicioString += ";";
        servicioString += servicio.hasServicioCuarto();
        servicioString += ";";
        servicioString += escribirRestaurante(servicio.getRestaurante());
        for(Map.Entry<String,ArrayList<String>> entry: servicio.getDisponibilidad().entrySet()){
            servicioString += ";";
            servicioString += entry.getKey();
            for(String str: entry.getValue()){
                if(entry.getValue().indexOf(str) == 0){
                    servicioString += ":";
                    servicioString += str;
                } else{
                    servicioString += ",";
                    servicioString += str;
                }   
            }
        }


        return servicioString;
    }
    
    public File guardarServicios(ArrayList<Servicio> servicios) {
        try{
            File file = new File("data\\Habitaciones.txt");
            if(file.createNewFile()){
                PrintWriter writer = new PrintWriter(file);
                for(Servicio ser: servicios){
                    writer.println(escribirServicio(ser));
                } 
                writer.close();
                return file;
            } else {
                file.delete();
                File file2 = new File("data\\Habitaciones.txt");
                PrintWriter writer = new PrintWriter(file2);
                for(Servicio ser: servicios){
                    writer.println(escribirServicio(ser));
                }  
                writer.close();
                return file2;
            }

            
        } catch (IOException e){
            System.out.println("An error ocurred");
        }
        return null;
	
    }
    
    
    public String escribirMenu(Menu men){
        String menuString = "";
        menuString += men.getIdentificador();
        menuString += ";";
        for(ProductoMenu prod: men.getProductosMenu()){
            menuString += ";";
            menuString += escribirProductoMenu(prod);
        }
        menuString += men.hasServicioCuarto();
        return menuString;
    }

    public File guardarMenusComida(ArrayList<Menu> menus) {
        try{
            File file = new File("data\\Habitaciones.txt");
            if(file.createNewFile()){
                PrintWriter writer = new PrintWriter(file);
                for(Menu men: menus){
                    writer.println(escribirMenu(men));
                } 
                writer.close();
                return file;
            } else {
                file.delete();
                File file2 = new File("data\\Habitaciones.txt");
                PrintWriter writer = new PrintWriter(file2);
                for(Menu men: menus){
                    writer.println(escribirMenu(men));
                } 
                writer.close();
                return file2;
            }

            
        } catch (IOException e){
            System.out.println("An error ocurred");
        }
        return null;
    }
    
    
    
    public String escribirHuesped(Huesped hues){
        String huespedString = "";
        huespedString += hues.getNombre();
        huespedString += ";";
        huespedString += hues.getDocumento();
        huespedString += ";";
        huespedString += hues.getCorreo();
        huespedString += ";";
        huespedString += hues.getCelular();
        return huespedString;
    }
    public File guardarHuespedes(ArrayList<Huesped> huespedes) {
	
    }
    
    public Habitacion getHabitacionCreada() {
	return habitacion;
    }
    
    public File getHabitaciones() {
	return habitaciones;
    }
    
    public File getTarifas() {
	return tarifas;
    }
    
    public File getReservas() {
	return reservas;
    }
    
    public File getServicios() {
	return servicios;
    }
    
    public File getProductosMenu() {
	return productosMenu;
    }
    
    public File getHuespedes() {
	return huespedes;
    }
}
