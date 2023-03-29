package consola;
import java.util.ArrayList;
import java.util.Scanner;

import hotel.Huesped;
import hotel.Habitacion;
import hotel.Grupo;

public class InterfazRecepcionista implements InterfazUsuario
{
    private MenuEmpleado menuEmp;
    private MenuRecepcionista menuRecep;
    
    public void mostrarMenu() {

    System.out.println("1. Hacer reserva por huesped");
	System.out.println("2. Registrar huesped");
	System.out.println("3. Asignar habitacion a huesped.");
	System.out.println("4. Generar factura");
	System.out.println("5. Obtener informacion de habitaciones");
	System.out.println("6. Obtener informacion de reservas.");
	System.out.println("7. Asignar habitacion a grupo");
	
    }
    
    public void opcionElegida(int opcion) {
        Scanner scanner= new Scanner(System.in);
        switch (opcion){
            case 1:
                System.out.println("Ingrese nombre Huesped");
                String nombre = scanner.nextLine();
                Huesped huesped= null;
                ArrayList<Huesped> huespedes = Huesped.getHuespedes();
                for (Huesped i: huespedes){
                    String inom= i.getNombre();
                    if (inom.equals(nombre)){
                        huesped = i;
                    }
                    else {
                        System.out.println("No se encontro huesped");
                    }
                }
                System.out.println("Ingrese fecha de ingreso");
                String fechain= scanner.nextLine();
                System.out.println("Ingrese fecha de salida");
                String fechafin= scanner.nextLine();
                menuRecep.hacerReservaPorHuesped(huesped,fechain,fechafin);


            case 2:
                System.out.println ("Ingrese Nombre");
                String nombre2 = scanner.nextLine();
                System.out.println ("Ingrese Correo");
                String correo= scanner.nextLine();
                System.out.println ("Ingrese Documento");
                String documento= scanner.nextLine();
                System.out.println ("Ingrese Celular");
                String celular= scanner.nextLine();
                menuRecep.RegistrarHuesped(nombre2,correo,documento,celular);

            case 3:
                System.out.println("Ingrese id Habitacion");
                String id = scanner.nextLine();
                ArrayList<Habitacion> habitaciones = Habitacion.getHabitaciones();
                Habitacion habitacion = null;
                for (Habitacion i: habitaciones){
                    String iID= i.getIdentificador();
                    if (iID.equals(id)){
                        habitacion= i;
                    }
                    else {
                        System.out.println("No se encontro habitacion");
                    }
                }
                System.out.println("Ingrese Nombre Huesped");
                String nombre = scanner.nextLine();
                Huesped huesped= null;
                ArrayList<Huesped> huespedes = Huesped.getHuespedes();
                for (Huesped i: huespedes){
                    String inom= i.getNombre();
                    if (inom.equals(nombre)){
                        huesped = i;
                    }
                    else {
                        System.out.println("No se encontro huesped");
                    }
                }
                menuRecep.asignarHabitacionAHuesped(Huesped);

            case 4:
                menuRecep.generarFactura();
            
            case 5:
                menuRecep.obtenerInformacionDeHabitaciones();
                
            case 6:
                menuRecep.obtenerInformacionReservas();

            case 7:
                System.out.println("Ingrese id Habitacion");
                String id = scanner.nextLine();
                ArrayList<Habitacion> habitaciones = Habitacion.getHabitaciones();
                Habitacion habitacion = null;
                for (Habitacion i: habitaciones){
                    String iID= i.getIdentificador();
                    if (iID.equals(id)){
                        habitacion= i;
                    }
                    else {
                        System.out.println("No se encontro habitacion");
                    }
                }
                System.out.println("Ingrese los nombres de los huespedes separados por , ");
                String nombres = scanner.nextLine();
                String[] integrantes = nombres.split(", ");
                ArrayList<Huesped> huespedesGrupo = null;
                ArrayList<Huesped> huespedes = Huesped.getHuespedes();

                for (String i: integrantes){
                    for (Huesped j: huespedes){
                    String jnom= i.getNombre();
                    if (jnom.equals(nombre)){
                        huespedesGrupo.add(j);
                    }
                    else {
                        System.out.println("No se encontro huesped");
                    }
                    }
                }
                
                Grupo grupo = new Grupo(huespedesGrupo);
                menuRecep.asignarHabitacionAGrupo(habitacion,grupo);
        }
	
    }

}
