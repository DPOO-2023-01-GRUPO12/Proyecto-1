package consola;

import java.util.Scanner;

public class Interfaz
{
    public static void revisarTipo(Usuario usuario, Scanner scanner){
		Autenticador autenticador = new Autenticador();
		String tipoUsuario = autenticador.revisarTipo(usuario);
		if (tipoUsuario.equals("recepcionista")) {
			InterfazRecepcionista interfazRecepcionista = new InterfazRecepcionista();
			interfazRecepcionista.mostrarMenu();
			int opcion = scanner.nextInt();
			interfazRecepcionista.opcionElegida(opcion);
			}
			else if (tipoUsuario.equals("administrador")) {
			InterfazAdministrador interfazAdministrador = new InterfazAdministrador();
			interfazAdministrador.mostrarMenu();
			int opcion = scanner.nextInt();
			interfazAdministrador.opcionElegida(opcion);
			}
			else if (tipoUsuario.equals("empleado")) {
			InterfazEmpleado interfazEmpleado = new InterfazEmpleado();
			interfazEmpleado.mostrarMenu();
			int opcion = scanner.nextInt();
			interfazEmpleado.opcionElegida(opcion);
			} else if(tipoUsuario.equals("huesped")){
			InterfazHuesped interfazHuesped = new InterfazHuesped();
			interfazHuesped.mostrarMenu();
			int opcion = scanner.nextInt();
			interfazHuesped.opcionElegida(opcion);
			}
			else{
				System.out.println("Tipo de usuario no existe");
			}	
	}
	
	public static void signIn(Usuario usuario, Scanner scanner){
		Autenticador autenticador = new Autenticador();
		if (autenticador.revisarExistencia(usuario)) {
			revisarTipo(usuario, scanner);
			
		} else {
			System.out.println("Usuario no existe");
			System.out.println("Por favor registrese.");	
		}
	}

	public static String[] ingresarDatos(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese su login: ");
		String login = scanner.nextLine();
			
		System.out.println("Ingrese su password: ");
		String password = scanner.nextLine();

		System.out.println("Ingrese que tipo de usuario es: ");
		String tipo = scanner.nextLine();

		String[] datos = new String[3];
		datos[0] = login;
		datos[1] = password;
		datos[2] = tipo;

		return datos;
	}
	
	public static void mostrarMenu(){
		System.out.println("1. Iniciar sesion");
		System.out.println("2. Registrarse");
		System.out.println("3. Salir");
	}

	public static void opcionElegida(int opcion,Scanner scanner){
		if (opcion == 1) {
			String[] datos = ingresarDatos();
			signIn(new Usuario(datos[0],datos[1],datos[2]), scanner);
		} else if (opcion == 2) {
			String[] datos = ingresarDatos();
			Usuario usuario = new Usuario(datos[0],datos[1],datos[2]);
			revisarTipo(usuario, scanner);
		} else {
			System.out.println("Opcion no valida");
		}
		
	}
    public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bienvenido al sistema de reservas de Hotel");

		
		
		boolean corriendo = true;
		while(corriendo){
			mostrarMenu();
			int opcion = scanner.nextInt();
			if(opcion!=3){
				opcionElegida(opcion,scanner);
			}else{
				corriendo = false;
				System.out.println("Gracias por usar el sistema de reservas de Hotel");
			}
			

		}

	
	}

	

}
