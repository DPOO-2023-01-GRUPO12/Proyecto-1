package hotel;

import java.util.ArrayList;

public class ProductoMenu
{
    private String nombre;
    private float precio;
    private boolean bebida;
    private ArrayList<Integer> disponibilidad;
    
    public ProductoMenu(String nom, float pre, ArrayList<Integer> dispo) {
	nombre = nom;
	precio = pre;
	disponibilidad = dispo;
    }
    
    public String getNombre() {
	return nombre;
    }
    
    public float getPrecio() {
	return precio;
    }
    
    public ArrayList<Integer> setDisponibilidad() {
	return disponibilidad;
    }
    
}
