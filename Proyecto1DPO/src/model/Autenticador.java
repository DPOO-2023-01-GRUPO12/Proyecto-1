package model;

public class Autenticador {
    private PMS pms;

    public Autenticador(PMS pms){
        this.pms = pms;
    }

    public boolean revisarExistencia(String login){
        if(pms.getUsuarios().containsKey(login)){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public String revisarTipo(String login){
        return pms.getUsuarios().get(login).get(1);
    }

    public boolean revisarPassword(String login, String password){
        if(pms.getUsuarios().get(login).get(0).equals(password)){
            return true;
        }
        else{
            return false;
        }
    }
}
