package console;

import java.io.File;
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
        informacion = pms.getInformacionHotel();
        guardador = pms.getGuardador();
        autenticador = new Autenticador(informacion);
        interfazAdministrador = new InterfazAdministrador(cargador, informacion);
        interfazRecepcionista = new InterfazRecepcionista(cargador, informacion);
        interfazEmpleado = new InterfazEmpleado(cargador, informacion);


        // TODO code application logic here
        corriendo = true;
        
        String[] pathNames = { "src", "data", "usuarios.txt"};
        String pathUsers = String.join(File.separator , pathNames);
        
        cargador.cargarUsuarios(pathUsers);
        while(corriendo){
            mostrarMenu();
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            if(opcion==1){
                iniciarSesion();
            } else{
                corriendo = false;
                System.out.println("Desea guardar?");
                System.out.println("1. Si");
                System.out.println("2. No");
                int opcion2 = scanner.nextInt();
                if(opcion2==1){
                    guardador.guardarHabitaciones();
                    guardador.guardarTipoHabitacones();
                    guardador.guardarUsusariosHotel();
                    guardador.guardarHuespedes();
                    guardador.guardarReservas();
                    guardador.guardarMenuBebidas();
                    guardador.guardarMenuPlatos();
                    guardador.guardarServicios();
                    guardador.guardarConsumos();
                    guardador.guardarCamas();
                    guardador.guardarTarifasCuarto();
                }
                
                
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
            if(autenticador.revisarPassword(login, password)){
                System.out.println("Bienvenido");
                String tipo = autenticador.revisarTipo(login);
                if(tipo.equals("administrador")){
                    boolean corr = true;
                    while(corr){
                        interfazAdministrador.mostrarMenu();
                        int opcion = scanner.nextInt();
                        if(opcion!=12){
                            interfazAdministrador.opcionElegida(opcion);
                        } else {
                            corr = false;
                        }
                    }
                } else if(tipo.equals("recepcionista")){
                    boolean corr = true;
                    while(corr){
                        interfazRecepcionista.mostrarMenu();
                        int opcion = scanner.nextInt();
                        if(opcion!=6){
                            interfazRecepcionista.opcionElegida(opcion);
                        } else {
                            corr = false;
                        }
                    }
                } else if(tipo.equals("empleado")){
                    boolean corr = true;
                    while(corr){
                        interfazEmpleado.mostrarMenu();
                        int opcion = scanner.nextInt();
                        if(opcion!=2){
                            interfazEmpleado.opcionElegida(opcion);
                        } else {
                            corr = false;
                        }
                    }
                }
            } else{
                System.out.println("Contraseña incorrecta");
            }
            

        } else{
            System.out.println("El usuario no existe.");
        }

    }
    
}
