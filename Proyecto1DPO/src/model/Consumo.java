package model;


public class Consumo{

    private String fecha;
    private double valor;
    private double iva;
    private String tipoConsumo;
    private String habitacion;
    private boolean pagado;
    private boolean pagoInmediato;
    private boolean esGrupo;
    private String descripcion;

    public Consumo(String tipoConsumo,String habitacion){
        this.tipoConsumo=tipoConsumo;
        this.habitacion=habitacion;
    }


    

}