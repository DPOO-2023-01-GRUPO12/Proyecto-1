package model;
public class PMS {
    private Cargador cargador;
    private InformacionHotel informacion;
    private GuardadorInformacion guardador;

    public PMS(){
        informacion = new InformacionHotel();
        cargador = new Cargador(informacion);
        guardador = new GuardadorInformacion(informacion);
    }

    public Cargador getCargador(){
        return cargador;
    }
    
    public InformacionHotel getInformacionHotel(){
        return informacion;
    }

    public GuardadorInformacion getGuardador(){
        return guardador;
    }


}
