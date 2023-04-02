package model;

import java.util.ArrayList;

public class TarifaCuarto {

    private String tipoCuarto;
    private String rangoFechas;
    private ArrayList<String> diasSemana;
    private double valor;
//TODO
    public TarifaCuarto(String cuarto,String rango,ArrayList<String> dias,double valor) {
        this.tipoCuarto=cuarto;
        this.rangoFechas= rango;
        this.diasSemana=dias;
        this.valor=valor;
    }

    public String getTipoCuarto(){
        return this.tipoCuarto;
    }

    public String getRangoFechas() {
        return this.rangoFechas;
    }

    public ArrayList<String> getDiasSemana() {
        return this.diasSemana;
    }

    public double getValor(){
        return this.valor;
    }

    public void setRangoFechas(String rango){
        this.rangoFechas= rango;
    }
    
    public void setDiasSemana(ArrayList<String> dias){
        this.diasSemana= dias;
    }

    @Override
    public String toString(){
        return "Tipo Cuarto" + getTipoCuarto() + ", Rango Fechas: " + getRangoFechas() + ", Dias Semana: " + getDiasSemana() + ", Valor: " + getValor() ;

    }
}
