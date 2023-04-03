package console;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import model.Cargador;
import model.GuardadorInformacion;
import model.InformacionHotel;
import model.PMS;

public class Interfaz {
    private static PMS pms;
    private static Cargador cargador;
    private static GuardadorInformacion guardador;
    private static InformacionHotel informacion;
    private static Autenticador autenticador;

    private static boolean corriendo;

    private static InterfazAdministrador interfazAdministrador;
    private static InterfazRecepcionista interfazRecepcionista;
    private static InterfazEmpleado interfazEmpleado;
    
    public static void main(String[] args) throws ParseException, IOException {
        pms = new PMS();
        cargador = pms.getCargador();
        guardador = pms.getGuardador();
        informacion = pms.getInformacionHotel();
        autenticador = new Autenticador(informacion);
        interfazAdministrador = new InterfazAdministrador(cargador, informacion);
        interfazRecepcionista = new InterfazRecepcionista(cargador, informacion);
        interfazEmpleado = new InterfazEmpleado(cargador, informacion);


        // TODO code application logic here
        corriendo = true;
        cargador.cargarUsuarios("data\\Usuarios.txt");
        while(corriendo){
            mostrarMenu();
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            if(opcion==1){
                iniciarSesion();
            } else{
                corriendo = false;
                scanner.close();
            }
        }
    }

    public static void mostrarMenu(){
        System.out.println("Bienvenido al sistema del hotel");
        System.out.println("1. Iniciar sesion");
        System.out.println("2. Salir");
    }

    public static void iniciarSesion() throws ParseException, IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su login: ");
        String login = scanner.nextLine();
        System.out.println("Ingrese su password: ");
        String password = scanner.nextLine();
        if(autenticador.revisarExistencia(login)){
            String tipo = autenticador.revisarTipo(login);
            if(tipo.equals("administrador")){
                interfazAdministrador.mostrarMenu();
                int opcion = scanner.nextInt();
                interfazAdministrador.opcionElegida(opcion);


            } else if(tipo.equals("recepcionista")){
                interfazRecepcionista.mostrarMenu();
                int opcion = scanner.nextInt();
                interfazRecepcionista.opcionElegida(opcion);

            } else if(tipo.equals("empleado")){
                interfazEmpleado.mostrarMenu();
            }

        } else{
            System.out.println("El usuario no existe.");
        }
        scanner.close();

    }
    
}
