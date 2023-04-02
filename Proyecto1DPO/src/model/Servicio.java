package model;

import java.util.ArrayList;
import java.util.Map;

public class Servicio {

    private String nombreTipo;
    private String ubicacion;
    private Map<String,ArrayList<String>> disponibilidad;
    private Tarifa tarifa;
    private String tipoCobro;
    private boolean servicioCuarto;

    public Servicio(String tipo, String ubic,Map<String,ArrayList<String>> dispo, double precio,String tipoCobro){
        this.nombreTipo = tipo;
        this.ubicacion = ubic;
        this.disponibilidad = dispo;
        this.tarifa = new Tarifa(precio);
        this.tipoCobro = tipoCobro;
    }

    public void setTarifa(double precio){
        tarifa.setValor(precio);
    }

    public double getTarifa(){
        return tarifa.getValor();
    }

    public String getTipoCobro(){
        return tipoCobro;
    }
    
    public void setServicioCuarto(boolean servicio){
        this.servicioCuarto = servicio;
    }

    public boolean hasServicioCuarto(){
        return servicioCuarto;
    }

    
    
}
