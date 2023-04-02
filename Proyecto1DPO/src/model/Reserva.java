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
    private ArrayList<Factura> facturasHabitaciones;
    private Grupo grupo;
    private ArrayList<Habitacion> habitacionesReservadas;
    private Huesped huespedEncargado;

    public Reserva(Huesped huesped, int cantidadPersonas, String fechaIn, String fechaOut){
        this.fechaIn = fechaIn;
        this.fechaOut = fechaOut;
        this.cantidadPersonas = cantidadPersonas;
        this.huespedEncargado = huesped;
        this.cancelada = false;
        this.checkin = false;
        this.habitacionesReservadas = new ArrayList<Habitacion>();
        this.facturasHabitaciones = new ArrayList<Factura>();
        this.tarifaTotal = 0;    

    }
    public void setTarifaTotal(double tarifa){
        tarifaTotal = tarifa;
    }

    public String getRango(){
        String rangoString = getFechaIn().trim() + "-" + getFechaOut().trim();
        return rangoString;
    }

    public double getTarifaTotal(){
        return tarifaTotal;
    }

    public void agregarHabitacion(Habitacion habitacion){
        habitacionesReservadas.add(habitacion);
    }

    public void setCheckin(boolean in){
        this.checkin = in;
    }

    public void setCancelada(boolean cancelada){
        this.cancelada = cancelada;

    }

    public boolean isCancelada(){
        return cancelada;
    }

    public Huesped getHuespedEncargado(){
        return huespedEncargado;
    }

    public Grupo getGrupo(){
        return grupo;
    }

    public void setGrupo(Grupo grupo){
        this.grupo = grupo;
    }


    public ArrayList<Consumo> getConsumosGrupo(){
        return grupo.getConsumos();
       
    }

    public ArrayList<Habitacion> getHabitacionesReservadas(){
        return habitacionesReservadas;
    }

    public ArrayList<Factura> getFacturasHabitaciones(){
        return facturasHabitaciones;
    }

    public void agregarFacturaHabitacion(Factura factura){
        facturasHabitaciones.add(factura);
    }

    public String mostrarFacturaCheckout(){
        String res = "";
        for(Factura fac: getFacturasHabitaciones()){
            res += fac.getInformacionConsumos();
        }
        return res;
    }

    public String getFechaIn(){
        return fechaIn;
    }

    public String getFechaOut(){
        return fechaOut;
    }

    public int getCantidadPersonas(){
        return cantidadPersonas;
    }

    
    

}
