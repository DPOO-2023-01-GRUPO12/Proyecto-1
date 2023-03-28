package hotel;

import java.util.ArrayList;

public class Reserva
{
    private int cantidadHuesped;
    private float tarifaTotal;
    private boolean cancelada;
    private ArrayList<Huesped> huespedesAlojados;
    private Huesped encargadoReserva;
    private Habitacion habitacionReserva;
    private String fechaIngreso;
    private String fechaSalida;
    private static ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    
    public Reserva(int cantidad, float tarifa, String fechaIn, String fechaOut) {
	cantidadHuesped = cantidad;
	tarifaTotal = tarifa;
    fechaIngreso = fechaIn;
    fechaSalida = fechaOut;
    reservas.add(this);
    }
    
    public int getCantidadHuesped() {
	return cantidadHuesped;
    }
    
    public float getTarifaTotal() {
	return tarifaTotal;
    }
    
    public void setCancelada(boolean can) {
	cancelada = can;
    }
    
    public boolean isCancelada() {
	return cancelada;
    }

    public void agregarHuesped(Huesped huesped){
        huespedesAlojados.add(huesped);
    }

    public ArrayList<Huesped> getHuespedesAlojados(){
        return huespedesAlojados;
    }

    public void setEncargadoReserva(Huesped huesped){
        encargadoReserva = huesped;
    }

    public Huesped getEncargadoReserva(){
        return encargadoReserva;
    }

    public void setHabitacionReserva(Habitacion habitacion){
        habitacionReserva = habitacion;
    }

    public Habitacion getHabitacionReserva(){
        return habitacionReserva;
    }  

    public String getFechaIngreso(){
        return fechaIngreso;
    }

    public String getFechaSalida(){
        return fechaSalida;
    }  

    public static ArrayList<Reserva> getReservas(){
        return reservas;
    }

}
