package consola;

import java.util.Scanner;

public class Interfaz
{
    private Autenticador autenticador;
    
    public static void main(String args[]) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Ingrese su login: ");
	String login = scanner.nextLine();
	
	System.out.println("Ingrese su password: ");
	String password = scanner.nextLine();
	
	Usuario usuario = new Usuario(login,password);
	
	
    }

}
