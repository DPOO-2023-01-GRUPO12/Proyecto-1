package hotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Servicio
{
    private String tipo;
    private String formaPago;
    private String tipoCobro;
    private boolean servicioCuarto;
    private Restaurante restaurante;
    private Map<String,ArrayList<String>> disponibilidad;
    
    public Servicio(String ti, String pago, String cobro) {
	tipo = ti;
	formaPago = pago;
	tipoCobro = cobro;
    servicioCuarto=false;
    disponibilidad = new HashMap<String,ArrayList<String>>();
    }


    public String getTipo() {
        return tipo;
    }

    public String getFormaPago(){
        return formaPago;
    }

    public String getTipoCobro(){
        return tipoCobro;
    }
    
    public void setServicioCuarto(boolean servicio) {
	servicioCuarto = servicio;
    }
    
    public boolean hasServicioCuarto() {
	return servicioCuarto;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void agregarDisponibilidad(String dia, ArrayList<String> horas)
    {
        disponibilidad.put(dia, horas);
    }

    public Map<String,ArrayList<String>> getDisponibilidad()
    {
        return disponibilidad;
    }
        
}
