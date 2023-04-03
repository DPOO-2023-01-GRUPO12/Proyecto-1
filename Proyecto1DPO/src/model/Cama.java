package model;


public class Cama {
    private String tamanio;
    private int cantidadPersonas;
    private boolean ninios;


    public Cama(String tamanio, int cantidad){
        this.tamanio = tamanio;
        this.cantidadPersonas = cantidad;
    }

    public String getTamanio(){
        return tamanio;
    }

    public void setTamanio(String tam){
        this.tamanio = tam;
    }

    public int getCantidadPersonas(){
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cant){
        this.cantidadPersonas = cant;
    }

    public void setNinios(boolean ninios){
        this.ninios = ninios;
    }

    public boolean isNinios(){
        return ninios;
    }

    @Override
    public String toString(){
        return "Tamanio: " + getTamanio() + ", Cantidad Personas: " + getCantidadPersonas() + "Apta para ninios: " + isNinios();

    }
}