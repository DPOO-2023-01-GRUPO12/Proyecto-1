package console;

import model.Cargador;
import model.InformacionHotel;

public class InterfazRecepcionista {

    private Cargador cargador;
    private InformacionHotel informacionHotel;

    public InterfazRecepcionista(Cargador car, InformacionHotel info){
        cargador = car;
        informacionHotel = info;
    }

    public void mostrarMenu(){
        System.out.println("1. Consultar inventario de habitaciones.");
        System.out.println("2. Realizar reserva por huesped. ");
        System.out.println("3. Cancelar reserva. ");
        System.out.println("4. Realizar check-out.");

    }

    public void opcionElegida(int opcion){

    }
}
