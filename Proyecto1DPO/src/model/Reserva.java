package model;

import java.util.ArrayList;
public class Reserva {

    private String fechaIn;
    private String fechaOut;
    private double tarifaTotal;
    private int cantidadPersonas;
    private boolean cancelada; 
    private boolean checkin;
    private Factura facturaCheckout;
    private Grupo grupo;
    private ArrayList<Habitacion> habitacionesReservadas;
    private Huesped huespedEncargado;

    public Reserva(String fechaIn, String fechaOut, double tarifaTotal){
        this.fechaIn = fechaIn;
        this.fechaOut = fechaOut;
        this.tarifaTotal = tarifaTotal;
    }

    public void setCheckin(boolean in){
        this.checkin = in;
    }

    public void setCancelada(boolean cancelada){
        this.cancelada = cancelada;

    }

    public Huesped getHuespedEncargado(){}
        return huespedEncargado;

    public Grupo getGrupo(){
        return grupo;
    }

    public ArrayList<Consumo> getConsumosGrupo(){
        return grupo.getConsumos();
       
    }
    

}
