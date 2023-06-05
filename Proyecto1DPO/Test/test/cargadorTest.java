package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Bebida;
import model.Cama;
import model.Habitacion;
import model.PMS;
import model.Plato;
import model.Servicio;
import model.TarifaCuarto;
import model.TipoHabitacion;
import persistencia.Cargador;


class cargadorTest {
	
	private Cargador cargador;
	private PMS pms;
	
	
	@BeforeEach
	void setUpEscenario1 ()  {
		try
        {
			pms = new PMS();
            cargador = new Cargador(pms);
        }
        catch( Exception e )
        {
            fail( "No debería fallar: " + e.getMessage( ) );
        }
		
		
	}

	@Test
	void CargarHabitacionTest() throws FileNotFoundException, IOException {
		
		setUpEscenario1();
		
		String[] pathNames = { ".", "Test","datatest","" };
        String path = String.join(File.separator, pathNames);
        
        File fileHabitaciones = new File(path + "habitacionesTest.txt");
        
        cargador.cargarHabitaciones(fileHabitaciones);
        
        Map<String, Habitacion> habitacionesTest = pms.getInventarioHabitaciones();
        
        assertEquals(10,habitacionesTest.size(),"Se han debido cargar 10 habitaciones");
        
       
	}
	
	@Test
	void CargarHabitacionVacioTest() throws FileNotFoundException, IOException {
		
		setUpEscenario1();
		
		String[] pathNames = { ".", "Test","datatest","" };
        String path = String.join(File.separator, pathNames);
        
        File fileHabitaciones = new File(path + "habitacionesVacioTest.txt");
        
        cargador.cargarHabitaciones(fileHabitaciones);
        
        Map<String, Habitacion> habitacionesTest = pms.getInventarioHabitaciones();
        
        assertEquals(0,habitacionesTest.size(),"No se deberían ahber cargado habitaciones.");
        
       
	}
	
	@Test
	void CargarTipoHabitacionTest() throws FileNotFoundException, IOException {
		
		setUpEscenario1();
		
		String[] pathNames = { ".", "Test","datatest","" };
        String path = String.join(File.separator, pathNames);
        
        File fileTipoHabitaciones = new File(path + "tipoHabitacionTest.txt");
        
        cargador.cargarTipoHabitaciones(fileTipoHabitaciones);
        Map<String, TipoHabitacion> tipoHabitaciones = pms.getTipoHabitaciones();
        
        assertEquals(4,tipoHabitaciones.size(),"Se han debido cargar 4 tipos de habitaciones");
		
	}
	
	@Test
	void CargarTipoHabitacionVacioTest() throws FileNotFoundException, IOException {
		
		setUpEscenario1();
		
		String[] pathNames = { ".", "Test","datatest","" };
        String path = String.join(File.separator, pathNames);
        
        File fileTipoHabitaciones = new File(path + "tipoHabitacionVacioTest.txt");
        
        cargador.cargarTipoHabitaciones(fileTipoHabitaciones);
        Map<String, TipoHabitacion> tipoHabitaciones = pms.getTipoHabitaciones();
        
        assertEquals(0,tipoHabitaciones.size(),"Se han debido cargar 0 tipos de habitaciones");
		
	}
	
	@Test
	void CargarCamasTest() throws FileNotFoundException, IOException {
		
		setUpEscenario1();
		
		String[] pathNames = { ".", "Test","datatest","" };
        String path = String.join(File.separator, pathNames);
        
        File fileCamas = new File(path + "camasTest.txt");
        
        cargador.cargarCamas(fileCamas);
        ArrayList<Cama> camasTest = pms.getCamas();
        
        assertEquals(6,camasTest.size(),"Se han debido cargar 6 camas");
	
	}
	
	@Test
	void CargarCamasVacioTest() throws FileNotFoundException, IOException {
		
		setUpEscenario1();
		
		String[] pathNames = { ".", "Test","datatest","" };
        String path = String.join(File.separator, pathNames);
        
        File fileCamas = new File(path + "camasVacioTest.txt");
        
        cargador.cargarCamas(fileCamas);
        ArrayList<Cama> camasTest = pms.getCamas();
        
        assertEquals(0,camasTest.size(),"Se han debido cargar 0 camas");
	
	}
	
	@Test
	void CargarTarifasCuartoTest() throws FileNotFoundException, IOException {
		
		setUpEscenario1();
		
		String[] pathNames = { ".", "Test","datatest","" };
        String path = String.join(File.separator, pathNames);
        
        File fileTarifas = new File(path + "tarifasTest.txt");
        
        cargador.cargarTarifasCuarto(fileTarifas);
        
        ArrayList<TarifaCuarto> tarifasHotel = pms.getTarifasCuartos();
        
        assertEquals(11, tarifasHotel.size(),"Se deberían haber cargado 11 tarifas");
       
       
	}
	
	@Test
	void CargarTarifasCuartoVacioTest() throws FileNotFoundException, IOException {
		
		setUpEscenario1();
		
		String[] pathNames = { ".", "Test","datatest","" };
        String path = String.join(File.separator, pathNames);
        
        File fileTarifas = new File(path + "tarifasVacioTest.txt");
        
        cargador.cargarTarifasCuarto(fileTarifas);
        
        ArrayList<TarifaCuarto> tarifasHotel = pms.getTarifasCuartos();
        
        assertEquals(11,tarifasHotel.size(),"Se deberían haber cargado 0 tarifas.");
       
       
	}
	
	@Test
	void CargarMenuBebidasTest() throws FileNotFoundException, IOException {
		
		setUpEscenario1();
		
		String[] pathNames = { ".", "Test","datatest","" };
        String path = String.join(File.separator, pathNames);
        
        File fileBebidas = new File(path + "bebidasTest.txt");
        
        cargador.cargarMenuBebidas(fileBebidas);
        
        Map<String, Bebida> menuBebidas = pms.getMenuBebidas();
        
        assertEquals(10,menuBebidas.size(),"Se deberían haber cargado 10 bebidas");
       
       
	}


	@Test
	void CargarMenuBebidasVacioTest() throws FileNotFoundException, IOException {
		
		setUpEscenario1();
		
		String[] pathNames = { ".", "Test","datatest","" };
        String path = String.join(File.separator, pathNames);
        
        File fileBebidas = new File(path + "bebidasVacioTest.txt");
        
        cargador.cargarMenuBebidas(fileBebidas);
        
        Map<String, Bebida> menuBebidas = pms.getMenuBebidas();
        
        assertEquals(0,menuBebidas.size(),"Se deberían haber cargado 0 bebidas");
       
       
	}
	
	@Test
	void CargarMenuPlatosTest() throws FileNotFoundException, IOException {
		
		setUpEscenario1();
		
		String[] pathNames = { ".", "Test","datatest","" };
        String path = String.join(File.separator, pathNames);
        
        File filePlatos = new File(path + "menuTest.txt");
        
        cargador.cargarMenuPlatos(filePlatos);
        
        Map<String, Plato> menuPlatos = pms.getMenuPlatos();
        
        assertEquals(14,menuPlatos.size(),"Se deberían cargar 14 opciones del menú");
	
	}
	
	@Test
	void CargarMenuPlatosVacioTest() throws FileNotFoundException, IOException {
		
		setUpEscenario1();
		
		String[] pathNames = { ".", "Test","datatest","" };
        String path = String.join(File.separator, pathNames);
        
        File filePlatos = new File(path + "menuVacioTest.txt");
        
        cargador.cargarMenuPlatos(filePlatos);
        
        Map<String, Plato> menuPlatos = pms.getMenuPlatos();
        
        assertEquals(0,menuPlatos.size(),"Se deberían cargar 0 opciones del menú");
	
	}
	
	@Test
	void CargarusuarioTest() throws FileNotFoundException, IOException {
		
		setUpEscenario1();
		
		String[] pathNames = { ".", "Test","datatest","" };
        String path = String.join(File.separator, pathNames);
        
        File fileUsuarios = new File(path + "UsuariosTest.txt");
        
        cargador.cargarUsuarios(fileUsuarios);
        
        Map<String, ArrayList<String>> usuariosHotel = pms.getUsuarios();
        
        assertEquals(12,usuariosHotel.size(),"El Hotel tiene 12 usuarios");
        
}
	
	@Test
	void CargaServiciosTest() throws FileNotFoundException, IOException {
		
		setUpEscenario1();
		
		String[] pathNames = { ".", "Test","datatest","" };
        String path = String.join(File.separator, pathNames);
        
        File fileServicios = new File(path + "servicioTest.txt");
        
        cargador.cargarServicios(fileServicios);
        
        Map<String, Servicio> serviciosHotel = pms.getServicios();
        
        assertEquals(10,serviciosHotel.size(),"EL Hotel tiene 10 servicios");
	}
	
	@Test
	void CargaServiciosVacioTest() throws FileNotFoundException, IOException {
		
		setUpEscenario1();
		
		String[] pathNames = { ".", "Test","datatest","" };
        String path = String.join(File.separator, pathNames);
        
        File fileServicios = new File(path + "servicioVacioTest.txt");
        
        cargador.cargarServicios(fileServicios);
        
        Map<String, Servicio> serviciosHotel = pms.getServicios();
        
        assertEquals(0,serviciosHotel.size(),"EL Hotel tiene 0 servicios");
	}
		
	@Test
	void CargaInformacionHotelTest() throws FileNotFoundException, IOException {
		
		setUpEscenario1();
		
		String[] pathNames = { ".", "Test","datatest","" };
        String path = String.join(File.separator, pathNames);
        
        File fileNombres = new File(path + "nombresArchivosTest.txt");
        
        cargador.cargarInformacionHotel(fileNombres);
        
        
        assertEquals(10,pms.getInventarioHabitaciones().size(),"Se han debido cargar 10 habitaciones");
        assertEquals(4,pms.getTipoHabitaciones().size(),"Se han debido cargar 4 tipos de habitaciones");
        assertEquals(6,pms.getCamas().size(),"Se han debido cargar 6 camas");
        assertEquals(11,pms.getTarifasCuartos().size(),"Se deberían haber cargado 11 tarifas");
        assertEquals(10,pms.getMenuBebidas().size(),"Se deberían haber cargado 10 bebidas");
        assertEquals(14,pms.getMenuPlatos().size(),"Se deberían cargar 14 opciones del menú");
        assertEquals(10,pms.getServicios().size(),"EL Hotel tiene 10 servicios");
        
	}
	
	@Test
	void CargaInformacionHotelVacioTest() throws FileNotFoundException, IOException {
		
		setUpEscenario1();
		
		String[] pathNames = { ".", "Test","datatest","" };
        String path = String.join(File.separator, pathNames);
        
        File fileNombres = new File(path + "nombresArchivosVacioTest.txt");
        
        cargador.cargarInformacionHotel(fileNombres);
        
        
        assertEquals(0,pms.getInventarioHabitaciones().size(),"Se han debido cargar 0 habitaciones");
        assertEquals(0,pms.getTipoHabitaciones().size(),"Se han debido cargar 0 tipos de habitaciones");
        assertEquals(0,pms.getCamas().size(),"Se han debido cargar 0 camas");
        assertEquals(0,pms.getTarifasCuartos().size(),"Se deberían haber cargado 0 tarifas");
        assertEquals(0,pms.getMenuBebidas().size(),"Se deberían haber cargado 0 bebidas");
        assertEquals(0,pms.getMenuPlatos().size(),"Se deberían cargar 0 opciones del menú");
        assertEquals(0,pms.getServicios().size(),"EL Hotel tiene 0 servicios");
        
	}
}
