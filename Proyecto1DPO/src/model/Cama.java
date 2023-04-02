package model;


public class Cama {
    private String tamanio;
    private int cantidadPersonas;
    private boolean ninios;


    public Cama(String tamanio, int cantidad){
        this.tamanio = tamanio;
        this.cantidadPersonas = cantidad;
    }

    public void setNinios(boolean ninios){
        this.ninios = ninios;
    }

    public int getCantidadPersonas(){
        return cantidadPersonas;
    }

    public String getTamanio(){
        return tamanio;
    }

    public boolean isNinios(){
        return ninios;
    }

    @Override
    public String toString(){
        return "Tamanio: " + getTamanio() + ", Cantidad Personas: " + getCantidadPersonas() + "Apta para ninios: " + isNinios();

    }
}