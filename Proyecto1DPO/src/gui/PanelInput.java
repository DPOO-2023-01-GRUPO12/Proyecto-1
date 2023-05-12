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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Juanca
 */
class PanelInput extends JPanel implements ActionListener {

    private Campo input;
    private Campo pass;
    private RoundedButton botonLogin;
    private JLabel ingresado;
    private Autenticador authenticator;
    private FrameLogIn ventanaLogin;

    public PanelInput(FrameLogIn ventanaLogin, PanelUsuario pUsu, PMS pms) {
        this.ventanaLogin = ventanaLogin;
        authenticator = new Autenticador(pms);
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 100));
        setPreferredSize(new Dimension(500, 700));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Layout centro
        setLayout(new BorderLayout());

        // Panel que se agrega a centro
        JPanel general = new JPanel();
        general.setOpaque(false);
        general.setBorder(null);
        BoxLayout l = new BoxLayout(general, BoxLayout.Y_AXIS);
        general.setLayout(l);

        // Panel de arriba tiene titulo y mensaje
        JPanel panelTitulo = new JPanel(new GridLayout(2, 1));
        panelTitulo.setOpaque(false);
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
        userLabel.setOpaque(false);
        userLabel.setFont(new Font("Roboto", Font.BOLD, 15));
        userPanel.add(userLabel);
        input = new Campo(10, "Enter your user");

        userPanel.add(input);

        JPanel passwordPanel = new JPanel(new GridLayout(3, 1));
        passwordPanel.setOpaque(false);
        JLabel passLabel = new JLabel("Password", SwingConstants.LEFT);
        passLabel.setFont(new Font("Roboto", Font.BOLD, 15));
        passwordPanel.add(passLabel);

        pass = new Campo(10, "Password");

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
        botonLogin = new RoundedButton("Log in");
        botonLogin.setBackground(new Color(204, 153, 255));
        botonLogin.setFocusPainted(false);
        botonLogin.setForeground(Color.BLACK);
        botonLogin.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
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
                    //JOptionPane.showMessageDialog(null, "Contrasena incorrecta", "Error", JOptionPane.WARNING_MESSAGE);
                    //ingresado.setForeground(Color.red);
                    //ingresado.setText("Contrasena incorrecta");
                    setEnabled(false);
                    CustomDialog dialog = new CustomDialog(this, "Contrasena incorrecta");
                    dialog.addWindowListener(new WindowAdapter() {
                	    @Override
                	    public void windowClosing(WindowEvent e) {
                		setEnabled(true);
                	    }
                	});
                    dialog.setVisible(true);
                    //setEnabled(true);

                }
            } else {
        	//JOptionPane.showMessageDialog(null, "Contrasena incorrecta", "Error", JOptionPane.WARNING_MESSAGE);
                //ingresado.setForeground(Color.red);
                //ingresado.setText("No existe el usuario");
        	setEnabled(false);
        	CustomDialog dialog = new CustomDialog(this, "No existe el usuario");
        	dialog.addWindowListener(new WindowAdapter() {
        	    @Override
        	    public void windowClosing(WindowEvent e) {
        		setEnabled(true);
        	    }
        	});
        	dialog.setVisible(true);
        	//setEnabled(true);
 

            }
        }

    }
    public void setEnabled(boolean enabled) {
        botonLogin.setEnabled(enabled);
        ingresado.setEnabled(enabled);
        super.setEnabled(enabled);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Set anti-aliasing for smoother edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set paint color to white
        g2d.setColor(Color.WHITE);

        // Draw rounded rectangle with solid color
        int arcWidth = 20;
        int arcHeight = 20;
        int x = 0;
        int y = 0;
        int width = getWidth();
        int height = getHeight();
        g2d.fillRoundRect(x, y, width, height, arcWidth, arcHeight);

        g2d.dispose();
    }

}