package hotel;

import java.util.ArrayList;
import java.time.*;
import java.time.format.DateTimeFormatter;

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
    private static ArrayList<Habitacion> habitaciones = new ArrayList<Habitacion>();
    private static int contadorHabitaciones = 0;

    public Habitacion(String iden, String ubic, int capac, TipoHabitacion tipo) {
	identificador = iden;
	ubicacion = ubic;
	capacidad = capac;
	tipoHabitacion = tipo;
    camas = new ArrayList<Cama>();
    tarifas = new ArrayList<Tarifa>();
    cobros = new ArrayList<Consumo>();
    reservas = new ArrayList<Reserva>();
    habitaciones.add(this);
    contadorHabitaciones++;
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

    public TipoHabitacion geTipoHabitacion(){
        return tipoHabitacion;
    }

    public void agregarCama(Cama cama){
        camas.add(cama);
    }
    
    public ArrayList<Cama> getCamas(){
	return camas;
    }

    public void agregarTarifa(Tarifa tarifa){
        tarifas.add(tarifa);
    }
    
    public ArrayList<Tarifa> getTarifas(){
	return tarifas;
    }
    
    public Tarifa getTarifaActual() {
        double min = tarifas.get(0).getValor();
        for(Tarifa tar: tarifas){
            if(tar.getValor() < min){
                min = tar.getValor();
                tarifaActual = tar;
            }
        }
	return tarifaActual;
    }

    public void agregarConsumo(Consumo consumo){
        cobros.add(consumo);
    }

    public ArrayList<Consumo> getCobros(){
        return cobros;
    }

    public void agregarReserva(Reserva reserva){
        reservas.add(reserva);
    }

    public ArrayList<Reserva> getReservas(){
	return reservas;
    }


    
    public Reserva getReservaActual() {
        LocalDate fechaActual = LocalDate.now();
        for(Reserva res: reservas){
            LocalDate fechaIn = LocalDate.parse(res.getFechaIngreso(), DateTimeFormatter.ofPattern("dd MM yyyy"));
            LocalDate fechaOut = LocalDate.parse(res.getFechaSalida(), DateTimeFormatter.ofPattern("dd MM yyyy"));
            if(fechaIn.isBefore(fechaActual) && fechaOut.isAfter(fechaActual)){
                reservaActual = res;
            }
        }
	return reservaActual;
    }
    
    public void setDisponibilidad(boolean disp) {
	disponibilidad = disp;
    }
    
    public boolean hasDisponibilidad() {
	return disponibilidad;
    }

    public static ArrayList<Habitacion> getHabitaciones(){
        return habitaciones;
    }

    public static int getContadorHabitaciones(){
        return contadorHabitaciones;
    }


}
