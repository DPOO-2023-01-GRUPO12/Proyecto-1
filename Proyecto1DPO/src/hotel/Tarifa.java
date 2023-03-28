package hotel;

import java.util.ArrayList;

public class Tarifa
{
    private static int contadorTarifas;
    private int identificador;
    private String tipoCuarto;
    private ArrayList<String> rangoFechas;
    private ArrayList<String> diasSemana;
    private double valor;
    private static ArrayList<Tarifa> tarifas = new ArrayList<Tarifa>();
    
    public Tarifa(String cuarto, ArrayList<String> fechas, ArrayList<String> dias, double valor) {
	identificador = contadorTarifas;
    tipoCuarto = cuarto;
	rangoFechas = fechas;
	diasSemana = dias;
    this.valor = valor;
    tarifas.add(this);
    contadorTarifas++;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setTipo(String tipo){
        tipoCuarto = tipo;
    }
    

    public String getTipoCuarto() {
	return tipoCuarto;
    }

    public void setRangoFechas(ArrayList<String> fechas){
        rangoFechas = fechas;
    }
    
    public ArrayList<String> getRangoFechas(){
	return rangoFechas;
    }

    public void setDiasSemana(ArrayList<String> dias){
        diasSemana = dias;
    }
    
    public ArrayList<String> getDiasSemana(){
	return diasSemana;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public double getValor(){
        return valor;
    }
    
    public static ArrayList<Tarifa> getTarifas(){
        return tarifas;
    }

}
