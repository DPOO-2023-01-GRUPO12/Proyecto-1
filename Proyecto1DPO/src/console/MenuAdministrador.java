package console;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.IntFunction;

import model.Cargador;
import model.Habitacion;
import model.InformacionHotel;
import model.TarifaCuarto;
import model.TipoHabitacion;
import model.Cama;

public class MenuAdministrador {
    private Cargador cargador;
    private InformacionHotel informacionHotel;

    public MenuAdministrador(Cargador car, InformacionHotel info){
        cargador = car;
        informacionHotel = info;
    }

    public void cargarHabitaciones(File habitaciones){
        cargador.cargarHabitaciones(habitaciones);
    }

    public void cargarTipoHabitaciones(File tipoHabitaciones){
        cargador.cargarTipoHabitaciones(tipoHabitaciones);
    }

    public void cargarTarifasPorTipoCuarto(File tarifasTipoCuarto){
        cargador.cargarTarifasCuarto(tarifasTipoCuarto);
    }
    
    public void cargarCamas(File file){
        cargador.cargarCamas(file);
    }


    public void crearHabitacion(String id, String ub, String desc){
        Scanner scanner = new Scanner(System.in);
        Habitacion habitacion = new Habitacion(id,ub,desc);
        System.out.println("Para crear una habitacion debe seleccionar un tipo de habitacion y camas.");
        mostrarMenuTipoHabitacion();
        int opcion = scanner.nextInt();
        TipoHabitacion tipo = opcionTipoHabitacion(opcion);
        while(tipo.equals(null)){
            System.out.println("No se pudo asignar el tipo de habitacion habitacion.");
            tipo = opcionTipoHabitacion(opcion);
        }

        habitacion.setTipoHabitacion(tipo);

        mostrarMenuCamas();
        
        
    }

    private void mostrarMenuTipoHabitacion(){
        System.out.println("1. Seleccionar tipo de habitacion. ");
        System.out.println("2. Crear tipo de habitacion. ");

    }

    private TipoHabitacion opcionTipoHabitacion(int opcion){
        Scanner scanner = new Scanner(System.in);
        switch(opcion){
            case 1:
                if(informacionHotel.getTipoHabitaciones().isEmpty()){
                    System.out.println("No hay tipos de habitacion cargados, ¿desea cargar los tipos de habitacion?.");
                    System.out.println("1. Si.");
                    System.out.println("2. No.");
                    int opcion2 = scanner.nextInt();
                    if(opcion2 == 1){
                        System.out.println("Ingrese el nombre del archivo: ");
                        String nombreArchivo = scanner.nextLine();
                        File file = new File(nombreArchivo);
                        cargarTipoHabitaciones(file);
                    } else{
                        System.out.println("No se puede crear una habitacion sin un tipo de habitacion.");
                        return null;
                    }
                }
                System.out.println("Seleccione el tipo de habitacion: ");
                System.out.println(informacionHotel.getTipoHabitaciones().keySet());
                    
                String nombreTipo = scanner.nextLine();
                while(!informacionHotel.getTipoHabitaciones().containsKey(nombreTipo)){
                    System.out.println("El tipo de habitacion no existe, ingrese uno nuevo: ");
                    nombreTipo = scanner.nextLine();
                }
                 return informacionHotel.getTipoHabitaciones().get(nombreTipo);
            case 2:
                System.out.println("Ingrese el nombre del tipo de habitacion: ");
                String nombreTipo2 = scanner.nextLine();
                while(informacionHotel.getTipoHabitaciones().containsKey(nombreTipo2)){
                    System.out.println("El tipo de habitacion ya existe, ingrese uno nuevo: ");
                    nombreTipo2 = scanner.nextLine();
                }
                return crearTipoHabitacion(nombreTipo2);
            default:
                System.out.println("Opcion invalida, intente de nuevo.");
                return null;
        }
    }

    private TipoHabitacion crearTipoHabitacion(String tipo){
        Scanner scanner = new Scanner(System.in);
        TipoHabitacion tipoHabitacion = new TipoHabitacion(tipo);
        System.out.println("Debe asignarle al menos una tarifa al tipo de habitacion. ");
        System.out.println("1. Seleccionar tarifa de habitacion. ");
        int opcion = scanner.nextInt();
        if(opcion == 1){
            if(informacionHotel.getTarifasCuartos().isEmpty()){
                System.out.println("No hay tarifas cargadas, ¿desea cargar las tarifas?.");
                System.out.println("1. Si.");
                System.out.println("2. No.");
                int opcion2 = scanner.nextInt();
                if(opcion2 == 1){
                    System.out.println("Ingrese el nombre del archivo: ");
                    String nombreArchivo = scanner.nextLine();
                    File file = new File(nombreArchivo);
                    cargarTarifasPorTipoCuarto(file);
                } else{
                    System.out.println("No se puede crear una habitacion sin una tarifa.");
                    return null;
                }
            }
            System.out.println("Seleccione la tarifa marcando el numero de la que desea: ");
            System.out.format("%15s %20s %30s %60s %15s", "TARIFA", "TIPO", "RANGO FECHAS", "DIAS SEMANA", "VALOR");
            for(TarifaCuarto tar: informacionHotel.getTarifasCuartos()){

                tar.foString(informacionHotel.getTarifasCuartos().indexOf(tar)); // o usar tar.toString()
            }
            int opcion3 = scanner.nextInt();
            while(opcion3 < 0 || opcion3 > informacionHotel.getTarifasCuartos().size()){
                System.out.println("Opcion invalida, intente de nuevo: ");
                opcion3 = scanner.nextInt();
            }
            tipoHabitacion.agregarTarifaCuarto(informacionHotel.getTarifasCuartos().get(opcion3));


        } else{
            System.out.println("Opcion invalida.");
            return null;
        }
        return tipoHabitacion;
        

    }
    
    
    private void mostrarMenuCamas(){
        System.out.println("1. Seleccionar camas. ");
    }

    private ArrayList<Cama> opcionCamas(int opcion){
        Scanner scanner = new Scanner(System.in);
        switch(opcion){
            case 1:
                if(informacionHotel.getCamas().isEmpty()){
                    System.out.println("No hay camas cargadas, ¿desea cargar las camas?.");
                    System.out.println("1. Si.");
                    System.out.println("2. No.");
                    int opcion2 = scanner.nextInt();
                    if(opcion2 == 1){
                        System.out.println("Ingrese el nombre del archivo: ");
                        String nombreArchivo = scanner.nextLine();
                        File file = new File(nombreArchivo);
                        cargarCamas(file);
                    } else{
                        System.out.println("No se puede crear una habitacion sin camas.");
                        return null;
                    }
                }
                System.out.println("Seleccione las camas que desea agregar a la habitacion: ");
                System.out.println(informacionHotel.getCamas().keySet());
                    
                String nombreTipo = scanner.nextLine();
                while(!informacionHotel.getCamas().containsKey(nombreTipo)){
                    System.out.println("La cama no existe, ingrese una nueva: ");
                    nombreTipo = scanner.nextLine();
                }
                 return informacionHotel.getCamas().get(nombreTipo);
            case 2:
                System.out.println("Ingrese el nombre del tipo de habitacion: ");
                String nombreTipo2 = scanner.nextLine();
                while(informacionHotel.getCamas().containsKey(nombreTipo2)){
                    System.out.println("La cama ya existe, ingrese una nueva: ");
                    nombreTipo2 = scanner.nextLine();
                }
                return crearTipoHabitacion(nombreTipo2);
            default:
                System.out.println("Opcion invalida, intente de nuevo.");
                return null;
        }
    }

}
