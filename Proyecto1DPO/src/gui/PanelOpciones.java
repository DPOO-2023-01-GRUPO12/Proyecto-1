package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelOpciones extends JPanel implements ActionListener {

    private JButton opcionCargarArchivos;
    private JButton opcionCrearHabitacion;
    private JButton opcionCrearTipoHabitacion;
    private JButton opcionConfigurarProductoMenu;
    private GrupoBotones bg;
    private CustomButton userIcon;
    private CustomButton btnArchivos;
    private CustomButton btnHabitacion;
    private CustomButton btnTipoHabitacion;
    private CustomButton btnConfigurar;
    private CustomButton btnConcurr;
    private FrameAdmin frameAdmin;

    public PanelOpciones(FrameAdmin frameAdmin) {
        this.frameAdmin = frameAdmin;
        setPreferredSize(new Dimension(100, getHeight()));
        setBackground(new Color(23, 35, 31));

        setLayout(new GridLayout(10, 1));
        String[] pathNames = { "Proyecto1DPO", "Icons", "" };
        String path = String.join(File.separator, pathNames);

        bg = new GrupoBotones();
        userIcon = new CustomButton(path + "user.png", bg);
        userIcon.addActionListener(this);

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

        add(userIcon);
        add(btnArchivos);
        add(btnHabitacion);
        add(btnTipoHabitacion);
        add(btnConfigurar);
        add(btnConcurr);

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

    }

}
