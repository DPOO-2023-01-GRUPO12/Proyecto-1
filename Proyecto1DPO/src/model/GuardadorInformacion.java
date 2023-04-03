package model;

import java.io.BufferedWriter;
import java.io.*;
import java.io.File;
import java.io.FilterWriter;
import java.util.ArrayList;
import java.util.Map;

private InformacionHotel informacion;

public class GuardadorInformacion {

    public void guardarHabitaciones(Map<String,Habitacion> habitaciones) {
        
        try{
            File file = new File("data/habitaciones.txt");
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
                FilterWriter writer = new FileWriter(file);
                BufferedWriter buff= new BufferedWriter(writer);
                
                Map<String,Habitacion> habitaciones= informacion.getHabitaciones()

                for (M)
            }else{
                System.out.println("File already exists.");
            }
        }catch (Exception e){
            System.out.println("No se pudo guardar el archivo de habitaciones. ");
        }
    }

    public void guardarTipoHabitacones(Map<String,TipoHabitacion> tipoHabitaciones) {
        File file = new File("data/tipoHabitaciones.txt");
        try{
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
            }else{
                System.out.println("File already exists.");
            }
        } catch (Exception e){
            System.out.println("An error occurred.");
        }
    }

    public File guardarTarifasCuarto(Map<String,TarifaCuarto> tarifasCuarto) {
        return null;
    }

    public File guardarReservas(Map<String,Reserva> reservas) {
        return null;
    }

    public File guardarMenuBebidas(Map<String,Bebida> bebidas) {
        return null;
    }

    public File guardarMenuPlatos(Map<String,Plato> platos) {
        return null;
    }

    public File guardarHuespedes(Map<String,Huesped> huespedes) {
        return null;
    }

    public File guardarUsusariosHotel(Map<String,ArrayList<String>> usuarios) {
        return null;
    }
}
