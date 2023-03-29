package hotel;

import java.util.ArrayList;

public class Grupo
{
    private ArrayList<Huesped> huespedes;
    private ArrayList<Servicio> serviciosUsados;
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Consumo> consumosNoPagados;
    private ArrayList<Consumo> consumosPagados;
    private ArrayList<Consumo> consumos;

    public Grupo (ArrayList<Huesped> integrantes)
    {
        this.huespedes = integrantes;
    }

    public ArrayList<Habitacion> getHabitaciones(){
	return habitaciones;
    }
    
    public ArrayList<Huesped> getIntegrantes(){
	return huespedes;
    }

    public void agregarIntegrante(Huesped huesped){
        huespedes.add(huesped);
    }
    
    public boolean isParte(Huesped huesped){
        boolean flag = false;

        if (huespedes.contains(huesped)){
            flag = true;
        }
        return flag;
    }

    public ArrayList<Consumo> getConsumos(){
        return consumos;
    }

    public void agregarConsumo(Consumo consumo){
        consumos.add(consumo);
    }

    public ArrayList<Consumo> getConsumosPagados(){
        return consumosPagados;
    }

    public ArrayList<Consumo> getConsumosNoPagados(){
        return consumosNoPagados;
    }

    public void agregarConsumoPagoNoPago(Consumo consumo, boolean pago){
        if (pago){
            consumosPagados.add(consumo);
        }
        else {
            consumosNoPagados.add(consumo);
        }
    }
    public ArrayList<Servicio> getServiciosUsados(){
	return serviciosUsados;}

    public void agregarServicioUsado(Servicio servicio){
        serviciosUsados.add(servicio);
    }






    }
    

