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
    private MenuEmpleado menuEmpleado;

    public InterfazEmpleado(Cargador car, InformacionHotel info){
        cargador = car;
        informacionHotel = info;
        menuEmpleado = new MenuEmpleado(car, info);
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
                opcionPago();
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

        Huesped huespedConsumo = informacionHotel.getHuesped().get(documento);

        System.out.println("Es un grupo? (si/no); ");
        String grupo = scanner.nextLine();
        while(!grupo.equals("si") && !grupo.equals("no")){
            System.out.println("La respuesta ingresada no es valida. Ingrese nuevamente: ");
            grupo = scanner.nextLine();
        }


        System.out.println("Ingrese el tipo de consumo: ");
        System.out.println("restaurante,spa,guia");
        String tipoConsumo = scanner.nextLine();

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
        menuEmpleado.registrarConsumoHuesped(huespedConsumo, cons, grupo);
        scanner.close();
    
    }
    
    private void opcionPago(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Es un grupo? (si/no): ");
        String grupo = scanner.nextLine();
        while(!grupo.equals("si") && !grupo.equals("no")){
            System.out.println("La respuesta ingresada no es valida. Ingrese nuevamente: ");
            grupo = scanner.nextLine();
        }
        if(grupo.equals("si")){

        } else{
            
        }



        System.out.println("Ingrese el documento del huesped encargado: ");
        String documento = scanner.nextLine();
        while(!informacionHotel.getHuesped().containsKey(documento)){
            System.out.println("El documento ingresado no existe. Ingrese nuevamente: ");
            documento = scanner.nextLine();
        }

        Huesped huespedConsumo = informacionHotel.getHuesped().get(documento);



    }
}
