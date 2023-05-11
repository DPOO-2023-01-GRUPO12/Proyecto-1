package gui;

import java.awt.*;

import javax.swing.*;

import console.MenuAdministrador;
import model.PMS;
import persistencia.GuardadorInformacion;

public class FrameAdmin extends JFrame {
    private PanelInfo panelInfo;
    private PanelArchivos panelArchivos;
    private PanelCrearHabitacion panelHabitacion;
    private PMS sistema;
    private MenuAdministrador menuAdmin;
    private PanelTipoHabitacion panelTipoHabitacion;
    private PanelConfigurar panelConfigurar;
    private PanelConcurrencia panelConcurr;
    private CardLayout cardPane;
    private JPanel paneles;

    public FrameAdmin(PMS pms) {

        sistema = pms;
        menuAdmin = new MenuAdministrador(pms.getCargador(), pms);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(this.getDefaultCloseOperation()==JFrame.EXIT_ON_CLOSE) {
            cerrar();
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        int newWidth = (int) (1500 * 0.7);
        int newHeight = (int) (900 * 0.7);
        
        setSize(newWidth, newHeight);
        
        setLayout(new BorderLayout());
        JPanel arriba = new JPanel();
        arriba.setBackground(new Color(23, 35, 31));
   
        add(arriba, BorderLayout.NORTH);
        PanelOpciones panelOpciones = new PanelOpciones(this);
        add(panelOpciones, BorderLayout.WEST);
        
        cardPane =  new CardLayout();
        paneles = new JPanel();
        paneles.setVisible(true);
        paneles.setLayout(cardPane);
        
        
        panelInfo = new PanelInfo(this);
        paneles.add(panelInfo, "Info");
        panelArchivos = new PanelArchivos(this, sistema);
        paneles.add(panelArchivos, "Archivos");

        

        add(paneles, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void mostrarUsuario() {
	cardPane.show(paneles,"Info");

    }

    public void cerrar() {
	/*
        GuardadorInformacion g = sistema.getGuardador();
        
        if(sistema.getCamas().size()>0 && sistema.getMenuBebidas().size()>0 && sistema.getMenuPlatos().size()>0) {
            g.guardarCamas();
            g.guardarConsumos();
            g.guardarHabitaciones();
            g.guardarHuespedes();
            g.guardarMenuBebidas();
            g.guardarMenuPlatos();
            g.guardarReservas();
            g.guardarServicios();
            g.guardarTarifasCuarto();
            g.guardarTipoHabitacones();
            //g.guardarUsusariosHotel();  
            
        }*/
             
         dispose();
        
    }

    public void mostrarArchivos() {
    
	cardPane.show(paneles,"Archivos");

    }

    public void crearHabitacion() {
        panelHabitacion = new PanelCrearHabitacion(menuAdmin, sistema);
        paneles.add(panelHabitacion, "Habitacion");
        cardPane.show(paneles,"Habitacion");

    }

    public void crearTipoHabitacion() {
        panelTipoHabitacion = new PanelTipoHabitacion(menuAdmin);
        paneles.add(panelTipoHabitacion, "Tipo");
        cardPane.show(paneles,"Tipo");

    }

    public void mostrarConfigurar() {
        panelConfigurar = new PanelConfigurar(menuAdmin, sistema);
        paneles.add(panelConfigurar, "Configurar");
        cardPane.show(paneles,"Configurar");
    }

    public void mostrarConcurrencia() {
        panelConcurr = new PanelConcurrencia(menuAdmin, sistema);
        paneles.add(panelConcurr, "Concurr");
        cardPane.show(paneles,"Concurr");
    }

}
