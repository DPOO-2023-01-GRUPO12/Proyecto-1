package model;

import persistencia.Cargador;
import persistencia.GuardadorInformacion;

public class PMS {
    private Cargador cargador;
    private Hotel informacion;
    private GuardadorInformacion guardador;

    public PMS(){
        informacion = new Hotel();
        cargador = new Cargador(informacion);
        guardador = new GuardadorInformacion(informacion);
    }

    public Cargador getCargador(){
        return cargador;
    }
    
    public Hotel getInformacionHotel(){
        return informacion;
    }

    public GuardadorInformacion getGuardador(){
        return guardador;
    }


}
