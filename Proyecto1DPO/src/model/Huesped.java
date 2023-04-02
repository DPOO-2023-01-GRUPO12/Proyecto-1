package model;

import java.util.ArrayList;

public class Huesped {

    private String nombre;
    private String documento;
    private String celular;
    private String correo;
    private int edad;
    private Habitacion habitacion;
    private ArrayList<Consumo> consumosPagos;
    private ArrayList<Consumo> consumosNoPagos;


    public Huesped(String nombre, String documento, String celular, String correo, int edad){
        this.nombre = nombre;
        this.documento = documento;
        this.celular = celular;
        this.correo = correo;
        this.edad = edad;
        this.consumosPagos= new ArrayList<Consumo>();
        this.consumosNoPagos= new ArrayList<Consumo>();
    }

    public String getNombre(){
        return nombre;
    }

    public String getDocumento(){
        return documento;
    }

    public String getCelular(){
        return celular;
    }

    public String getCorreo(){
        return correo;
    }

    public int getEdad(){
        return edad;
    }

    public Habitacion getHabitacion(){
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion){
        this.habitacion = habitacion;
    }

    public void agregarConsumo (Consumo consumo){
        if (consumo.getPagado()){
            this.consumosPagos.add(consumo);
        }else{
            this.consumosNoPagos.add(consumo);
        }
    }

    public ArrayList<Consumo> getConsumosPagos(){
        return consumosPagos;

    }

    public ArrayList<Consumo> getConsumosNoPagos(){
        return consumosNoPagos;

    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + " Documento: " + documento + " Celular: " + celular + " Correo: " + correo + " Edad: " + edad;
    }
}