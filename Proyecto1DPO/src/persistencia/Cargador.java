package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashMap;

import model.Habitacion;
import model.TipoHabitacion;
import model.Cama;
import model.TarifaCuarto;
import model.Bebida;
import model.Plato;
import model.Servicio;

import model.PMS;

public class Cargador {

    private PMS pms;

    public Cargador(PMS pms) {
        this.pms = pms;
    }

    public void cargarHabitaciones(File file) throws IOException, FileNotFoundException {

        if (file.exists()) {

            try {

                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea = br.readLine(); // Ignora la primera línea, los títulos de las columnas.

                linea = br.readLine();
                while (linea != null) {

                    // Lectura del primer bloque

                    String[] partes = linea.split(";");
                    String identificador = partes[0];

                    String ubicacion = partes[1];
                    boolean balcon = Boolean.parseBoolean(partes[2]);
                    boolean vista = Boolean.parseBoolean(partes[3]);
                    boolean cocina = Boolean.parseBoolean(partes[4]);
                    String descripcion = partes[5];

                    // Lectura del segundo bloque

                    String scamas = partes[6];
                    String tipoHabitacionString = partes[7];

                    ArrayList<Cama> camas = new ArrayList<>();

                    // Creador de camas (Si se selecciona que las camas van incluidas en el archivo)

                    List<String> myList = Arrays.asList(scamas.split(",")); // Separa cada una de las camas
                    for (String scama : myList) {

                        String[] partesCama = scama.split("-"); // separa los atributos de una sola cama
                        String tamanio = partesCama[0];
                        int cantidad = Integer.parseInt(partesCama[1]);
                        boolean ninios = Boolean.parseBoolean(partesCama[2]);

                        Cama nuevaCama = new Cama(tamanio, cantidad);
                        nuevaCama.setNinios(ninios);
                        camas.add(nuevaCama);
                    } // for cama

                    // Creador de tipo de habitación

                    TipoHabitacion tipoHabitacion = new TipoHabitacion(tipoHabitacionString);
                    pms.agregarTipoHabitacion(tipoHabitacion);

                    // Creador de la habitación

                    Habitacion elemHabitacion = new Habitacion(identificador, ubicacion, descripcion);
                    elemHabitacion.setTipoHabitacion(tipoHabitacion);
                    elemHabitacion.setCamas(camas);
                    elemHabitacion.setBalcon(balcon);
                    elemHabitacion.setVista(vista);
                    elemHabitacion.setCocina(cocina);
                    elemHabitacion.calcularCapacidad();

                    pms.agregarHabitacion(elemHabitacion); // Actualiza la información (El metodo put actualiza o añade
                                                           // según sea el caso);

                    linea = br.readLine();

                } // While

                br.close();
                actualizarTarifasHabitacion();

            } // try

            catch (FileNotFoundException e) {
                System.out.println("No se encontró el archivo");
                e.printStackTrace();
            } // Catch

            catch (IOException e) {
                System.out.println("Error de lectura");
                e.printStackTrace();
            } // Catch

        } // if

    } // función

    public void cargarTipoHabitaciones(File file) throws IOException, FileNotFoundException {

        if (file.exists()) {

            try {

                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea = br.readLine();
                linea = br.readLine();
                while (linea != null)

                {

                    String[] partes = linea.split(";");
                    String nombre = partes[0];

                    TipoHabitacion tipoHabitacion = new TipoHabitacion(nombre);

                    // añadir respectivas tarifas al tipo de la habotación
                    ArrayList<TarifaCuarto> listaTarifas = pms.getTarifasCuartos();

                    for (TarifaCuarto tarifa : listaTarifas) {
                        if (tarifa.getTipoCuarto().equalsIgnoreCase(tipoHabitacion.getNombreTipo())) {
                            tipoHabitacion.agregarTarifaCuarto(tarifa);
                        } // if tarifa
                    } // for tarifa
                    pms.agregarTipoHabitacion(tipoHabitacion); // Añade el tipo a la lista

                    linea = br.readLine();

                } // while

                br.close();
            } // try

            catch (FileNotFoundException e) {
                System.out.println("No se encontró el archivo");
                e.printStackTrace();
            } // Catch

            catch (IOException e) {
                System.out.println("Error de lectura");
                e.printStackTrace();
            } // Catch

        } // if
    }// función

    public void cargarCamas(File file) throws IOException, FileNotFoundException {

        if (file.exists()) {

            try {

                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea = br.readLine();
                linea = br.readLine();
                while (linea != null) {

                    String[] partes = linea.split(";"); // Separa los atributos de una cama.
                    String tamanio = partes[0];
                    int cantidad = Integer.parseInt(partes[1]);
                    boolean ninios = Boolean.parseBoolean(partes[2]);

                    Cama nuevaCama = new Cama(tamanio, cantidad);
                    nuevaCama.setNinios(ninios);
                    pms.agregarCama(nuevaCama);

                    linea = br.readLine();
                }
                br.close();

            } // Try

            catch (FileNotFoundException e) {
                System.out.println("No se encontró el archivo");
                e.printStackTrace();
            } // Catch

            catch (IOException e) {
                System.out.println("Error de lectura");
                e.printStackTrace();
            } // Catch

        } // if

    }// función

    public void cargarTarifasCuarto(File file) throws IOException, FileNotFoundException {

        if (file.exists()) {

            try {

                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea = br.readLine();

                linea = br.readLine();
                while (linea != null) {

                    String[] partes = linea.split(";"); // separa los elementos de una tarifa
                    String tipoCuarto = partes[0];
                    String rangoFechas = partes[1];
                    String diasSemana = partes[2];
                    double valor = Double.parseDouble(partes[3]);

                    ArrayList<String> diasSemanaLista = new ArrayList<String>(Arrays.asList(diasSemana.split(","))); // Obtiene
                                                                                                                     // los
                                                                                                                     // días
                                                                                                                     // de
                                                                                                                     // la
                                                                                                                     // semana

                    TarifaCuarto unaTarifa = new TarifaCuarto(tipoCuarto, rangoFechas, diasSemanaLista, valor);

                    pms.agregarTarifaCuarto(unaTarifa);

                    linea = br.readLine();

                } // while

                br.close();

                actualizarTarifasHabitacion();
            } // Try

            catch (FileNotFoundException e) {
                System.out.println("No se encontró el archivo");
                e.printStackTrace();
            } // Catch

            catch (IOException e) {
                System.out.println("Error de lectura");
                e.printStackTrace();
            } // Catch

        } // if
    }// funcion

    public void cargarMenuBebidas(File file) throws IOException, FileNotFoundException {

        if (file.exists()) {

            try {

                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea = br.readLine();

                linea = br.readLine();
                while (linea != null) {
                    String[] partes = linea.split(";");

                    String nombre = partes[0];
                    String rangoHoras = partes[1];
                    String comidaDispon = partes[2];
                    String lugarDispon = partes[3];
                    boolean servicioCuarto = Boolean.parseBoolean(partes[4]);
                    double precio = Double.parseDouble(partes[5]);

                    Bebida bebida = new Bebida(nombre, precio, rangoHoras, comidaDispon, lugarDispon);
                    bebida.setServicioCuarto(servicioCuarto);

                    pms.agregarBebida(bebida);

                    linea = br.readLine();

                } // while

                br.close();
            } // try

            catch (FileNotFoundException e) {
                System.out.println("No se encontró el archivo");
                e.printStackTrace();
            } // Catch

            catch (IOException e) {
                System.out.println("Error de lectura");
                e.printStackTrace();
            } // Catch

        } // if

    }// funcion

    public void cargarMenuPlatos(File file) throws IOException, FileNotFoundException {

        if (file.exists()) {

            try {

                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea = br.readLine();

                linea = br.readLine();
                while (linea != null) {

                    String[] partes = linea.split(";");

                    String nombre = partes[0];
                    String rangoHoras = partes[1];
                    String comidaDispon = partes[2];
                    String lugarDispon = partes[3];
                    boolean servicioCuarto = Boolean.parseBoolean(partes[4]);
                    double precio = Double.parseDouble(partes[5]);

                    Plato plato = new Plato(nombre, precio, rangoHoras, comidaDispon, lugarDispon);
                    plato.setServicioCuarto(servicioCuarto);

                    pms.agregarPlato(plato);
                    linea = br.readLine();
                }

                br.close();
            } // try

            catch (FileNotFoundException e) {
                System.out.println("No se encontró el archivo");
                e.printStackTrace();
            } // Catch

            catch (IOException e) {
                System.out.println("Error de lectura");
                e.printStackTrace();
            } // Catch

        } // if
    }

    public void cargarUsuarios(File file) throws IOException, FileNotFoundException {
        if (file.exists()) {

            try {

                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea = br.readLine();

                linea = br.readLine();
                while (linea != null) {

                    String[] partes = linea.split(";");

                    String login = partes[0];
                    String password = partes[1];

                    pms.agregarUsuario(login, password);
                    linea = br.readLine();

                } // while
                br.close();

            } // try

            catch (FileNotFoundException e) {
                System.out.println("No se encontró el archivo");
                e.printStackTrace();
            } // Catch

            catch (IOException e) {
                System.out.println("Error de lectura");
                e.printStackTrace();
            } // Catch

        } // if

        else {
            System.out.println("No existe el archivo");
        }

    } // funcion

    public void cargarServicios(File file) throws IOException, FileNotFoundException {

        if (file.exists()) {

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea = br.readLine();

                linea = br.readLine();
                while (linea != null) {

                    String[] partes = linea.split(";");

                    String nombreTipo = partes[0];
                    String ubicacion = partes[1];
                    String mapaDispo = partes[2];
                    String tipoCobro = partes[3];
                    boolean servicioCuarto = Boolean.parseBoolean(partes[4]);
                    double precio = Double.parseDouble(partes[5]);

                    HashMap<String, ArrayList<String>> disponibilidad = new HashMap<String, ArrayList<String>>();

                    List<String> myList = Arrays.asList(mapaDispo.split(",")); // Separa cada uno de los sets Dias-horas
                    for (String diaHora : myList) {
                        String[] dH = diaHora.split("_"); // Separa dia y set de horas.

                        String diaDispo = dH[0];
                        String horasDispo = dH[1];

                        String[] horas = horasDispo.split("-");
                        ArrayList<String> setHoras = new ArrayList<String>();

                        for (String hora : horas) {

                            setHoras.add(hora);
                        } // for horas
                        disponibilidad.put(diaDispo, setHoras);

                    } // for diahora

                    Servicio servicio = new Servicio(nombreTipo, ubicacion, disponibilidad, precio, tipoCobro);
                    servicio.setServicioCuarto(servicioCuarto);
                    pms.agregarServicio(servicio);
                    linea = br.readLine();

                } // while

                br.close();

            } // try

            catch (FileNotFoundException e) {
                System.out.println("No se encontró el archivo");
                e.printStackTrace();
            } // Catch

            catch (IOException e) {
                System.out.println("Error de lectura");
                e.printStackTrace();
            } // Catch

        } // if
    }// funcion

    public void cargarInformacionHotel(File FileInformacionHotel) throws FileNotFoundException, IOException {

        if (FileInformacionHotel.exists()) {

            try {
                BufferedReader br = new BufferedReader(new FileReader(FileInformacionHotel));
                String linea = br.readLine();

                linea = br.readLine();
                while (linea != null) {

                    String[] partes = linea.split(";");

                    String pathTarifas = partes[0];
                    String pathTipoHabitaciones = partes[1];
                    String pathHabitaciones = partes[2];
                    String pathServicios = partes[3];
                    String pathCamas = partes[4];
                    String pathMenuBebidas = partes[5];
                    String pathMenuPlatos = partes[6];

                    String[] pathNames = { "Proyecto1DPO", "data", };
                    String path = String.join(File.separator, pathNames);

                    File fileTarifas = new File(path + pathTarifas);
                    File fileTipohabitaciones = new File(path + pathTipoHabitaciones);
                    File fileHabitaciones = new File(path + pathHabitaciones);
                    File fileServicios = new File(path + pathServicios);
                    File fileCamas = new File(path + pathCamas);
                    File fileMenuBebidas = new File(path + pathMenuBebidas);
                    File fileMenuPlatos = new File(path + pathMenuPlatos);

                    cargarTarifasCuarto(fileTarifas);
                    cargarTipoHabitaciones(fileTipohabitaciones);
                    cargarHabitaciones(fileHabitaciones);
                    cargarServicios(fileServicios);
                    cargarCamas(fileCamas);
                    cargarMenuBebidas(fileMenuBebidas);
                    cargarMenuPlatos(fileMenuPlatos);

                    linea = br.readLine();

                } // fin while

                br.close();
            } // fin try
            catch (FileNotFoundException e) {
                System.out.println("No se encontró el archivo");
                e.printStackTrace();
            } // fin catch
            catch (IOException e) {
                System.out.println("Error de lectura");
                e.printStackTrace();
            } // fin cacth

        } // fin if
    }// fin función

    private void actualizarTarifasHabitacion() {

        ArrayList<TarifaCuarto> listaTarifas = pms.getTarifasCuartos();
        Map<String, TipoHabitacion> maptipohabitciones = pms.getTipoHabitaciones();

        for (String tipo : maptipohabitciones.keySet()) {

            for (TarifaCuarto tarifa : listaTarifas) {
                String nombreTarifa = tarifa.getTipoCuarto();
                if (tipo.equalsIgnoreCase(nombreTarifa)) {
                    TipoHabitacion tipoActual = maptipohabitciones.get(tipo);
                    tipoActual.agregarTarifaCuarto(tarifa);
                }
            } // for tarifas

        } // for tipos

    }// método

}
