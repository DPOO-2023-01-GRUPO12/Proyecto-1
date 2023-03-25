package hotel;

public class Consumo
{
    private String tipoCobro;
    private boolean pagoInmediato;
    private String descripcion;
    private Servicio servicio;
    
    public Consumo(String tipo, String desc) {
	tipoCobro = tipo;
	descripcion = desc;
    }
    
    public String getTipoCobro() {
	return tipoCobro;
    }
    
    public String getDescripcion() {
	return descripcion;
    }
    
    public void setPagoInmediato(boolean pago) {
	pagoInmediato = pago;
    }
    
    public boolean isPagoInmediato() {
	return pagoInmediato;
    }

}
