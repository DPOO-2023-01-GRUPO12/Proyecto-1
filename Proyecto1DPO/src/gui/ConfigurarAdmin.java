package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class ConfigurarAdmin extends JDialog implements ActionListener{

    private JRadioButton radio1;
    private JRadioButton radio2;
    private JRadioButton radio3;
    private JRadioButton radio4;

    private JButton botonOk;
    private JButton botonCancelar;

    public ConfigurarAdmin(){
        setBackground(Color.lightGray);
        setLocationRelativeTo(null);
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        layout.setVgap(10);

        // Norte
        JLabel titulo = new JLabel("¿Qué desea Configurar?", SwingConstants.CENTER);

        Font f = titulo.getFont();
        titulo.setFont(new Font("macOS SF Pro", Font.BOLD, 12));
        titulo.setBorder(null);
        titulo.setForeground(Color.BLACK);
        titulo.setOpaque(false);

        add(titulo, BorderLayout.NORTH);

        // Central
        JPanel panelCentral = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        panelCentral.setLayout(new GridLayout(3, 1));
        // gbc.fill = GridBagConstraints.HORIZONTAL;

        // Central - BOTONES opciones
        ButtonGroup bg = new ButtonGroup();
        radio1 = new JRadioButton("Configurar tarifa servicio");
        radio2 = new JRadioButton("Configurar menu de platos");
        radio3 = new JRadioButton("Configurar menu de bebidas");
        

        radio1.setBounds(radio1.getX(), radio1.getY(), 150, 70);
        radio2.setBounds(radio2.getX(), radio2.getY(), 150, 70);
        radio3.setBounds(radio3.getX(), radio3.getY(), 150, 70);
       
        bg.add(radio1);
        bg.add(radio2);
        bg.add(radio3);
        

        panelCentral.add(radio1);

        panelCentral.add(radio2);

        panelCentral.add(radio3);

       
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

        setSize(300, 300);
        // pack();
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }


    
    
}
