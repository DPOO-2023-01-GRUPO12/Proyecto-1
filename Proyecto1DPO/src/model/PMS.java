package model;
public class PMS {
    private Cargador cargador;
    private InformacionHotel informacion;
    private GuardadorInformacion guardador;

    public PMS(){
        cargador = new Cargador();
        informacion = new InformacionHotel();
        guardador = new GuardadorInformacion();
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
