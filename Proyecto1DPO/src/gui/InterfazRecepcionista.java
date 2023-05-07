package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import console.MenuRecepcionista;
import model.Habitacion;
import model.PMS;
import persistencia.Cargador;

public class InterfazRecepcionista extends JFrame implements ActionListener {

    private JRadioButton radio1;
    private JRadioButton radio2;
    private JRadioButton radio3;
    private JRadioButton radio4;
    private JRadioButton radio5;
    private JButton botonOk;
    private JButton botonCancelar;
    private PMS sistema;
    private Cargador cargador;
    private MenuRecepcionista menuRec;

    public InterfazRecepcionista(PMS pms) {
        sistema = pms;
        cargador = sistema.getCargador();
        menuRec = new MenuRecepcionista(cargador, sistema);
        setVisible(true);
        setBackground(Color.lightGray);

        setLocationRelativeTo(null);
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        layout.setVgap(10);

        // Norte
        JLabel titulo = new JLabel("¿Qué desea hacer?", SwingConstants.CENTER);

        Font f = titulo.getFont();
        titulo.setFont(new Font("macOS SF Pro", Font.BOLD, 12));
        titulo.setBorder(null);
        titulo.setForeground(Color.BLACK);
        titulo.setOpaque(false);

        add(titulo, BorderLayout.NORTH);

        // Central
        JPanel panelCentral = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        panelCentral.setLayout(new GridLayout(5, 1));
        // gbc.fill = GridBagConstraints.HORIZONTAL;

        // Central - BOTONES opciones
        ButtonGroup bg = new ButtonGroup();
        radio1 = new JRadioButton("Consultar habitaciones");
        radio2 = new JRadioButton("Realizar reserva");
        radio3 = new JRadioButton("Realizar registro");
        radio4 = new JRadioButton("Cancelar reserva ");
        radio5 = new JRadioButton("Realizar check-out ");

        radio1.setBounds(radio1.getX(), radio1.getY(), 150, 70);
        radio2.setBounds(radio2.getX(), radio2.getY(), 150, 70);
        radio3.setBounds(radio3.getX(), radio3.getY(), 150, 70);
        radio4.setBounds(radio4.getX(), radio4.getY(), 150, 70);
        radio5.setBounds(radio5.getX(), radio5.getY(), 150, 70);

        bg.add(radio1);
        bg.add(radio2);
        bg.add(radio3);
        bg.add(radio4);
        bg.add(radio5);

        panelCentral.add(radio1);

        panelCentral.add(radio2);

        panelCentral.add(radio3);

        panelCentral.add(radio4);

        panelCentral.add(radio5);

        add(panelCentral, BorderLayout.CENTER);

        // Botones OK-Cancelar
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

        setSize(300, 400);
        // pack();
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource() == botonOk) {
            if (radio1.isSelected()) {

                JDialog mostrarHabs = new JDialog();
                mostrarHabs.setResizable(false);
                mostrarHabs.setLocationRelativeTo(this);
                mostrarHabs.setLayout(new BorderLayout());
                JLabel tituloTipoHab = new JLabel("Habitaciones", SwingConstants.CENTER);
                tituloTipoHab.setFont(new Font("macOS SF Pro", Font.BOLD, 15));
                tituloTipoHab.setBorder(null);
                tituloTipoHab.setForeground(Color.BLACK);
                tituloTipoHab.setOpaque(false);
                mostrarHabs.add(tituloTipoHab, BorderLayout.NORTH);

                // JPanel panelLista = new JPanel();

                DefaultListModel<String> lm = new DefaultListModel<>();
                JList<String> listaHabs = new JList<>(lm);

                for (Habitacion hab : sistema.getInventarioHabitaciones().values()) {
                    lm.addElement(hab.toString());
                }

                JScrollPane scroll = new JScrollPane(listaHabs);
                scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
                scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

                mostrarHabs.add(scroll, BorderLayout.CENTER);

                JPanel panelSouth = new JPanel();
                panelSouth.setLayout(new FlowLayout());
                JButton botonOkTh = new JButton("OK");
                botonOkTh.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mostrarHabs.setVisible(false);
                        mostrarHabs.dispose();
                        mostrarHabs.pack();
                    }
                });
                panelSouth.add(botonOkTh);
                mostrarHabs.add(panelSouth, BorderLayout.SOUTH);
                mostrarHabs.setSize(300, 400);
                mostrarHabs.setVisible(true);

            }
            if (radio2.isSelected()) {
                // TODO: Realizar reserva

                RealizarRegistro registro = new RealizarRegistro();

                RealizarReserva reserva = new RealizarReserva(sistema, menuRec);

            }
            if (radio3.isSelected()) {
                // TODO: Realizar Registro
                RealizarRegistro registro = new RealizarRegistro();
            }
            if (radio4.isSelected()) {
                // Cancelar Reserva
            }
            if (radio5.isSelected()) {
                // Realizar checkout

            }
        }
        if (e.getSource() == botonCancelar) {
            this.setVisible(false);
            this.dispose();
            this.pack();
        }
    }

}
