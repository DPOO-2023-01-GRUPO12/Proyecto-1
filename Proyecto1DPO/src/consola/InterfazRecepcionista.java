package consola;
import java.util.ArrayList;
import java.util.Scanner;

import hotel.Huesped;

public class InterfazRecepcionista extends InterfazEmpleado
{
    private MenuEmpleado menuEmp;
    private MenuRecepcionista menuRecep;
    
    public void mostrarMenu() {

    System.out.println("1. Hacer reserva por huesped");
	System.out.println("2. Registrar huesped");
	System.out.println("3. Asignar habitacion a huesped.");
	System.out.println("4. Generar factura");
	System.out.println("5. Obtener informacion habitaciones");
	System.out.println("6. Obtener informacion reservas.");
	System.out.println("7. Asignar habitacion grupo");
	System.out.println("8. Crear habitacion.");
	
    }
    
    public void opcionElegida(int opcion) {
        Scanner scanner= new Scanner(System.in);
        switch (opcion){
            case 1:
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
                System.out.println("Ingrese fecha de ingreso");
                String fechain= scanner.nextLine();
                System.out.println("Ingrese fecha de salida");
                String fechafin= scanner.nextLine();
                menuRecep.hacerReservaPorHuesped(huesped,fechain,fechafin);


            case 2:
                System.out.println ("Ingrese Nombre");
                String nombre= scanner.nextLine();
                System.out.println ("Ingrese Correo");
                String correo= scanner.nextLine();
                System.out.println ("Ingrese Documento");
                String documento= scanner.nextLine();
                System.out.println ("Ingrese Celular");
                String celular= scanner.nextLine();
                menuRecep.RegistrarHuesped(nombre,correo,documento,celular);

            case 3:

        }
	
    }

}
