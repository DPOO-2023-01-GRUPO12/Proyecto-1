package console;

import java.util.Scanner;

import model.Cargador;
import model.Consumo;
import model.Grupo;
import model.Habitacion;
import model.Huesped;
import model.InformacionHotel;

public class InterfazEmpleado {

    private Cargador cargador;
    private InformacionHotel informacionHotel;

    public InterfazEmpleado(Cargador car, InformacionHotel info){
        cargador = car;
        informacionHotel = info;
    }

    public void mostrarMenu(){
        System.out.println("1. Registrar consumo de huesped. ");
        System.out.println("2. Registrar pago de huesped. ");
    }

    public void opcionElegida(int opcion){
        switch(opcion){
            case 1:
                opcionConsumo();
                break;
            case 2:
                System.out.println("Ingrese el nombre del archivo: ");
                break;
        }

    }

    private void opcionConsumo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el documento del huesped encargado: ");
        String documento = scanner.nextLine();
        while(!informacionHotel.getHuesped().containsKey(documento)){
            System.out.println("El documento ingresado no existe. Ingrese nuevamente: ");
            documento = scanner.nextLine();
        }
        System.out.println("Es un grupo? (si/no); ");
        String grupo = scanner.nextLine();
        while(!grupo.equals("si") && !grupo.equals("no")){
            System.out.println("La respuesta ingresada no es valida. Ingrese nuevamente: ");
            grupo = scanner.nextLine();
        }


        System.out.println("Ingrese el tipo de consumo: ");
        System.out.println("servicio,alojamiento,restaurante");
        String tipoConsumo = scanner.nextLine();
        String tipoServicio;
        if(tipoConsumo.equals("servicio")){
            System.out.println("Ingrese el tipo de servicio: ");
            tipoServicio = scanner.nextLine();
        }

        while(!tipoConsumo.equals("servicio") && !tipoConsumo.equals("alojamiento") && !tipoConsumo.equals("restaurante")){
            System.out.println("El tipo de consumo ingresado no existe. Ingrese nuevamente: ");
            tipoConsumo = scanner.nextLine();
        }

        System.out.println("Ingrese el valor del consumo: ");
        double valor = scanner.nextDouble();
        while(valor < 0){
            System.out.println("El valor ingresado no es valido. Ingrese nuevamente: ");
            valor = scanner.nextDouble();
        }

        Consumo cons = new Consumo(tipoConsumo, valor);

        System.out.println("Desea cargarlo a la habitacion? (si/no): ");
        String cargarHabitacion = scanner.nextLine();
        while(!cargarHabitacion.equals("si") && !cargarHabitacion.equals("no")){
            System.out.println("La respuesta ingresada no es valida. Ingrese nuevamente: ");
            cargarHabitacion = scanner.nextLine();
        }

        if(cargarHabitacion.equals("si")){
            if(tipoConsumo.equals("restaurante")){
                cons.setPagoInmediato(false);
                cons.setPagado(false);
                if(grupo.equals("si")){
                    Grupo g = informacionHotel.getGrupos().get(documento);
                    cons.setEsGrupo(true);
                } else{
                    cons.setEsGrupo(false);
                }
                cons.setHabitacion(informacionHotel.getHuesped().get(documento).getHabitacion().getIdentificador());
            } else if(tipoConsumo.equals("servicio")){
                if(informacionHotel.getServicios().get(tipoServicio).hasServicioCuarto()){
                    cons.setPagoInmediato(false);
                    cons.setPagado(false);
                    if(grupo.equals("si")){
                        Grupo g = informacionHotel.getGrupos().get(documento);
                        cons.setEsGrupo(true);
                    } else{
                        cons.setEsGrupo(false); 
                    }
                    cons.setHabitacion(informacionHotel.getHuesped().get(documento).getHabitacion().getIdentificador());
                } else{
                    System.out.println("El servicio no tiene la opcion de cargar a la habitacion.");
                }
            }

        } else{
            cons.setPagoInmediato(true);
            cons.setPagado(false);
            if(grupo.equals("si")){
                Grupo g = informacionHotel.getGrupos().get(documento);
                cons.setEsGrupo(true);
            } else{
                cons.setEsGrupo(false);
                cons.setHabitacion(informacionHotel.getHuesped().get(documento).getHabitacion().getIdentificador());
            }
        }



        if(tipoConsumo.equals("servicio")){
            if(informacionHotel.getServicios().get(tipoConsumo).hasServicioCuarto()){
                cons.setPagoInmediato(false;
            } else{

            }
        } else if(tipoConsumo.equals("restaurante")){
            cons.setPagoInmediato(false);
        }

        if(grupo.equals("si")){
            Grupo g = informacionHotel.getGrupos().get(documento); 
            cons.setEsGrupo(true);
        }
        Habitacion habitacion = informacionHotel.getHuesped().get(documento).getHabitacion();
        
        
        

        System.out.println("Ingrese la cantidad: ");
        
        System.out.println("Ingrese el nombre del archivo: ");
    }
    
}
