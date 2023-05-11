package gui;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import console.MenuAdministrador;
import model.PMS;

public class PanelConcurrencia extends JPanel implements ActionListener{

    private PMS pms;
    private Concurrencia tabla;
    private NormalButton btnActualizar;

    public PanelConcurrencia(MenuAdministrador menuAdmin, PMS sistema) {
        pms = sistema;
        setLayout(new BorderLayout());
        tabla = new Concurrencia(pms);
        
        
        int newWidth = (int) (getWidth() * 0.7);
        int newHeight = (int) (getHeight() * 0.7);
        
        setSize(newWidth, newHeight);
        setLayout(new BorderLayout());
        
        tabla.setSize(newWidth,newHeight);
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
