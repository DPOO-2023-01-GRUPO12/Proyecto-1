/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.swing.*;

import model.PMS;
import persistencia.Cargador;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FrameLogIn extends JFrame {

    private PanelIconoLogIn panelIzq;
    private PanelUsuario panelDer;

    private PMS sistema;
    public FrameLogIn() {
        sistema = new PMS();
        Cargador cargador = sistema.getCargador();
        String[] pathNames = { ".", "data", "usuarios.txt" };
        String pathUsers = String.join(File.separator, pathNames);
        File fileUsers = new File(pathUsers);
        
        


        try {
            cargador.cargarUsuarios(fileUsers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        int newWidth = (int) (1500 * 0.7);
        int newHeight = (int) (900 * 0.7);
        
        setSize(newWidth, newHeight);
        JLayeredPane pane = new JLayeredPane();

        Background background = new Background(this);
        background.setVisible(true);
        background.setBounds(getX(), getY(), getWidth(), getHeight());
        //add(background);
        pane.add(background, Integer.valueOf(0));

        JPanel paneles = new JPanel();
        paneles.setLayout(new GridLayout(1, 1));
        paneles.setOpaque(false);
        paneles.setBounds(getX(), getY(), getWidth(), getHeight());

        //Panel izquierda donde se mueestra icono
        //panelIzq = new PanelIconoLogIn(this);
        //paneles.add(panelIzq);

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
            new FrameAdmin(sistema);

        } else if (tipo.equals("recepcionista")) {
            new FrameRecep(sistema);

        } else if (tipo.equals("empleado")) {
            new FrameEmple(sistema);

        }

    }

    public PMS getSistema() {
        return sistema;
    }

    public static void main(String[] args) {
        new FrameLogIn();

    }
}
