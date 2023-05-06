package gui;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import console.MenuAdministrador;
import model.Cama;
import model.Habitacion;
import model.PMS;
import model.TipoHabitacion;

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
    private MenuAdministrador menuAdmin;
    private PMS sistema;

    public InputHabitacion(PMS pms, MenuAdministrador menuAdmin) {
        sistema = pms;
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

    private void seleccionarTipoHab(Habitacion hab) {
        JDialog seleccionarTipoHabitacion = new JDialog();
        seleccionarTipoHabitacion.setLayout(new BorderLayout());
        JLabel tituloTipoHab = new JLabel("Seleccione el tipo de habitacion", SwingConstants.CENTER);
        tituloTipoHab.setFont(new Font("macOS SF Pro", Font.BOLD, 15));
        tituloTipoHab.setBorder(null);
        tituloTipoHab.setForeground(Color.BLACK);
        tituloTipoHab.setOpaque(false);
        seleccionarTipoHabitacion.add(tituloTipoHab, BorderLayout.NORTH);

        // JPanel panelLista = new JPanel();
        DefaultListModel<String> lm = new DefaultListModel<>();
        JList<String> listaTipoHabs = new JList<>(lm);
        for (TipoHabitacion tipo : sistema.getTipoHabitaciones().values()) {
            lm.addElement(tipo.getNombreTipo());
        }

        JScrollPane scroll = new JScrollPane(listaTipoHabs);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        seleccionarTipoHabitacion.add(scroll, BorderLayout.CENTER);

        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        JButton botonOkTh = new JButton("OK");
        botonOkTh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarTipoHabitacion.setVisible(false);
                seleccionarTipoHabitacion.dispose();
                seleccionarTipoHabitacion.pack();
                String tipoSeleccionado = listaTipoHabs.getSelectedValue();
                menuAdmin.asignarHabitacionTipo(hab, sistema.getTipoHabitaciones().get(tipoSeleccionado));
                seleccionarTipoHabitacion.setVisible(false);
                seleccionarTipoHabitacion.dispose();
                seleccionarTipoHabitacion.pack();
                seleccionarCamas(hab);
            }
        });
        panelSouth.add(botonOkTh);

        JButton botonCancelarTh = new JButton("CANCELAR");
        botonCancelarTh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarTipoHabitacion.setVisible(false);
                seleccionarTipoHabitacion.dispose();
                seleccionarTipoHabitacion.pack();
            }
        });
        panelSouth.add(botonCancelarTh);

        seleccionarTipoHabitacion.add(panelSouth, BorderLayout.SOUTH);
        seleccionarTipoHabitacion.setSize(300, 400);
        seleccionarTipoHabitacion.setVisible(true);
    }

    private void seleccionarCamas(Habitacion hab) {
        JDialog seleccionarCamas = new JDialog();
        seleccionarCamas.setLayout(new BorderLayout());
        JLabel tituloCamas = new JLabel("Seleccionee la/las cama/camas", SwingConstants.CENTER);
        tituloCamas.setFont(new Font("macOS SF Pro", Font.BOLD, 15));
        tituloCamas.setBorder(null);
        tituloCamas.setForeground(Color.BLACK);
        tituloCamas.setOpaque(false);
        seleccionarCamas.add(tituloCamas, BorderLayout.NORTH);

        // JPanel panelLista = new JPanel();
        DefaultListModel<String> lm = new DefaultListModel<>();
        JList<String> listaCamas = new JList<>(lm);
        for (Cama cama : sistema.getCamas()) {
            lm.addElement(cama.toString());
        }

        JScrollPane scroll = new JScrollPane(listaCamas);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        seleccionarCamas.add(scroll, BorderLayout.CENTER);

        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        JButton botonOkTh = new JButton("OK");
        botonOkTh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarCamas.setVisible(false);
                seleccionarCamas.dispose();
                seleccionarCamas.pack();
                int[] camasSeleIndex = listaCamas.getSelectedIndices();
                ArrayList<Cama> camasSelec = new ArrayList<Cama>();
                for (int i : camasSeleIndex) {
                    camasSelec.add(sistema.getCamas().get(i));
                }
                menuAdmin.asignarHabitacionCamas(hab, camasSelec);
                seleccionarCamas.setVisible(false);
                seleccionarCamas.dispose();
                seleccionarCamas.pack();

            }
        });
        panelSouth.add(botonOkTh);

        JButton botonCancelarTh = new JButton("CANCELAR");
        botonCancelarTh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarCamas.setVisible(false);
                seleccionarCamas.dispose();
                seleccionarCamas.pack();
            }
        });
        panelSouth.add(botonCancelarTh);

        seleccionarCamas.add(panelSouth, BorderLayout.SOUTH);
        seleccionarCamas.setSize(300, 400);
        seleccionarCamas.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonOk) {

            Habitacion hab = menuAdmin.crearHabitacion(inputId.getText(), inputUbicacion.getText(),
                    inputDescripcion.getText());
            this.setVisible(false);
            this.dispose();
            this.pack();
            seleccionarTipoHab(hab);

        }
    }

}
