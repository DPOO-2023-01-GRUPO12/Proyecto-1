package consola;

import java.io.File;
import java.util.ArrayList;

import hotel.Habitacion;
import hotel.Tarifa;

public class GuardadorInformacion
{
    private Habitacion habitacion;
    private File habitaciones;
    private File tarifas;
    private File reservas;
    private File servicios;
    private File menus;
    private File huespedes;
    
    public File guardarHabitacionCreada(Habitacion habitacion) {
	
    }
    
    public File guardarHabitaciones(ArrayList<Habitacion> habitaciones) {
	
    }
    
    public File guardarTarifas(ArrayList<Tarifa> tarifas) {
	
    }
    
    public File guardarReservas(ArrayList<Reserva> reservas) {
	
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
    
    public File getMenus() {
	return menus;
    }
    
    public File getHuespedes() {
	return huespedes;
    }
}
