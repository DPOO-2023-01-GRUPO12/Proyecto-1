package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashMap;

import model.InformacionHotel;

public class Cargador { 

    private InformacionHotel informacionHotel;

    public Cargador(InformacionHotel informacion){
        informacionHotel = informacion;
    }



    public void cargarHabitaciones(File file) throws IOException, FileNotFoundException {

        
        if (file.exists()){

            try
                {

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
                    String tipoHabitacionString = partes[7];
                    
                    ArrayList<Cama> camas = new ArrayList<>();
                    List<TarifaCuarto> tarifasIncluidas = new ArrayList<>();

                    //Creador de camas (Si se selecciona que las camas van incluidas en el archivo)

                    List<String> myList = Arrays.asList(scamas.split(",")); //Separa cada una de las camas
                    for (String scama:myList){

                        String[] partesCama = scama.split("-"); //separa los atributos de una sola cama
                        String tamanio = partesCama[0];
                        int cantidad = Integer.parseInt(partesCama[1]);
                        boolean ninios = Boolean.parseBoolean(partesCama[2]);
                        
                        Cama nuevaCama = new Cama(tamanio, cantidad);
                        nuevaCama.setNinios(ninios);
                        camas.add(nuevaCama);               
                        } //for cama

                    //Creador de tipo de habitación
                
                
                    TipoHabitacion tipoHabitacion = new TipoHabitacion(tipoHabitacionString);
                    ArrayList<TarifaCuarto> listaTarifas = informacionHotel.getTarifasCuartos();

                    for (TarifaCuarto tarifa:listaTarifas){
                        if (tarifa.getTipoCuarto().equals(tipoHabitacion.getNombreTipo())){
                            tipoHabitacion.agregarTarifaCuarto(tarifa);
                        } //if
                        }//for tarifa
                    
                    
                    //Creador de la habitación

                    Habitacion elemHabitacion = new Habitacion(identificador, ubicacion, descripcion);
                    elemHabitacion.setTipoHabitacion(tipoHabitacion);
                    elemHabitacion.setCamas(camas);
                    elemHabitacion.setBalcon(balcon);
                    elemHabitacion.setVista(vista);
                    elemHabitacion.setCocina(cocina);
                    elemHabitacion.calcularCapacidad();

                    agregarHabitacion(elemHabitacion); //Actualiza la información (El metodo put actualiza o añade según sea el caso); 

                    linea = br.readLine(); 

                } //While

                br.close();

                }//try
                
            catch (FileNotFoundException e)
                {
                    System.out.println("No se encontró el archivo");
                    e.printStackTrace();
                }//Catch

            catch (IOException e)
                {
                    System.out.println("Error de lectura");
                    e.printStackTrace();
                } //Catch

        }//if
        
    } //función



    public void agregarHabitacion(Habitacion habitacion) {
        informacionHotel.getInventarioHabitaciones().put(habitacion.getIdentificador(), habitacion);
    }
    public void agregarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        informacionHotel.getTipoHabitaciones().put(tipoHabitacion.getNombreTipo(), tipoHabitacion);
    }


    public void cargarTipoHabitaciones(File file) throws IOException, FileNotFoundException {

        if (file.exists()){

            try
                {

                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea = br.readLine();
                linea = br.readLine();
                while (linea != null)
                
                {

                    String[] partes = linea.split(";");
                    String nombre = partes[0];

                    TipoHabitacion tipoHabitacion = new TipoHabitacion(nombre);

                    //añadir respectivas tarifas al tipo de la habotación
                    ArrayList<TarifaCuarto> listaTarifas = informacionHotel.getTarifasCuartos();

                    for (TarifaCuarto tarifa:listaTarifas){
                        if (tarifa.getTipoCuarto().equalsIgnoreCase(tipoHabitacion.getNombreTipo())){
                            tipoHabitacion.agregarTarifaCuarto(tarifa);
                        }   // if tarifa
                    }//for tarifa
                    agregarTipoHabitacion(tipoHabitacion); //Añade el tipo a la lista

                    linea = br.readLine(); 

                }//while

                br.close();}//try

            catch (FileNotFoundException e)
                {
                    System.out.println("No se encontró el archivo");
                    e.printStackTrace();
                }//Catch

            catch (IOException e)
                {
                    System.out.println("Error de lectura");
                    e.printStackTrace();
                } //Catch

        
        }//if 
    }//función

    
    public void agregarCama(Cama Cama) {

        informacionHotel.getCamas().add(Cama);
    }


    public void cargarCamas(File file) throws IOException, FileNotFoundException {

        if (file.exists()){

            try
                {

                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea = br.readLine();
                linea = br.readLine();
                while (linea != null){

                    String[] partes = linea.split(";"); //Separa los atributos de una cama.
                    String tamanio = partes[0];
                    int cantidad = Integer.parseInt(partes[1]);
                    boolean ninios = Boolean.parseBoolean(partes[2]);
                        
                    Cama nuevaCama = new Cama(tamanio, cantidad);
                    nuevaCama.setNinios(ninios);
                    agregarCama(nuevaCama);

                    linea = br.readLine(); 
                }
                br.close();

                } //Try

            catch (FileNotFoundException e)
                {
                    System.out.println("No se encontró el archivo");
                    e.printStackTrace();
                }//Catch

            catch (IOException e)
                {
                    System.out.println("Error de lectura");
                    e.printStackTrace();
                } //Catch

        }//if
                
    }//función

  


    public void cargarTarifasCuarto(File file) throws IOException, FileNotFoundException {

        if (file.exists()){

            try
                {

                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea = br.readLine();

                linea = br.readLine();
                while (linea != null){
                    

                        String[] partes = linea.split(";"); //separa los elementos de una tarifa
                        String tipoCuarto = partes[0];
                        String rangoFechas = partes[1];
                        String diasSemana = partes[2];
                        double valor = Double.parseDouble(partes[3]);


                        ArrayList<String> diasSemanaLista = new  ArrayList<String>(Arrays.asList(diasSemana.split(","))); //Obtiene los días de la semana 

                        TarifaCuarto unaTarifa = new TarifaCuarto(tipoCuarto, rangoFechas, diasSemanaLista, valor);

                        agregarTarifaCuarto(unaTarifa);

                        actualizarTarifasHabitacion();

                        linea = br.readLine(); 
                        
                } //while
                
                br.close();
                } //Try

            catch (FileNotFoundException e)
                {
                    System.out.println("No se encontró el archivo");
                    e.printStackTrace();
                }//Catch

            catch (IOException e)
                {
                    System.out.println("Error de lectura");
                    e.printStackTrace();
                } //Catch


        }//if 
    }//funcion


    private void actualizarTarifasHabitacion(){

        ArrayList<TarifaCuarto> listaTarifas = informacionHotel.getTarifasCuartos();
        private Map<String,TipoHabitacion> maptipohabitciones  = informacionHotel.getTipoHabitaciones();

        for (String tipo:maptipohabitciones.KeySet()){

            for (TarifaCuarto tarifa:listaTarifas){
                String nombreTarifa = tarifa.getTipoCuarto();
                if (tipo.equalsIgnoreCase(nombreTarifa))
                {
                   TipoHabitacion tipoActual = maptipohabitciones.get(tipo); 
                   tipoActual.agregarTarifaCuarto(tarifa);
                }
            }//for tarifas


        }//for tipos
        

    }//método

    private void agregarTarifaCuarto(TarifaCuarto tarifa) {

        informacionHotel.getTarifasCuartos().add(tarifa);
    }

    
    public void cambiarTarifaServicio(String nombreServicio,double valor) {

        if (informacionHotel.getServicios().containsKey(nombreServicio))
        {
            Servicio servicioEdit = informacionHotel.getServicios().get(nombreServicio);
            servicioEdit.setTarifa(valor);
        }


    }

    public void cargarMenuBebidas(File file) throws IOException, FileNotFoundException {

        if (file.exists()){

            try
            {

                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea = br.readLine();

                linea = br.readLine();
                while (linea != null){
                    String[] partes = linea.split(";");

                    String nombre = partes[0];
                    String rangoHoras = partes[1];
                    String comidaDispon = partes[2];
                    String lugarDispon = partes[3];
                    boolean servicioCuarto = Boolean.parseBoolean(partes[4]);
                    double precio = Double.parseDouble(partes[5]);

                    Bebida bebida = new Bebida(nombre, precio, rangoHoras, comidaDispon, lugarDispon);
                    bebida.setServicioCuarto(servicioCuarto);

                    agregarBebida(bebida);

                    linea = br.readLine(); 


                }//while

                br.close();
            } //try

        catch (FileNotFoundException e)
                {
                    System.out.println("No se encontró el archivo");
                    e.printStackTrace();
                }//Catch

            catch (IOException e)
                {
                    System.out.println("Error de lectura");
                    e.printStackTrace();
                } //Catch
        
    }//if

    }//funcion

    public void agregarBebida(Bebida bebida) { 
        informacionHotel.getMenuBebidas().put(bebida.getNombre(), bebida);  
    }
    

    public void cargarMenuPlatos(File file) throws IOException, FileNotFoundException {

        if (file.exists()){

            try
            {   

            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea = br.readLine();

            linea = br.readLine();
            while (linea != null){

                String[] partes = linea.split(";");

                String nombre = partes[0];
                String rangoHoras = partes[1];
                String comidaDispon = partes[2];
                String lugarDispon = partes[3];
                boolean servicioCuarto = Boolean.parseBoolean(partes[4]);
                double precio = Double.parseDouble(partes[5]);

                Plato plato = new Plato(nombre, precio, rangoHoras, comidaDispon, lugarDispon);
                plato.setServicioCuarto(servicioCuarto);

                   agregarPlato(plato);
                linea = br.readLine(); 
            }

            br.close();
            } //try

            catch (FileNotFoundException e)
                {
                    System.out.println("No se encontró el archivo");
                    e.printStackTrace();
                }//Catch

            catch (IOException e)
                {
                    System.out.println("Error de lectura");
                    e.printStackTrace();
                } //Catch
        

        }//if
    }

    public void agregarPlato(Plato plato) {  

        informacionHotel.getMenuPlatos().put(plato.getNombre(), plato);
    }




    public void cargarUsuarios(String pathUsuarios) throws IOException, FileNotFoundException  {
        File file = new File(pathUsuarios);
        if(file.exists()){

            try
            {  
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea = br.readLine();

            linea = br.readLine();
            while (linea != null){

                String[] partes = linea.split(";");

                String login = partes[0];
                String password = partes[1];

                agregarUsuario(login, password);
                linea = br.readLine(); 


            } //while
            br.close();


            }//try

            catch (FileNotFoundException e)
                {
                    System.out.println("No se encontró el archivo");
                    e.printStackTrace();
                }//Catch

            catch (IOException e)
                {
                    System.out.println("Error de lectura");
                    e.printStackTrace();
                } //Catch


        } //if
        
        else {
            System.out.println("No existe el archivo");
             }
    
    } //funcion

    private void agregarUsuario (String login,String password){


        ArrayList usuario = new ArrayList<String>();
        usuario.add(password);

        if(login.contains("admin")){
            usuario.add("administrador");}

        else if (login.contains("empleado")){
            usuario.add("empleado");}
        
        else if (login.contains("recepcionista")){
            usuario.add("recepcionista");}

        

        informacionHotel.getUsuarios().put(login, usuario);
    }


    public void cargarServicios(File file) throws IOException, FileNotFoundException  {

         if (file.exists()){

            try
            {   
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea = br.readLine();

            linea = br.readLine();
            while (linea != null){

                String[] partes = linea.split(";");

                String nombreTipo = partes[0];
                String ubicacion = partes[1];
                String mapaDispo = partes[2];
                String tipoCobro = partes[3];
                boolean servicioCuarto = Boolean.parseBoolean(partes[4]);
                double precio = Double.parseDouble(partes[5]);

                HashMap<String,ArrayList<String>> disponibilidad = new HashMap<String,ArrayList<String>>();

                List<String> myList = Arrays.asList(mapaDispo.split(",")); //Separa cada uno de los sets Dias-horas
                for (String diaHora:myList){
                    String[] dH = diaHora.split("_"); //Separa dia y set de horas.

                    String diaDispo = dH[0];
                    String horasDispo = dH[1];

                    String[] horas = horasDispo.split("-");
                    ArrayList setHoras = new ArrayList<String>();

                    for (String hora:horas){
                            
                        setHoras.add(hora);   
                    } //for horas
                    disponibilidad.put(diaDispo, setHoras);


                    }//for diahora

                
                Servicio servicio = new Servicio(nombreTipo, ubicacion, disponibilidad, precio, tipoCobro);
                servicio.setServicioCuarto(servicioCuarto);
                agregarServicio(servicio);
                linea = br.readLine(); 


                } //while

            br.close();

            }//try

            catch (FileNotFoundException e)
                {
                    System.out.println("No se encontró el archivo");
                    e.printStackTrace();
                }//Catch

            catch (IOException e)
                {
                    System.out.println("Error de lectura");
                    e.printStackTrace();
                } //Catch

         }//if
    }//funcion

    public void agregarServicio(Servicio servicio) {

        informacionHotel.getServicios().put(servicio.getNombreTipo(), servicio);
    }


    public void agregarReserva(Reserva reserva) {
        informacionHotel.getReservas().put(reserva.getHuespedEncargado().getDocumento(), reserva);
    }


    public void agregarHuesped(Huesped Huesped) {
        informacionHotel.getHuespedes().put(Huesped.getDocumento(), Huesped);
    }

    public void agregarGrupo(Grupo grupo){
        informacionHotel.getGrupos().put(grupo.getHuespedEncargado().getDocumento(), grupo);
        
    }

    public void agregarConsumo(Consumo consumo){
        informacionHotel.getConsumos().put(consumo.getHuesped().getDocumento(), consumo);
    }
}
