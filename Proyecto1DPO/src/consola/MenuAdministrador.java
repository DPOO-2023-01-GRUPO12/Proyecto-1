package consola;

import java.io.File;

import hotel.Habitacion;
import hotel.TipoHabitacion;

public class MenuAdministrador
{
    private CargadorInformacion cargador;
    private GuardadorInformacion guardador;
    private Habitacion habitacion;
    
    
    public void cargarInformacionServicios(File servicios) {
	cargador.cargarServicios(servicios);
    }
    
    public void cargarInformacionHabitaciones(File habitaciones) {
	cargador.cargarHabitaciones(habitaciones);
    }
    
    public void cargarInformacionTarifas(File tarifas) {
	cargador.cargarTarifas(tarifas);
    }
    
    public void modificarTarifa() {
	
    }
    
    public void modificarServicio() {
	
    }
    
    public void modificarHabitacion() {
	
    }
    
    public void modificarMenuComida() {
	
    }
    
    public Habitacion crearHabitacion(String id, String ubicacion, int capacidad, TipoHabitacion tipo) {
	Habitacion habitacion = new Habitacion(id,ubicacion,capacidad,tipo);
	return habitacion;
    }




}
