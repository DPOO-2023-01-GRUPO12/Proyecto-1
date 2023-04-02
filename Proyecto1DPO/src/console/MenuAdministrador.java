package console;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Cargador;
import model.Habitacion;
import model.InformacionHotel;
import model.Plato;
import model.Servicio;
import model.TarifaCuarto;
import model.TipoHabitacion;
import model.Bebida;
import model.Cama;

public class MenuAdministrador {
    private Cargador cargador;
    private InformacionHotel informacionHotel;

    public MenuAdministrador(Cargador car, InformacionHotel info){
        cargador = car;
        informacionHotel = info;
    }

    public void cargarHabitaciones(String pathHabitaciones) throws IOException{
        File file = new File(pathHabitaciones);
        if(file.exists()){
            cargador.cargarHabitaciones(file);
        } else{
            System.out.println("No existe el archivo");
        }
    }


    public void cargarTipoHabitaciones(String pathTipoHabitaciones){
        File file = new File(pathTipoHabitaciones);
        if(file.exists()){
            cargador.cargarTipoHabitaciones(file);
        } else{
            System.out.println("No existe el archivo");
        }

    }


    public void cargarTarifasPorTipoCuarto(String pathTarifasTipoCuarto){
        File file = new File(pathTarifasTipoCuarto);
        if(file.exists()){
            cargador.cargarTarifasCuarto(file);
        } else{
            System.out.println("No existe el archivo");
        }
    }
    

    public void cargarCamas(String pathFile){
        File file = new File(pathFile);
        if(file.exists()){
            cargador.cargarCamas(file);
        } else{
            System.out.println("No existe el archivo");
        }
    }


    public void crearHabitacion(String id, String ub, String desc){
        Habitacion habitacion = new Habitacion(id,ub,desc);
        System.out.println("Para crear una habitacion debe seleccionar un tipo de habitacion y camas.");
        asignarHabitacionTipo(habitacion);
        asignarHabitacionCamas(habitacion);
        cargador.cargarHabitacion(habitacion);
    }

    private void asignarHabitacionTipo(Habitacion hab){
        Scanner scanner = new Scanner(System.in);
        mostrarMenuTipoHabitacion();
        int opcion = scanner.nextInt();
        TipoHabitacion tipo = opcionTipoHabitacion(opcion);
        while(tipo.equals(null)){
            System.out.println("No se pudo asignar el tipo de habitacion habitacion.");
            tipo = opcionTipoHabitacion(opcion);
        }
        cargador.agregarTipoHabitacion(tipo);
        hab.setTipoHabitacion(tipo);
        scanner.close();
    }

    private void asignarHabitacionCamas(Habitacion hab){
        Scanner scanner = new Scanner(System.in);
        mostrarMenuCamas();
        int opcion = scanner.nextInt();
        ArrayList<Cama> camas = opcionCamas(opcion);
        while(camas.equals(null)){
            System.out.println("No se pudo asignar las camas a la habitacion.");
            camas = opcionCamas(opcion);
        }
        for(Cama cama: camas){
            cargador.agregarCama(cama);
        }
        hab.setCamas(camas);
        scanner.close();
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
                        cargarTipoHabitaciones(nombreArchivo);
                    } else{
                        System.out.println("No se puede crear una habitacion sin un tipo de habitacion.");
                        scanner.close();
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
                scanner.close();
                return informacionHotel.getTipoHabitaciones().get(nombreTipo);
            case 2:
                System.out.println("Ingrese el nombre del tipo de habitacion: ");
                String nombreTipo2 = scanner.nextLine();
                while(informacionHotel.getTipoHabitaciones().containsKey(nombreTipo2)){
                    System.out.println("El tipo de habitacion ya existe, ingrese uno nuevo: ");
                    nombreTipo2 = scanner.nextLine();
                }
                scanner.close();
                return crearTipoHabitacion(nombreTipo2);
            default:
                System.out.println("Opcion invalida, intente de nuevo.");
                scanner.close();
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
                    cargarTarifasPorTipoCuarto(nombreArchivo);
                } else{
                    System.out.println("No se puede crear una habitacion sin una tarifa.");
                    scanner.close();
                    return null;
                }
            }
            System.out.println("Seleccione la tarifa marcando el numero de la que desea: ");
            for(TarifaCuarto tar: informacionHotel.getTarifasCuartos()){
                int index = informacionHotel.getTarifasCuartos().indexOf(tar);
                System.out.print("Tarifa " + index);
                System.out.println(tar.toString());
            }
            int opcion3 = scanner.nextInt();
            while(opcion3 < 0 || opcion3 > informacionHotel.getTarifasCuartos().size()){
                System.out.println("Opcion invalida, intente de nuevo: ");
                opcion3 = scanner.nextInt();
            }
            tipoHabitacion.agregarTarifaCuarto(informacionHotel.getTarifasCuartos().get(opcion3));


        } else{
            System.out.println("Opcion invalida.");
            scanner.close();
            return null;
        }
        scanner.close();
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
                        cargarCamas(nombreArchivo);
                    } else{
                        System.out.println("No se puede crear una habitacion sin camas.");
                        scanner.close();
                        return null;
                    }
                }
                System.out.println("¿Cuantas camas desea asignar a la habitacion?");
                int cantidad = scanner.nextInt();
                ArrayList<Cama> camas = new ArrayList<Cama>();
                ArrayList<Integer> camasEscogidas = new ArrayList<Integer>();
                for(Cama cama: informacionHotel.getCamas()){
                    int index = informacionHotel.getCamas().indexOf(cama);
                    System.out.print("Cama " + index);
                    System.out.println(cama.toString());
                }

                for(int i = 0; i < cantidad; i++){
                    System.out.println("Seleccione la cama que desea agregar a la habitacion: ");
                    int camaIndex = scanner.nextInt();
                    while(camaIndex < 0 || camaIndex > informacionHotel.getCamas().size()){
                        System.out.println("Opcion invalida, intente de nuevo: ");
                        camaIndex = scanner.nextInt();
                        
                    }
                    if(camasEscogidas.contains(Integer.valueOf(camaIndex))){
                        System.out.println("La cama ya fue seleccionada, escoja otra: ");
                        camaIndex = scanner.nextInt();
                    } else{
                        camasEscogidas.add(Integer.valueOf(camaIndex));
                        camas.add(informacionHotel.getCamas().get(camaIndex));
                    }
                }
                scanner.close();
                return camas;
            default:
                System.out.println("Opcion invalida.");
                scanner.close();
                return null;
        }
    }

    
    public void cargarServicios(String pathServicios){
        File file = new File(pathServicios);
        if(file.exists()){
            cargador.cargarServicios(file);
        } else{
            System.out.println("No existe el archivo");
        }

    }


    public void cambiarTarifaServicio(String nombreServicio, double valor){
        Servicio ser = informacionHotel.getServicios().get(nombreServicio);
        ser.setTarifa(valor);
    }


    public void cargarMenuPlatos(String pathPlatos){
        File file = new File(pathPlatos);
        if(file.exists()){
            cargador.cargarMenuPlatos(file);
        } else{
            System.out.println("No existe el archivo");
        }
    }


    public void cargarMenuBebidas(String pathBebidas){
        File file = new File(pathBebidas);
        if(file.exists()){
            cargador.cargarMenuBebidas(file);
        } else{
            System.out.println("No existe el archivo");
        }
    }


    public void configurarPlato(String nombrePlato){
        System.out.println("¿Que desea cambiar del plato?");
        mostrarMenuPlatoBebida();
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        Plato plato = informacionHotel.getMenuPlatos().get(nombrePlato);
        opcionPlatoBebida(opcion,plato);
        scanner.close();
    }

    public void configurarBebida(String nombreBebida){
        System.out.println("¿Que desea cambiar de la bebida?");
        mostrarMenuPlatoBebida();
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        Bebida bebida = informacionHotel.getMenuBebidas().get(nombreBebida);
        opcionPlatoBebida(opcion,bebida);
        scanner.close();
    }

    private void mostrarMenuPlatoBebida(){
        System.out.println("1. Cambiar nombre. ");
        System.out.println("2. Cambiar tarifa.");
        System.out.println("3. Cambiar rango de horas disponible. ");
        System.out.println("4. Cambiar comida de disponibilidad. ");
        System.out.println("5. Cambiar lugar de disponibilidad. ");
        System.out.println("6. Cambiar disponibilidad para servicio al cuarto.. ");
    }

    private void opcionPlatoBebida(int opcion, Plato plato){
        Scanner scanner = new Scanner(System.in);
        switch(opcion){
            case 1:
                System.out.println("Nombre actual del plato: " + plato.getNombre());
                System.out.println("Ingrese el nuevo nombre del plato: ");
                
                String nombre = scanner.nextLine();

                while(informacionHotel.getMenuPlatos().containsKey(nombre)){
                    System.out.println("Ya existe un plato con ese nombre, intente de nuevo.");
                    nombre = scanner.nextLine();
                }
                plato.setNombre(nombre);
                informacionHotel.getMenuPlatos().remove(plato.getNombre());
                informacionHotel.getMenuPlatos().put(nombre, plato);
                scanner.close();
                break;
            case 2:
                System.out.println("Tarifa actual del plato: " + plato.getTarifa());
                System.out.println("Ingrese la nueva tarifa del plato: ");
                double tarifa = scanner.nextDouble();
                plato.setTarifa(tarifa);
                scanner.close();
                break;
            case 3:
                System.out.println("Rango de horas actual del plato: " + plato.getRangoHoras());
                System.out.println("Ingrese el nuevo rango de horas del plato: ");
                String horas = scanner.nextLine();
                plato.setRangoHoras(horas);
                scanner.close();
                break;
            case 4:
                System.out.println("Comidas de disponibilidad actual del plato: " + plato.getComidaDispon());
                System.out.println("Ingrese las nuevas comidas de disponiblidad del plato: ");
                String comida = scanner.nextLine();
                plato.setComidaDispon(comida);
                scanner.close();
                break;
            case 5:
                System.out.println("Lugares de disponibilidad actual del plato: " + plato.getLugarDispon());
                System.out.println("Ingrese los nuevos lugares de disponibilidad del plato: ");
                String lugar = scanner.nextLine();
                plato.setLugarDispon(lugar);
                scanner.close();
                break;
            case 6:
                System.out.println("Disponibilidad para servicio al cuarto actual del plato: " + plato.hasServicioCuarto());
                System.out.println("Ingrese la nueva disponibilidad para servicio al cuarto del plato: ");
                boolean servicioCuarto = scanner.nextBoolean();
                plato.setServicioCuarto(servicioCuarto);
                scanner.close();
                break;
            default:
                System.out.println("Opcion invalida.");
                scanner.close();
                break;
            }
    }
    
    private void opcionPlatoBebida(int opcion, Bebida bebida){
        Scanner scanner = new Scanner(System.in);
        switch(opcion){
            case 1:
                System.out.println("Nombre actual de la bebida: " + bebida.getNombre());
                System.out.println("Ingrese el nuevo nombre de la bebida: ");
                
                String nombre = scanner.nextLine();

                while(informacionHotel.getMenuBebidas().containsKey(nombre)){
                    System.out.println("Ya existe una bebida con ese nombre, intente de nuevo.");
                    nombre = scanner.nextLine();
                }
                bebida.setNombre(nombre);
                informacionHotel.getMenuBebidas().remove(bebida.getNombre());
                informacionHotel.getMenuBebidas().put(nombre, bebida);
                scanner.close();
                break;
            case 2:
                System.out.println("Tarifa actual de la bebida: " + bebida.getTarifa());
                System.out.println("Ingrese la nueva tarifa de la bebida: ");
                double tarifa = scanner.nextDouble();
                bebida.setTarifa(tarifa);
                scanner.close();
                break;
            case 3:
                System.out.println("Rango de horas actual de la bebida: " + bebida.getRangoHoras());
                System.out.println("Ingrese el nuevo rango de horas de la bebida: ");
                String horas = scanner.nextLine();
                bebida.setRangoHoras(horas);
                scanner.close();
                break;
            case 4:
                System.out.println("Comidas de disponibilidad actual de la bebida: " + bebida.getComidaDispon());
                System.out.println("Ingrese las nuevas comidas de disponiblidad de la bebida: ");
                String comida = scanner.nextLine();
                bebida.setComidaDispon(comida);
                scanner.close();
                break;
            case 5:
                System.out.println("Lugares de disponibilidad actual de la bebida: " + bebida.getLugarDispon());
                System.out.println("Ingrese los nuevos lugares de disponibilidad de la bebida: ");
                String lugar = scanner.nextLine();
                bebida.setLugarDispon(lugar);
                scanner.close();
                break;
            case 6:
                System.out.println("Disponibilidad para servicio al cuarto actual de la bebida: " + bebida.hasServicioCuarto());
                System.out.println("Ingrese la nueva disponibilidad para servicio al cuarto de la bebida: ");
                boolean servicioCuarto = scanner.nextBoolean();
                bebida.setServicioCuarto(servicioCuarto);
                scanner.close();
                break;
            default:
                System.out.println("Opcion invalida.");
                scanner.close();
                break;
            }
    }

}
