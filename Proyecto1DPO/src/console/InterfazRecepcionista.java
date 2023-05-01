package console;

import persistencia.Cargador;
import model.Grupo;
import model.Habitacion;
import model.Huesped;
import model.Hotel;
import model.Reserva;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfazRecepcionista {

    private Cargador cargador;
    private Hotel informacionHotel;
    private MenuRecepcionista menuRecepcionista;

    public InterfazRecepcionista(Cargador car, Hotel info){
        cargador = car;
        informacionHotel = info;
        menuRecepcionista = new MenuRecepcionista(car, info);
    }

    public void mostrarMenu(){
        System.out.println("1. Consultar inventario de habitaciones.");
        System.out.println("2. Realizar reserva por huesped. ");
        System.out.println("3. Cancelar reserva. ");
        System.out.println("4. Realizar check-out.");
        System.out.println("5. Generar Log grupo");
        System.out.println("6. Salir");

    }

    public void opcionElegida(int opcion) throws ParseException{
        switch(opcion){
            case 1:
                menuRecepcionista.consultarInventarioHabitaciones();
                break;
            case 2:
                System.out.println("Ingrese su nombre: ");
                Scanner scanner = new Scanner(System.in);
                String nombre = scanner.nextLine();
                System.out.println("Ingrese su documento: ");
                String documento = scanner.nextLine();
                System.out.println("Ingrese su celular: ");
                String celular = scanner.nextLine();
                System.out.println("Ingrese su correo: ");
                String correo = scanner.nextLine();
                System.out.println("Ingrese su edad: ");
                int edad = scanner.nextInt();
                Huesped huespedEncargado = menuRecepcionista.realizarRegistro(nombre, documento, celular, correo, edad);
                informacionHotel.agregarHuesped(huespedEncargado);
                System.out.println("Ingrese la cantidad de huespedes: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine();
                
                System.out.println("Ingrese la fecha de ingreso: ");
                String fechaIn= scanner.nextLine();
                System.out.println("Ingrese la fecha de salida: ");
                String fechaOut= scanner.nextLine();
                Reserva reserva = menuRecepcionista.RealizarReservaHuesped(huespedEncargado,cantidad,fechaIn,fechaOut);
                informacionHotel.agregarReserva(reserva);
                double tarifaTotal = menuRecepcionista.configurarTarifaTotal(fechaIn, fechaOut, cantidad,reserva);
                reserva.setTarifaTotal(tarifaTotal);

                if(cantidad > 1){
                    Grupo grupo = new Grupo(documento);
                    grupo.setHuespedEncargado(huespedEncargado);
                    for(int i = 0;i<cantidad;i++){
                        System.out.println("Ingrese el nombre del huesped: ");
                        String nombreHuesped = scanner.nextLine();
                        System.out.println("Ingrese el documento del huesped: ");
                        String documentoHuesped = scanner.nextLine();
                        System.out.println("Ingrese el celular del huesped: ");
                        String celularHuesped = scanner.nextLine();
                        System.out.println("Ingrese el correo del huesped: ");
                        String correoHuesped = scanner.nextLine();
                        System.out.println("Ingrese la edad del huesped: ");
                        int edadHuesped = scanner.nextInt();
                        scanner.nextLine();
                        Huesped huesped = menuRecepcionista.realizarRegistro(nombreHuesped, documentoHuesped, celularHuesped, correoHuesped, edadHuesped);
                        informacionHotel.agregarHuesped(huesped);
                        grupo.agregarIntegrante(huesped);
                    }
                    informacionHotel.agregarGrupo(grupo);
                    reserva.setGrupo(grupo);
                    ArrayList<Habitacion> habitacionesAsignadas = reserva.getHabitacionesReservadas();
                    reserva.getGrupo().setHabitaciones(habitacionesAsignadas);
                    int inicioHuesped = 0;
                    int diferenciaHabitacion = 0;
                    for(Habitacion habitacion: habitacionesAsignadas){
                        int capacidadHabitacion = habitacion.getCapacidad();
                        List<Huesped> huespedesHabitacion = reserva.getGrupo().getIntegrantes().subList(inicioHuesped, (capacidadHabitacion-1)+diferenciaHabitacion);
                        for(Huesped huesped: huespedesHabitacion){
                            huesped.setHabitacion(habitacion);
                        }
                        inicioHuesped = capacidadHabitacion-1;
                        diferenciaHabitacion = capacidadHabitacion-1;
                    }
                }
                informacionHotel.agregarReserva(reserva);
                break;
            case 3:
                System.out.println("Ingrese el documento del huesped que hizo la reserva");
                Scanner scanner1 = new Scanner(System.in);
                String documentoHuesped = scanner1.nextLine();
                menuRecepcionista.cancelarReserva(documentoHuesped);
                break;
            case 4:
                System.out.println("Ingrese el documento del huesped que hizo la reserva");
                Scanner scanner2 = new Scanner(System.in);
                String documentoHuesped1 = scanner2.nextLine();
                menuRecepcionista.realizarCheckOut(documentoHuesped1);
                break;
            case 5:
                System.out.println("Ingrese el documento del huesped que hizo la reserva");
                Scanner scanner3 = new Scanner(System.in);
                String documentoHuesped2 = scanner3.nextLine();
                if(!informacionHotel.getHuespedes().containsKey(documentoHuesped2)){
                    System.out.println("El huesped no existe");
                    break;
                } else{
                    if(!informacionHotel.getGrupos().containsKey(documentoHuesped2)){
                        System.out.println("El huesped no pertenece a un grupo");
                        break;
                    } else{
                        if(informacionHotel.getReservas().get(documentoHuesped2).isCheckin()==true){
                            System.out.println("El huesped no ha realizado el check-out");
                            break;
                        } else{
                            menuRecepcionista.generarLogGrupo(documentoHuesped2);
                        }
                    }
                }
                
                break;
            default:
                System.out.println("Opcion invalida.");
                break;
        }

    }
}
