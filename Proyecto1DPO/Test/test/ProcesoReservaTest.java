package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;


import org.junit.jupiter.api.Test;

import console.MenuRecepcionista;
import model.Huesped;
import model.PMS;
import model.Reserva;
import persistencia.Cargador;

class ProcesoReservaTest {

	private Cargador cargador;
	private PMS pms;
	private MenuRecepcionista MR;

	
	void setUpEscenarioHotel ()  {
		try
        {
			pms = new PMS();
            cargador = new Cargador(pms);
            MR = new MenuRecepcionista(cargador, pms);
            
            String[] pathNames = { ".", "Test","datatest","" };
            String path = String.join(File.separator, pathNames);
            
            File fileNombres = new File(path + "nombresArchivosTest.txt");
            
            cargador.cargarInformacionHotel(fileNombres);
        }
        catch( Exception e )
        {
            fail( "No debería fallar: " + e.getMessage( ) );
        }
		
		
	}
	

	void setUpEscenarioHotelVacio ()  {
		try
        {
			pms = new PMS();
            cargador = new Cargador(pms);
            
            String[] pathNames = { ".", "Test","datatest","" };
            String path = String.join(File.separator, pathNames);
            
            File fileNombres = new File(path + "nombresArchivosVacioTest.txt");
            
            cargador.cargarInformacionHotel(fileNombres);
        }
        catch( Exception e )
        {
            fail( "No debería fallar: " + e.getMessage( ) );
        }
		
		
	}
	
	@Test
	void RealizarRegistroHuesped () {
		
		setUpEscenarioHotel();
		
		Huesped huespedTest = MR.realizarRegistro("Alice", "101010", "3223309259", "Alicelice@gmail.com", 19);
		
		assertEquals("Alice",huespedTest.getNombre(),"El nombre del huesped es Alice");
		assertEquals("101010",huespedTest.getDocumento(),"El documento del huesped es Alice");
		assertEquals("3223309259",huespedTest.getCelular(),"El celular del huesped es Alice");
		assertEquals("Alicelice@gmail.com",huespedTest.getCorreo(),"El correo del huesped es Alice");
		assertEquals(19,huespedTest.getEdad(),"La edad del huesped es Alice");
	}
	
	@Test
	void RealizarRegistroVacioHuesped () {
		
		try
        {
			setUpEscenarioHotelVacio();
			Huesped huespedTest = MR.realizarRegistro("Alice", "101010", "3223309259", "Alicelice@gmail.com", 19);
			
			assertEquals("Alice",huespedTest.getNombre(),"El nombre del huesped es Alice");
			assertEquals("101010",huespedTest.getDocumento(),"El documento del huesped es Alice");
			assertEquals("3223309259",huespedTest.getCelular(),"El celular del huesped es Alice");
			assertEquals("Alicelice@gmail.com",huespedTest.getCorreo(),"El correo del huesped es Alice");
			assertEquals(19,huespedTest.getEdad(),"La edad del huesped es Alice");
        }
        catch( Exception e )
        {
            fail( "El registro no se ve afectado si el hotel está vacio: " + e.getMessage( ) );
        }
	}
	
	@Test
	void RealizarReservaHuesped () {
		
		setUpEscenarioHotel();
		
		Huesped huespedTest = MR.realizarRegistro("Alice", "101010", "3223309259", "Alicelice@gmail.com", 19);
		
		Reserva reservaTest = MR.RealizarReservaHuesped("101010", 3, "20/04/2023", "15/05/2023");
		
		Huesped huespedAlice = reservaTest.getHuespedEncargado();
		
		assertEquals("Alice", huespedAlice.getNombre(),"El nombre del huesped encargado es Alice");
		assertFalse(reservaTest.isCancelada(),"La reserva no debe estar cancelada");
		assertTrue(reservaTest.getRango().contains("20/04/2023-15/05/2023"),"El rango de la reserva es 20/04/2023-15/05/2023");
	}
	
	@Test
	void RealizarReservaHuespedVacia() {
		
		try
        {
		
		setUpEscenarioHotelVacio();
		
		Huesped huespedTest = MR.realizarRegistro("Alice", "101010", "3223309259", "Alicelice@gmail.com", 19);
		
		Reserva reservaTest = MR.RealizarReservaHuesped("101010", 3, "20/04/2023", "15/05/2023");
		
		Huesped huespedAlice = reservaTest.getHuespedEncargado();
		
		assertEquals("Alice", huespedAlice.getNombre(),"El nombre del huesped encargado es Alice");
		assertFalse(reservaTest.isCancelada(),"La reserva no debe estar cancelada");
		assertTrue(reservaTest.getRango().contains("20/04/2023-15/05/2023"),"El rango de la reserva es 20/04/2023-15/05/2023");
		}
		catch( Exception e )
        {
            fail( "La reserva no se ve afectado aún si el hotel está vacio: " + e.getMessage( ) );
        }
		
	
	
	}


}
