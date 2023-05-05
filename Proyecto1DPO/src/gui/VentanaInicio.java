package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.GroupLayout.Alignment;

public class VentanaInicio extends JFrame {
    private JFrame login;
    private static PMS pms;
    private static Cargador cargador;
    private static GuardadorInformacion guardador;
    private InterfazAdministrador interfazAdministrador;
    private InterfazRecepcionista interfazRecepcionista;
    private InterfazEmpleado interfazEmpleado;

    public VentanaInicio() {

        setTitle("Sistema del Hotel");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        this.getContentPane().setBackground(new Color(137, 209, 254));

        PanelPrincipal panelPrincipal = new PanelPrincipal(this);
        // pms = new PMS();
        // interfazAdministrador = new InterfazAdministrador(pms);
        // interfazRecepcionista = new InterfazRecepcionista(pms);
        // interfazEmpleado = new InterfazEmpleado(pms);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        add(panelPrincipal, c);

        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
    }

    public static void main(String[] args) throws ParseException, IOException {
        new VentanaInicio();
        pms = new PMS();
        cargador = pms.getCargador();
        String[] pathNames = { ".", "data", "usuarios.txt" };
        String pathUsers = String.join(File.separator, pathNames);
        File fileUsers = new File(pathUsers);

        cargador.cargarUsuarios(fileUsers);
        /*
         * //
         * //
         * autenticador = new Autenticador(pms);
         * interfazAdministrador = new InterfazAdministrador(cargador, pms);
         * interfazRecepcionista = new InterfazRecepcionista(cargador, pms);
         * interfazEmpleado = new InterfazEmpleado(cargador, pms);
         * 
         * 
         * 
         * corriendo = true;
         * 
         * 
         * while(corriendo){
         * mostrarMenu();
         * Scanner scanner = new Scanner(System.in);
         * int opcion = scanner.nextInt();
         * 
         * if(opcion==1){
         * iniciarSesion();
         * } else{
         * corriendo = false;
         * System.out.println("Desea guardar?");
         * System.out.println("1. Si");
         * System.out.println("2. No");
         * int opcion2 = scanner.nextInt();
         * if(opcion2==1){
         * guardador.guardarHabitaciones();
         * guardador.guardarTipoHabitacones();
         * guardador.guardarUsusariosHotel();
         * guardador.guardarHuespedes();
         * guardador.guardarReservas();
         * guardador.guardarMenuBebidas();
         * guardador.guardarMenuPlatos();
         * guardador.guardarServicios();
         * guardador.guardarConsumos();
         * guardador.guardarCamas();
         * guardador.guardarTarifasCuarto();
         * }
         * 
         * 
         * }
         * }
         */
    }

    public void iniciarSesion() {
        IniciarSesion dialogoInicioSesion = new IniciarSesion(this, pms);

    }

    public void salir() {
        this.setVisible(false);
        this.dispose();

    }

}
