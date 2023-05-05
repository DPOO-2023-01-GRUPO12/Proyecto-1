package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.lang.foreign.GroupLayout;

import javax.swing.*;
import java.awt.*;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class InputHabitacion extends JDialog implements ActionListener {
    private JTextField inputIdentificador;
    private JTextField inputUbicacion;
    private JTextField inputDescripcion;

    private JRadioButton radioCocina1;
    private JRadioButton radioCocina2;
    private JRadioButton radioBalcon1;
    private JRadioButton radioBalcon2;
    private JRadioButton radioVista1;
    private JRadioButton radioVista2;

    private JButton botonOk;
    private JButton botonCancelar;

    public InputHabitacion()  {
        setBackground(Color.lightGray);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelCentral = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panelCentral.setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        JLabel usuario = new JLabel("Usuario: ");
        inputUsuario = new JTextField();
        JLabel ubicacion = new JLabel("Ubicacion: ");
        inputUbicacion = new JTextField();
        JLabel descripcion = new JLabel("Descripcion: ");
        inputDescripcion = new JTextField();


        JLabel cocina = new JLabel("Tiene Cocina: ")
        JButtonGroup bgCocina = new JButtonGroup();
        radioCocina1 = new JRadioButton("Si");
        radioCocina2 = new JRadioButton("No");
        bgCocina.add(radioCocina1);
        bgCocina.add(radioCocina2);

        JLabel balcon = new JLabel("Tiene balcon: ")
        JButtonGroup bgBalcon = new JButtonGroup();
        radioBalcon1 = new JRadioButton("Si");
        radioBalcon2 = new JRadioButton("No");
        bgBalcon.add(radioBalcon1);
        bgBalcon.add(radioBalcon2);


        JLabel vista = new JLabel("Tiene vista al mar: ")
        JButtonGroup bgVista = new JButtonGroup();
        radioVista1 = new JRadioButton("Si");
        radioVista2 = new JRadioButton("No");
        bgVista.add(radioVista1);
        bgVista.add(radioVista2);


        GroupLayout.SequentialGroup h = layout.createSequentialGroup();
        h.addGroup(layout.createParallelGroup().addComponent(usuario).addComponent(inputUsuario));
        h.addGroup(layout.createParallelGroup().addComponent(ubicacion).addComponent(inputUbicacion));
        h.addGroup(layout.createParallelGroup().addComponent(descripcion).addComponent(inputDescripcion));
        h.addGroup(layout.createParallelGroup().addComponent(cocina).addComponent(radioCocina1).addComponent(radioCocina2));
        h.addGroup(layout.createParallelGroup().addComponent(balcon).addComponent(radioBalcon1).addComponent(radioBalcon2));
        h.addGroup(layout.createParallelGroup().addComponent(vista).addComponent(radioVista1).addComponent(radioVista2));

        GroupLayout.SequentialGroup v = layout.createSequentialGroup();

        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(usuario).addComponent(inputUsuario));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(ubicacion).addComponent(inputUbicacion));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(descripcion).addComponent(inputDescripcion));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(cocina).addComponent(radioCocina1).addComponent(radioCocina2));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(balcon).addComponent(radioBalcon1).addComponent(radioBalcon2));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(vista).addComponent(radioVista1).addComponent(radioVista2));
        layout.setVerticalGroup(v);


        add(panelCentral,BorderLayout.CENTER);

        JPanel panelBotonesInferior = new JPanel();
        panelBotonesInferior.setLayout(new FlowLayout());

        botonOk = new JButton("OK");
        botonOk.setBorderPainted(true);
        botonOk.addActionListener(this);
        botonCancelar = new JButton("CANCELAR");
        botonCancelar.setBorderPainted(true);
        botonCancelar.addActionListener(this);

        panelBotonesInferior.add(botonOk);
        panelBotonesInferior.add(botonCancelar);

        add(panelBotonesInferior, BorderLayout.SOUTH);


    }

}
