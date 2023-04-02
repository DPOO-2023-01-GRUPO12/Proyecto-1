package model;

import java.util.ArrayList;

public class Factura{ 

    private static int contadorFactura= 0;
    private int numeroFactura;
    private String fecha;
    private ArrayList<Huesped> huespedes;
    private String habitacion;
    private String informacionConsumos;
    private double iva;
    private double valorTotal;
    private boolean esGrupo;

    public Factura(String habitacion){
        this.numeroFactura = contadorFactura;
        this.habitacion = habitacion;
        this.huespedes = new ArrayList<Huesped>();
        this.informacionConsumos = "";
        this.valorTotal = 0;
        this.esGrupo = false;
        contadorFactura++;
    }

    public void setHabitacion(String habitacion){
        this.habitacion = habitacion;
    }

    public String getHabitacion(){
        return habitacion;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public String getFecha(){
        return fecha;
    }

    public void setHuespedes(ArrayList<Huesped> huespedes){
        this.huespedes = huespedes;
    }

    public ArrayList<Huesped> getHuespedes(){
        return huespedes;
    }

    public void setInformacionConsumos(String informacionConsumos){
        this.informacionConsumos = informacionConsumos;
    }

    public void agregarHuesped(Huesped huesped){
        huespedes.add(huesped);
    }

    public void setEsGrupo(boolean grupo){
        this.esGrupo = grupo;
    }

    public boolean isGrupo(){
        return esGrupo;
    }

    public void generartextoFactura (Consumo consumo){
        String textoConsumo = ("Descripción del consumo: " + consumo.getDescripcion());

        informacionConsumos = textoConsumo;

    }



    private void setValorTotal (double valorTotal){
        this.valorTotal = valorTotal;
    }

    public void generartextoFactura (ArrayList<Consumo> consumos){
        for (Consumo consumo: consumos){
           int contadorConsumos = 0;
           String textoConsumo = ("Consumo #" + contadorConsumos + ". Descripción del consumo: " + consumo.getDescripcion());
           informacionConsumos += textoConsumo;
           contadorConsumos++;
        }
    }

    public String getInformacionConsumos (){
        return informacionConsumos;
    }
}