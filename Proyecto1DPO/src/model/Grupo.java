package model;

import java.util.ArrayList;

public class Grupo {
    private static int contadorGrupo = 0 ;
    private int identificador;
    private ArrayList<Huesped> integrantes;
    private ArrayList<Consumo> consumos;

    public Grupo (){
        this.identificador=contadorGrupo;
        this.integrantes=new ArrayList<Huesped>();
        this.consumos =new ArrayList<Consumo>();
        contadorGrupo++;
    }

    public int getIdentificador() {
        return this.identificador;
    }

    public ArrayList<Consumo> getConsumos() {
        return this.consumos;
    }

    public ArrayList<Huesped> getIntegrantes() {
        return this.integrantes;
    }

    public void agregarIntegrante(Huesped huesped){
        this.integrantes.add(huesped);
        contadorGrupo++;
    }

    public void agregarConsumo(Consumo consumo){
        this.consumos.add(consumo);
    }


}
