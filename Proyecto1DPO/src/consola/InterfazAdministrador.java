package consola;

import java.io.File;
import java.util.Scanner;

import hotel.Habitacion;
import hotel.TipoHabitacion;

public class InterfazAdministrador extends InterfazEmpleado
{
    private MenuAdministrador menuAdmin;
    
    
    public void mostrarMenu() {
	System.out.println("1. Cargar informacion servicios.");
	System.out.println("2. Cargar informacion habitaciones.");
	System.out.println("3. Cargar informacion tarifas.");
	System.out.println("4. Modificar tarifa.");
	System.out.println("5. Modificar servicio.");
	System.out.println("6. Modificar habitacion.");
	System.out.println("7. Modificar menu comida.");
	System.out.println("8. Crear habitacion.");
    }
    
    public void opcionElegida(int opcion) {
	Scanner scanner = new Scanner(System.in);
	switch(opcion) {
	case 1:
	    System.out.println("Ingrese el path al archivo de servicios: ");
	    String pathServicios = scanner.nextLine();
	    File servicios = new File(pathServicios);
	    menuAdmin.cargarInformacionServicios(servicios);
	case 2:
	    System.out.println("Ingrese el path al archivo de habitaciones: ");
	    String pathHab = scanner.nextLine();
	    File habitaciones = new File(pathHab);
	    menuAdmin.cargarInformacionHabitaciones(habitaciones);
	case 3:
	    System.out.println("Ingrese el path al archivo de tarifas: ");
	    String pathTar = scanner.nextLine();
	    File tarifas = new File(pathTar);
	    menuAdmin.cargarInformacionTarifas(tarifas);
	case 4:
	case 5:
	case 6:
	case 7:
	case 8:
	    System.out.println("Ingrese el identificador: ");
	    String id = scanner.nextLine();
	    System.out.println("Ingrese la ubicacion de la habitacion: ");
	    String ubic = scanner.nextLine();
	    System.out.println("Ingrese la capacidad de la habitacion: ");
	    int capac = scanner.nextInt();
	    
	    System.out.println("Ingrese el tipo de habitacion: ");
	    String nombre = scanner.nextLine();
	    TipoHabitacion tipoHab = new TipoHabitacion(nombre);
	    
	    System.out.println("¿Tiene vista? (1. Si 0. No): ");
	    boolean vista = scanner.nextBoolean();
	    tipoHab.setVista(vista);
	    
	    System.out.println("¿Tiene cocina? (1. Si 0. No): ");
	    boolean cocina = scanner.nextBoolean();
	    tipoHab.setCocina(cocina);
	    
	    System.out.println("¿Tiene balcon? (1. Si 0. No): ");
	    boolean balcon = scanner.nextBoolean();
	    tipoHab.setBalcon(balcon);
	    
	    Habitacion habitacion = menuAdmin.crearHabitacion(id, ubic, capac, tipoHab);
	default:
	    System.out.println("Opcion incorrecta.");
	}
    }

}
