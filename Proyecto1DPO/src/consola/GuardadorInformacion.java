package consola;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import hotel.Habitacion;
import hotel.Huesped;
import hotel.Menu;
import hotel.Reserva;
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
        return habitacionString;
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
                System.out.println("File already exists.");
            }
        } catch (IOException e){
            System.out.println("An error ocurred");
        }
        return null;
    }
    
    
    private String escribirTarifa(Tarifa tarifa){
        String tarifaString = "";
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
        return tarifaString;
    }
    
    public File guardarTarifas(ArrayList<Tarifa> tarifas) {
        try{
            File file = new File("data\\Tarifas.txt");
            if(file.createNewFile()){
                PrintWriter writer = new PrintWriter(file);
                for(Tarifa tar: tarifas){
                    writer.println(escribirTarifa(tar));
                } 
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
    

    private String escribirReserva(Reserva reserva){
        String reservaString = "";
        reservaString += reserva.getCantidadHuesped();
        reservaString += ";";
        reservaString += reserva.getTarifaTotal();
        reservaString += ";";
        reservaString += reserva.getFechaIngreso();
        reservaString += ";";
        reservaString += reserva.getFechaSalida();
        return reservaString;
    }

    public File guardarReservas(ArrayList<Reserva> reservas) {
        try{
            File file = new File("data\\Reservas.txt");
            if(file.createNewFile()){
                PrintWriter writer = new PrintWriter(file);
                for(Reserva res: reservas){
                    writer.println(escribirReserva(res));
                }
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
    
    
    private String escribirServicio(Servicio servicio){
        String servicioString = "";
        servicioString += servicio.getNombre();
        servicioString += ";";
        servicioString += servicio.getDescripcion();
        servicioString += ";";
        servicioString += servicio.getCosto();
        return servicioString;
    }
    
    public File guardarServicios(ArrayList<Servicio> servicios) {
	
    }
    
    public File guardarMenusComida(ArrayList<Menu> menus) {
	
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
