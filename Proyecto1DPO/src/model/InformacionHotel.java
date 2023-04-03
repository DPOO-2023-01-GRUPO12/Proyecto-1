package model;

import java.util.ArrayList;
import java.util.HashMap;
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

    public InformacionHotel(){
        habitaciones = new HashMap<String,Habitacion>();
        tipoHabitaciones = new HashMap<String,TipoHabitacion>();
        camas = new ArrayList<Cama>();
        tarifasCuarto = new ArrayList<TarifaCuarto>();
        tarifas = new ArrayList<Tarifa>();
        menuBebidas = new HashMap<String,Bebida>();
        menuPlatos = new HashMap<String,Plato>();
        usuarios = new HashMap<String,ArrayList<String>>();
        servicios = new HashMap<String,Servicio>();
        reservas = new HashMap<String,Reserva>();
        huespedes = new HashMap<String,Huesped>();
        grupos = new HashMap<String,Grupo>();
        consumos = new HashMap<String,Consumo>();
    }
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

    public Map<String,Reserva> getReservas() {
        return reservas;
    }

    public Map<String,Huesped> getHuespedes(){
        return huespedes;
    }

    public Map<String,Grupo> getGrupos() {
        return grupos;
    }

    public Map<String,Consumo> getConsumos(){
        return consumos;
    }


}
