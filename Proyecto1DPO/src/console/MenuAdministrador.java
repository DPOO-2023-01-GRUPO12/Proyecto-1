package console;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import persistencia.Cargador;
import model.Habitacion;
import model.PMS;
import model.Plato;
import model.Servicio;
import model.TarifaCuarto;
import model.TipoHabitacion;
import model.Bebida;
import model.Cama;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MenuAdministrador {
    private Cargador cargador;
    private PMS pms;

    public MenuAdministrador(Cargador car, PMS pms) {
        cargador = car;
        this.pms = pms;
        
    }

    public void informarFechasSinTarifa() throws ParseException {
        TimeUnit time = TimeUnit.DAYS;
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        for (Map.Entry<String, TipoHabitacion> tipo : pms.getTipoHabitaciones().entrySet()) {
            ArrayList<Date> fechasTomadas = new ArrayList<Date>();
            for (TarifaCuarto tar : tipo.getValue().getTarifas()) {
                String rangoFechas = tar.getRangoFechas();
                String[] fechas = rangoFechas.split("-");
                String fechaInTarifa = fechas[0];
                fechaInTarifa = fechaInTarifa.trim();
                fechaInTarifa = fechaInTarifa.replace("de ", "");
                fechaInTarifa = fechaInTarifa.replace(" ", "/");
                String fechaFinTarifa = fechas[1];
                fechaFinTarifa = fechaFinTarifa.trim();
                fechaFinTarifa = fechaFinTarifa.replace("de ", "");
                fechaFinTarifa = fechaFinTarifa.replace(" ", "/");

                Date inicioTarifa = formato.parse(fechaInTarifa);
                Date finTarifa = formato.parse(fechaFinTarifa);
                long difeTarifaTiempo = finTarifa.getTime() - inicioTarifa.getTime();
                int difeTarifaDias = (int) time.convert(difeTarifaTiempo, TimeUnit.MILLISECONDS);

                for (int i = 1; i <= difeTarifaDias; i++) {
                    Calendar cal = new GregorianCalendar();
                    cal.setTime(inicioTarifa);
                    Date fecha = cal.getTime();
                    fechasTomadas.add(fecha);
                    cal.add(Calendar.DATE, i);
                }
            }
            if (fechasTomadas.size() != 365) {
                System.out.println("El tipo de habitacion " + tipo.getValue().getNombreTipo()
                        + " no tiene tarifas para las siguientes fechas:");
                for (int i = 1; i < 365; i++) {
                    Calendar cal = new GregorianCalendar();
                    cal.setTime(new Date());
                    cal.add(Calendar.DATE, i);
                    Date fecha = cal.getTime();
                    if (!fechasTomadas.contains(fecha)) {
                        System.out.println(formato.format(fecha));
                    }
                }
            }
        }
    }

    public void cargarTipoHabitaciones(String pathTipoHabitaciones) throws FileNotFoundException, IOException {
        File file = new File("Proyecto1DPO/data/" + pathTipoHabitaciones);
        try {
            cargador.cargarTipoHabitaciones(file);
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        }

    }

    public void cargarTarifasPorTipoCuarto(String pathTarifasTipoCuarto) throws FileNotFoundException, IOException {
        File file = new File("Proyecto1DPO/data/" + pathTarifasTipoCuarto);
        try {
            cargador.cargarTarifasCuarto(file);
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        }
    }

    public void cargarCamas(String pathFile) throws FileNotFoundException, IOException {
        File file = new File("Proyecto1DPO/data/" + pathFile);
        try {
            cargador.cargarCamas(file);
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        }
    }

    public Habitacion crearHabitacion(String id, String ub, String desc) {
        Habitacion habitacion = new Habitacion(id, ub, desc);

       
        return habitacion;
    }

    public void crearHabitacion(String id, String ub, String desc,  String tipoHab, int[] indicesCamas,boolean cocina, boolean balcon,
            boolean vista,boolean aireA,boolean calefaccion,boolean ropadecama,
            boolean secador,boolean plancha, boolean usba,boolean usbc,boolean desayuno,boolean TV,boolean cafetera) {
        Habitacion habitacion = new Habitacion(id, ub, desc);
        habitacion.setCocina(cocina);
        habitacion.setBalcon(balcon);
        habitacion.setVista(vista);
        habitacion.setAireAcondicionado(aireA);
        habitacion.setCalefaccion(calefaccion);
        habitacion.setTV(TV);
        habitacion.setCafetera(cafetera);
        habitacion.setRopaDeCama(ropadecama);
        habitacion.setPlancha(plancha);
        habitacion.setSecador(secador);
        habitacion.setUSBA(usba);
        habitacion.setUSBC(usbc);
        habitacion.setDesayuno(desayuno);
        TipoHabitacion tipo = pms.getTipoHabitaciones().get(tipoHab);
        habitacion.setTipoHabitacion(tipo);
        ArrayList<Cama> camasSelec = new ArrayList<Cama>();
        for (int i : indicesCamas) {
            camasSelec.add(pms.getCamas().get(i));
        }
        habitacion.setCamas(camasSelec);
        pms.agregarHabitacion(habitacion);
    }

    public void asignarHabitacionTipo(Habitacion hab, TipoHabitacion tipo) {
        hab.setTipoHabitacion(tipo);
    }

    public void asignarHabitacionCamas(Habitacion hab, ArrayList<Cama> camas) {
        hab.setCamas(camas);
        pms.agregarHabitacion(hab);
    }

    public void crearTipoHabitacion(String tipo) {
        TipoHabitacion tipoHabitacion = new TipoHabitacion(tipo);
        pms.agregarTipoHabitacion(tipoHabitacion);
        pms.actualizarTarifasHabitacion();
    }

    public void cargarServicios(String pathServicios) throws FileNotFoundException, IOException {
        File file = new File("Proyecto1DPO/data/" + pathServicios);
        try {
            cargador.cargarServicios(file);
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        }

    }

    public void cambiarTarifaServicio(String nombreServicio, double valor) {
        Servicio ser = pms.getServicios().get(nombreServicio);
        System.out.println(pms.getServicios());
        System.out.println(nombreServicio + ", " + valor + ", " + ser);
        ser.setTarifa(valor);
        pms.agregarServicio(ser);

    }

    public void cargarMenuPlatos(String pathPlatos) throws FileNotFoundException, IOException {
        File file = new File("Proyecto1DPO/data/" + pathPlatos);
        try {
            cargador.cargarMenuPlatos(file);
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        }
    }

    public void cargarMenuBebidas(String pathBebidas) throws FileNotFoundException, IOException {
        File file = new File("Proyecto1DPO/data/" + pathBebidas);
        try {
            cargador.cargarMenuBebidas(file);
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        }
    }

    public void configurarPlatoNombre(String nombreString, String nuevo) {
        Plato plato = pms.getMenuPlatos().get(nombreString);
        plato.setNombre(nombreString);
        pms.getMenuPlatos().remove(plato.getNombre());
        pms.getMenuPlatos().put(nuevo, plato);
    }

    public void configurarPlatoTarifa(String nombreString, double nuevo) {
        Plato plato = pms.getMenuPlatos().get(nombreString);
        plato.setTarifa(nuevo);
        pms.agregarPlato(plato);
    }

    public void configurarPlatoRangoHoras(String nombreString, String nuevo) {
        Plato plato = pms.getMenuPlatos().get(nombreString);
        plato.setRangoHoras(nuevo);
        pms.agregarPlato(plato);
    }

    public void configurarPlatoDisponibilidadComida(String nombreString, String nuevo) {
        Plato plato = pms.getMenuPlatos().get(nombreString);
        plato.setComidaDispon(nuevo);
        pms.agregarPlato(plato);
    }

    public void configurarPlatoDisponibilidadLugar(String nombreString, String nuevo) {
        Plato plato = pms.getMenuPlatos().get(nombreString);
        plato.setLugarDispon(nuevo);
        pms.agregarPlato(plato);
    }

    public void configurarPlatoDisponibilidadServicioCuarto(String nombreString, boolean nuevo) {
        Plato plato = pms.getMenuPlatos().get(nombreString);
        plato.setServicioCuarto(nuevo);
        pms.agregarPlato(plato);
    }

    //
    //
    //

    public void configurarBebidaNombre(String nombreString, String nuevo) {
        Bebida bebida = pms.getMenuBebidas().get(nombreString);
        bebida.setNombreBebida(nuevo);
        pms.getMenuBebidas().remove(bebida.getNombre());
        pms.getMenuBebidas().put(nuevo, bebida);
    }

    public void configurarBebidaTarifa(String nombreString, double nuevo) {
        Bebida bebida = pms.getMenuBebidas().get(nombreString);
        bebida.setTarifa(nuevo);
        pms.agregarBebida(bebida);
    }

    public void configurarBebidaRangoHoras(String nombreString, String nuevo) {
        Bebida bebida = pms.getMenuBebidas().get(nombreString);
        bebida.setRangoHoras(nuevo);
        pms.agregarBebida(bebida);
    }

    public void configurarBebidaDisponibilidadComida(String nombreString, String nuevo) {
        Bebida bebida = pms.getMenuBebidas().get(nombreString);
        bebida.setComidaDispon(nuevo);
        pms.agregarBebida(bebida);
    }

    public void configurarBebidaDisponibilidadLugar(String nombreString, String nuevo) {
        Bebida bebida = pms.getMenuBebidas().get(nombreString);
        bebida.setLugarDispon(nuevo);
        pms.agregarBebida(bebida);
    }

    public void configurarBebidaDisponibilidadServicioCuarto(String nombreString, boolean nuevo) {
        Bebida bebida = pms.getMenuBebidas().get(nombreString);
        bebida.setServicioCuarto(nuevo);
        pms.agregarBebida(bebida);
    }

}
