package gui;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

import model.Huesped;
import console.MenuRecepcionista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RealizarRegistro extends JDialog implements ActionListener {

    private JTextField inputNombre;
    private JTextField inputDocumento;
    private JTextField inputCelular;
    private JTextField inputCorreo;
    private JTextField inputEdad;

    private JButton botonOk;
    private JButton botonCancelar;

    private MenuRecepcionista menuRecep;

    public RealizarRegistro() {
        setBackground(Color.lightGray);
        setLocationRelativeTo(this);
        setLayout(new BorderLayout());

        // Panel textfields, centro

        JPanel inputUser = new JPanel();
        GroupLayout layout = new GroupLayout(inputUser);
        inputUser.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel nombre = new JLabel("Nombre", SwingConstants.LEFT);
        inputNombre = new JTextField("", 15);

        JLabel documento = new JLabel("Documento", SwingConstants.LEFT);
        inputDocumento = new JTextField("", 15);

        JLabel celular = new JLabel("Celular", SwingConstants.LEFT);
        inputCelular = new JTextField("", 15);

        JLabel correo = new JLabel("Correo", SwingConstants.LEFT);
        inputCorreo = new JTextField("", 15);

        JLabel edad = new JLabel("Edad", SwingConstants.LEFT);
        inputEdad = new JTextField("", 15);

        GroupLayout.SequentialGroup hor = layout.createSequentialGroup();
        hor.addGroup(layout.createParallelGroup().addComponent(nombre).addComponent(documento).addComponent(celular)
                .addComponent(correo).addComponent(edad));
        hor.addGroup(layout.createParallelGroup().addComponent(inputNombre).addComponent(inputDocumento)
                .addComponent(inputCelular).addComponent(inputCorreo).addComponent(inputEdad));
        layout.setHorizontalGroup(hor);

        GroupLayout.SequentialGroup ver = layout.createSequentialGroup();
        ver.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(nombre).addComponent(inputNombre));
        ver.addGroup(
                layout.createParallelGroup(Alignment.BASELINE).addComponent(documento).addComponent(inputDocumento));
        ver.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(celular).addComponent(inputCelular));
        ver.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(correo).addComponent(inputCorreo));
        ver.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(edad).addComponent(inputEdad));
        layout.setVerticalGroup(ver);

        add(inputUser, BorderLayout.CENTER);

        // Panel Sur, botones
        JPanel panelBotonesSalida = new JPanel();
        panelBotonesSalida.setLayout(new FlowLayout());

        botonOk = new JButton("OK");
        botonOk.addActionListener(this);
        botonCancelar = new JButton("CANCELAR");
        botonCancelar.addActionListener(this);

        panelBotonesSalida.add(botonOk);
        panelBotonesSalida.add(botonCancelar);

        add(panelBotonesSalida, BorderLayout.SOUTH);

        pack();
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonOk) {

            int edadHuesped = Integer.parseInt(inputEdad.getText());
            menuRecep.realizarRegistro(inputNombre.getText(), inputDocumento.getText(), inputCelular.getText(),
                    inputCorreo.getText(), edadHuesped);

            this.setVisible(false);
            this.dispose();
            this.pack();

        }

        else if (e.getSource() == botonCancelar) {

            this.setVisible(false);
            this.dispose();
            this.pack();

        }

    }

}