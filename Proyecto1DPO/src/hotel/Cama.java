package hotel;

import java.util.ArrayList;

public class Cama
{
    private String tamanio;
    private int cantidadPersonas;
    private boolean ninios;
    private static ArrayList<Cama> camas = new ArrayList<Cama>();
    
    public Cama(String tam, int cantidad) {
	tamanio = tam;
	cantidadPersonas = cantidad;
    camas.add(this);
    }
    
    public void setNinios(boolean nin) {
	ninios = nin;
    }
    
    public boolean hasNinios() {
	return ninios;
    }
    
    public String getTamanio() {
	return tamanio;
    }
    
    public int getCantidadPersonas() {
	return cantidadPersonas;
    }

    public static ArrayList<Cama> getCamas(){
        return camas;
    }

}
