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

    private static ArrayList<Servicio> servicios = new ArrayList<Servicio>();
    
    public Servicio(String ti, String pago, String cobro) {
	tipo = ti;
	formaPago = pago;
	tipoCobro = cobro;
    servicioCuarto=false;
    disponibilidad = new HashMap<String,ArrayList<String>>();
    servicios.add(this);
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
        

    public static ArrayList<Servicio> getServicios(){
        return servicios;
    }
}
