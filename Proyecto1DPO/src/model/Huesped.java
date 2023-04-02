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
    }

    public ArrayList<Consumo> getConsumosPagos(){
        return consumosPagos;

    }

    public ArrayList<Consumo> getConsumosNoPagos(){
        return consumosNoPagos;

    }
}