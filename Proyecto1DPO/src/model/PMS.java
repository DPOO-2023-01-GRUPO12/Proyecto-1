package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import persistencia.Cargador;
import persistencia.GuardadorInformacion;

public class PMS {
    private Cargador cargador;
    private GuardadorInformacion guardador;
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

    public PMS(){
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
        cargador = new Cargador(this);
        guardador = new GuardadorInformacion(this);
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

    public void agregarHabitacion(Habitacion habitacion) {
        getInventarioHabitaciones().put(habitacion.getIdentificador(), habitacion);
    }
    public void agregarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        getTipoHabitaciones().put(tipoHabitacion.getNombreTipo(), tipoHabitacion);
    }

    public void agregarCama(Cama Cama) {
        getCamas().add(Cama);
    }

    public void agregarTarifaCuarto(TarifaCuarto tarifa) {
        getTarifasCuartos().add(tarifa);
    }

    public void agregarBebida(Bebida bebida) { 
        getMenuBebidas().put(bebida.getNombre(), bebida);  
    }

    public void agregarPlato(Plato plato) {  
        getMenuPlatos().put(plato.getNombre(), plato);
    }

    public void agregarUsuario (String login,String password){


        ArrayList<String> usuario = new ArrayList<String>();
        usuario.add(password);

        if(login.contains("admin")){
            usuario.add("administrador");}

        else if (login.contains("empleado")){
            usuario.add("empleado");}
        
        else if (login.contains("recepcionista")){
            usuario.add("recepcionista");}

        

        getUsuarios().put(login, usuario);
    }

    public void agregarServicio(Servicio servicio) {
        getServicios().put(servicio.getNombreTipo(), servicio);
    }


    public void agregarReserva(Reserva reserva) {
        getReservas().put(reserva.getHuespedEncargado().getDocumento(), reserva);
    }


    public void agregarHuesped(Huesped Huesped) {
        getHuespedes().put(Huesped.getDocumento(), Huesped);
    }

    public void agregarGrupo(Grupo grupo){
        getGrupos().put(grupo.getHuespedEncargado().getDocumento(), grupo);
        
    }

    public void agregarConsumo(Consumo consumo){
        getConsumos().put(consumo.getHuesped().getDocumento(), consumo);
    }

    

    
    public void cambiarTarifaServicio(String nombreServicio,double valor) {

        if (getServicios().containsKey(nombreServicio))
        {
            Servicio servicioEdit = getServicios().get(nombreServicio);
            servicioEdit.setTarifa(valor);
        }


    }

    public Cargador getCargador(){
        return cargador;
    }
    

    public GuardadorInformacion getGuardador(){
        return guardador;
    }


}
