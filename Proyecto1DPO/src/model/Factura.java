package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Factura{ 

    private static int contadorFactura= 0;
    private int numeroFactura;
    private String fecha;
    private ArrayList<Huesped> huespedes;
    private String habitacion;
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Consumo> consumos;
    private String informacionConsumos;
    private String textoFactura;
    private double iva;
    private double valorTotal;
    private boolean esGrupo;

    public Factura(Habitacion habitacion){
        this.numeroFactura = contadorFactura;
        LocalDate fechaActual=LocalDate.now();
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd LLLL yyyy");
        this.fecha=fechaActual.format(formato);
        this.huespedes = new ArrayList<Huesped>();
        this.habitacion = habitacion.getIdentificador();
        this.habitaciones = new ArrayList<Habitacion>();
        habitaciones.add(habitacion);
        this.consumos = habitacion.getConsumosNoPagos();
        this.informacionConsumos = "";
        this.textoFactura="";
        this.valorTotal = 0;
        this.iva = 0.19*valorTotal;
        this.esGrupo = false;
        contadorFactura++;
    }

    public Factura(Reserva reserva, Grupo grupo){
        this.numeroFactura = contadorFactura;
        LocalDate fechaActual=LocalDate.now();
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd LLLL yyyy");
        this.fecha=fechaActual.format(formato); 
        this.habitacion = setHabitaciones(reserva.getHabitacionesReservadas());
        this.habitaciones = grupo.getHabitaciones();
        this.huespedes = grupo.getIntegrantes();
        this.consumos = grupo.getConsumosNoPagos();
        this.informacionConsumos = "";
        this.textoFactura="";
        this.valorTotal = 0;
        this.iva = 0.19*valorTotal;
        this.esGrupo = true;
        contadorFactura++;
    }

    public Factura(Reserva reserva, Huesped huespedEncargado){
        this.numeroFactura = contadorFactura;
        LocalDate fechaActual=LocalDate.now();
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd LLLL yyyy");
        this.fecha=fechaActual.format(formato); 
        this.habitacion = setHabitaciones(reserva.getHabitacionesReservadas());
        this.habitaciones = reserva.getHabitacionesReservadas();
        this.huespedes = new ArrayList<Huesped>();
        huespedes.add(huespedEncargado);
        this.consumos = huespedEncargado.getConsumosNoPagos();
        this.informacionConsumos = "";
        this.textoFactura="";
        this.valorTotal = 0;
        this.iva = 0.19*valorTotal;
        this.esGrupo = false;
        contadorFactura++;
    }

    public Factura(Huesped huesped){
        this.numeroFactura = contadorFactura;
        this.habitacion = huesped.getHabitacion().getIdentificador();
        this.habitaciones = new ArrayList<Habitacion>();
        habitaciones.add(huesped.getHabitacion());
        this.huespedes = new ArrayList<Huesped>();
        huespedes.add(huesped);
        this.huespedes.add(huesped);
        this.consumos = huesped.getConsumosNoPagos();
        this.informacionConsumos = "";
        this.textoFactura="";
        this.valorTotal = 0;
        this.iva = 0.19*valorTotal;
        this.esGrupo = false;
        contadorFactura++;
    }

    public Factura(Grupo grupo){
        this.numeroFactura = contadorFactura;
        this.habitacion = setHabitaciones(grupo.getHabitaciones());
        this.habitaciones = grupo.getHabitaciones();
        this.huespedes = grupo.getIntegrantes();
        this.consumos = grupo.getConsumosNoPagos();
        this.informacionConsumos = "";
        this.valorTotal = 0;
        this.esGrupo = true;
        contadorFactura++;
    }

    public Factura(Consumo consumo){
        this.numeroFactura = contadorFactura;
        this.habitacion = consumo.getHabitacion();
        this.habitaciones = new ArrayList<Habitacion>();
        habitaciones.add(consumo.getHabitacionAsignada());
        this.huespedes = new ArrayList<Huesped>();
        this.huespedes.add(consumo.getHuesped());
        if(!consumo.getGrupo().equals(null)){
            this.esGrupo = true;
            for(Huesped integrante: consumo.getGrupo().getIntegrantes()){
                if(!integrante.equals(consumo.getHuesped())){
                    this.huespedes.add(integrante);
                }
            }
        } else{
            this.esGrupo = false;
        }
        this.consumos = new ArrayList<Consumo>();
        this.consumos.add(consumo);
        this.informacionConsumos = "";
        this.valorTotal = 0;
        contadorFactura++;
    }

    public String getNumeroFactura(){
        return Integer.toString(numeroFactura);
    }

    public String getFecha(){
        return fecha;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    public void setHuespedes(ArrayList<Huesped> huespedes){
        this.huespedes = huespedes;
    }

    public ArrayList<Huesped> getHuespedes(){
        return huespedes;
    }

    public void agregarHuesped(Huesped huesped){
        huespedes.add(huesped);
    }

    public void setHabitacion(String habitacion){
        this.habitacion = habitacion;
    }

    public String getHabitacion(){
        return habitacion;
    }

    public ArrayList<Habitacion> getHabitaciones(){
        return habitaciones;
    }
    
    public String setHabitaciones(ArrayList<Habitacion> habitaciones){
        String habitacionesString = "";
        for (Habitacion habitacion: habitaciones){
            habitacionesString = habitacionesString + habitacion.getIdentificador() + ", ";
        }
        return habitacionesString;
    }

    public void agregarHabitacion(Habitacion habitacion){
        habitaciones.add(habitacion);
    }

    public void setConsumos(ArrayList<Consumo> consumos){
        this.consumos = consumos;
    }

    public ArrayList<Consumo> getConsumos(){
        return consumos;
    }

    public void agregarConsumo(Consumo consumo){
        consumos.add(consumo);
    }

    
    public void setInformacionConsumos(String informacionConsumos){
        this.informacionConsumos = informacionConsumos;
    }

    public String getInformacionConsumos (){
        return informacionConsumos;
    }

    public String getTextoFactura(){
        return textoFactura;
    }

    public double getIva(){
        return iva;
    }

    public void setIva(double val){
        this.iva = val;
    }

    public double getValorTotal(){
        return valorTotal;
    }

    private void setValorTotal(){
        double valorTotal = 0;
        for (Consumo consumo: consumos){
            valorTotal+= consumo.getValor();
        }
        this.valorTotal = valorTotal;
    }


    public void setEsGrupo(boolean grupo){
        this.esGrupo = grupo;
    }

    public boolean isGrupo(){
        return esGrupo;
    }

    public void generarTextoFactura(){
        setValorTotal();
        String textoFactura = ("Factura #" + numeroFactura + ". Fecha: " + fecha + ". Habitación: " + habitacion + ". Huespedes: " + infoHuespedes() + ". Consumos: " + infoConsumos() + ". Valor total: " + valorTotal + ". IVA: " + iva + ".");
        this.textoFactura = textoFactura;
    }

    private String infoHuespedes(){
        String infoHuespedes = "";
        for (Huesped huesped: huespedes){
            infoHuespedes+= huesped.toString();
        }
        return infoHuespedes;
    }

    private String infoConsumos(){
        String infoConsumos = "";
        for (Consumo consumo: consumos){
            infoConsumos+= consumo.toString();
        }
        return infoConsumos;
    }

    

    public void generartextoFactura (Consumo consumo){
        String textoConsumo = ("Descripción del consumo: " + consumo.getDescripcion());

        informacionConsumos = textoConsumo;

    }

    public void generartextoFactura (ArrayList<Consumo> consumos){
        for (Consumo consumo: consumos){
           int contadorConsumos = 0;
           String textoConsumo = ("Consumo #" + contadorConsumos + ". Descripción del consumo: " + consumo.getDescripcion());
           informacionConsumos += textoConsumo;
           contadorConsumos++;
        }
    }

    

    

}