package gui;

import java.awt.*;

import javax.swing.*;

import console.MenuEmpleado;
import model.PMS;
import persistencia.GuardadorInformacion;

public class FrameEmple extends JFrame {

    private MenuEmpleado menu;
    private PanelOpcionesEmpl panelOp;
    private PanelAgregarConsumo agregarConsumo;
    private PanelInfoEmple info;
    private JPanel panelCentro;
    private PMS pms;
    private JPanel paneles;
    private CardLayout cardPane;

    public FrameEmple(PMS sistema) {

        pms = sistema;
        menu = new MenuEmpleado(sistema.getCargador(), sistema);

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

        panelOp = new PanelOpcionesEmpl(this);
        add(panelOp, BorderLayout.WEST);
        
        cardPane =  new CardLayout();
        paneles = new JPanel();
        paneles.setVisible(true);
        paneles.setLayout(cardPane);
        
        
        
        agregarConsumo = new PanelAgregarConsumo(menu);
        panelCentro = new JPanel();
        panelCentro.setLayout(new FlowLayout());
        panelCentro.add(agregarConsumo);
        panelCentro.setBackground(new Color(117, 149, 114));
        agregarConsumo.setBackground(Color.lightGray);
        
        paneles.add(panelCentro,"Centro");

        
        add(arriba, BorderLayout.NORTH);
        
        add(paneles, BorderLayout.CENTER);
        setVisible(true);

    }

    public void mostrarAgregarConsumo() {
        cardPane.show(paneles, "Centro");
    }

    public void mostrarPerfil() {
	info = new PanelInfoEmple(this);
        paneles.add(info,"Info");
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

}
