/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.PMS;
import persistencia.Cargador;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FrameLogIn extends JFrame {

    private Background background;
    private PanelIconoLogIn panelIzq;
    private PanelUsuario panelDer;
    private BufferedImage myPicture;
    private JPanel panelBack;
    private PMS sistema;
    private FrameAdmin frameAdmin;
    private FrameRecep frameRecep;

    public FrameLogIn() {
        sistema = new PMS();
        Cargador cargador = sistema.getCargador();
        String[] pathNames = { "Proyecto1DPO", "data", "usuarios.txt" };
        String pathUsers = String.join(File.separator, pathNames);
        File fileUsers = new File(pathUsers);

        try {
            cargador.cargarUsuarios(fileUsers);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 900);
        JLayeredPane pane = new JLayeredPane();

        Background background = new Background(this);
        background.setBounds(getX(), getY(), getWidth(), getHeight());

        pane.add(background, Integer.valueOf(0));

        JPanel paneles = new JPanel();
        paneles.setLayout(new GridLayout(1, 2));
        paneles.setOpaque(false);
        paneles.setBounds(getX(), getY(), getWidth(), getHeight());

        // Panel izquierda donde se mueestra icono
        panelIzq = new PanelIconoLogIn(this);
        paneles.add(panelIzq);

        // Panel derecha donde habra un panel para el input del usuario
        panelDer = new PanelUsuario(this, sistema);
        paneles.add(panelDer);

        pane.add(paneles, Integer.valueOf(1));

        add(pane);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void iniciarSesion(String tipo) {

        if (tipo.equals("administrador")) {
            frameAdmin = new FrameAdmin(sistema);

        } else if (tipo.equals("recepcionista")) {
            frameRecep = new FrameRecep(sistema);

        } else if (tipo.equals("empleado")) {
            // frameEmple = new FrameEmple();

        }

    }

    public PMS getSistema() {
        return sistema;
    }

    public static void main(String[] args) {
        new FrameLogIn();

    }
}
