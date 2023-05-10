package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class PanelOpcionesEmpl extends JPanel implements ActionListener{


    GrupoBotones bg;

    CustomButton consumoIcon;
    CustomButton perfilIcon;

    FrameEmple frame;



    public PanelOpcionesEmpl(FrameEmple emple){ 
        frame = emple;

        setPreferredSize(new Dimension(100, getHeight()));
        setBackground(new Color(23, 35, 31));

        setLayout(new GridLayout(12, 1));
        String[] pathNames = { ".", "Icons", "" };
        String path = String.join(File.separator, pathNames);

        bg = new GrupoBotones();

        perfilIcon = new CustomButton(path + "user.png", bg);
        perfilIcon.addActionListener(this);
        consumoIcon = new CustomButton(path + "servicios.png", bg);
        consumoIcon.addActionListener(this);
        bg.add(perfilIcon);
        bg.add(consumoIcon);

        add(perfilIcon);
        add(consumoIcon);
        

        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == consumoIcon){
            frame.mostrarAgregarConsumo();
        }
        else if(e.getSource() == perfilIcon){
            frame.mostrarPerfil();
            
        }
    }
    
}
