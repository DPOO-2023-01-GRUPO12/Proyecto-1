package model;

import java.util.ArrayList;

public class Habitacion {

    private String identificador;
    private String ubicacion;
    private int capacidad;
    private boolean balcon;
    private boolean vista;
    private boolean cocina;
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
        noPagos.add(consumo);
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



    @Override
    public String toString(){
        return "ID: " + this.getIdentificador()  + ", Ubicacion: "  + this.getUbicacion()  + ", Capacidad: "  + String.valueOf(this.getCapacidad())  + ", Balcon:"  + String.valueOf(this.hasBalcon()) + ", Vista: " + String.valueOf(this.hasVista()) + ", Cocina: " + String.valueOf(this.hasCocina()) + ", Descripcion: " + this.getDescripcion() + ", Camas: " + this.getCamas().toString() + ", Reservas: " + this.getReservas().toString() + ", Tipo habitacion: " + this.getTipoHabitacion().toString() + ", Consumos pagos: " + this.getConsumosPagos().toString() + ", Consumos no pagos: " + this.getConsumosNoPagos().toString() + ", Huespedes Alojados: " + this.getHuespedesAlojados().toString();

    }

    public void agregarConsumoPago(String tipo,double valor){
        Consumo consumo= new Consumo(tipo, valor);
        consumo.setHabitacion(this.identificador);
        consumo.setPagado(true);

        this.pagos.add(consumo);
    }

    public void agregarConsumoNoPago(String tipo,double valor){
        Consumo consumo= new Consumo(tipo, valor);
        consumo.setHabitacion(this.identificador);

        this.noPagos.add(consumo);
    }


}