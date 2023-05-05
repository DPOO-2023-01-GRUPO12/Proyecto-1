package console;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

    public void cargarHabitaciones(String pathHabitaciones) throws IOException {
        File file = new File("Proyecto1DPO/data/" + pathHabitaciones);
        try {

            cargador.cargarHabitaciones(file);
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        }
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

    public void crearHabitacion(String id, String ub, String desc) throws FileNotFoundException, IOException {
        Habitacion habitacion = new Habitacion(id, ub, desc);
        System.out.println("Para crear una habitacion debe seleccionar un tipo de habitacion y camas.");
        asignarHabitacionTipo(habitacion);
        asignarHabitacionCamas(habitacion);
        pms.agregarHabitacion(habitacion);
    }

    private void asignarHabitacionTipo(Habitacion hab) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        mostrarMenuTipoHabitacion();
        int opcion = scanner.nextInt();
        scanner.nextLine();
        TipoHabitacion tipo = opcionTipoHabitacion(opcion);
        if (tipo.equals(null)) {
            System.out.println("No se pudo asignar el tipo de habitacion habitacion.");
        } else {
            pms.agregarTipoHabitacion(tipo);
            hab.setTipoHabitacion(tipo);
            pms.agregarHabitacion(hab);
        }

    }

    private void asignarHabitacionCamas(Habitacion hab) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        mostrarMenuCamas();
        int opcion = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Cama> camas = opcionCamas(opcion);
        if (camas.equals(null)) {
            System.out.println("No se pudo asignar las camas a la habitacion.");
        } else {
            for (Cama cama : camas) {
                pms.agregarCama(cama);
            }
            hab.setCamas(camas);
            pms.agregarHabitacion(hab);

        }

    }

    private void mostrarMenuTipoHabitacion() {
        System.out.println("1. Seleccionar tipo de habitacion. ");
        System.out.println("2. Crear tipo de habitacion. ");

    }

    private TipoHabitacion opcionTipoHabitacion(int opcion) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                if (pms.getTipoHabitaciones().isEmpty()) {
                    System.out.println("No hay tipos de habitacion cargados, ¿desea cargar los tipos de habitacion?.");
                    System.out.println("1. Si.");
                    System.out.println("2. No.");
                    int opcion2 = scanner.nextInt();
                    scanner.nextLine();
                    if (opcion2 == 1) {
                        System.out.println("Ingrese el nombre del archivo: ");
                        String nombreArchivo = scanner.nextLine();
                        cargarTipoHabitaciones(nombreArchivo);
                    } else {
                        System.out.println("No se puede crear una habitacion sin un tipo de habitacion.");
                        return null;
                    }
                }
                System.out.println("Seleccione el tipo de habitacion: ");
                System.out.println(pms.getTipoHabitaciones().keySet());

                String nombreTipo = scanner.nextLine();
                if (!pms.getTipoHabitaciones().containsKey(nombreTipo)) {
                    System.out.println("El tipo de habitacion no existe");
                    return null;
                }
                return pms.getTipoHabitaciones().get(nombreTipo);
            case 2:
                System.out.println("Ingrese el nombre del tipo de habitacion: ");
                String nombreTipo2 = scanner.nextLine();
                if (pms.getTipoHabitaciones().containsKey(nombreTipo2)) {
                    System.out.println("El tipo de habitacion ya existe, ingrese uno nuevo: ");
                    return null;
                }
                return crearTipoHabitacion(nombreTipo2);
            default:
                System.out.println("Opcion invalida, intente de nuevo.");
                return null;
        }
    }

    public TipoHabitacion crearTipoHabitacion(String tipo) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        TipoHabitacion tipoHabitacion = new TipoHabitacion(tipo);
        System.out.println("Debe asignarle al menos una tarifa al tipo de habitacion. ");
        System.out.println("1. Seleccionar tarifa de habitacion. ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 1) {
            if (pms.getTarifasCuartos().isEmpty()) {
                System.out.println("No hay tarifas cargadas, ¿desea cargar las tarifas?.");
                System.out.println("1. Si.");
                System.out.println("2. No.");
                int opcion2 = scanner.nextInt();
                scanner.nextLine();
                if (opcion2 == 1) {
                    System.out.println("Ingrese el nombre del archivo: ");
                    String nombreArchivo = scanner.nextLine();
                    cargarTarifasPorTipoCuarto(nombreArchivo);
                } else {
                    System.out.println("No se puede crear una habitacion sin una tarifa.");
                    return null;
                }
            }
            System.out.println("Seleccione la tarifa marcando el numero de la que desea: ");
            for (TarifaCuarto tar : pms.getTarifasCuartos()) {
                if (tar.getTipoCuarto().equals(tipoHabitacion.getNombreTipo())) {
                    int index = pms.getTarifasCuartos().indexOf(tar);
                    System.out.print("Tarifa " + index + ": ");
                    System.out.println(tar.toString());
                }
            }
            int opcion3 = scanner.nextInt();
            scanner.nextLine();
            if (opcion3 < 0 || opcion3 > pms.getTarifasCuartos().size()) {
                System.out.println("Opcion invalida.");

                return null;
            }
            tipoHabitacion.agregarTarifaCuarto(pms.getTarifasCuartos().get(opcion3));
            pms.agregarTipoHabitacion(tipoHabitacion);

        } else {
            System.out.println("Opcion invalida.");

            return null;
        }

        return tipoHabitacion;

    }

    private void mostrarMenuCamas() {
        System.out.println("1. Seleccionar camas. ");
    }

    private ArrayList<Cama> opcionCamas(int opcion) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                if (pms.getCamas().isEmpty()) {
                    System.out.println("No hay camas cargadas, ¿desea cargar las camas?.");
                    System.out.println("1. Si.");
                    System.out.println("2. No.");
                    int opcion2 = scanner.nextInt();
                    scanner.nextLine();
                    if (opcion2 == 1) {
                        System.out.println("Ingrese el nombre del archivo: ");
                        String nombreArchivo = scanner.nextLine();
                        cargarCamas(nombreArchivo);
                    } else {
                        System.out.println("No se puede crear una habitacion sin camas.");
                        return null;
                    }
                }
                System.out.println("¿Cuantas camas desea asignar a la habitacion?");
                int cantidad = scanner.nextInt();
                scanner.nextLine();
                ArrayList<Cama> camas = new ArrayList<Cama>();
                ArrayList<Integer> camasEscogidas = new ArrayList<Integer>();
                for (Cama cama : pms.getCamas()) {
                    int index = pms.getCamas().indexOf(cama);
                    System.out.print("Cama " + index);
                    System.out.println(cama.toString());
                }

                for (int i = 0; i < cantidad; i++) {
                    System.out.println("Seleccione la cama que desea agregar a la habitacion: ");
                    int camaIndex = scanner.nextInt();
                    if (camaIndex < 0 || camaIndex > pms.getCamas().size()) {
                        System.out.println("Opcion invalida");

                    }
                    if (camasEscogidas.contains(Integer.valueOf(camaIndex))) {
                        System.out.println("La cama ya fue seleccionada, escoja otra: ");
                        camaIndex = scanner.nextInt();
                    } else {
                        camasEscogidas.add(Integer.valueOf(camaIndex));
                        camas.add(pms.getCamas().get(camaIndex));

                    }
                }
                return camas;
            default:
                System.out.println("Opcion invalida.");
                return null;
        }
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

    public void configurarPlato(String nombrePlato) {
        System.out.println("¿Que desea cambiar del plato?");
        mostrarMenuPlatoBebida();
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        scanner.nextLine();
        Plato plato = pms.getMenuPlatos().get(nombrePlato);
        pms.agregarPlato(plato);
        opcionPlatoBebida(opcion, plato);

    }

    public void configurarBebida(String nombreBebida) {
        System.out.println("¿Que desea cambiar de la bebida?");
        mostrarMenuPlatoBebida();
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        scanner.nextLine();
        Bebida bebida = pms.getMenuBebidas().get(nombreBebida);
        pms.agregarBebida(bebida);
        opcionPlatoBebida(opcion, bebida);

    }

    private void mostrarMenuPlatoBebida() {
        System.out.println("1. Cambiar nombre. ");
        System.out.println("2. Cambiar tarifa.");
        System.out.println("3. Cambiar rango de horas disponible. ");
        System.out.println("4. Cambiar comida de disponibilidad. ");
        System.out.println("5. Cambiar lugar de disponibilidad. ");
        System.out.println("6. Cambiar disponibilidad para servicio al cuarto.. ");
    }

    private void opcionPlatoBebida(int opcion, Plato plato) {
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println("Nombre actual del plato: " + plato.getNombre());
                System.out.println("Ingrese el nuevo nombre del plato: ");

                String nombre = scanner.nextLine();

                while (pms.getMenuPlatos().containsKey(nombre)) {
                    System.out.println("Ya existe un plato con ese nombre, intente de nuevo.");
                    nombre = scanner.nextLine();
                }
                plato.setNombre(nombre);
                pms.getMenuPlatos().remove(plato.getNombre());
                pms.getMenuPlatos().put(nombre, plato);

                break;
            case 2:
                System.out.println("Tarifa actual del plato: " + plato.getTarifa());
                System.out.println("Ingrese la nueva tarifa del plato: ");
                double tarifa = scanner.nextDouble();
                plato.setTarifa(tarifa);
                pms.agregarPlato(plato);

                break;
            case 3:
                System.out.println("Rango de horas actual del plato: " + plato.getRangoHoras());
                System.out.println("Ingrese el nuevo rango de horas del plato: ");
                String horas = scanner.nextLine();
                plato.setRangoHoras(horas);
                pms.agregarPlato(plato);

                break;
            case 4:
                System.out.println("Comidas de disponibilidad actual del plato: " + plato.getComidaDispon());
                System.out.println("Ingrese las nuevas comidas de disponiblidad del plato: ");
                String comida = scanner.nextLine();
                plato.setComidaDispon(comida);
                pms.agregarPlato(plato);

                break;
            case 5:
                System.out.println("Lugares de disponibilidad actual del plato: " + plato.getLugarDispon());
                System.out.println("Ingrese los nuevos lugares de disponibilidad del plato: ");
                String lugar = scanner.nextLine();
                plato.setLugarDispon(lugar);
                pms.agregarPlato(plato);

                break;
            case 6:
                System.out.println(
                        "Disponibilidad para servicio al cuarto actual del plato: " + plato.hasServicioCuarto());
                System.out.println("Ingrese la nueva disponibilidad para servicio al cuarto del plato: ");
                boolean servicioCuarto = scanner.nextBoolean();
                plato.setServicioCuarto(servicioCuarto);
                pms.agregarPlato(plato);

                break;
            default:
                System.out.println("Opcion invalida.");

                break;
        }
    }

    private void opcionPlatoBebida(int opcion, Bebida bebida) {
        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println("Nombre actual de la bebida: " + bebida.getNombre());
                System.out.println("Ingrese el nuevo nombre de la bebida: ");

                String nombre = scanner.nextLine();

                while (pms.getMenuBebidas().containsKey(nombre)) {
                    System.out.println("Ya existe una bebida con ese nombre, intente de nuevo.");
                    nombre = scanner.nextLine();
                }
                bebida.setNombre(nombre);
                pms.getMenuBebidas().remove(bebida.getNombre());
                pms.getMenuBebidas().put(nombre, bebida);

                break;
            case 2:
                System.out.println("Tarifa actual de la bebida: " + bebida.getTarifa());
                System.out.println("Ingrese la nueva tarifa de la bebida: ");
                double tarifa = scanner.nextDouble();
                bebida.setTarifa(tarifa);
                pms.agregarBebida(bebida);

                break;
            case 3:
                System.out.println("Rango de horas actual de la bebida: " + bebida.getRangoHoras());
                System.out.println("Ingrese el nuevo rango de horas de la bebida: ");
                String horas = scanner.nextLine();
                bebida.setRangoHoras(horas);
                pms.agregarBebida(bebida);

                break;
            case 4:
                System.out.println("Comidas de disponibilidad actual de la bebida: " + bebida.getComidaDispon());
                System.out.println("Ingrese las nuevas comidas de disponiblidad de la bebida: ");
                String comida = scanner.nextLine();
                bebida.setComidaDispon(comida);
                pms.agregarBebida(bebida);

                break;
            case 5:
                System.out.println("Lugares de disponibilidad actual de la bebida: " + bebida.getLugarDispon());
                System.out.println("Ingrese los nuevos lugares de disponibilidad de la bebida: ");
                String lugar = scanner.nextLine();
                bebida.setLugarDispon(lugar);
                pms.agregarBebida(bebida);

                break;
            case 6:
                System.out.println(
                        "Disponibilidad para servicio al cuarto actual de la bebida: " + bebida.hasServicioCuarto());
                System.out.println("Ingrese la nueva disponibilidad para servicio al cuarto de la bebida: ");
                boolean servicioCuarto = scanner.nextBoolean();
                bebida.setServicioCuarto(servicioCuarto);
                pms.agregarBebida(bebida);

                break;
            default:
                System.out.println("Opcion invalida.");

                break;
        }
    }

}
