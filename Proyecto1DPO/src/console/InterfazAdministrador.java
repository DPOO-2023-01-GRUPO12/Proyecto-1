package console;

import java.util.Scanner;


import model.Cargador;
import model.InformacionHotel;
import model.Servicio;

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
                scanner.close();
                break;
            case 2:
                System.out.println("Ingrese el nombre del archivo: ");
                nombreArchivo = scanner.nextLine();
                menuAdministrador.cargarTipoHabitaciones(nombreArchivo);
                scanner.close();
                break;
            case 3:
                System.out.println("Ingrese el nombre del archivo: ");
                nombreArchivo = scanner.nextLine();
                menuAdministrador.cargarTarifasPorTipoCuarto(nombreArchivo);
                scanner.close();
                break;
            case 4:
                System.out.println("Ingrese el nombre del archivo: ");
                nombreArchivo = scanner.nextLine();
                menuAdministrador.cargarCamas(nombreArchivo);
                scanner.close();
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
                scanner.close();
                break;
            case 6:
                System.out.println("Ingrese el nombre del archivo: ");
                nombreArchivo = scanner.nextLine();
                menuAdministrador.cargarServicios(nombreArchivo);
                scanner.close();
                break;
            case 7:
                opcionTarifaServicio();
                break;
            case 8:
                System.out.println("Ingrese el nombre del archivo: ");
                nombreArchivo = scanner.nextLine();
                menuAdministrador.cargarMenuPlatos(nombreArchivo);
                scanner.close();
                break;
            case 9:
                System.out.println("Ingrese el nombre del archivo: ");
                nombreArchivo = scanner.nextLine();
                menuAdministrador.cargarMenuBebidas(nombreArchivo);
                scanner.close();
                break;
            case 10:
                opcionConfigurarPlato();
                scanner.close();
                break;
            case 11:
                opcionConfigurarBebida();
                scanner.close();
                break;
            default:
                System.out.println("Opcion invalida.");
                scanner.close();
                break;
        }
    }

    private void opcionTarifaServicio(){
        Scanner scanner = new Scanner(System.in);
        if(informacionHotel.getServicios().isEmpty()){
            System.out.println("No hay servicios cargados, ¿desea cargar los servicios?");
            System.out.println("1. Si.");
            System.out.println("2. No.");
            int opcion2 = scanner.nextInt();
            if(opcion2 == 1){
                    System.out.println("Ingrese el nombre del archivo: ");
                    String nombreArchivo = scanner.nextLine();
                    menuAdministrador.cargarServicios(nombreArchivo);
            } else{
                System.out.println("No se puede cambiar la tarifa de servicios que no existen.");
            }
        } else{
            System.out.println("Ingrese el nombre del servicio: ");
            String nombreServicio = scanner.nextLine();
            if(!informacionHotel.getServicios().containsKey(nombreServicio)){
                System.out.println("El servicio no existe.");
            }else{
                Servicio ser = informacionHotel.getServicios().get(nombreServicio);
                System.out.println("La tarifa original es de: " + ser.getTarifa());
                System.out.println("Ingrese la nueva tarifa: ");
                double tarifa = scanner.nextDouble();
                menuAdministrador.cambiarTarifaServicio(nombreServicio,tarifa);
            }

        }
        scanner.close();
        
    }

    private void opcionConfigurarPlato(){
        Scanner scanner = new Scanner(System.in);
        if(informacionHotel.getMenuPlatos().isEmpty()){
            System.out.println("No hay platos cargados, ¿desea cargar los platos?");
            System.out.println("1. Si.");
            System.out.println("2. No.");
            int opcion2 = scanner.nextInt();
            if(opcion2 == 1){
                    System.out.println("Ingrese el nombre del archivo: ");
                    String nombreArchivo = scanner.nextLine();
                    menuAdministrador.cargarMenuPlatos(nombreArchivo);
            } else{
                System.out.println("No se puede configurar un plato que no existe.");
            }
        } else{
            System.out.println("Ingrese el nombre del plato: ");
            String nombrePlato = scanner.nextLine();
            if(!informacionHotel.getMenuPlatos().containsKey(nombrePlato)){
                System.out.println("El plato no existe.");
            }else{
                menuAdministrador.configurarPlato(nombrePlato);
            }
        }
        scanner.close();
        
    }

    private void opcionConfigurarBebida(){
        Scanner scanner = new Scanner(System.in);
        if(informacionHotel.getMenuPlatos().isEmpty()){
            System.out.println("No hay bebidas cargadas, ¿desea cargar las bebidas?");
            System.out.println("1. Si.");
            System.out.println("2. No.");
            int opcion2 = scanner.nextInt();
            if(opcion2 == 1){
                    System.out.println("Ingrese el nombre del archivo: ");
                    String nombreArchivo = scanner.nextLine();
                    menuAdministrador.cargarMenuPlatos(nombreArchivo);
            } else{
                System.out.println("No se puede configurar una bebida que no existe.");
            }
        } else{
            System.out.println("Ingrese el nombre de la bebida: ");
            String nombreBebida = scanner.nextLine();
            if(!informacionHotel.getMenuPlatos().containsKey(nombreBebida)){
                System.out.println("El plato no existe.");
            }else{
                menuAdministrador.configurarBebida(nombreBebida);
            }
        }
        scanner.close();
    }
}
