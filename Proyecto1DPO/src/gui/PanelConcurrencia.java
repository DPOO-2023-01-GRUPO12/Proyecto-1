package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import console.MenuAdministrador;
import model.PMS;

public class PanelConcurrencia extends JPanel{

    private PMS pms;
    private Concurrencia tabla;
    

    public PanelConcurrencia(MenuAdministrador menuAdmin, PMS sistema) {
        pms = sistema;
        setLayout(new BorderLayout());
        tabla = new Concurrencia(pms);


        JPanel panelTitulo = new JPanel();
        panelTitulo.setOpaque(true);
        Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);
        panelTitulo.setBorder(whiteLine);
        panelTitulo.setBackground(new Color(6, 57, 112));
        JLabel titulo = new JLabel("Consultar Inventario", SwingConstants.CENTER);
        titulo.setFont(new Font("Roboto", Font.BOLD, 30));
        titulo.setForeground(Color.white);
        panelTitulo.add(titulo);
        panelTitulo.setVisible(true);

       

        
        
        int newWidth = (int) (getWidth() * 0.7);
        int newHeight = (int) (getHeight() * 0.7);
        
        setSize(newWidth, newHeight);
        setLayout(new BorderLayout());
        
        tabla.setSize(newWidth,newHeight);
        add(tabla,BorderLayout.CENTER);
        add(panelTitulo,BorderLayout.NORTH);
        
        
        
        
    }


  
}
