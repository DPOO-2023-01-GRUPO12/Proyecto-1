package consola;

import java.io.File;
import java.io.FileNotFoundException;

import hotel.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList; 
import java.util.List; 
import java.util.Arrays;

public class CargadorInformacion
{
    private Restaurante restaurante;
    private Servicio servicio;
    private Tarifa tarifa;
    private Habitacion habitacion;


    public void cargarHabitaciones(File habitaciones) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(habitaciones));
		String linea = br.readLine();


	    linea = br.readLine();
		while (linea != null)
        {
            String[] partes = linea.split(";");
            
            String identificador = partes[0];
            String ubicacion = partes[1];
            int capacidad = Integer.parseInt(partes[2]);
            String nombreTipo = partes[3];


            TipoHabitacion elTipo = new TipoHabitacion(nombreTipo);
            Habitacion laHabitacion = new Habitacion(identificador, ubicacion, capacidad, elTipo);

            linea = br.readLine();

            }

		br.close();

        }
    
    
    public void cargarMenusRestaurante(File menus) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(menus));
		String linea = br.readLine();


	    linea = br.readLine();
		while (linea != null)
        {
            String[] partes = linea.split(";");

            String ubicacion = partes[0];

            Restaurante elrestaurante = new Restaurante(ubicacion);

            linea = br.readLine();

        }

		br.close();
	
    }
    
    public void cargarServicios(File servicios) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(servicios));
		String linea = br.readLine();


	    linea = br.readLine();
		while (linea != null)
        {
            String[] partes = linea.split(";");
            
            String tipoServicio = partes[0];
            String formaPago = partes[1];
            String tipoCobro = partes[2];
            Boolean servicioCuarto = Boolean.parseBoolean(partes[3]);

            Servicio elServicio = new Servicio(tipoServicio, formaPago, tipoCobro);

            linea = br.readLine();

        }

		br.close();

	
    }
    
    public void cargarTarifas(File tarifas) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(tarifas));
		String linea = br.readLine();


	    linea = br.readLine();
		while (linea != null)
        {
            String[] partes = linea.split(";");
            
            String tipoCuarto = partes[0];
            String fechas = partes[1];
            String dias = partes[2];
            double valor = Double.parseDouble(partes[3]);

            ArrayList<String> rangoFechas = new ArrayList<String>(Arrays.asList(fechas.split(",")));
            ArrayList<String> diasSemana = new ArrayList<String>(Arrays.asList(dias.split(",")));

            Tarifa laTarifa = new Tarifa(tipoCuarto, rangoFechas, diasSemana, valor);
           

            linea = br.readLine();

        }

		br.close();

        }

}
        
	
    
    
    

