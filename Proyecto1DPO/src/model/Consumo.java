package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Consumo{

    private String fecha;
    private double valor;
    private double iva;
    private Huesped huesped;
    private String tipoConsumo;
    private String habitacion;
    private Habitacion habitacionAsignada;
    private boolean pagado;
    private boolean pagoInmediato;
    private boolean esGrupo;
    private String descripcion;
    private Factura factura;
    private Grupo grupo;

    public Consumo(String tipoConsumo,Habitacion habitacion,double valor){
        this.tipoConsumo=tipoConsumo;
        this.habitacion=habitacion.getIdentificador();
        this.habitacionAsignada=habitacion;
        this.valor=valor;
        this.iva= valor*0.19;
        this.esGrupo=false;
        this.pagado=false;
        this.pagoInmediato=false;

        LocalDate fechaActual=LocalDate.now();
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd LLLL yyyy");
        this.fecha=fechaActual.format(formato); 
    }

    public Consumo(String tipoConsumo,double valor){
        this.tipoConsumo=tipoConsumo;
        this.valor=valor;
        this.iva= valor*0.19;
        this.esGrupo=false;
        this.pagado=false;
        this.pagoInmediato=false;

        LocalDate fechaActual=LocalDate.now();
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd LLLL yyyy");
        this.fecha=fechaActual.format(formato);
    }

    public Consumo(Huesped huesped, String tipoConsumo,double valor){
        this.huesped=huesped;
        this.habitacionAsignada = huesped.getHabitacion();
        this.habitacion=huesped.getHabitacion().getIdentificador();
        this.tipoConsumo=tipoConsumo;
        this.valor=valor;
        this.iva= valor*0.19;
        this.esGrupo=false;
        this.pagado=false;
        this.pagoInmediato=false;

        LocalDate fechaActual=LocalDate.now();
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd LLLL yyyy");
        this.fecha=fechaActual.format(formato);
    }

    public Huesped getHuesped(){
        return this.huesped;
    }

    public void setHabitacion(String habitacion){
        this.habitacion=habitacion;
    }

    public void setValor(double valor){
        this.valor=valor;
    }

    public void setEsGrupo(boolean grupo){
        this.esGrupo=grupo;
    }

    public void setPagado(boolean pago){
        setDescripcion(toString());
        this.pagado=pago;
    }

    @Override
    public String toString(){
        return "Fecha: "+this.fecha+", Habitacion: "+this.habitacion+", Tipo de consumo: "+this.tipoConsumo+", Valor: "+this.valor+", Iva: "+this.iva + ", Es grupo: " + String.valueOf(this.isGrupo());

    }

    public void setPagoInmediato(boolean pago){
        this.pagoInmediato=pago;
    }   

    public void setFactura(){
        this.factura= new Factura(this.habitacionAsignada);
    }

    public void setFactura(Factura far){
        this.factura= far;
    }

    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }

    public String getFecha(){
        return this.fecha;
    }

    public double getValor(){
        return this.valor;
    }

    public double getIva(){
        return this.iva;
    }

    public String getTipoConsumo(){
        return this.tipoConsumo;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public boolean isGrupo() {
        return this.esGrupo;
    }

    public String getHabitacion() {
        return this.habitacion;
    }

    public Habitacion getHabitacionAsignada() {
        return this.habitacionAsignada;
    }

    public boolean getPagado(){
        return this.pagado;
    }

    public boolean getPagoInmediato(){
        return this.pagoInmediato;
    }

    public Factura getFactura(){
        return this.factura;
    }

    public void setGrupo(Grupo grupo){
        this.grupo=grupo;
    }

    public Grupo getGrupo(){
        return this.grupo;
    }

}