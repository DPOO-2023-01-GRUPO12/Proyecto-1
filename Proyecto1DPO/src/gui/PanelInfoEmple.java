package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelInfoEmple extends JPanel implements ActionListener{


    private BufferedImage img;
    private NormalButton botonSalir;

    FrameEmple frame;


    public PanelInfoEmple(FrameEmple emple){
        frame =emple;
        setBackground(new Color(6, 57, 112));

        setForeground(Color.WHITE);
        setLayout(new BorderLayout());
        JPanel panelArriba = new JPanel();
        Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);
        panelArriba.setBorder(whiteLine);
        panelArriba.setBackground(new Color(6, 57, 112));
        JLabel titulo = new JLabel("BIENVENIDO EMPLEADO", SwingConstants.CENTER);
        titulo.setFont(new Font("Roboto", Font.BOLD, 30));
        titulo.setForeground(getForeground());
        panelArriba.add(titulo);

        add(panelArriba, BorderLayout.NORTH);

        JPanel panelAbajo = new JPanel(new BorderLayout());
        panelAbajo.setPreferredSize(new Dimension(100, 100));
        panelAbajo.setBackground(new Color(6, 57, 112));

        String[] pathNames = { ".", "Icons", "" };
        String path = String.join(File.separator, pathNames);

        try {
            img = ImageIO.read(new File(path + "userGrande.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        int width = img.getWidth(null) / 2; // double the width
        int height = img.getHeight(null) / 2; // double the height

        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(scaledImg);
        JLabel icono = new JLabel(imgIcon);
        panelAbajo.add(icono, BorderLayout.CENTER);

        botonSalir = new NormalButton("LOG OUT");
        botonSalir.addActionListener(this);

        panelAbajo.add(botonSalir, BorderLayout.SOUTH);

        add(panelAbajo, BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonSalir){

            frame.cerrar();

        }
    }
    
}
