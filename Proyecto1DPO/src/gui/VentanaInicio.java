package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;  
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import javax.swing.border.Border;

import console.InterfazAdministrador;
import console.InterfazEmpleado;
import console.InterfazRecepcionista;
import model.Autenticador;
import model.PMS;
import persistencia.Cargador;
import persistencia.GuardadorInformacion;
import javax.swing.*;

public class VentanaInicio extends JFrame
{
    private JFrame login;
    private PMS pms;
    private InterfazAdministrador interfazAdministrador;
    private InterfazRecepcionista interfazRecepcionista;
    private InterfazEmpleado interfazEmpleado;

    
    public VentanaInicio() {
	setTitle("Sistema del Hotel");
	setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();  
	this.getContentPane().setBackground(new Color(137,209,254));

	
	
	PanelPrincipal panelPrincipal = new PanelPrincipal(this);
	//pms = new PMS();
	//interfazAdministrador = new InterfazAdministrador(pms);
	//interfazRecepcionista = new InterfazRecepcionista(pms);
	//interfazEmpleado = new InterfazEmpleado(pms);

	GridBagConstraints c = new GridBagConstraints();
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 1;
	c.gridy = 1;
	add(panelPrincipal,c);
	
	setSize(900,800);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
	setVisible(true);
    }
    

    public static void main(String[] args) throws ParseException, IOException {
	new VentanaInicio();
	/*
        pms = new PMS();
        //cargador = pms.getCargador();
        //guardador = pms.getGuardador();
        autenticador = new Autenticador(pms);
        interfazAdministrador = new InterfazAdministrador(cargador, pms);
        interfazRecepcionista = new InterfazRecepcionista(cargador, pms);
        interfazEmpleado = new InterfazEmpleado(cargador, pms);



        corriendo = true;
        
        String[] pathNames = {"Proyecto1DPO","data", "usuarios.txt"};
        String pathUsers = String.join(File.separator , pathNames);
        File fileUsers = new File(pathUsers);
        
        cargador.cargarUsuarios(fileUsers);
        while(corriendo){
            mostrarMenu();
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            if(opcion==1){
                iniciarSesion();
            } else{
                corriendo = false;
                System.out.println("Desea guardar?");
                System.out.println("1. Si");
                System.out.println("2. No");
                int opcion2 = scanner.nextInt();
                if(opcion2==1){
                    guardador.guardarHabitaciones();
                    guardador.guardarTipoHabitacones();
                    guardador.guardarUsusariosHotel();
                    guardador.guardarHuespedes();
                    guardador.guardarReservas();
                    guardador.guardarMenuBebidas();
                    guardador.guardarMenuPlatos();
                    guardador.guardarServicios();
                    guardador.guardarConsumos();
                    guardador.guardarCamas();
                    guardador.guardarTarifasCuarto();
                }
                
                
            }
        }
        */
    }


    public void iniciarSesion()
    {
	//JDialog dialogo = new JDialog(this);
	//dialogo.setLocationRelativeTo(this);
	//dialogo.setLayout
	//dialogo.setVisible(true);
	//login = new JFrame();
	//login.setLayout(getLayout());
	
    }
    
    public void salir()
    {
	this.dispose();
	
    }

}
