package console;

import model.Cargador;
import model.InformacionHotel;

public class InterfazEmpleado {

    private Cargador cargador;
    private InformacionHotel informacionHotel;

    public InterfazEmpleado(Cargador car, InformacionHotel info){
        cargador = car;
        informacionHotel = info;
    }

    public void mostrarMenu(){
        System.out.println("1. Consultar inventario de habitaciones.");
        System.out.println("2. Registrar consumo de huesped. ");
        System.out.println("3. Registrar pago de huesped. ");
    }

    public void opcionElegida(int opcion){

    }
    
}
