package console;

import model.InformacionHotel;

public class Autenticador {
    private InformacionHotel informacionHotel;

    public Autenticador(InformacionHotel informacionHotel){
        this.informacionHotel = informacionHotel;
    }

    public boolean revisarExistencia(String login){
        if(informacionHotel.getUsuarios().containsKey(login)){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public String revisarTipo(String login){
        return informacionHotel.getUsuarios().get(login).get(1);
    }
}
