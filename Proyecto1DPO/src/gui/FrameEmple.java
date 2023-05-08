package gui;

import java.awt.*;

import javax.swing.*;


import console.MenuEmpleado;
import model.PMS;

public class FrameEmple extends JFrame{

    private MenuEmpleado menu ;
    private PanelAgregarConsumo agregarConsumo;
    private PanelInfoEmple info;
    private JPanel panelCentro;
    private PMS pms;

    public FrameEmple(PMS sistema){

        pms = sistema;
        menu = new MenuEmpleado(sistema.getCargador(), sistema);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLayout(new BorderLayout());

        PanelOpcionesEmpl panelOp = new PanelOpcionesEmpl(this);
        agregarConsumo =  new PanelAgregarConsumo(menu);
        panelCentro = new JPanel();
        panelCentro.setLayout(new FlowLayout());
        panelCentro.add(agregarConsumo);
        panelCentro.setBackground(new Color(117, 149, 114));
        agregarConsumo.setBackground(Color.lightGray);
        panelCentro.setVisible(false);


        info = new PanelInfoEmple(this);

        add(panelOp,BorderLayout.WEST);
        add(info,BorderLayout.CENTER);
        setVisible(true);

    }





    public void mostrarAgregarConsumo(){
        panelCentro.setVisible(true);
        info.setVisible(false);
        this.add(panelCentro,BorderLayout.CENTER);
    }

    public void mostrarPerfil(){
        info.setVisible(true);
        panelCentro.setVisible(false);
        this.add(info,BorderLayout.CENTER);
    }

    public void cerrar(){
        dispose();
    }


   
    
}
