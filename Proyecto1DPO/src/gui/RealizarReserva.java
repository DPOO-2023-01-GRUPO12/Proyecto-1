package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import console.MenuRecepcionista;
import model.PMS;

public class RealizarReserva extends JFrame implements ActionListener {

    private JButton botonOk;
    private JButton botonCancelar;

    private JTextField inputHuesped;
    private JTextField inputCantidadDePersonas;
    private JTextField inputFechaIngreso;
    private JTextField inputFechaSalida;
    private MenuRecepcionista menuRec;
    private PMS sistema;

    public RealizarReserva(PMS pms, MenuRecepcionista rec) {
        sistema = pms;
        menuRec = rec;

        setBackground(Color.lightGray);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelCentral = new JPanel();
        GroupLayout layout = new GroupLayout(panelCentral);
        panelCentral.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel nombreHuesped = new JLabel("Huesped: ");
        inputHuesped = new JTextField();
        JLabel cantidadPersonas = new JLabel("Cantidad Personas: ");
        inputCantidadDePersonas = new JTextField();
        JLabel fechaIngreso = new JLabel("Fecha de ingreso: ");
        inputFechaIngreso = new JTextField();
        JLabel fechaSalida = new JLabel("Fecha de Salida: ");
        inputFechaSalida = new JTextField();

        GroupLayout.SequentialGroup h = layout.createSequentialGroup();

        h.addGroup(layout.createParallelGroup().addComponent(nombreHuesped).addComponent(cantidadPersonas)
                .addComponent(fechaIngreso).addComponent(fechaSalida));
        h.addGroup(layout.createParallelGroup().addComponent(inputHuesped).addComponent(inputCantidadDePersonas)
                .addComponent(inputFechaIngreso).addComponent(inputFechaSalida));
        layout.setHorizontalGroup(h);
        GroupLayout.SequentialGroup v = layout.createSequentialGroup();

        v.addGroup(
                layout.createParallelGroup(Alignment.BASELINE).addComponent(nombreHuesped).addComponent(inputHuesped));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(cantidadPersonas)
                .addComponent(inputCantidadDePersonas));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(fechaIngreso)
                .addComponent(inputFechaIngreso));
        v.addGroup(
                layout.createParallelGroup(Alignment.CENTER).addComponent(fechaSalida).addComponent(inputFechaSalida));

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
        setSize(300, 190);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonOk) {
            menuRec.RealizarReservaHuesped(inputHuesped.getText(), Integer.parseInt(inputCantidadDePersonas.getText()),
                    inputFechaIngreso.getText(), inputFechaSalida.getText());
        }
        if (e.getSource() == botonCancelar) {
            this.setVisible(false);
            this.dispose();
            this.pack();
        }

    }

}
