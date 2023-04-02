package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.util.Arrays;

public class Cargador { 
    //TODO: configurar la carga de archivos y en los metodos de agregar y actulizar usar la informacion del hotel para actualizar contenido.
    public void cargarHabitaciones(File file) throws IOException {

        List<Cama> camas = new ArrayList<>();

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
            String descripción = partes[5];

            //Lectura del segundo bloque 

            String scamas = partes[6];
            String tipoHabitacion = partes[7];

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
            String[] partesTipo = tipoHabitacion.split(","); //Separa atributos de tipo.
            String nombre = partesTipo[0];
            String tarifas = partesTipo[1];
            String tarifaActual = partesTipo[2];

            //TODO contruir tarifas a partir del tipo.



            }

             

            
             
             
        

        }
    public void cargarHabitacion(Habitacion habitacion) {}
    

    private void agregarHabitacion(Habitacion habitacion) {

    }

    private void actualizarHabitacion(Habitacion habitacion ) {
    }

    public void cargarTipoHabitaciones(File file) {
    }

    public void agregarTipoHabitacion(TipoHabitacion tipoHabitacion) {
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
}
