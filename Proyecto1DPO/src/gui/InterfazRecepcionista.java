package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InterfazRecepcionista extends JFrame implements ActionListener{


    private JRadioButton radio1;
    private JRadioButton radio2;
    private JRadioButton radio3;
    private JRadioButton radio4;
    private JRadioButton radio5;    private JButton botonOk;
    private JButton botonCancelar;


    public InterfazRecepcionista(){
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
        radio5 = new JRadioButton("Realizar check-cout ");

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
        


        if(e.getSource() == botonOk){
            if(radio1.isSelected()){
                //TODO: Añadir codigo consultar habitaciones 
                // creo que tambien viene aca lo de la visualizacion de disponibilidad


            }
            if(radio2.isSelected()){
                //TODO: Realizar reserva 
                RealizarReserva reserva = new RealizarReserva();


            }
            if(radio3.isSelected()){
                //TODO: Realizar Registro
            }
            if(radio4.isSelected()){
                // Cancelar Reserva 
            }
            if(radio5.isSelected()){
                // Realizar checkout

            }
        }
        if(e.getSource() == botonCancelar){
            this.setVisible(false);
            this.dispose();
            this.pack();
        }
    } 



    public static void main(String[] args) {
        InterfazRecepcionista in = new InterfazRecepcionista();
    }
    
}
