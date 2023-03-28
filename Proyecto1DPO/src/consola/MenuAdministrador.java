package consola;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import hotel.Habitacion;
import hotel.Tarifa;
import hotel.TipoHabitacion;

public class MenuAdministrador
{
    private CargadorInformacion cargador;
    private GuardadorInformacion guardador;
    private Habitacion habitacion;
    
    
    public void cargarInformacionServicios(File servicios) throws FileNotFoundException, IOException {
	cargador.cargarServicios(servicios);
    }
    
    public void cargarInformacionHabitaciones(File habitaciones) throws FileNotFoundException, IOException {
	cargador.cargarHabitaciones(habitaciones);
    }
    
    public void cargarInformacionTarifas(File tarifas) throws FileNotFoundException, IOException {
	cargador.cargarTarifas(tarifas);
    }
    
    public void modificarTarifa(int identificador, int opcion) {
        Tarifa tarifaModificar = null;
        for(Tarifa tar: Tarifa.getTarifas()){
            if(tar.getIdentificador() == identificador){
                tarifaModificar = tar;
                break;
            }
        }
        switch(opcion){
            case 1:
                //modificar Tipo
                System.out.println("El tipo de tarifa es: " + tarifaModificar.getTipoCuarto());
                System.out.println("Ingrese el nuevo tipo de tarifa: ");
                String tipo = System.console().readLine();
                tarifaModificar.setTipo(tipo);
                break;

            case 2:
                //modificar rango de fechas
                System.out.println("El rango de fechas es: " + tarifaModificar.getRangoFechas());
                System.out.println("Desea (1. Agregar nuevo rango 2. Eliminar)");
                int opcionRango = Integer.parseInt(System.console().readLine());
                switch(opcionRango){
                    case 1:
                        System.out.println("Ingrese el nuevo rango de fechas: ");
                        String rango = System.console().readLine();
                        tarifaModificar.getRangoFechas().add(rango);
                        break;
                    case 2:
                        System.out.println("Ingrese el rango de fechas a eliminar: ");
                        String rangoEliminar = System.console().readLine();
                        for(int i = 0; i < tarifaModificar.getRangoFechas().size(); i++){
                            if(rangoEliminar.equals(tarifaModificar.getRangoFechas().get(i))){
                                tarifaModificar.getRangoFechas().remove(i);
                                break;
                            }
                        }
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
                break;
            case 3:
                //modificar días de la semana
                System.out.println("Los días de la semana son: " + tarifaModificar.getDiasSemana());
                System.out.println("Desea (1. Agregar nuevos días    2. Eliminar días)");
                int opcionDias = Integer.parseInt(System.console().readLine());
                switch(opcionDias){
                    case 1:
                        System.out.println("Ingrese los nuevos días de la semana ");
                        String dias = System.console().readLine();
                        tarifaModificar.getDiasSemana().add(dias);
                        break;
                    case 2:
                        System.out.println("Ingrese los  días de la semana a eliminar ");
                        String diasPorEliminar = System.console().readLine();
                        for (int i = 0; i< tarifaModificar.getDiasSemana().size(); i++){
                            if (diasPorEliminar.equals(tarifaModificar.getDiasSemana().get(i))){
                                tarifaModificar.getDiasSemana().remove(i);
                                break;
                            }
                        }
                    break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }   
                break;
            case 4:
                System.out.println("El valor de la tarifa es: " + tarifaModificar.getValor());
                System.out.println("Ingrese el nuevo valor de la tarifa: ");
                double valorModificar = Double.parseDouble(System.console().readLine());
                tarifaModificar.setValor(valorModificar);
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
	
    }
    
    public void modificarServicio() {
	
    }
    
    public void modificarHabitacion() {
	
    }
    
    public void modificarMenuComida() {
	
    }
    
    public Habitacion crearHabitacion(String id, String ubicacion, int capacidad, TipoHabitacion tipo) {
	Habitacion habitacion = new Habitacion(id,ubicacion,capacidad,tipo);
	return habitacion;
    }




}
