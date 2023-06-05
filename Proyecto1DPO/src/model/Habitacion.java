package model;

import java.util.ArrayList;

public class Habitacion {

    private String identificador;
    private String ubicacion;
    private int capacidad;
    private boolean balcon;
    private boolean vista;
    private boolean cocina;

    private boolean aireAcondicionado;
    private boolean calefaccion;
    private boolean TV;
    private boolean cafetera;
    private boolean ropaDeCama;
    private boolean plancha;
    private boolean secador;
    private boolean USBA;
    private boolean USBC;
    private boolean desayuno;
    
    private String descripcion;
    private ArrayList<Cama> camas;
    private ArrayList<Reserva> reservas;
    private Reserva reservaActual;
    private TipoHabitacion tipoHabitacion;
    private ArrayList<Consumo> pagos;
    private ArrayList<Consumo> noPagos;
    private ArrayList<Huesped> alojados;
    private boolean disponiblidad;
    private ArrayList<String> fechasBloqueadas;
    


    public Habitacion(String id, String ubic, String desc){

        this.identificador = id;
        this.ubicacion = ubic;
        this.descripcion = desc;
        this.pagos= new ArrayList<Consumo>();
        this.noPagos= new ArrayList<Consumo>();
        this.reservas = new ArrayList<Reserva>();
        this.alojados = new ArrayList<Huesped>();
        this.fechasBloqueadas = new ArrayList<String>();

    }

    public void setTipoHabitacion (TipoHabitacion tipo){
        tipoHabitacion = tipo;
    }

    public void setCamas(ArrayList<Cama> camas){
        this.camas = camas;
        calcularCapacidad();
    }
    
    public void setBalcon (boolean balcon){
        this.balcon = balcon;
    }

    public void setVista (boolean vista){
        this.vista = vista;
    }

    public void setCocina (boolean cocina){
        this.cocina = cocina;
    }

    public void setDisponibilidad (boolean disponible){
        disponiblidad = disponible;
    }

    

    public void calcularCapacidad (){
        int capacidadCamas = 0;
        for (Cama cama: camas ){
            int cantidad = cama.getCantidadPersonas();
            capacidadCamas += cantidad;
        }

        this.capacidad = capacidadCamas;

    }

    public ArrayList<Reserva> getReservas(){

        return reservas;
    }

    public void setReservaActual (Reserva reserva){
        reservaActual = reserva;
    }

    public Reserva getReservaActual(){
        return reservaActual;
    }

    public String getIdentificador(){
        return identificador;
    }

    public String getUbicacion(){
        return ubicacion;
    }

    public int getCapacidad(){
        return capacidad;
    }

    public boolean hasBalcon(){
        return balcon;
    }

     public boolean hasVista(){
        return vista;
    }

     public boolean hasCocina(){
        return cocina;
    }

    public boolean hasDisponibilidad(){
        return disponiblidad;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public ArrayList<String> getFechasBloqueadas(){
        return fechasBloqueadas;
    }

    public void agregarFechaBloqueada(String rango){
        fechasBloqueadas.add(rango);
    }

    public void eliminarFechaBloqueada(String rango){
        fechasBloqueadas.remove(rango);
    }

    public void agregarPago(Consumo consumo){
        pagos.add(consumo);
    }

    public void agregarHuesped(Huesped huesped){
        alojados.add(huesped);
    }

    public void agregarReserva(Reserva reserva){
        reservas.add(reserva);
    }

    public void agregarConsumo(Consumo consumo){
        if (consumo.isPago()){
            this.pagos.add(consumo);
        } else {
            this.noPagos.add(consumo);
        }
    }

    public ArrayList<Cama> getCamas(){
        return camas;
    }

    public TipoHabitacion getTipoHabitacion(){
        return tipoHabitacion;
    }

    public ArrayList<Consumo> getConsumosPagos(){
        return pagos;
    }

    public ArrayList<Consumo> getConsumosNoPagos(){
        return noPagos;
    }

    public ArrayList<Huesped> getHuespedesAlojados(){
        return alojados;
    } 



    public boolean isAireAcondicionado() {
		return aireAcondicionado;
	}

	public void setAireAcondicionado(boolean aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}

	public boolean isCalefaccion() {
		return calefaccion;
	}

	public void setCalefaccion(boolean calefaccion) {
		this.calefaccion = calefaccion;
	}

	public boolean isTV() {
		return TV;
	}

	public void setTV(boolean tV) {
		TV = tV;
	}

	public boolean isCafetera() {
		return cafetera;
	}

	public void setCafetera(boolean cafetera) {
		this.cafetera = cafetera;
	}

	public boolean isRopaDeCama() {
		return ropaDeCama;
	}

	public void setRopaDeCama(boolean ropaDeCama) {
		this.ropaDeCama = ropaDeCama;
	}

	public boolean isPlancha() {
		return plancha;
	}

	public void setPlancha(boolean plancha) {
		this.plancha = plancha;
	}

	public boolean isSecador() {
		return secador;
	}

	public void setSecador(boolean secador) {
		this.secador = secador;
	}

	public boolean isUSBA() {
		return USBA;
	}

	public void setUSBA(boolean uSBA) {
		USBA = uSBA;
	}

	public boolean isUSBC() {
		return USBC;
	}

	public void setUSBC(boolean uSBC) {
		USBC = uSBC;
	}

	public boolean isDesayuno() {
		return desayuno;
	}

	public void setDesayuno(boolean desayuno) {
		this.desayuno = desayuno;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
    public String toString(){
        return "ID: " + this.getIdentificador()  + ", Ubicacion: "  + this.getUbicacion()  + ", Capacidad: "  + String.valueOf(this.getCapacidad())  + ", Balcon:"  + String.valueOf(this.hasBalcon()) + ", Vista: " + String.valueOf(this.hasVista()) + ", Cocina: " + String.valueOf(this.hasCocina()) + ", Descripcion: " + this.getDescripcion() + ", Camas: " + this.getCamas().toString() + ", Reservas: " + this.getReservas().toString() + ", Tipo habitacion: " + this.getTipoHabitacion().toString() + ", Consumos pagos: " + this.getConsumosPagos().toString() + ", Consumos no pagos: " + this.getConsumosNoPagos().toString() + ", Huespedes Alojados: " + this.getHuespedesAlojados().toString();

    }


}