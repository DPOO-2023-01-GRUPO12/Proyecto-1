package model;

import java.util.ArrayList;

public class Habitacion {

    private String identificador;
    private String ubicacion;
    private int capacidad;
    private boolean balcon;
    private boolean vista;
    private boolean cocina;
    private String descripcion;
    private ArrayList<Cama> camas;
    private ArrayList<Reserva> reservas;
    private Reserva reservaActual;
    private TipoHabitacion tipoHabitacion;
    private ArrayList<Consumo> pagos;
    private ArrayList<Consumo> noPagos;
    private ArrayList<Huesped> alojados;
    


    public Habitacion(String id, String ubic, String desc){

        this.identificador = id;
        this.ubicacion = ubic;
        this.descripcion = desc;}

    public void setTipoHabitacion (TipoHabitacion tipo){
        tipoHabitacion = tipo;
    }

    public void setCamas(ArrayList<Cama> camas){
        this.camas = camas;
        calcularCapacidad();
    }
    
    public void setBalcon (boolean balcon){
        this.balcon = balcon;
    }

    public void setVista (boolean vista){
        this.vista = vista;
    }

    public void setCocina (boolean cocina){
        this.cocina = cocina;
    }

    private void calcularCapacidad (){
        int capacidadCamas = 0;
        for (Cama cama: camas ){
            int cantidad = cama.getCantidadPersonas();
            capacidadCamas += cantidad;
        }

        this.capacidad = capacidadCamas;

    }

    public ArrayList<Reserva> getReservas(){

        return reservas;
    }

    public void setReservaActual (Reserva reserva){
        reservaActual = reserva;
    }

    public Reserva getReservaActual(){
        return reservaActual;
    }


}