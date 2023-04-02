package model;

import java.util.ArrayList;
import java.util.Map;

public class Servicio {

    private String nombreTipo;
    private String ubicacion;
    private Map<String,ArrayList<String>> disponibilidad;
    private Tarifa tarifa;

    public Servicio(String tipo, String ubic,Map<String,ArrayList<String>> dispo, double precio){
        this.nombreTipo = tipo;
        this.ubicacion = ubic;
        this.disponibilidad = dispo;
        this.tarifa = new Tarifa(precio);
    }

    public void setTarifa(double precio){
        tarifa.setValor(precio);
    }

    public double getTarifa(){
        return tarifa.getValor();
    }

    
    
}
