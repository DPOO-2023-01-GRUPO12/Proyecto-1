package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import model.Autenticador;
import model.PMS;

public class IniciarSesion extends JDialog implements ActionListener {

    private Autenticador authenticator;
    private PMS sistema;
    private JButton botonOk;
    private JButton botonCancelar;
    private JTextField inputUser;
    private JTextField inputPassword;

    public IniciarSesion(VentanaInicio ventanaPrincipal, PMS pms) {
        authenticator = new Autenticador(pms);

        setBackground(Color.lightGray);
        setLocationRelativeTo(ventanaPrincipal);
        setLayout(new BorderLayout());

        // Panel central
        JPanel inputUsuario = new JPanel();
        GroupLayout layout = new GroupLayout(inputUsuario);
        inputUsuario.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel user = new JLabel("Usuario:", SwingConstants.LEFT);
        inputUser = new JTextField("", 15);
        JLabel password = new JLabel("Contraseña:", SwingConstants.LEFT);
        inputPassword = new JTextField("", 15);

        GroupLayout.SequentialGroup h = layout.createSequentialGroup();
        h.addGroup(layout.createParallelGroup().addComponent(user).addComponent(password));
        h.addGroup(layout.createParallelGroup().addComponent(inputUser).addComponent(inputPassword));
        layout.setHorizontalGroup(h);

        GroupLayout.SequentialGroup v = layout.createSequentialGroup();

        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(user).addComponent(inputUser));
        v.addGroup(
                layout.createParallelGroup(Alignment.BASELINE).addComponent(password).addComponent(inputPassword));
        layout.setVerticalGroup(v);

        add(inputUsuario, BorderLayout.CENTER);

        // Botones, panel inferior
        JPanel panelBotonesInferior = new JPanel();
        panelBotonesInferior.setLayout(new FlowLayout());

        botonOk = new JButton("OK");
        botonOk.addActionListener(this);
        botonCancelar = new JButton("CANCELAR");
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
            boolean existenciaUsuario = authenticator.revisarExistencia(inputUser.getText().strip());
            if (existenciaUsuario) {
                boolean contrasenaCorrecta = authenticator.revisarPassword(inputUser.getText().strip(),
                        inputPassword.getText().strip());
                if (contrasenaCorrecta) {
                    JOptionPane.showMessageDialog(this, "Sesion iniciada");
                    this.setVisible(false);
                    InterfazAdmin iadmin = new InterfazAdmin(sistema);
                    iadmin.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Contraseña incorrecta");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No existe el usuario");
            }
        } else if (e.getSource() == botonCancelar) {
            this.setVisible(false);
            this.dispose();
            this.pack();
        }
    }

}
