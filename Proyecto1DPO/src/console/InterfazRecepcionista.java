package console;

import model.Cargador;
import model.Grupo;
import model.Habitacion;
import model.Huesped;
import model.InformacionHotel;
import model.Reserva;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class InterfazRecepcionista {

    private Cargador cargador;
    private InformacionHotel informacionHotel;
    private MenuRecepcionista menuRecepcionista;

    public InterfazRecepcionista(Cargador car, InformacionHotel info){
        cargador = car;
        informacionHotel = info;
        menuRecepcionista = new MenuRecepcionista(car, info);
    }

    public void mostrarMenu(){
        System.out.println("1. Consultar inventario de habitaciones.");
        System.out.println("2. Realizar reserva por huesped. ");
        System.out.println("3. Cancelar reserva. ");
        System.out.println("4. Realizar check-out.");

    }

    public void opcionElegida(int opcion) throws ParseException{
        switch(opcion){
            case 1:
                menuRecepcionista.consultarInventarioHabitaciones();
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
                cargador.agregarHuesped(huespedEncargado);
                System.out.println("Ingrese la cantidad de huespedes: ");
                int cantidad = scanner.nextInt();
                
                System.out.println("Ingrese la fecha de ingreso: ");
                String fechaIn= scanner.nextLine();
                System.out.println("Ingrese la fecha de salida: ");
                String fechaOut= scanner.nextLine();
                Reserva reserva = menuRecepcionista.RealizarReservaHuesped(huespedEncargado,cantidad,fechaIn,fechaOut);

                double tarifaTotal = menuRecepcionista.configurarTarifaTotal(fechaIn, fechaOut, cantidad,reserva);
                reserva.setTarifaTotal(tarifaTotal);

                if(cantidad > 1){
                    Grupo grupo = new Grupo();
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
                        Huesped huesped = menuRecepcionista.realizarRegistro(nombreHuesped, documentoHuesped, celularHuesped, correoHuesped, edadHuesped);
                        cargador.agregarHuesped(huespedEncargado);
                        grupo.agregarIntegrante(huesped);
                    }
                    reserva.setGrupo(grupo);
                }
                cargador.agregarReserva(reserva);
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
            default:
                System.out.println("Opcion invalida.");
                break;
        }

    }
}
