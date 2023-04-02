package model;

public class Bebida {
    
    private String nombre;
    private String rangoHoras;
    private String comidaDispon;
    private String lugarDispon;
    private Tarifa tarifa;
    private boolean servicioCuarto;

    public Bebida(String nombre,double precio,String rangoHoras,String comidaDispon,String lugarDispon){
        this.nombre=nombre;
        this.rangoHoras=rangoHoras;
        this.comidaDispon=comidaDispon;
        this.lugarDispon=lugarDispon;
        this.tarifa.setValor(precio);
        this.servicioCuarto=false;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nom){
        this.nombre=nom;
    }

    public String getRangoHoras(){
        return this.rangoHoras;
    }

    public void setRangoHoras(String rango){
        this.rangoHoras=rango;
    }

    public String getComidaDispon(){
        return this.comidaDispon;
    }

    public void setComidaDispon(String comida){
        this.comidaDispon=comida;
    }

    public String getLugarDispon(){
        return this.lugarDispon;
    }

    public void setLugarDispon(String lugar){
        this.lugarDispon=lugar;
    }

    public double getTarifa(){
        return this.tarifa.getValor();
    }

    public void setTarifa(double precio){
        this.tarifa.setValor(precio);
    }

    public boolean hasServicioCuarto(){
        return this.servicioCuarto;
    }

    public void setServicioCuarto(boolean servicio){
        this.servicioCuarto=servicio;
    }
}
