package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InterfazEmpleado extends JFrame implements ActionListener {


    private JRadioButton radio1;
    private JButton botonOk;
    private JButton botonCancelar;

    private JRadioButton radio2;

    public InterfazEmpleado(){
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
        panelCentral.setLayout(new GridLayout(1, 1));
        // gbc.fill = GridBagConstraints.HORIZONTAL;

        // Central - BOTONES opciones
        ButtonGroup bg = new ButtonGroup();
        radio1 = new JRadioButton("Registrar Consumos");

        radio1.setBounds(radio1.getX(), radio1.getY(), 150, 70);
        
        bg.add(radio1);
       
        panelCentral.add(radio1);

      
        add(panelCentral, BorderLayout.CENTER);

        // Botones OK-Cancelar
        JPanel panelBotonesInferior = new JPanel();
        panelBotonesInferior.setLayout(new FlowLayout());

        botonOk = new JButton("OK");
        botonOk.setBorderPainted(true);
        botonOk.addActionListener( this);
        botonCancelar = new JButton("CANCELAR");
        botonCancelar.setBorderPainted(true);
        botonCancelar.addActionListener(this);

        panelBotonesInferior.add(botonOk);
        panelBotonesInferior.add(botonCancelar);

        add(panelBotonesInferior, BorderLayout.SOUTH);

        setSize(250,150);
        // pack();
        setResizable(false);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonOk){
            if(radio1.isSelected()){


                AgregarConsumo cons = new AgregarConsumo();

                // Hacer lo de agregar un consumo



            }
            else{
                JOptionPane.showMessageDialog(null , "Porfavor seleccione una opcion");
            }

        }

        else if(e.getSource() == botonCancelar){
            this.setVisible(false);
            this.dispose();
            this.pack();
        }
    }

   
    
}
