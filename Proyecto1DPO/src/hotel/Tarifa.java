package hotel;

import java.util.ArrayList;

public class Tarifa
{
    private String tipoCuarto;
    private ArrayList<String> rangoFechas;
    private ArrayList<String> diasSemana;
    private double valor;
    private static ArrayList<Tarifa> tarifas = new ArrayList<Tarifa>();
    
    public Tarifa(String cuarto, ArrayList<String> fechas, ArrayList<String> dias, double valor) {
	tipoCuarto = cuarto;
	rangoFechas = fechas;
	diasSemana = dias;
    this.valor = valor;
    tarifas.add(this);
    }
    
    public String getTipoCuarto() {
	return tipoCuarto;
    }
    
    public ArrayList<String> getRangoFechas(){
	return rangoFechas;
    }
    
    public ArrayList<String> getDiasSemana(){
	return diasSemana;
    }

    public double getValor(){
        return valor;
    }
    
    public static ArrayList<Tarifa> getTarifas(){
        return tarifas;
    }

}
