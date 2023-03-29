package consola;

import java.util.ArrayList;

import hotel.*;

public class Hotel {
    private String nombre;
    private Interfaz interfaz;
    private GuardadorInformacion guardador;
    private ArrayList<Huesped> huespedesAlojados;
    private ArrayList<Reserva> reservasEfectuadas;
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<TipoHabitacion> tiposHabitacion;
    private ArrayList<Tarifa> tarifas;
    private ArrayList<Servicio> servicios;
    private ArrayList<Registro> registros;
    private ArrayList<Usuario> trabajadores;
    private ArrayList<Usuario> administradores;
    private ArrayList<Usuario> empleados;
    private ArrayList<Usuario> recepcionistas;
    
    public Hotel(String nom){
        interfaz = new Interfaz();
        nombre = nom;
    }

    public String getNombre(){
        return nombre;
    }

    public ArrayList<Huesped> getHuespedesAlojados(){
        return huespedesAlojados;
    }

    public void actualizarHuespedesAlojados(Huesped huesped){
        for(Huesped h: getHuespedesAlojados()){
            if(h.getNombre().equals(huesped.getNombre())){
                h = huesped;
            }
        }
    }

    public void agregarHuesped(Huesped huesped){
        huespedesAlojados.add(huesped);
    }



    public ArrayList<Reserva> getReservasEfectuadas(){
        return reservasEfectuadas;
    }

    public void actualizarReservasEfectuadas(Reserva reserva){
        for(Reserva r: getReservasEfectuadas()){
            if(r.getIdentificador()==reserva.getIdentificador()){
                r = reserva;
            }
        }
        guardador.guardarReservas(reservasEfectuadas);
    }

    public void agregarReserva(Reserva reserva){
        reservasEfectuadas.add(reserva);
        guardador.guardarReservas(reservasEfectuadas);
    }



    public ArrayList<Habitacion> getHabitaciones(){
        return habitaciones;
    }

    public void actualizarHabitaciones(Habitacion habitacion){
        for(Habitacion h: getHabitaciones()){
            if(h.getIdentificador()==habitacion.getIdentificador()){
                h = habitacion;
            }
        }
        guardador.guardarHabitaciones(habitaciones);
    }

    public void agregarHabitacion(Habitacion habitacion){
        habitaciones.add(habitacion);
        guardador.guardarHabitacionCreada(habitacion);
        guardador.guardarHabitaciones(habitaciones);
    }




    public ArrayList<TipoHabitacion> getTiposHabitacion(){
        return tiposHabitacion;
    }

    public void actualizarTiposHabitacion(TipoHabitacion tipoHabitacion){
        for(TipoHabitacion t: getTiposHabitacion()){
            if(t.getIdentificador()==tipoHabitacion.getIdentificador()){
                t = tipoHabitacion;
            }
        }
    }




    public void agregarTipoHabitacion(TipoHabitacion tipoHabitacion){
        tiposHabitacion.add(tipoHabitacion);

    }



    public ArrayList<Tarifa> getTarifasHotel(){
        return tarifas;
    }

    public void actualizarTarifasHotel(Tarifa tarifa){
        for(Tarifa t: getTarifasHotel()){
            if(t.getIdentificador()==tarifa.getIdentificador()){
                t = tarifa;
            }
        }
        guardador.guardarTarifas(tarifas);
    }

    public void agregarTarifaHotel(Tarifa tarifa){
        tarifas.add(tarifa);
        guardador.guardarTarifas(tarifas);
    }



    public ArrayList<Servicio> getServiciosHotel(){
        return servicios;
    }

    public void actualizarServiciosHotel(Servicio servicio){
        for(Servicio s: getServiciosHotel()){
            if(s.getTipo()==servicio.getTipo()){
                s = servicio;
            }
        }
    }

    public void agregarServicioHotel(Servicio servicio){
        servicios.add(servicio);
    }



    public ArrayList<Registro> getRegistros(){
        return registros;
    }

    public void actualizarRegistros(Registro registro){
        for(Registro r: getRegistros()){
            if(r.getIdentificador()==registro.getIdentificador()){
                r = registro;
            }
        }
    }

    public void agregarRegistro(Registro registro){
        registros.add(registro);
    }



    public ArrayList<Usuario> getTrabajadores(){
        return trabajadores;
    }

    public void agregarTrabajador(Usuario trab){
        trabajadores.add(trab);
    }

    public ArrayList<Usuario> getAdministradores(){
        return administradores;
    }

    public void agregarAdministrador(Usuario admin){
        administradores.add(admin);
    }

    public ArrayList<Usuario> getEmpleados(){
        return empleados;
    }

    public void agregarEmpleado(Usuario emp){
        empleados.add(emp);
    }

    public ArrayList<Usuario> getRecepcionistas(){
        return recepcionistas;
    }

    public void agregarRecepcionista(Usuario recep){
        recepcionistas.add(recep);
    }

}
