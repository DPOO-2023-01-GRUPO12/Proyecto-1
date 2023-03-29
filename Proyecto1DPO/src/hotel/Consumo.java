package hotel;

public class Consumo
{
    private static int contadorConsumos = 0;
    private int identificador;
    private String tipoCobro;
    private boolean pagoInmediato;
    private String descripcion;
    private String fecha;
    private double valor;
    private boolean pagado;
    private Servicio servicio;
    private Factura factura;
    private Reserva reserva;
    
    public Consumo(String tipo, String desc, String fecha, double valor) {
    identificador = contadorConsumos++;
    tipoCobro = tipo;
    pagoInmediato = false;
	descripcion = desc;
    fecha = this.fecha;
    valor = this.valor;
    pagado = false;
    servicio = new Servicio();
    factura = new Factura();
    reserva = new Reserva();
    contadorConsumos++;

    }

    public int getIdentificador() {
        return identificador;
    }
    
    public String getTipoCobro() {
	return tipoCobro;
    }
    
    public String getDescripcion() {
	return descripcion;
    }
    
    public String getFecha() {
	return fecha;
    }

    public String getValor() {
	return valor;
    }

    public void setPagoInmediato(boolean pago) {
	pagoInmediato = pago;
    }
    
    public boolean isPagoInmediato() {
	return pagoInmediato;
    }

    public void setPagado(boolean estado) {
	pagado   = estado;
    }

    public boolean isPagado() {
	return pagado;
    }

    public Servicio getServicio() {
        return servicio;
    }
    public Factura getFactura() {
        return factura;
    }

    public Reserva getReserva() {
        return reserva;
    }
}
