package hotel;

import java.util.ArrayList;

public class Registro
{
    private boolean entrada;
    private ArrayList<Consumo> consumos;
    private ArrayList<Consumo> consumosPagados;
    private Huesped checkin;
    
    public void setEntrada() {
	entrada = false;
    consumos = new ArrayList<Consumo>();
    consumosPagados = new ArrayList<Consumo>();
    }

    public void setEntrada(boolean en){
        entrada = en;
    }

    public boolean isEntrada() {
        return entrada;
        }

    public void agregarConsumo(Consumo consumo) {
        consumos.add(consumo);
    }

    public ArrayList<Consumo> getConsumos() {
        return consumos;
    }


    public void agregarConsumoPagado(Consumo consumo) {
        consumosPagados.add(consumo);
    }

    public ArrayList<Consumo> getConsumosPagados() {
        return consumosPagados;
    }
    
    

    public void setCheckin(Huesped huesped) {
        checkin = huesped;
    }

    public Huesped getCheckin() {
        return checkin;
    }

}
