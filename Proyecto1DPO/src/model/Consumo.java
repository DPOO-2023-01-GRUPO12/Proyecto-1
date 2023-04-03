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
    
    public String getFecha(){
        return this.fecha;
    }

    public void setFecha(String fecha){
        this.fecha=fecha;
    }

    public double getValor(){
        return this.valor;
    }

    public void setValor(double valor){
        this.valor=valor;
    }

    public double getIva(){
        return this.iva;
    }

    public void setIva(double iva){
        this.iva=iva;
    }

    public Huesped getHuesped(){
        return this.huesped;
    }

    public void setHuesped(Huesped huesped){
        this.huesped=huesped;
    }

    public String getTipoConsumo(){
        return this.tipoConsumo;
    }

    public void setTipoConsumo(String tipoConsumo){
        this.tipoConsumo=tipoConsumo;
    }
    
    public String getHabitacion() {
        return this.habitacion;
    }

    public void setHabitacion(String habitacion){
        this.habitacion=habitacion;
    }

    public Habitacion getHabitacionAsignada() {
        return this.habitacionAsignada;
    }

    public void setHabitacionAsignada(Habitacion habitacionAsignada){
        this.habitacionAsignada=habitacionAsignada;
    }

    public boolean isPago(){
        return this.pagado;
    }

    public void setPago(boolean pago){
        this.pagado=pago;
    }

    public boolean isPagoInmediato(){
        return this.pagoInmediato;
    }

    public void setPagoInmediato(boolean pago){
        this.pagoInmediato=pago;
    }
   
    public boolean isGrupo(){
        return this.esGrupo;
    }

    public void setEsGrupo(boolean grupo){
        this.esGrupo=grupo;
    }

    public void setPagado(boolean pago){
        setDescripcion(toString());
        this.pagado=pago;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    
    public Factura getFactura(){
        return this.factura;
    }

    public void setFactura(Factura far){
        this.factura= far;
    }

    public void setFactura(){
        this.factura= new Factura(this.habitacionAsignada);
    }

    public Grupo getGrupo(){
        return this.grupo;
    }


    public void setGrupo(Grupo grupo){
        this.grupo=grupo;
    }
    
    @Override
    public String toString(){
        return "Fecha: "+this.fecha+", Habitacion: "+this.habitacion+", Tipo de consumo: "+this.tipoConsumo+", Valor: "+this.valor+", Iva: "+this.iva + ", Es grupo: " + String.valueOf(this.isGrupo());

    }

    

    

    

    

}