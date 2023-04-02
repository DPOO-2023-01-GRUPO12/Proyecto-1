package console;

import java.util.Scanner;


import model.Cargador;
import model.InformacionHotel;

public class InterfazAdministrador {
    private Cargador cargador;
    private InformacionHotel informacionHotel;
    private MenuAdministrador menuAdministrador;

    public InterfazAdministrador(Cargador car, InformacionHotel info){
        cargador = car;
        informacionHotel = info;
        menuAdministrador = new MenuAdministrador(car,info);
    }

    public void mostrarMenu(){
        System.out.println("1. Cargar habitaciones.");
        System.out.println("2. Cargar tipos de habitaciones.");
        System.out.println("3. Cargar tarifas por tipo de cuarto.");
        System.out.println("4. Cargar camas.");
        System.out.println("5. Crear habitacion.");
        System.out.println("6. Cargar servicios.");
        System.out.println("7. Cambiar tarifa de un servicio.");
        System.out.println("8. Cargar menu de platos.");
        System.out.println("9. Cargar menu de bebidas.");
        System.out.println("10. Configurar plato.");
        System.out.println("11. Configurar bebida.");

    }

    public void opcionElegida(int opcion){
        Scanner scanner = new Scanner(System.in);
        switch(opcion){
            case 1:
                System.out.println("Ingrese el nombre del archivo: ");
                String nombreArchivo = scanner.nextLine();
                menuAdministrador.cargarHabitaciones(nombreArchivo);
                break;
            case 2:
                System.out.println("Ingrese el nombre del archivo: ");
                nombreArchivo = scanner.nextLine();
                menuAdministrador.cargarTipoHabitaciones(nombreArchivo);
                break;
            case 3:
                System.out.println("Ingrese el nombre del archivo: ");
                nombreArchivo = scanner.nextLine();
                menuAdministrador.cargarTarifasPorTipoCuarto(nombreArchivo);
                break;
            case 4:
                System.out.println("Ingrese el nombre del archivo: ");
                nombreArchivo = scanner.nextLine();
                menuAdministrador.cargarCamas(nombreArchivo);
                break;
            case 5:
                System.out.println("Ingrese el identificador para la habitacion: ");
                String id = scanner.nextLine();
                while(informacionHotel.getInventarioHabitaciones().containsKey(id)){
                    System.out.println("El identificador ya existe, ingrese uno nuevo: ");
                    id = scanner.nextLine();
                }
                System.out.println("Ingrese la ubicacion de la habitacion: ");
                String ub = scanner.nextLine();
                System.out.println("Ingrese la descripcion de la habitacion: ");
                String desc = scanner.nextLine();
                menuAdministrador.crearHabitacion(id,ub,desc);
                break;
            case 6:
                System.out.println("Ingrese el nombre del archivo: ");
                nombreArchivo = scanner.nextLine();
                menuAdministrador.cargarServicios(nombreArchivo);
                break;
            case 7:
                opcionTarifaServicio();

        }
    }

    private void opcionTarifaServicio(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del servicio: ");
        String nombreServicio = scanner.nextLine();
        if(!informacionHotel.getServicios().containsKey(nombreServicio)){
            System.out.println("El servicio no existe.");
        } else{
            System.out.println("La tarifa original es de: "+ servicio);
            System.out.println("Ingrese la nueva tarifa: ");
            double tarifa = scanner.nextDouble();
            menuAdministrador.cambiarTarifaServicio(nombreServicio,tarifa);
        }
        System.out.println("Ingrese la nueva tarifa: ");
        double tarifa = scanner.nextDouble();
        menuAdministrador.cambiarTarifaServicio(nombreServicio,tarifa);
    }
}
