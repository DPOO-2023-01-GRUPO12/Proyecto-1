package model;

import java.util.ArrayList;
import java.time.*;

public class TipoHabitacion {

    private String nombreTipo;
    private ArrayList<TarifaCuarto> tarifas;
    private TarifaCuarto tarifaActual;


    public TipoHabitacion(String tipo){
        this.nombreTipo = tipo;
        tarifas = new ArrayList<TarifaCuarto>();
    }
    
    public void setRangoFechas(String rango) {

        for (TarifaCuarto fee:this.tarifas ) {
            fee.setRangoFechas(rango);
        }
        
    }

    public void agregarDiaSemana(String dia) {
//TODO
        for (TarifaCuarto fee:this.tarifas ) {
            ArrayList<String>dias=fee.getDiasSemana();
            dias.add(dia);
        }
        
    }

    public void agregarTarifaCuarto(TarifaCuarto tarifa) {

        this.tarifas.add(tarifa);

    }

    public void setTarifaActual() {   
        LocalDate fechaActual = LocalDate.now();

        for (TarifaCuarto fee:this.tarifas ) {
            String[] fechas= fee.getRangoFechas().split("-");
            
            
        }
        
    }
}
