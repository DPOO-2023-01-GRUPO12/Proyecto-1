package model;

import java.util.ArrayList;
import java.util.Map;

public class Restaurante{

    private boolean tomadoComedor;
    private String ubicacion;
    private Map<String, ArrayList<String>> disponibilidad;
    private ArrayList<Plato> platos;
    private ArrayList<Bebida> bebidas;


    public Restaurante(String ubicacion){
        this.ubicacion = ubicacion;
        platos = new ArrayList<Plato>();
        bebidas  = new ArrayList<Bebida>();
    }

    public void setTomadoComedor(boolean comedor){
        this.tomadoComedor = comedor;
    }

    public void agregarPlato (Plato plato){
        platos.add(plato);

    }

    public void agregarBebida (Bebida bebida){
        bebidas.add(bebida);
    }

    public void agregarDisponibilidad (String dias,ArrayList<String> horas){
        this.disponibilidad.put(dias, horas);
    }

    public boolean getTomadoComedor (){
        return this.tomadoComedor;
    }

    public String getUbicacion (){
        return this.ubicacion;
    }
}