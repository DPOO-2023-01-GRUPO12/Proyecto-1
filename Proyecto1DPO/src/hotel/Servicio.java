package hotel;

import java.util.ArrayList;

public class Servicio
{
    private String tipo;
    private String formaPago;
    private String tipoCobro;
    private boolean servicioCuarto;
    private Restaurante restaurante;

    private static ArrayList<Servicio> servicios = new ArrayList<Servicio>();
    
    public Servicio(String ti, String pago, String cobro) {
	tipo = ti;
	formaPago = pago;
	tipoCobro = cobro;
    servicios.add(this);
    }
    
    public void setServicioCuarto(boolean servicio) {
	servicioCuarto = servicio;
    }
    
    public boolean hasServicioCuarto() {
	return servicioCuarto;
    }

    public static ArrayList<Servicio> getServicios(){
        return servicios;
    }
}
