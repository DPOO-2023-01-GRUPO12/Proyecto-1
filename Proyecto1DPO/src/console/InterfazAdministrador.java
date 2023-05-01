package console;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;


import persistencia.Cargador;
import model.PMS;
import model.Servicio;

public class InterfazAdministrador {
    private Cargador cargador;
    private PMS pms;
    private MenuAdministrador menuAdministrador;

    public InterfazAdministrador(Cargador car, PMS pms){
        cargador = car;
        
        this.pms = pms;
        menuAdministrador = new MenuAdministrador(car,pms);
    }

    public void mostrarMenu(){
        System.out.println("1. Cargar información del hotel.");
        System.out.println("2. Crear habitacion.");
        System.out.println("3. Cambiar tarifa de un servicio.");
        System.out.println("4. Configurar plato.");
        System.out.println("5. Configurar bebida.");
        System.out.println("6. Notificar fechas sin tarifas");
        System.out.println("6. Salir");

    }

    public void opcionElegida(int opcion) throws IOException, ParseException{
        Scanner scanner = new Scanner(System.in);
        switch(opcion){
            case 1:
            System.out.println("Ingrese el nombre del archivo: ");
                String nombreArchivo = scanner.nextLine();
                menuAdministrador.cargarInformacionHotel(nombreArchivo);
                //menuAdministrador.informarFechasSinTarifa();       
                break;


            case 2:
                System.out.println("Ingrese el identificador para la habitacion: ");
                String id = scanner.nextLine();
                while(pms.getInventarioHabitaciones().containsKey(id)){
                    System.out.println("El identificador ya existe, ingrese uno nuevo: ");
                    id = scanner.nextLine();
                }
                System.out.println("Ingrese la ubicacion de la habitacion: ");
                String ub = scanner.nextLine();
                System.out.println("Ingrese la descripcion de la habitacion: ");
                String desc = scanner.nextLine();
                menuAdministrador.crearHabitacion(id,ub,desc);
                break;

            case 3:
                opcionTarifaServicio();
                break;

            case 4:
                opcionConfigurarPlato();
                break;
            case 5:
                opcionConfigurarBebida();
                break;
            case 6:
                System.out.println("Saliendo...");
                break;

            case 7:
            default:
                System.out.println("Opcion invalida.");
                break;
        }
    }

    private void opcionTarifaServicio() throws FileNotFoundException, IOException{
        Scanner scanner = new Scanner(System.in);
        if(pms.getServicios().isEmpty()){
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
            if(!pms.getServicios().containsKey(nombreServicio)){
                System.out.println("El servicio no existe.");
            }else{
                Servicio ser = pms.getServicios().get(nombreServicio);
                System.out.println("La tarifa original es de: " + ser.getTarifa());
                System.out.println("Ingrese la nueva tarifa: ");
                double tarifa = scanner.nextDouble();
                menuAdministrador.cambiarTarifaServicio(nombreServicio,tarifa);
            }

        }        
    }

    private void opcionConfigurarPlato() throws FileNotFoundException, IOException{
        Scanner scanner = new Scanner(System.in);
        if(pms.getMenuPlatos().isEmpty()){
            System.out.println("No hay platos cargados, ¿desea cargar los platos?");
            System.out.println("1. Si.");
            System.out.println("2. No.");
            
            int opcion2 = scanner.nextInt();
            if(opcion2==1){
                    System.out.println("Ingrese el nombre del archivo: ");
                    String nombreArchivo = scanner.nextLine();
                    menuAdministrador.cargarMenuPlatos(nombreArchivo);
            } else{
                System.out.println("No se puede configurar un plato que no existe.");
            }
        } else{
            System.out.println("Ingrese el nombre del plato: ");
            String nombrePlato = scanner.nextLine();
            if(!pms.getMenuPlatos().containsKey(nombrePlato)){
                System.out.println("El plato no existe.");
            }else{
                menuAdministrador.configurarPlato(nombrePlato);
            }
        }
        
    }

    private void opcionConfigurarBebida() throws FileNotFoundException, IOException{
        Scanner scanner = new Scanner(System.in);
        if(pms.getMenuBebidas().isEmpty()){
            System.out.println("No hay bebidas cargadas, ¿desea cargar las bebidas?");
            System.out.println("1. Si.");
            System.out.println("2. No.");
            int opcion2 = scanner.nextInt();
            if(opcion2 == 1){
                    System.out.println("Ingrese el nombre del archivo: ");
                    String nombreArchivo = scanner.nextLine();
                    menuAdministrador.cargarMenuBebidas(nombreArchivo);
            } else{
                System.out.println("No se puede configurar una bebida que no existe.");
            }
        } else{
            System.out.println("Ingrese el nombre de la bebida: ");
            String nombreBebida = scanner.nextLine();
            if(!pms.getMenuBebidas().containsKey(nombreBebida)){
                System.out.println("La bebida no existe.");
            }else{
                menuAdministrador.configurarBebida(nombreBebida);
            }
        }
    }
}
