package hotel;

import java.util.ArrayList;

public class Habitacion
{
    private String identificador;
    private String ubicacion;
    private int capacidad;
    private TipoHabitacion tipoHabitacion;
    private boolean disponibilidad;
    private ArrayList<Cama> camas;
    private ArrayList<Tarifa> tarifas;
    private Tarifa tarifaActual;
    private ArrayList<Consumo> cobros;
    private ArrayList<Reserva> reservas;
    private Reserva reservaActual;
    
    public Habitacion(String iden, String ubic, int capac, TipoHabitacion tipo) {
	identificador = iden;
	ubicacion = ubic;
	capacidad = capac;
	tipoHabitacion = tipo;
    }
    
    public String getIdentificador() {
	return identificador;
    }
    
    public String getUbicacion() {
	return ubicacion;
    }
    
    public int getCapacidad() {
	return capacidad;
    }
    
    public ArrayList<Cama> getCamas(){
	return camas;
    }
    
    public ArrayList<Tarifa> getTarifas(){
	return tarifas;
    }
    
    public Tarifa getTarifaActual() {
	return tarifaActual;
    }
    
    public ArrayList<Reserva> getReservas(){
	return reservas;
    }
    
    public Reserva getReservaActual() {
	return reservaActual;
    }
    
    public void setDisponibilidad(boolean disp) {
	disponibilidad = disp;
    }
    
    public boolean hasDisponibilidad() {
	return disponibilidad;
    }

}
