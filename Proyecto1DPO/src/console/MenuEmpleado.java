package console;

import java.util.Scanner;

import model.Cargador;
import model.Consumo;
import model.Grupo;
import model.Huesped;
import model.InformacionHotel;

public class MenuEmpleado {

    private Cargador cargador;
    private InformacionHotel informacionHotel;

    public MenuEmpleado(Cargador car, InformacionHotel info){
        cargador = car;
        informacionHotel = info;
    }

    public void registrarConsumoHuesped(Huesped huesped, Consumo cons, String grupo){
        Scanner scanner = new Scanner(System.in);
        if(informacionHotel.getServicios().get(cons.getTipoConsumo()).hasServicioCuarto()){
            System.out.println("Desea cargarlo a la habitacion? (si/no): ");
            String cargarHabitacion = scanner.nextLine();
            while(!cargarHabitacion.equals("si") && !cargarHabitacion.equals("no")){
                System.out.println("La respuesta ingresada no es valida. Ingrese nuevamente: ");
                cargarHabitacion = scanner.nextLine();
            }
            if(cargarHabitacion.equals("si")){
                cons.setPagoInmediato(true);
                cons.setPagado(false);
                cons.setHabitacion(informacionHotel.getHuesped().get(huesped.getDocumento()).getHabitacion().getIdentificador());
            } else{
                cons.setPagoInmediato(true);
                cons.setPagado(false);
            }
            if(grupo.equals("si")){
                Grupo g = informacionHotel.getGrupos().get(huesped.getDocumento());
                cons.setEsGrupo(true);
                g.agregarConsumoNoPago(cons);
            } else{
                cons.setEsGrupo(false);
                cons.setHabitacion(informacionHotel.getHuesped().get(huesped.getDocumento()).getHabitacion().getIdentificador());
                informacionHotel.getHuesped().get(huesped.getDocumento()).agregarConsumo(cons);
            }
        } else{
            cons.setPagoInmediato(true);
            cons.setPagado(false);
            if(grupo.equals("si")){
                Grupo g = informacionHotel.getGrupos().get(huesped.getDocumento());
                cons.setEsGrupo(true);
                g.agregarConsumoNoPago(cons);
            } else{
                cons.setEsGrupo(false);
                cons.setHabitacion(informacionHotel.getHuesped().get(huesped.getDocumento()).getHabitacion().getIdentificador());
                informacionHotel.getHuesped().get(huesped.getDocumento()).agregarConsumo(cons);
            }
        }

        scanner.close();

    }
    
}
