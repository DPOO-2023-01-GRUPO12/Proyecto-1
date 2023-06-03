package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

public class PanelOpciones extends JPanel implements ActionListener {

    private GrupoBotones bg;
    private CustomButton userIcon;
    private CustomButton btnArchivos;
    private CustomButton btnHabitacion;
    private CustomButton btnTipoHabitacion;
    private CustomButton btnConfigurar;
    private CustomButton btnConcurr;
    private CustomButton btnGraficas;
    private FrameAdmin frameAdmin;

    public PanelOpciones(FrameAdmin frameAdmin) {
        this.frameAdmin = frameAdmin;
        setPreferredSize(new Dimension(100, getHeight()));
        setBackground(new Color(23, 35, 31));

        setLayout(new GridLayout(10, 1));
        String[] pathNames = { ".", "Icons", "" };
        String path = String.join(File.separator, pathNames);

        bg = new GrupoBotones();
        userIcon = new CustomButton(path + "user.png", bg);
        userIcon.addActionListener(this);
        
        
        
        btnGraficas = new CustomButton(path + "graphics.png" ,bg);
        btnGraficas.addActionListener(this);

        btnArchivos = new CustomButton(path + "file.png", bg);
        btnArchivos.addActionListener(this);

        btnHabitacion = new CustomButton(path + "habitacion.png", bg);
        btnHabitacion.addActionListener(this);

        btnTipoHabitacion = new CustomButton(path + "tipoHabi.png", bg);
        btnTipoHabitacion.addActionListener(this);

        btnConfigurar = new CustomButton(path + "configurar.png", bg);
        btnConfigurar.addActionListener(this);

        btnConcurr = new CustomButton(path + "concurrencia.png", bg);
        btnConcurr.addActionListener(this);

        bg.add(userIcon);
        bg.add(btnArchivos);
        bg.add(btnHabitacion);
        bg.add(btnTipoHabitacion);
        bg.add(btnConfigurar);
        bg.add(btnConcurr);
        bg.add(btnGraficas);

        add(userIcon);
        add(btnArchivos);
        add(btnHabitacion);
        add(btnTipoHabitacion);
        add(btnConfigurar);
        add(btnConcurr);
        add(btnGraficas);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userIcon) {
            frameAdmin.mostrarUsuario();
        } else if (e.getSource() == btnArchivos) {
            frameAdmin.mostrarArchivos();
        } else if (e.getSource() == btnHabitacion) {
            frameAdmin.crearHabitacion();
        } else if (e.getSource() == btnTipoHabitacion) {
            frameAdmin.crearTipoHabitacion();
        } else if (e.getSource() == btnConfigurar) {
            frameAdmin.mostrarConfigurar();
        } else if (e.getSource() == btnConcurr) {
            frameAdmin.mostrarConcurrencia();
        }
        else if (e.getSource() == btnGraficas) {
            frameAdmin.mostrarGraficas();
        }
    

    }

}
