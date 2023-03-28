package consola;

import java.util.ArrayList;

import hotel.*;

public class InformacionHotel
{
    private GuardadorInformacion guardador;
    private Habitacion habitacion;
    private Reserva reserva;
    private Huesped huesped;
    private Servicio servicio;
    private Tarifa tarifa;

    public ArrayList<Huesped> getHuespedesAlojados(){
        return Huesped.getHuespedes();
    }
    
    public ArrayList<Reserva> getReservasEfectuadas(){
        return Reserva.getReservas();
    }
    
    public ArrayList<Habitacion> getHabitacionesHotel(){
        return Habitacion.getHabitaciones();
    }
    
    public ArrayList<Tarifa> getTarifasHotel(){
        return Tarifa.getTarifas();
    }
    
    public ArrayList<Servicio> getServiciosHotel(){
        return Servicio.getServicios();
    }

    public ArrayList<Usuario> getUsuariosHotel(){
        return Usuario.getUsuarios();
    }

    public ArrayList<Usuario> getTrabajadoresHotel(){
        return Usuario.getTrabajadores();
    }

    public ArrayList<Usuario> getEmpleados(){
        return Usuario.getEmpleados();
    }

    public ArrayList<Usuario> getAdministradores(){
        return Usuario.getAdministradores();
    }

    public ArrayList<Usuario> getRecepcionistas(){
        return Usuario.getRecepcionistas();
    }

    public void actualizarHuespedesAlojados(Huesped huesped, Huesped actualizado){
        Huesped.getHuespedes().set(Huesped.getHuespedes().indexOf(huesped), actualizado);
    }

    public void actualizarReservasEfectuadas(Reserva reserva, Reserva actualizada){
        Reserva.getReservas().set(Reserva.getReservas().indexOf(reserva), actualizada);
    }

    public void actualizarHabitacionesHotel(Habitacion habitacion, Habitacion actualizada){
        Habitacion.getHabitaciones().set(Habitacion.getHabitaciones().indexOf(habitacion), actualizada);
    }

    public void actualizarTarifasHotel(Tarifa tarifa, Tarifa actualizada){
        Tarifa.getTarifas().set(Tarifa.getTarifas().indexOf(tarifa), actualizada);
    }

    public void actualizarServiciosHotel(Servicio servicio, Servicio actualizado){
        Servicio.getServicios().set(Servicio.getServicios().indexOf(servicio), actualizado);
    }
}
