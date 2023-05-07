package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;

import console.MenuAdministrador;
import model.PMS;

public class ConfigurarMenu extends JDialog implements ActionListener {
    private JRadioButton radio1;
    private JRadioButton radio2;
    private JRadioButton radio3;
    private JRadioButton radio4;
    private JRadioButton radio5;
    private JRadioButton radio6;
    private JButton btnOk;
    private JButton btnCancelar;
    private PMS sistema;
    private MenuAdministrador menuAdmin;
    private int opcion;

    public ConfigurarMenu(PMS sistema, MenuAdministrador menuAdmin, int op) {
        this.sistema = sistema;
        this.menuAdmin = menuAdmin;
        opcion = op;
        setVisible(true);
        setSize(350, 160);
        setResizable(false);
        setLayout(new BorderLayout());

        JLabel tituloMenu = new JLabel("Que desea cambiar", SwingConstants.CENTER);
        tituloMenu.setFont(new Font("macOS SF Pro", Font.BOLD, 12));
        tituloMenu.setBorder(null);
        tituloMenu.setForeground(Color.BLACK);
        tituloMenu.setOpaque(false);

        add(tituloMenu, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(6, 1));

        ButtonGroup bg = new ButtonGroup();
        radio1 = new JRadioButton("Nombre");
        radio2 = new JRadioButton("Tarifa");
        radio3 = new JRadioButton("Rango de horas");
        radio4 = new JRadioButton("Comida de disponibilidad");
        radio5 = new JRadioButton("Lugar de disponibilidad");
        radio6 = new JRadioButton("Disponibilidad servicio al cuarto");

        radio1.setBounds(radio1.getX(), radio1.getY(), 150, 70);
        radio2.setBounds(radio2.getX(), radio2.getY(), 150, 70);
        radio3.setBounds(radio3.getX(), radio3.getY(), 150, 70);
        radio4.setBounds(radio4.getX(), radio4.getY(), 150, 70);
        radio5.setBounds(radio5.getX(), radio5.getY(), 150, 70);
        radio6.setBounds(radio6.getX(), radio6.getY(), 150, 70);

        bg.add(radio1);
        bg.add(radio2);
        bg.add(radio3);
        bg.add(radio4);
        bg.add(radio5);
        bg.add(radio6);

        panelCentral.add(radio1);

        panelCentral.add(radio2);

        panelCentral.add(radio3);

        panelCentral.add(radio4);

        panelCentral.add(radio5);

        panelCentral.add(radio6);

        add(panelCentral, BorderLayout.CENTER);

        JPanel panelBotonesInferior = new JPanel();
        panelBotonesInferior.setLayout(new FlowLayout());

        btnOk = new JButton("OK");
        btnOk.addActionListener(this);
        btnCancelar = new JButton("CANCELAR");
        btnCancelar.addActionListener(this);
        panelBotonesInferior.add(btnOk);
        panelBotonesInferior.add(btnCancelar);

        add(panelBotonesInferior, BorderLayout.SOUTH);

        pack();

        setLocationRelativeTo(null);
    }

    private void cambiarOpcion(String nombreProducto, int op, String title, String campo1, String campo2, String tipo) {
        JDialog cambiar = new JDialog();
        cambiar.setLocationRelativeTo(null);
        cambiar.setSize(350, 160);
        cambiar.setResizable(false);
        cambiar.setLayout(new BorderLayout());
        JLabel titulo = new JLabel(title, SwingConstants.CENTER);
        cambiar.add(titulo, BorderLayout.CENTER);

        JPanel panelCentral = new JPanel();
        GroupLayout layout = new GroupLayout(panelCentral);
        panelCentral.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel nombreOr = new JLabel(campo1);
        JTextField nombreOrField = new JTextField(10);
        nombreOrField.setEditable(false);
        if (op == 0) {
            nombreOrField.setText(sistema.getMenuPlatos().get(nombreProducto).getNombre());
        } else if (op == 1) {
            nombreOrField.setText(sistema.getMenuBebidas().get(nombreProducto).getNombre());
        }

        JLabel nombreNue = new JLabel(campo2);
        JTextField nombreNueField = new JTextField(10);

        GroupLayout.SequentialGroup h = layout.createSequentialGroup();
        h.addGroup(layout.createParallelGroup().addComponent(nombreOr).addComponent(nombreNue));
        h.addGroup(layout.createParallelGroup().addComponent(nombreOrField).addComponent(nombreNueField));
        layout.setHorizontalGroup(h);

        GroupLayout.SequentialGroup v = layout.createSequentialGroup();

        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(nombreOr).addComponent(nombreOrField));
        v.addGroup(
                layout.createParallelGroup(Alignment.BASELINE).addComponent(nombreNue).addComponent(nombreNueField));
        layout.setVerticalGroup(v);

        cambiar.add(panelCentral, BorderLayout.CENTER);
        JPanel abajo = new JPanel();
        JButton botonOk = new JButton("OK");
        botonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (op == 0) {
                    if (tipo.equals("nombre")) {
                        menuAdmin.configurarPlatoNombre(nombreProducto, nombreNueField.getText());
                    } else if (tipo.equals("tarifa")) {
                        menuAdmin.configurarPlatoTarifa(nombreProducto,
                                (double) Double.parseDouble(nombreNueField.getText()));
                    } else if (tipo.equals("rango")) {
                        menuAdmin.configurarPlatoRangoHoras(nombreProducto, nombreNueField.getText());
                    } else if (tipo.equals("comida")) {
                        menuAdmin.configurarPlatoDisponibilidadComida(nombreProducto, nombreNueField.getText());
                    } else if (tipo.equals("lugar")) {
                        menuAdmin.configurarPlatoDisponibilidadLugar(nombreProducto, nombreNueField.getText());
                    } else if (tipo.equals("servicio")) {
                        menuAdmin.configurarPlatoDisponibilidadServicioCuarto(nombreProducto,
                                Boolean.parseBoolean(nombreNueField.getText()));
                    }

                } else if (op == 1) {
                    menuAdmin.configurarBebidaNombre(nombreOrField.getText(), nombreNueField.getText());
                }
                cambiar.dispose();

            }
        });
        abajo.add(botonOk);

        JButton botonCancelar = new JButton("CANCELAR");
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiar.setVisible(false);
                cambiar.dispose();

            }
        });
        abajo.add(botonCancelar);
        cambiar.add(abajo, BorderLayout.SOUTH);

        cambiar.pack();
        cambiar.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnOk) {
            JDialog nombreMenu = new JDialog();

            nombreMenu.setLayout(new BorderLayout());
            JPanel panelCentro = new JPanel(new FlowLayout());
            if (opcion == 0) {
                nombreMenu.add(new JLabel("Que plato desea cambiar"), BorderLayout.NORTH);

            } else if (opcion == 1) {
                nombreMenu.add(new JLabel("Que bebida desea cambiar"), BorderLayout.NORTH);
            }
            JLabel c = new JLabel("Nombre:");
            JTextField nombreMenuField = new JTextField(10);
            panelCentro.add(c);
            panelCentro.add(nombreMenuField);
            nombreMenu.add(panelCentro, BorderLayout.CENTER);

            JPanel abajo = new JPanel(new FlowLayout());
            JButton botonOk = new JButton("OK");
            botonOk.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (radio1.isSelected()) {
                        cambiarOpcion(nombreMenuField.getText(), opcion, "Cambiar nombre", "Nombre original",
                                "Nombre nuevo", "nombre");
                    } else if (radio2.isSelected()) {
                        cambiarOpcion(nombreMenuField.getText(), opcion, "Cambiar tarifa", "Nombre",
                                "Nueva tarifa", "tarifa");
                    } else if (radio3.isSelected()) {
                        cambiarOpcion(nombreMenuField.getText(), opcion, "Cambiar rango de horas", "Nombre",
                                "Nuevo rango de horas", "rango");
                    } else if (radio4.isSelected()) {
                        cambiarOpcion(nombreMenuField.getText(), opcion, "Cambiar comida", "Nombre",
                                "Nueva comida", "comida");
                    } else if (radio5.isSelected()) {
                        cambiarOpcion(nombreMenuField.getText(), opcion, "Cambiar lugar", "Nombre",
                                "Nuevo lugar", "lugar");
                    } else if (radio6.isSelected()) {
                        cambiarOpcion(nombreMenuField.getText(), opcion, "Cambiar servicio de cuarto", "Nombre",
                                "Nuevo servicio de cuarto", "servicio");
                    }
                    nombreMenu.dispose();

                }
            });
            abajo.add(botonOk);
            JButton botonCancelar = new JButton("CANCELAR");
            botonCancelar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nombreMenu.dispose();

                }
            });
            abajo.add(botonCancelar);
            nombreMenu.add(abajo, BorderLayout.SOUTH);
            nombreMenu.pack();
            nombreMenu.setVisible(true);

        } else if (e.getSource() == btnCancelar) {
            dispose();

        }
    }
}
