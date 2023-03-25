package hotel;

public class Servicio
{
    private String tipo;
    private String formaPago;
    private String tipoCobro;
    private boolean servicioCuarto;
    private Menu menu;
    
    public Servicio(String ti, String pago, String cobro) {
	tipo = ti;
	formaPago = pago;
	tipoCobro = cobro;
    }
    
    public void setServicioCuarto(boolean servicio) {
	servicioCuarto = servicio;
    }
    
    public boolean hasServicioCuarto() {
	return servicioCuarto;
    }
}
