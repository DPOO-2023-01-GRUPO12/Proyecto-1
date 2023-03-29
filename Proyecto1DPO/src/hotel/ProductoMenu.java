package hotel;

import java.util.ArrayList;

public class ProductoMenu
{
    private String nombre;
    private float precio;
    private boolean bebida;
    private ArrayList<String> disponibilidad;
    
    public ProductoMenu(String nom, float pre, ArrayList<String> dispo) {
	nombre = nom;
	precio = pre;
    bebida = false;
	disponibilidad = dispo;
    }
    
    public String getNombre() {
	return nombre;
    }
    
    public float getPrecio() {
	return precio;
    }

    public void setBebida(boolean beb) {
        bebida = beb;
    }

    public boolean isBebida() {
        return bebida;
    }
    
    public ArrayList<String> getDisponibilidad() {
	    return disponibilidad;
    }
    
}
