package model;

import java.util.ArrayList;

public class Grupo {
    private int contadorGrupo;
    private int identificador;
    private ArrayList<Huesped> integrantes;
    private ArrayList<Consumo> consumos;
    static int contador;

    public Grupo (){
        contador++;
        this.contadorGrupo=0;
        this.identificador=contador; //REVISAR
        this.integrantes=new ArrayList<Huesped>();
        this.consumos =new ArrayList<Consumo>();
    }

    public int getIdentificador() {
        return this.identificador;
    }

    public ArrayList<Consumo> getConsumos() {
        return this.consumos;
    }

    public ArrayList<Huesped> getIntegrantes() {
        return this.integrantes;
        this.contadorGrupo++;
    }

    public void agregarIntegrante(Huesped huesped){
        this.integrantes.add(huesped);
    }

    public void agregarConsumo(Consumo consumo){
        this.consumos.add(consumo);
    }

}
