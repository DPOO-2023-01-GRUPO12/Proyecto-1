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

public class PanelOpcionesRecep extends JPanel implements ActionListener {

    private JButton opcionCargarArchivos;
    private JButton opcionCrearHabitacion;
    private JButton opcionCrearTipoHabitacion;
    private JButton opcionConfigurarProductoMenu;
    private GrupoBotones bg;
    private CustomButton userIcon;
    private CustomButton btnConsulta;
    private CustomButton btnReservar;
    private CustomButton btnRegistro;
    private CustomButton btnCancelar;
    private CustomButton btnCheckOut;
    private CustomButton btnLog;
    private FrameRecep frameRecep;

    public PanelOpcionesRecep(FrameRecep frameRecep) {
        this.frameRecep = frameRecep;
        setPreferredSize(new Dimension(100, getHeight()));
        setBackground(new Color(23, 35, 31));

        setLayout(new GridLayout(10, 1));
        String[] pathNames = { "Proyecto1DPO", "Icons", "" };
        String path = String.join(File.separator, pathNames);

        bg = new GrupoBotones();
        userIcon = new CustomButton(path + "user.png", bg);
        userIcon.addActionListener(this);

        btnConsulta = new CustomButton(path + "consulta.png", bg);
        btnConsulta.addActionListener(this);

        btnReservar = new CustomButton(path + "reservar.png", bg);
        btnReservar.addActionListener(this);

        btnRegistro = new CustomButton(path + "registro.png", bg);
        btnRegistro.addActionListener(this);

        btnCancelar = new CustomButton(path + "cancelar.png", bg);
        btnCancelar.addActionListener(this);

        btnCheckOut = new CustomButton(path + "checkout.png", bg);
        btnCheckOut.addActionListener(this);

        btnLog = new CustomButton(path + "log.png", bg);
        btnLog.addActionListener(this);

        bg.add(userIcon);
        bg.add(btnConsulta);
        bg.add(btnReservar);
        bg.add(btnRegistro);
        bg.add(btnCancelar);
        bg.add(btnCheckOut);
        bg.add(btnLog);

        add(userIcon);
        add(btnConsulta);
        add(btnReservar);
        add(btnRegistro);
        add(btnCancelar);
        add(btnCheckOut);
        add(btnLog);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userIcon) {
            frameRecep.mostrarUsuario();
        } else if (e.getSource() == btnConsulta) {
            frameRecep.consultarHabitaciones();
        } else if (e.getSource() == btnReservar) {
            frameRecep.hacerReserva();
        } else if (e.getSource() == btnRegistro) {
            frameRecep.hacerRegistro();
        } else if (e.getSource() == btnCancelar) {
            frameRecep.cancelarReserva();
        } else if (e.getSource() == btnCheckOut) {
            frameRecep.hacerCheckout();
        } else if (e.getSource() == btnLog) {
            frameRecep.generarLog();
        }

    }

}
