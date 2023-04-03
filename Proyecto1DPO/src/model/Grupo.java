package model;

import java.util.ArrayList;

public class Grupo {
    private String identificador;
    private ArrayList<Huesped> integrantes;
    private Huesped huespedEncargado;
    private ArrayList<Consumo> consumosNoPagos;
    private ArrayList<Consumo> consumosPagos;
    private ArrayList<Habitacion> habitaciones;

    public Grupo (String documentoEncargado){
        this.identificador=documentoEncargado;
        this.integrantes=new ArrayList<Huesped>();
        this.consumosNoPagos =new ArrayList<Consumo>();
        this.consumosPagos =new ArrayList<Consumo>();
        this.habitaciones = new ArrayList<Habitacion>();
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public ArrayList<Consumo> getConsumosNoPagos() {
        return this.consumosNoPagos;
    }

    public void agregarConsumoNoPago(Consumo consumo){
        this.consumosNoPagos.add(consumo);
    }

    public void agregarConsumoPago(Consumo consumo){
        this.consumosPagos.add(consumo);
    }

    public ArrayList<Consumo> getConsumosPagos() {
        return this.consumosPagos;
    }

    public ArrayList<Huesped> getIntegrantes() {
        return this.integrantes;
    }

    public Huesped getHuespedEncargado() {
        return this.huespedEncargado;
    }

    public void setHuespedEncargado(Huesped huespedEncargado) {
        this.huespedEncargado = huespedEncargado;
    }

    public void agregarIntegrante(Huesped huesped){
        this.integrantes.add(huesped);
    }

    public void agregarConsumo(Consumo consumo){
        if (consumo.isPago()){
            this.consumosPagos.add(consumo);
        } else {
            this.consumosPagos.add(consumo);
        }
    }

    public void agregarHabitacion(Habitacion habitacion){
        this.habitaciones.add(habitacion);
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return this.habitaciones;
    }


}
