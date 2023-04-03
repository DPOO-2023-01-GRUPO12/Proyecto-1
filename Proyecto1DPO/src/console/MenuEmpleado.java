package console;

import java.util.Scanner;

import model.Cargador;
import model.Consumo;
import model.Factura;
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

            if(grupo.equals("si")){
                Grupo g = informacionHotel.getGrupos().get(huesped.getDocumento());
                cons.setGrupo(g);
                cons.setEsGrupo(true);
                g.agregarConsumoNoPago(cons);
                cargador.agregarGrupo(g);
            } else{
                cons.setEsGrupo(false);
                cons.setHabitacion(informacionHotel.getHuespedes().get(huesped.getDocumento()).getHabitacion().getIdentificador());
                informacionHotel.getHuespedes().get(huesped.getDocumento()).agregarConsumo(cons);
            }

            if(cargarHabitacion.equals("si")){
                cons.setPagoInmediato(false);
                cons.setPagado(false);
                cons.setHabitacion(informacionHotel.getHuespedes().get(huesped.getDocumento()).getHabitacion().getIdentificador());
            } else{
                cons.setPagoInmediato(true);
                cons.setPagado(false);
                registrarPago(cons);
            }

        } else{
            if(grupo.equals("si")){
                Grupo g = informacionHotel.getGrupos().get(huesped.getDocumento());
                cons.setGrupo(g);
                cons.setEsGrupo(true);
                g.agregarConsumoNoPago(cons);
            } else{
                cons.setEsGrupo(false);
                cons.setHabitacion(informacionHotel.getHuespedes().get(huesped.getDocumento()).getHabitacion().getIdentificador());
                informacionHotel.getHuespedes().get(huesped.getDocumento()).agregarConsumo(cons);
            }
            cons.setPagoInmediato(true);
            cons.setPagado(false);
            registrarPago(cons);
            
        }
        cargador.agregarConsumo(cons);

        scanner.close();

    }
    
    private void registrarPago(Consumo cons){
        cons.setPagado(true);
        Factura factura =new Factura(cons);
        factura.generarTextoFactura();
        cons.setFactura(factura);
        cargador.agregarConsumo(cons);
        System.out.println(factura.getTextoFactura());
    }

}
