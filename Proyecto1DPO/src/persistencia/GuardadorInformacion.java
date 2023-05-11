package persistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;

import model.Bebida;
import model.Cama;
import model.Consumo;
import model.Habitacion;
import model.Huesped;
import model.PMS;
import model.Plato;
import model.Reserva;
import model.Servicio;
import model.TarifaCuarto;
import model.TipoHabitacion;



public class GuardadorInformacion {
    private PMS pms;
    public GuardadorInformacion(PMS pms){
        this.pms=pms;
    }
    public void guardarHabitaciones() {
        
        try{
            String[] pathNames = { "Proyecto1DPO", "data", "habitaciones.txt" };
            String pathHab = String.join(File.separator, pathNames);
            File file = new File(pathHab);
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Habitacion> habitaciones= pms.getInventarioHabitaciones();

                for (Map.Entry<String,Habitacion> entry: habitaciones.entrySet()){
                    Habitacion habitacion=(entry.getValue());
                    
                    buff.write(habitacion.getIdentificador());
                    buff.write(";");
                    buff.write(habitacion.getUbicacion());
                    buff.write(";");
                    Boolean vista= habitacion.hasVista();
                    buff.write(Boolean.toString(vista));
                    buff.write(";");
                    Boolean cocina= habitacion.hasCocina();
                    buff.write(Boolean.toString(cocina));
                    buff.write(";");
                    Boolean balcon= habitacion.hasBalcon();
                    buff.write(Boolean.toString(balcon));
                    buff.write(";");
                    buff.write(habitacion.getDescripcion());
                    buff.write(";");

                    ArrayList<Cama> camas= habitacion.getCamas();
                    
                    for (Cama cama:camas){
                        buff.write(cama.getTamanio());
                        buff.write("-");
                        buff.write(String.valueOf(cama.getCantidadPersonas()));
                        buff.write("-");
                        buff.write(Boolean.toString(cama.isNinios()));
                    }

                    buff.write(habitacion.getTipoHabitacion().getNombreTipo());

                    buff.newLine();
                }
                buff.close();

            }else{
                try {
                    FileWriter writer = new FileWriter(file,false);
                    BufferedWriter buff= new BufferedWriter(writer);

                    Map<String,Habitacion> habitaciones= pms.getInventarioHabitaciones();

                    for (Map.Entry<String,Habitacion> entry: habitaciones.entrySet()){
                        Habitacion habitacion=(entry.getValue());
                        
                        buff.write(habitacion.getIdentificador());
                        buff.write(habitacion.getUbicacion());
                        Boolean vista= habitacion.hasVista();
                        buff.write(Boolean.toString(vista));
                        Boolean cocina= habitacion.hasCocina();
                        buff.write(Boolean.toString(cocina));
                        Boolean balcon= habitacion.hasBalcon();
                        buff.write(Boolean.toString(balcon));
                        buff.write(habitacion.getDescripcion());
    
                        ArrayList<Cama> camas= habitacion.getCamas();
                        
                        for (Cama cama:camas){
                            buff.write(cama.getTamanio());
                            buff.write("-");
                            buff.write(String.valueOf(cama.getCantidadPersonas()));
                            buff.write("-");
                            buff.write(Boolean.toString(cama.isNinios()));
                        }

                        buff.write(habitacion.getTipoHabitacion().getNombreTipo());
    
                        buff.newLine();
                    }
                    buff.close();

                } catch (Exception e) {
                    System.out.println("No se pudo guardar el archivo de habitaciones. ");
                }
            }
        }catch (Exception e){
            System.out.println("No se pudo guardar el archivo de habitaciones. ");
        }
    }

    public void guardarTipoHabitacones() {
        try{
            String[] pathNames = { "Proyecto1DPO", "data", "tipohabitaciones.txt" };
            String pathTipo= String.join(File.separator, pathNames);
            File file = new File(pathTipo);
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,TipoHabitacion> tipos= pms.getTipoHabitaciones();

                for (Map.Entry<String,TipoHabitacion> entry: tipos.entrySet()){
                    TipoHabitacion tipo=(entry.getValue());
                    buff.write(tipo.toString());
                    buff.newLine();
                }
                buff.close();

            }else{
                try {
                    FileWriter writer = new FileWriter(file,false);
                    BufferedWriter buff= new BufferedWriter(writer);
                
                    Map<String,TipoHabitacion> tipos= pms.getTipoHabitaciones();

                    for (Map.Entry<String,TipoHabitacion> entry: tipos.entrySet()){
                        TipoHabitacion tipo=(entry.getValue());
                        buff.write(tipo.toString());
                        buff.newLine();
                    }
                    buff.close();

                } catch (Exception e) {
                    System.out.println("No se pudo guardar el archivo de Tipohabitaciones. ");
                }
            }
        } catch (Exception e){
            System.out.println("No se pudo guardar el archivo de Tipohabitaciones.");
        }
    }

    public void guardarTarifasCuarto() {
        try{
            String[] pathNames = { "Proyecto1DPO", "data", "tarifas.txt" };
            String pathTarifas = String.join(File.separator, pathNames);
            File file = new File(pathTarifas);
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                ArrayList<TarifaCuarto> tarifas= pms.getTarifasCuartos();

                for (TarifaCuarto tarifa: tarifas){

                    buff.write(tarifa.getTipoCuarto());
                    buff.write(";");
                    buff.write(tarifa.getRangoFechas());
                    buff.write(";");

                    ArrayList<String> dias= tarifa.getDiasSemana();
                    for (String dia:dias){
                        buff.write(dia);
                        buff.write(",");
                    }
                    buff.write(";");

                    buff.write(String.valueOf(tarifa.getValor()));
                    buff.newLine();
                }

                buff.close();

            }else{
                try {
                    FileWriter writer = new FileWriter(file,false);
                    BufferedWriter buff= new BufferedWriter(writer);
                
                    ArrayList<TarifaCuarto> tarifas= pms.getTarifasCuartos();

                    for (TarifaCuarto tarifa: tarifas){

                        buff.write(tarifa.getTipoCuarto());
                        buff.write(";");
                        buff.write(tarifa.getRangoFechas());
                        buff.write(";");
    
                        ArrayList<String> dias= tarifa.getDiasSemana();
                        for (String dia:dias){
                            buff.write(dia);
                            buff.write(",");
                        }
                        buff.write(";");
    
                        buff.write(String.valueOf(tarifa.getValor()));
                        buff.newLine();
                    }

                    buff.close();
                } catch (Exception e) {
                    System.out.println("No se pudo guardar el archivo de TarifasCuarto. ");
                }
            }
        } catch (Exception e){
            System.out.println("No se pudo guardar el archivo de TarifasCuarto.");
        }
    }

    public void guardarReservas() {
        try{
            String[] pathNames = { "Proyecto1DPO", "data", "reservas.txt" };
            String pathReservas = String.join(File.separator, pathNames);
            File file = new File(pathReservas);
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Reserva> reservas= pms.getReservas();

                for (Map.Entry<String,Reserva> entry: reservas.entrySet()){
                    Reserva reserva=(entry.getValue());
                    buff.write(reserva.toString());
                    buff.newLine();
                }
                buff.close();

            }else{
                try {
                    FileWriter writer = new FileWriter(file);
                    BufferedWriter buff= new BufferedWriter(writer);
                
                    Map<String,Reserva> reservas= pms.getReservas();

                    for (Map.Entry<String,Reserva> entry: reservas.entrySet()){
                        Reserva reserva=(entry.getValue());
                        buff.write(reserva.toString());
                        buff.newLine();
                    }
                    buff.close();

                } catch (Exception e) {
                    System.out.println("No se pudo guardar el archivo de Reservas. ");
                }
            }
        } catch (Exception e){
            System.out.println("No se pudo guardar el archivo de Reservas.");
        }
    }

    public void guardarMenuBebidas() {
        try{
            String[] pathNames = { "Proyecto1DPO", "data", "menubebidas.txt" };
            String pathBebidas = String.join(File.separator, pathNames);
            File file = new File(pathBebidas);
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Bebida> menu= pms.getMenuBebidas();

                for (Map.Entry<String,Bebida> entry: menu.entrySet()){
                    Bebida bebida=(entry.getValue());

                    buff.write(bebida.getNombre());
                    buff.write(";");
                    buff.write(bebida.getRangoHoras());
                    buff.write(";");
                    buff.write(bebida.getComidaDispon());
                    buff.write(";");
                    buff.write(bebida.getLugarDispon());
                    buff.write(";");
                    buff.write(Boolean.toString(bebida.hasServicioCuarto()));
                    buff.write(";");
                    buff.write(String.valueOf(bebida.getTarifa()));

                    buff.newLine();
                }

                buff.close();

            }else{
                try {
                    FileWriter writer = new FileWriter(file);
                    BufferedWriter buff= new BufferedWriter(writer);
                
                    Map<String,Bebida> menu= pms.getMenuBebidas();
                    
                    for (Map.Entry<String,Bebida> entry: menu.entrySet()){
                        Bebida bebida=(entry.getValue());
                        
                        buff.write(bebida.getNombre());
                        buff.write(";");
                        buff.write(bebida.getRangoHoras());
                        buff.write(";");
                        buff.write(bebida.getComidaDispon());
                        buff.write(";");
                        buff.write(bebida.getLugarDispon());
                        buff.write(";");
                        buff.write(Boolean.toString(bebida.hasServicioCuarto()));
                        buff.write(";");
                        buff.write(String.valueOf(bebida.getTarifa()));

                        buff.newLine();
                }

                buff.close();

                } catch (Exception e) {
                    System.out.println("No se pudo guardar el archivo de MenuBebidas. ");
                }
            }
        } catch (Exception e){
            System.out.println("No se pudo guardar el archivo de MenuBebidas.");
        }
    }

    public void guardarMenuPlatos() {
        try{
            String[] pathNames = { "Proyecto1DPO", "data", "menuplatos.txt" };
            String pathPlatos = String.join(File.separator, pathNames);
            File file = new File(pathPlatos);
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Plato> menu= pms.getMenuPlatos();

                for (Map.Entry<String,Plato> entry: menu.entrySet()){
                    Plato plato=(entry.getValue());
                    
                    buff.write(plato.getNombre());
                    buff.write(";");
                    buff.write(plato.getRangoHoras());
                    buff.write(";");
                    buff.write(plato.getComidaDispon());
                    buff.write(";");
                    buff.write(plato.getLugarDispon());
                    buff.write(";");
                    buff.write(Boolean.toString(plato.hasServicioCuarto()));
                    buff.write(";");
                    buff.write(String.valueOf(plato.getTarifa()));

                    buff.newLine();
                }
                buff.close();

            }else{
                try {
                    FileWriter writer = new FileWriter(file);
                    BufferedWriter buff= new BufferedWriter(writer);
                
                    Map<String,Plato> menu= pms.getMenuPlatos();

                    for (Map.Entry<String,Plato> entry: menu.entrySet()){
                        Plato plato=(entry.getValue());
                        buff.write(plato.getNombre());
                        buff.write(";");
                        buff.write(plato.getRangoHoras());
                        buff.write(";");
                        buff.write(plato.getComidaDispon());
                        buff.write(";");
                        buff.write(plato.getLugarDispon());
                        buff.write(";");
                        buff.write(Boolean.toString(plato.hasServicioCuarto()));
                        buff.write(";");
                        buff.write(String.valueOf(plato.getTarifa()));

                        buff.newLine();
                }
                buff.close();


                } catch (Exception e) {
                    System.out.println("No se pudo guardar el archivo de MenuPlatos. ");
                }
            }
        } catch (Exception e){
            System.out.println("No se pudo guardar el archivo de MenuPlatos.");
        }
    }

    public void guardarHuespedes() {
        try{
            String[] pathNames = { "Proyecto1DPO", "data", "huespedes.txt" };
            String pathHuespedes = String.join(File.separator, pathNames);
            File file = new File(pathHuespedes);
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Huesped> huespedes= pms.getHuespedes();

                for (Map.Entry<String,Huesped> entry: huespedes.entrySet()){
                    Huesped huesped=(entry.getValue());
                    buff.write(huesped.toString());
                    buff.newLine();
                }
                buff.close();

            }else{
                try {
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Huesped> huespedes= pms.getHuespedes();

                for (Map.Entry<String,Huesped> entry: huespedes.entrySet()){
                    Huesped huesped=(entry.getValue());
                    buff.write(huesped.toString());
                    buff.newLine();
                }
                buff.close();

                } catch (Exception e) {
                    System.out.println("No se pudo guardar el archivo de Huespedes. ");
                }
            }
        } catch (Exception e){
            System.out.println("No se pudo guardar el archivo de Huespedes.");
        }
    }

    public void guardarUsusariosHotel() {
        try{
            String[] pathNames = { "Proyecto1DPO", "data", "usuarios.txt" };
            String pathUsuarios = String.join(File.separator, pathNames);
            File file = new File(pathUsuarios);
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,ArrayList<String>> usuarios= pms.getUsuarios();

                for (Map.Entry<String,ArrayList<String>> entry: usuarios.entrySet()){
                    buff.write(entry.getKey());
                    buff.write(";");
                    
                    ArrayList<String> info = entry.getValue();
                    buff.write(info.get(0));
                    buff.newLine();
                    
                }
                buff.close();

            }else{
                try {
                    FileWriter writer = new FileWriter(file);
                    BufferedWriter buff= new BufferedWriter(writer);
                
                    Map<String,ArrayList<String>> usuarios= pms.getUsuarios();

                    for (Map.Entry<String,ArrayList<String>> entry: usuarios.entrySet()){
                        buff.write(entry.getKey());
                        buff.write(";");
                        
                        ArrayList<String> info = entry.getValue();
                        buff.write(info.get(0));
                        buff.newLine();
                        
                    }
                    buff.close();
                

                } catch (Exception e) {
                    System.out.println("No se pudo guardar el archivo de Usuarios. ");
                }
            }
        } catch (Exception e){
            System.out.println("No se pudo guardar el archivo de Usuarios.");
        }
    }

    public void guardarServicios() {
        try{
            String[] pathNames = { "Proyecto1DPO", "data", "servicios.txt" };
            String pathServicios = String.join(File.separator, pathNames);
            File file = new File(pathServicios);
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Servicio> servicios = pms.getServicios();

                for (Map.Entry<String,Servicio> entry: servicios.entrySet()){
                    Servicio servicio=(entry.getValue());
                    buff.write(servicio.getNombreTipo());
                    buff.write(";");
                    buff.write(servicio.getUbicacion());
                    buff.write(";");
                    
                    Map<String, ArrayList<String>> mapaDispo= servicio.getDisponibilidad();
                    for (Map.Entry<String,ArrayList<String>> entry2: mapaDispo.entrySet()){
                        String dia= entry2.getKey();
                        buff.write(dia);
                        buff.write("_");

                        ArrayList<String>horarios=entry2.getValue();
                        for(String hora:horarios){
                            buff.write(hora);
                            buff.write("-");
                        }
                        buff.write(",");
                    }
                    buff.write(";");

                    buff.write(servicio.getTipoCobro());
                    buff.write(";");
                    buff.write(String.valueOf(servicio.getTarifa()));

                    buff.newLine();
                }
                buff.close();

            }else{
                try {
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Servicio> servicios = pms.getServicios();

                for (Map.Entry<String,Servicio> entry: servicios.entrySet()){
                    Servicio servicio=(entry.getValue());
                    buff.write(servicio.getNombreTipo());
                    buff.write(";");
                    buff.write(servicio.getUbicacion());
                    buff.write(";");
                    
                    Map<String, ArrayList<String>> mapaDispo= servicio.getDisponibilidad();
                    for (Map.Entry<String,ArrayList<String>> entry2: mapaDispo.entrySet()){
                        String dia= entry2.getKey();
                        buff.write(dia);
                        buff.write("_");

                        ArrayList<String>horarios=entry2.getValue();
                        for(String hora:horarios){
                            buff.write(hora);
                            buff.write("-");
                        }
                        buff.write(",");
                    }
                    buff.write(";");

                    buff.write(servicio.getTipoCobro());
                    buff.write(";");
                    buff.write(String.valueOf(servicio.getTarifa()));

                    buff.newLine();
                }
                buff.close();

                } catch (Exception e) {
                    System.out.println("No se pudo guardar el archivo de Servicios. ");
                }
            }
        } catch (Exception e){
            System.out.println("No se pudo guardar el archivo de Servicios.");
        }
    }

    public void guardarConsumos() {
        try{
            String[] pathNames = { "Proyecto1DPO", "data", "consumos.txt" };
            String pathConsumos = String.join(File.separator, pathNames);
            File file = new File(pathConsumos);
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Consumo> consumos = pms.getConsumos();

                for (Map.Entry<String,Consumo> entry: consumos.entrySet()){
                    Consumo consumo=(entry.getValue());
                    buff.write(consumo.toString());
                    buff.newLine();
                }
                buff.close();

            }else{
                try {
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Consumo> consumos = pms.getConsumos();

                for (Map.Entry<String,Consumo> entry: consumos.entrySet()){
                    Consumo consumo=(entry.getValue());
                    buff.write(consumo.toString());
                    buff.newLine();
                }
                buff.close();

                } catch (Exception e) {
                    System.out.println("No se pudo guardar el archivo de Consumos. ");
                }
            }
        } catch (Exception e){
            System.out.println("No se pudo guardar el archivo de Consumos.");
        }
    }

    public void guardarCamas() {
        try{
            String[] pathNames = { "Proyecto1DPO", "data", "camas.txt" };
            String pathCamas = String.join(File.separator, pathNames);
            File file = new File(pathCamas);
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                ArrayList<Cama> camas= pms.getCamas();

                for (Cama cama: camas){
                    buff.write(cama.getTamanio());
                    buff.write(";");
                    buff.write(String.valueOf(cama.getCantidadPersonas()));
                    buff.write(";");
                    buff.write(Boolean.toString(cama.isNinios()));

                    buff.newLine();
                }
                buff.close();

            }else{
                try {
                    FileWriter writer = new FileWriter(file);
                    BufferedWriter buff= new BufferedWriter(writer);
                
                    ArrayList<Cama> camas= pms.getCamas();

                    for (Cama cama: camas){
                        buff.write(cama.getTamanio());
                        buff.write(";");
                        buff.write(String.valueOf(cama.getCantidadPersonas()));
                        buff.write(";");
                        buff.write(Boolean.toString(cama.isNinios()));
                    
                        buff.newLine();
                }
                buff.close();

                } catch (Exception e) {
                    System.out.println("No se pudo guardar el archivo de Camas. ");
                }
            }
        } catch (Exception e){
            System.out.println("No se pudo guardar el archivo de Camas.");
        }
    }

}
