package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.util.Arrays;
import model.InformacionHotel;

public class Cargador { 

    private InformacionHotel informacionHotel;
    public void cargarHabitaciones(File file) throws IOException {

        

        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea = br.readLine(); //Ignora la primera línea, los títulos de las columnas.

        linea = br.readLine();
        while (linea != null){


            //Lectura del primer bloque

            String[] partes = linea.split(";");
            String identificador = partes[0];

            
            String ubicacion = partes[1];
            boolean balcon = Boolean.parseBoolean(partes[2]);
            boolean vista = Boolean.parseBoolean(partes[3]);
            boolean cocina = Boolean.parseBoolean(partes[4]);
            String descripcion = partes[5];

            //Lectura del segundo bloque 

            String scamas = partes[6];
            String tipoHabitacionS = partes[7];
            
            ArrayList<Cama> camas = new ArrayList<>();
            List<TarifaCuarto> tarifasIncluidas = new ArrayList<>();

            //Creador de camas

            List<String> myList = Arrays.asList(scamas.split(",")); //Separa cada una de las camas
            for (String scama:myList){

                String[] partesCama = scama.split("-"); //separa los atributos de una sola cama
                String tamanio = partesCama[0];
                int cantidad = Integer.parseInt(partesCama[1]);
                boolean ninios = Boolean.parseBoolean(partesCama[2]);
                
                Cama nuevaCama = new Cama(tamanio, cantidad);
                nuevaCama.setNinios(ninios);
                camas.add(nuevaCama);               
                }

            //Creador de tipo de habitación
            String[] partesTipo = tipoHabitacionS.split(","); //Separa atributos de tipo.
            String nombre = partesTipo[0];
            String tarifas = partesTipo[1];
            
           
            TipoHabitacion tipoHabitacion = new TipoHabitacion(nombre);
            tipoHabitacion.setTarifaActual();
            
            //Creador de la habitación

            Habitacion elemHabitacion = new Habitacion(identificador, ubicacion, descripcion);
            elemHabitacion.setTipoHabitacion(tipoHabitacion);
            elemHabitacion.setCamas(camas);
            elemHabitacion.setBalcon(balcon);
            elemHabitacion.setVista(vista);
            elemHabitacion.setCocina(cocina);
            elemHabitacion.calcularCapacidad();


            linea = br.readLine(); 

            //Actualiza la información (El metodo put actualiza o añade según sea el caso)

            informacionHotel.getInventarioHabitaciones().put(elemHabitacion.getIdentificador(), elemHabitacion);
            
        } //While

        br.close();

        }


    public void agregarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        informacionHotel.getTipoHabitaciones().put(tipoHabitacion.getNombreTipo(), tipoHabitacion);
        }


    public void cargarTipoHabitaciones(File file) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea = br.readLine();


    }

    

    public void cargarCamas(File file) {
    }

    public void agregarCama(Cama Cama) {
    }


    public void cargarTarifasCuarto(File file) {
    }

    public void cambiarTarifaServicio(String nombreServicio,double valor) {
    }


    private void agregarTarifaCuarto(TarifaCuarto tarifa) {
    }

    private void actualizarTarifaCuarto(TarifaCuarto tarifa) {
    }


    public void cargarMenuBebidas(File file) {
    }

    private void agregarBebida(Bebida bebida) {   
    }
    
    private void actualizarBebida(Bebida bebida) {
    }


    public void cargarMenuPlatos(File file) {
    }

    private void agregarPlato(Plato plato) {   
    }

    private void actualizarPlato(Plato plato) {
    }


    public void cargarUsuarios(File file) {
    }

    private void agregarUsuario (String login,String password){
    }


    public void cargarServicios(File file) {
    }

    private void agregarServicio(Servicio servicio) {
    }


    public void agregarReserva(Reserva reserva) {
    }

    public void agregarHuesped(Huesped Huesped) {
    }

    public void agregarGrupo(Grupo grupo){
        
    }
}
