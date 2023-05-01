package persistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;

import model.Hotel;
import model.Bebida;
import model.Cama;
import model.Consumo;
import model.Habitacion;
import model.Huesped;
import model.Plato;
import model.Reserva;
import model.Servicio;
import model.TarifaCuarto;
import model.TipoHabitacion;



public class GuardadorInformacion {
    private Hotel informacion;
    public GuardadorInformacion(model.Hotel informacion2){
        this.informacion=informacion2;
    }
    public void guardarHabitaciones() {
        
        try{
            File file = new File("data/habitaciones.txt");
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Habitacion> habitaciones= informacion.getInventarioHabitaciones();

                for (Map.Entry<String,Habitacion> entry: habitaciones.entrySet()){
                    Habitacion habitacion=(entry.getValue());
                    buff.write(habitacion.toString());
                    buff.newLine();
                }
                buff.close();

            }else{
                try {
                    FileWriter writer = new FileWriter(file,false);
                    BufferedWriter buff= new BufferedWriter(writer);

                    Map<String,Habitacion> habitaciones= informacion.getInventarioHabitaciones();

                    for (Map.Entry<String,Habitacion> entry: habitaciones.entrySet()){
                        Habitacion habitacion=(entry.getValue());
                        buff.write(habitacion.toString());
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
            File file = new File("data/Tipohabitaciones.txt");
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,TipoHabitacion> tipos= informacion.getTipoHabitaciones();

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
                
                    Map<String,TipoHabitacion> tipos= informacion.getTipoHabitaciones();

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
            File file = new File("data/TarifasCuarto.txt");
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                ArrayList<TarifaCuarto> tarifas= informacion.getTarifasCuartos();

                for (TarifaCuarto tarifa: tarifas){
                    buff.write(tarifa.toString());
                    buff.newLine();
                }
                buff.close();

            }else{
                try {
                    FileWriter writer = new FileWriter(file,false);
                    BufferedWriter buff= new BufferedWriter(writer);
                
                    ArrayList<TarifaCuarto> tarifas= informacion.getTarifasCuartos();

                for (TarifaCuarto tarifa: tarifas){
                    buff.write(tarifa.toString());
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
            File file = new File("data/Reservas.txt");
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Reserva> reservas= informacion.getReservas();

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
                
                    Map<String,Reserva> reservas= informacion.getReservas();

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
            File file = new File("data/MenuBebidas.txt");
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Bebida> menu= informacion.getMenuBebidas();

                for (Map.Entry<String,Bebida> entry: menu.entrySet()){
                    Bebida bebida=(entry.getValue());
                    buff.write(bebida.toString());
                    buff.newLine();
                }
                buff.close();

            }else{
                try {
                    FileWriter writer = new FileWriter(file);
                    BufferedWriter buff= new BufferedWriter(writer);
                
                    Map<String,Bebida> menu= informacion.getMenuBebidas();

                    for (Map.Entry<String,Bebida> entry: menu.entrySet()){
                        Bebida bebida=(entry.getValue());
                        buff.write(bebida.toString());
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
            File file = new File("data/MenuPlatos.txt");
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Plato> menu= informacion.getMenuPlatos();

                for (Map.Entry<String,Plato> entry: menu.entrySet()){
                    Plato plato=(entry.getValue());
                    buff.write(plato.toString());
                    buff.newLine();
                }
                buff.close();

            }else{
                try {
                    FileWriter writer = new FileWriter(file);
                    BufferedWriter buff= new BufferedWriter(writer);
                
                    Map<String,Plato> menu= informacion.getMenuPlatos();

                    for (Map.Entry<String,Plato> entry: menu.entrySet()){
                        Plato plato=(entry.getValue());
                        buff.write(plato.toString());
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
            File file = new File("data/Huespedes.txt");
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Huesped> huespedes= informacion.getHuespedes();

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
                
                Map<String,Huesped> huespedes= informacion.getHuespedes();

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
            File file = new File("data/Usuarios.txt");
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,ArrayList<String>> usuarios= informacion.getUsuarios();

                for (Map.Entry<String,ArrayList<String>> entry: usuarios.entrySet()){
                    buff.write(entry.getKey());
                    buff.write(";");
                    ArrayList<String> usuario=(entry.getValue());
                    for ( String usu:usuario){
                        buff.write(usu);
                        buff.write(",");
                    }
                    buff.close();
                }

            }else{
                try {
                    FileWriter writer = new FileWriter(file);
                    BufferedWriter buff= new BufferedWriter(writer);
                
                    Map<String,ArrayList<String>> usuarios= informacion.getUsuarios();

                    for (Map.Entry<String,ArrayList<String>> entry: usuarios.entrySet()){
                        buff.write(entry.getKey());
                        buff.write(";");
                        ArrayList<String> usuario=(entry.getValue());
                        for ( String usu:usuario){
                            buff.write(usu);
                            buff.write(",");
                        }
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
            File file = new File("data/Servicios.txt");
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Servicio> servicios = informacion.getServicios();

                for (Map.Entry<String,Servicio> entry: servicios.entrySet()){
                    Servicio servicio=(entry.getValue());
                    buff.write(servicio.toString());
                    buff.newLine();
                }
                buff.close();

            }else{
                try {
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Servicio> servicios = informacion.getServicios();

                for (Map.Entry<String,Servicio> entry: servicios.entrySet()){
                    Servicio servicio=(entry.getValue());
                    buff.write(servicio.toString());
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
            File file = new File("data/Consumos.txt");
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Consumo> consumos = informacion.getConsumos();

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
                
                Map<String,Consumo> consumos = informacion.getConsumos();

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
            File file = new File("data/Camas.txt");
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FileWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                ArrayList<Cama> camas= informacion.getCamas();

                for (Cama cama: camas){
                    buff.write(cama.toString());
                    buff.newLine();
                }
                buff.close();

            }else{
                try {
                    FileWriter writer = new FileWriter(file);
                    BufferedWriter buff= new BufferedWriter(writer);
                
                    ArrayList<Cama> camas= informacion.getCamas();

                    for (Cama cama: camas){
                        buff.write(cama.toString());
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
