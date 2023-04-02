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
            LocalDate fechaIn=LocalDate.parse(fechas[0]);
            LocalDate fechaFin=LocalDate.parse(fechas[1]);
            
            Period intervalo= Period.between(fechaIn, fechaFin);
            int meses= intervalo.getMonths();
            int dias= intervalo.getDays();

            Period revisaPeriod= Period.between(fechaActual, fechaFin);
            int mesesR= revisaPeriod.getMonths();
            int diasR= revisaPeriod.getDays();

            if (mesesR < meses ) {
                this.tarifaActual=fee;
            } else if (mesesR == meses ){
                if (diasR<dias){
                    this.tarifaActual=fee;
                }
            }  
        } 
    }

    public String getNombreTipo() {
        return this.nombreTipo;
    }

    public ArrayList<TarifaCuarto> getTarifas() {
        return this.tarifas;
    }

    public TarifaCuarto getTarifaActual() {
        return this.tarifaActual;
    }

    @Override
    public String toString(){
        return "Nombre del tipo de habitación: " + getNombreTipo() + "Tarifas de la habitación: " + getTarifas() + "Tarifa actual de la habitación" + getTarifaActual();
    }
}
