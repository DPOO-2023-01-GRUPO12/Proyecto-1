package gui;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Flow;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import console.MenuAdministrador;

public class InputHabitacion extends JDialog implements ActionListener {
    private JTextField inputId;
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
    private JTextField inputUsuario;
    private MenuAdministrador menuAdmin;

    private

    public InputHabitacion(MenuAdministrador menuAdmin) {
        this.menuAdmin = menuAdmin;
        setBackground(Color.lightGray);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelCentral = new JPanel();
        GroupLayout layout = new GroupLayout(panelCentral);
        panelCentral.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel id = new JLabel("Identificador: ");
        inputId = new JTextField();
        JLabel ubicacion = new JLabel("Ubicacion: ");
        inputUbicacion = new JTextField();
        JLabel descripcion = new JLabel("Descripcion: ");
        inputDescripcion = new JTextField();

        JLabel cocina = new JLabel("Tiene Cocina: ");
        ButtonGroup bgCocina = new ButtonGroup();
        JPanel panelCocina = new JPanel(new FlowLayout());
        radioCocina1 = new JRadioButton("Si");
        radioCocina2 = new JRadioButton("No");
        bgCocina.add(radioCocina1);
        panelCocina.add(radioCocina1);
        bgCocina.add(radioCocina2);
        panelCocina.add(radioCocina2);

        JLabel balcon = new JLabel("Tiene balcon: ");
        ButtonGroup bgBalcon = new ButtonGroup();
        JPanel panelBalcon = new JPanel(new FlowLayout());
        radioBalcon1 = new JRadioButton("Si");
        radioBalcon2 = new JRadioButton("No");
        bgBalcon.add(radioBalcon1);
        panelBalcon.add(radioBalcon1);
        bgBalcon.add(radioBalcon2);
        panelBalcon.add(radioBalcon2);

        JLabel vista = new JLabel("Tiene vista al mar: ");
        ButtonGroup bgVista = new ButtonGroup();
        JPanel panelVista = new JPanel(new FlowLayout());
        radioVista1 = new JRadioButton("Si");
        radioVista2 = new JRadioButton("No");
        bgVista.add(radioVista1);
        panelVista.add(radioVista1);
        bgVista.add(radioVista2);
        panelVista.add(radioVista2);

        GroupLayout.SequentialGroup h = layout.createSequentialGroup();
        h.addGroup(layout.createParallelGroup().addComponent(usuario).addComponent(inputIdentificador));
        h.addGroup(layout.createParallelGroup().addComponent(ubicacion).addComponent(inputUbicacion));
        h.addGroup(layout.createParallelGroup().addComponent(descripcion).addComponent(inputDescripcion));
        h.addGroup(layout.createParallelGroup().addComponent(cocina).addComponent(radioCocina1)
                .addComponent(radioCocina2));
        h.addGroup(layout.createParallelGroup().addComponent(balcon).addComponent(radioBalcon1)
                .addComponent(radioBalcon2));
        h.addGroup(
                layout.createParallelGroup().addComponent(vista).addComponent(radioVista1).addComponent(radioVista2));

        h.addGroup(layout.createParallelGroup().addComponent(id).addComponent(ubicacion).addComponent(descripcion)
                .addComponent(cocina).addComponent(balcon).addComponent(vista));
        h.addGroup(layout.createParallelGroup().addComponent(inputId).addComponent(inputUbicacion)
                .addComponent(inputDescripcion).addComponent(panelCocina).addComponent(panelBalcon)
                .addComponent(panelVista));
        layout.setHorizontalGroup(h);
        GroupLayout.SequentialGroup v = layout.createSequentialGroup();

        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(id).addComponent(inputId));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(ubicacion).addComponent(inputUbicacion));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(descripcion)
                .addComponent(inputDescripcion));
        v.addGroup(layout.createParallelGroup(Alignment.CENTER).addComponent(cocina).addComponent(panelCocina));
        v.addGroup(layout.createParallelGroup(Alignment.CENTER).addComponent(balcon).addComponent(panelBalcon));
        v.addGroup(layout.createParallelGroup(Alignment.CENTER).addComponent(vista).addComponent(panelVista));
        layout.setVerticalGroup(v);

        add(panelCentral, BorderLayout.CENTER);

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

        pack();
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonOk) {
            menuAdmin.crearHabitacion(inputId.getText(), inputUbicacion.getText(), inputDescripcion.getText());
            dispose();
            JDialog seleccionarTipoHabitcion = new JDialog();
            seleccionarTipoHabitcion.setLayout(new BorderLayout());
            seleccionarTipoHabitcion.add(new JLabel("Seleccione el tipo de habitacion"), BorderLayout.NORTH);

            JPanel panelLista = new JPanel();
            JList listaTipoHabs = new JList();

            try {

                dispose();

            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
