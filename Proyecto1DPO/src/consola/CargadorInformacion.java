package consola;

import java.io.File;
import java.io.FileNotFoundException;

import hotel.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 

public class CargadorInformacion
{
    private Menu menu;
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
    }
    
    public void cargarMenus(File menus) {
	
    }
    
    public void cargarServicios(File servicios) {
	
    }
    
    public void cargarTarifas(File tarifas) {
	
    }
    
    
}
