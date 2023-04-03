package model;

import java.util.ArrayList;
import java.util.Map;

public class InformacionHotel {
    private Map<String,Habitacion> habitaciones;
    private Map<String,TipoHabitacion> tipoHabitaciones;
    private ArrayList<Cama> camas;
    private ArrayList<TarifaCuarto> tarifasCuarto;
    private ArrayList<Tarifa> tarifas;
    private Map<String,Bebida> menuBebidas;
    private Map <String,Plato> menuPlatos;
    private Map<String,ArrayList<String>> usuarios;
    private Map<String,Servicio> servicios;
    private Map<String,Reserva> reservas;
    private Map<String,Huesped> huespedes;
    private Map<String, Grupo> grupos;
    private Map<String,Consumo> consumos;

    
    public Map<String,Habitacion> getInventarioHabitaciones(){
        return habitaciones;
    }

    public Map<String,TipoHabitacion> getTipoHabitaciones(){
        return tipoHabitaciones;
    }

    public ArrayList<Cama> getCamas(){
        return camas;
    }

    public ArrayList<TarifaCuarto> getTarifasCuartos(){
        return tarifasCuarto;
    }

    public ArrayList<Tarifa> getTarifas(){
        return tarifas;
    }

    public Map<String,Bebida> getMenuBebidas(){
        return menuBebidas;
    }

    public Map <String,Plato> getMenuPlatos(){
        return menuPlatos;
    }

    public Map<String,ArrayList<String>> getUsuarios(){
        return usuarios;
    }

    public Map<String,Servicio> getServicios() {
        return servicios;
    }

    public Map<String,Reserva> getReserva() {
        return reservas;
    }

    public Map<String,Huesped> getHuesped(){
        return huespedes;
    }

    public Map<String,Grupo> getGrupos() {
        return grupos;
    }

    public Map<String,Consumo> getConsumos(){
        return consumos;
    }


}
