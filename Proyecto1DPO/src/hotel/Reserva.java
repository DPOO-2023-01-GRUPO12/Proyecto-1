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
    
    public Reserva(int cantidad, float tarifa) {
	cantidadHuesped = cantidad;
	tarifaTotal = tarifa;
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

}
