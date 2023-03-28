package consola;

import java.util.ArrayList;

public class Usuario
{
    private String login;
    private String password;
    private String tipo;
    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private static ArrayList<Usuario> trabajadores = new ArrayList<Usuario>();
    private static ArrayList<Usuario> empleados = new ArrayList<Usuario>();
    private static ArrayList<Usuario> administradores = new ArrayList<Usuario>();
    private static ArrayList<Usuario> recepcionistas = new ArrayList<Usuario>();

    public Usuario(String login, String password, String tipo) {
	this.login = login;
	this.password = password;
    this.tipo = tipo;
    usuarios.add(this);
    if(tipo.equals("empleado")){
        trabajadores.add(this);
        empleados.add(this);
    } else if(tipo.equals("administrador")){
        trabajadores.add(this);
        administradores.add(this);
    } else if(tipo.equals("recepcionista")){
        trabajadores.add(this);
        recepcionistas.add(this);
    }
    }
    
    public String getLogin() {
	return login;
    }
    
    public String getPassword() {
	return password;
    }

    public String getTipo() {
	return tipo;
    }

    public static ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }

    public static ArrayList<Usuario> getTrabajadores() {
        return trabajadores;
    }

    public static ArrayList<Usuario> getEmpleados() {
        return empleados;
    }

    public static ArrayList<Usuario> getAdministradores() {
        return administradores;
    }

    public static ArrayList<Usuario> getRecepcionistas() {
        return recepcionistas;
    }

}
