package hotel;

import java.util.ArrayList;

public class Grupo
{
    private ArrayList<Huesped> huespedes;
    private ArrayList<Servicio> serviciosUsados;
    private ArrayList<Habitacion> habitaciones;
    
    public ArrayList<Habitacion> getHabitaciones(){
	return habitaciones;
    }
    
    public ArrayList<Huesped> getIntegrantes(){
	return huespedes;
    }
    
    public ArrayList<Servicio> getServiciosUsados(){
	return serviciosUsados;
    }
    

}
