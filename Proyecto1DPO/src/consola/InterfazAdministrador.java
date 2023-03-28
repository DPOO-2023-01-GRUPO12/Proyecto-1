package consola;

import java.io.File;
import java.util.Scanner;

import hotel.Habitacion;
import hotel.Tarifa;
import hotel.TipoHabitacion;

public class InterfazAdministrador implements InterfazUsuario
{
    private MenuAdministrador menuAdmin;
    
    
    public void mostrarMenu() {
	System.out.println("1. Cargar informacion servicios.");
	System.out.println("2. Cargar informacion habitaciones.");
	System.out.println("3. Cargar informacion tarifas.");
	System.out.println("4. Modificar tarifa.");
	System.out.println("5. Modificar servicio.");
	System.out.println("6. Modificar habitacion.");
	System.out.println("7. Modificar menu.");
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
		break;

	case 2:
	    System.out.println("Ingrese el path al archivo de habitaciones: ");
	    String pathHab = scanner.nextLine();
	    File habitaciones = new File(pathHab);
	    menuAdmin.cargarInformacionHabitaciones(habitaciones);
		break;

	case 3:
	    System.out.println("Ingrese el path al archivo de tarifas: ");
	    String pathTar = scanner.nextLine();
	    File tarifas = new File(pathTar);
	    menuAdmin.cargarInformacionTarifas(tarifas);
		break;

	case 4:
		System.out.println("Ingrese el identificador de la tarifa: ");
		int idTar = scanner.nextInt();
		boolean existe = false;
		for(Tarifa tar: Tarifa.getTarifas()){
			if(tar.getIdentificador()==idTar){
				existe = true;
				break;
			}
		}
		
		if(!existe){
			System.out.println("No existe una tarifa con ese identificador");
			break;
		}
		System.out.println("¿Que desea cambiar? (1. Tipo 2. Rango de fechas 3. Dias de la semana 4. Valor): ");
		int opcionTar = scanner.nextInt();
		menuAdmin.modificarTarifa(idTar,opcionTar);
		break;

	case 5:
		System.out.println("Ingrese el tipo de servicio: ");
		String nomSer = scanner.nextLine();
		System.out.println("¿Que desea cambiar? (1. Forma de pago 2. Tipo cobro 3. Servicio al cuarto): ");
		int opcionSer = scanner.nextInt();
		menuAdmin.modificarServicio(nomSer,opcionSer);
		break;

	case 6:
		System.out.println("Ingrese el tipo de la habitación: ");
		String idHab = scanner.nextLine();
		System.out.println("¿Que desea cambiar? (1. Ubicación 2. Capacidad 3. Tipo de habitación): ");
		int opcionHab = scanner.nextInt();
		menuAdmin.modificarHabitacion(idHab,opcionHab);
		break;

	case 7:
		System.out.println("Ingrese el identificador del menu: ");
		String idMenu = scanner.nextLine();
		System.out.println("¿Que desea cambiar? (1. Servicio al cuarto 2. Producto del menu): ");
		int opcionMenu = scanner.nextInt();
		menuAdmin.modificarMenuComida(idMenu,opcionMenu);
		break;

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
		break;

	default:
	    System.out.println("Opcion incorrecta.");
	}
    }

}
