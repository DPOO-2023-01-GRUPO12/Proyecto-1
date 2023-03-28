package consola;

import java.util.Scanner;

import hotel.Cama;

public class Interfaz
{
    private Autenticador autenticador;
    
    public static void main(String args[]) {
	/* 
	Scanner scanner = new Scanner(System.in);
	System.out.println("Ingrese su login: ");
	String login = scanner.nextLine();
	
	System.out.println("Ingrese su password: ");
	String password = scanner.nextLine();
	*/
	Cama c1 = new Cama("suite", 1);
	Cama c2 = new Cama("king", 2);
	Cama c3 = new Cama("kid", 2);
	Cama c4 = new Cama("small", 3);
	
	System.out.println(Cama.getCamas());
	//Usuario usuario = new Usuario(login,password);
	
	
    }

}
