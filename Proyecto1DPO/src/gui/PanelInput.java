/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import model.Autenticador;
import model.PMS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Juanca
 */
class PanelInput extends JPanel implements ActionListener {

    private Campo input;
    private Campo pass;
    private JButton botonLogin;
    private JLabel ingresado;
    private Autenticador authenticator;
    private FrameLogIn ventanaLogin;

    public PanelInput(FrameLogIn ventanaLogin, PanelUsuario pUsu, PMS pms) {
        this.ventanaLogin = ventanaLogin;
        authenticator = new Autenticador(pms);
        setOpaque(true);
        setBackground(new Color(0, 0, 0, 100));
        setPreferredSize(new Dimension(500, 700));

        // Layout centro
        setLayout(new BorderLayout());

        // Panel que se agrega a centro
        JPanel general = new JPanel();
        BoxLayout l = new BoxLayout(general, BoxLayout.Y_AXIS);
        general.setLayout(l);

        // Panel de arriba tiene titulo y mensaje
        JPanel panelTitulo = new JPanel(new GridLayout(2, 1));
        JLabel titulo = new JLabel("Log In", SwingConstants.CENTER);
        titulo.setFont(new Font("Roboto", Font.BOLD, 25));

        JLabel texto = new JLabel("Welcome back! Please enter your user and password.", SwingConstants.CENTER);
        texto.setFont(new Font("Roboto", Font.PLAIN, 15));

        panelTitulo.add(titulo);
        panelTitulo.add(texto);

        general.add(panelTitulo);
        // add(panelTitulo,BorderLayout.NORTH);

        // Panel de abajo tiene campos
        JPanel fields = new JPanel();
        GroupLayout layout = new GroupLayout(fields);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        fields.setLayout(layout);

        JPanel userPanel = new JPanel(new GridLayout(2, 1));

        JLabel userLabel = new JLabel("User", SwingConstants.LEFT);
        userLabel.setFont(new Font("Roboto", Font.BOLD, 15));
        userPanel.add(userLabel);
        input = new Campo(10, "Enter your user");
        input.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (input.getText().equals("Enter your user")) {
                    input.setText("");
                }
            };
        });
        userPanel.add(input);

        JPanel passwordPanel = new JPanel(new GridLayout(3, 1));
        JLabel passLabel = new JLabel("Password", SwingConstants.LEFT);
        passLabel.setFont(new Font("Roboto", Font.BOLD, 15));
        passwordPanel.add(passLabel);

        pass = new Campo(10, "");

        pass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (pass.getText().equals("")) {
                    pass.setText("");
                }
            };
        });
        passwordPanel.add(pass);

        GroupLayout.SequentialGroup h = layout.createSequentialGroup();

        h.addGroup(layout.createParallelGroup().addComponent(userPanel).addComponent(passwordPanel));
        layout.setHorizontalGroup(h);

        GroupLayout.SequentialGroup v = layout.createSequentialGroup();

        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(userPanel));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(passwordPanel));
        layout.setVerticalGroup(v);

        general.add(fields);

        ingresado = new JLabel("");
        general.add(ingresado);

        add(general, BorderLayout.CENTER);
        botonLogin = new JButton("Log in");
        botonLogin.setBackground(new Color(25, 25, 112));
        //botonLogin.setForeground(Color.WHITE);
        botonLogin.addActionListener(this);
        add(botonLogin, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonLogin) {
            boolean existenciaUsuario = authenticator.revisarExistencia(input.getText().strip());
            if (existenciaUsuario) {
                String tipo = authenticator.revisarTipo(input.getText());
                boolean contrasenaCorrecta = authenticator.revisarPassword(input.getText(), pass.getText());
                if (contrasenaCorrecta) {
                    ventanaLogin.iniciarSesion(tipo);
                } else {
                    ingresado.setForeground(Color.red);
                    ingresado.setText("Contrasena incorrecta");
                }
            } else {
                ingresado.setForeground(Color.red);
                ingresado.setText("No existe el usuario");

            }
        }

    }

}