package console;



import persistencia.Cargador;
import model.Consumo;
import model.Factura;
import model.Grupo;
import model.Huesped;
import model.PMS;

public class MenuEmpleado {

    private PMS pms;

    public MenuEmpleado(Cargador car, PMS pms){
        this.pms = pms;
    }

    public void registrarConsumoHuesped(String documento, String grupo ,String nombreConsumo, double valor, String cargarHabitacion){
        Huesped huesped = pms.getHuespedes().get(documento);
        pms.agregarHuesped(huesped);
        Consumo cons = new Consumo(huesped,nombreConsumo,valor);


        
        if(pms.getServicios().get(cons.getTipoConsumo()).hasServicioCuarto()){

            if(grupo.equals("si")){
                Grupo g = pms.getGrupos().get(huesped.getDocumento());
                cons.setGrupo(g);
                cons.setEsGrupo(true);
                g.agregarConsumoNoPago(cons);
                pms.agregarGrupo(g);
            } else{
                cons.setEsGrupo(false);
                cons.setHabitacion(pms.getHuespedes().get(huesped.getDocumento()).getHabitacion().getIdentificador());
                pms.getHuespedes().get(huesped.getDocumento()).agregarConsumo(cons);
            }

            if(cargarHabitacion.equals("si")){
                cons.setPagoInmediato(false);
                cons.setPagado(false);
                cons.setHabitacion(pms.getHuespedes().get(huesped.getDocumento()).getHabitacion().getIdentificador());
            } else{
                cons.setPagoInmediato(true);
                cons.setPagado(false);
                registrarPago(cons);
            }

        } else{
            if(grupo.equals("si")){
                Grupo g = pms.getGrupos().get(huesped.getDocumento());
                cons.setGrupo(g);
                cons.setEsGrupo(true);
                g.agregarConsumoNoPago(cons);
            } else{
                cons.setEsGrupo(false);
                cons.setHabitacion(pms.getHuespedes().get(huesped.getDocumento()).getHabitacion().getIdentificador());
                pms.getHuespedes().get(huesped.getDocumento()).agregarConsumo(cons);
            }
            cons.setPagoInmediato(true);
            cons.setPagado(false);
            registrarPago(cons);
            
        }
        pms.agregarConsumo(cons);
        pms.agregarProductosPorCantidad(nombreConsumo);
        pms.agregarProductosPorPrecio(nombreConsumo,valor);
        
        
    }
    
    private void registrarPago(Consumo cons){
        cons.setPagado(true);
        Factura factura =new Factura(cons);
        factura.generarTextoFactura();
        cons.setFactura(factura);
        pms.agregarConsumo(cons);
        System.out.println(factura.getTextoFactura());
    }

}
