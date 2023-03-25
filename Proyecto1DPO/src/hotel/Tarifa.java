package hotel;

import java.util.ArrayList;

public class Tarifa
{
    private String tipoCuarto;
    private ArrayList<String> rangoFechas;
    private ArrayList<String> diasSemana;
    
    public Tarifa(String cuarto, ArrayList<String> fechas, ArrayList<String> dias) {
	tipoCuarto = cuarto;
	rangoFechas = fechas;
	diasSemana = dias;
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

}
