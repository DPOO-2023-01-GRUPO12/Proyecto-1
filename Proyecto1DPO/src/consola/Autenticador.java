package consola;

import java.util.ArrayList;

public class Autenticador
{
    private boolean usuarioExiste;
    private String tipoUsuario;
    private InformacionHotel infoHotel;
    
    public boolean revisarExistencia(Usuario usuario) {
        ArrayList listaUsuarios = infoHotel.getUsuariosHotel();
        
        boolean flag = false;
        if (listaUsuarios.contains(usuario))
        {
            flag = true;
        }

        return flag;

    }
    
    public String revisarTipo(Usuario usuario) {

        return usuario.getTipo();
    }

}
