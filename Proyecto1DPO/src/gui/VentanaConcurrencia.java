package gui;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import model.PMS;

public class VentanaConcurrencia extends JFrame {

    PMS sistema;
    public VentanaConcurrencia(PMS pms){
        sistema = pms;
        
        setVisible(true);
        setLayout(new BorderLayout());


        JLabel titulo = new JLabel("¿Qué desea hacer?", SwingConstants.CENTER);

        Font f = titulo.getFont();
        titulo.setFont(new Font("macOS SF Pro", Font.BOLD, 12));
        titulo.setBorder(null);
        titulo.setForeground(Color.BLACK);
        titulo.setOpaque(false);

        add(titulo, BorderLayout.NORTH);

        Concurrencia con = new Concurrencia(sistema);


        add(con,BorderLayout.CENTER);

        setSize(400, 300);
    }
    



    public static void main(String[] args) {
        VentanaConcurrencia ven = new VentanaConcurrencia(null);
    }
}
