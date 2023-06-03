package model;

public class AutenticadorHuesped
{
    private PMS pms;

    public AutenticadorHuesped(PMS pms){
        this.pms = pms;
    }

    public boolean revisarExistencia(String login){
	
        if(pms.getUsuariosHuespedes().containsKey(login)){
            return true;
        }
        else{
            return false;
        }
        
    }

    public boolean revisarPassword(String login, String password){
        if(pms.getUsuariosHuespedes().get(login).equals(password)){
            return true;
        }
        else{
            return false;
        }
    }

}
