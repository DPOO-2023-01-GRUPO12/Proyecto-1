package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import console.MenuAdministrador;
import model.Huesped;
import model.PMS;
import model.Reserva;

public class PanelConcurrencia extends JPanel implements ActionListener{

    private ArrayList<String> dias;
    private PMS pms;
    private Concurrencia tabla;
    private NormalButton btnActualizar;

    public PanelConcurrencia(MenuAdministrador menuAdmin, PMS sistema) {
        pms = sistema;
        setLayout(new BorderLayout());
        tabla = new Concurrencia(pms);
        add(tabla,BorderLayout.CENTER);
        
        btnActualizar = new NormalButton("ACTUALIZAR");
        btnActualizar.addActionListener(this);
        add(btnActualizar,BorderLayout.SOUTH);
        
        
        
        
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
	if(e.getSource()==btnActualizar) {
	    tabla.repaint();
	}
	
    }

}
