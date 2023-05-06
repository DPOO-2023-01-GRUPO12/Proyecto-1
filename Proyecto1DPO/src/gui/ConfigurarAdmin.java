package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.plaf.BorderUIResource;

public class ConfigurarAdmin extends JDialog implements ActionListener{

    private JRadioButton radio1;
    private JRadioButton radio2;
    private JRadioButton radio3;

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
        if(e.getSource() == botonOk){
                if(radio1.isSelected()){
                    // cambiar tarifa servicio
                   

                    JDialog dialogoServcio = new JDialog();
                    dialogoServcio.setVisible(true);
                    dialogoServcio.setSize(350, 160);
                    dialogoServcio.setLayout(new BorderLayout());

                    
                    JLabel tituloAgregar = new JLabel("CAMBIAR TARIFA SERVICIO", SwingConstants.CENTER);
                    tituloAgregar.setFont(new Font("macOS SF Pro", Font.BOLD, 12));
                    tituloAgregar.setBorder(null);
                    tituloAgregar.setForeground(Color.BLACK);
                    tituloAgregar.setOpaque(false);

                    dialogoServcio.add(tituloAgregar,BorderLayout.NORTH);
                    
                    JPanel panelServicioCentro = new JPanel();
                    GroupLayout layout = new GroupLayout(panelServicioCentro);
                    panelServicioCentro.setLayout(layout);

                    JLabel nombre = new JLabel("Nombre Servicio: ");
                    JTextField inputNombre = new JTextField();

                    JLabel tarifaAntigua = new JLabel("Tarifa Antigua: ");
                    JTextField inputTarifaAntigua = new JTextField();



                    JLabel tarifa = new JLabel("Tarifa nueva servicio: ");
                    JTextField inputTarifanueva = new JTextField();


                    GroupLayout.SequentialGroup h = layout.createSequentialGroup();
                    h.addGroup(layout.createParallelGroup().addComponent(nombre).addComponent(tarifaAntigua).addComponent(tarifa));
                    h.addGroup(layout.createParallelGroup().addComponent(inputNombre).addComponent(inputTarifaAntigua).addComponent(inputTarifanueva));
                    layout.setHorizontalGroup(h);
            
                    GroupLayout.SequentialGroup v = layout.createSequentialGroup();
            
                    v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(nombre).addComponent(inputNombre));
                    v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(tarifaAntigua).addComponent(inputTarifaAntigua));
                    v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(tarifa).addComponent(inputTarifanueva));
                    layout.setVerticalGroup(v);

                    dialogoServcio.add(panelServicioCentro,BorderLayout.CENTER);

                    
                    JPanel panelBotonesInferior = new JPanel();
                    panelBotonesInferior.setLayout(new FlowLayout());
                    
                    JButton cambiar = new JButton("Cambiar");
                    cambiar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ///TODO: CODIGO PARA PODER CAMBIAR TARIFA UN SERVCIO


                        }
                    });
                    panelBotonesInferior.add(cambiar);

                    dialogoServcio.add(panelBotonesInferior,BorderLayout.SOUTH);

                    dialogoServcio.setLocationRelativeTo(this);


    
                }
                if(radio2.isSelected()){
                    // cambiar tarifa menu de platos



                    JDialog dialogoPlatos = new JDialog();
                    dialogoPlatos.setVisible(true);
                    dialogoPlatos.setSize(350, 160);
                    dialogoPlatos.setLayout(new BorderLayout());

                    
                    JLabel tituloPlatos = new JLabel("CAMBIAR TARIFA PLATO", SwingConstants.CENTER);
                    tituloPlatos.setFont(new Font("macOS SF Pro", Font.BOLD, 12));
                    tituloPlatos.setBorder(null);
                    tituloPlatos.setForeground(Color.BLACK);
                    tituloPlatos.setOpaque(false);

                    dialogoPlatos.add(tituloPlatos,BorderLayout.NORTH);
                    
                    JPanel panelPlatosCentro = new JPanel();
                    GroupLayout layout = new GroupLayout(panelPlatosCentro);
                    panelPlatosCentro.setLayout(layout);

                    JLabel nombre = new JLabel("Nombre Plato: ");
                    JTextField inputNombre = new JTextField();

                    JLabel tarifaAntigua = new JLabel("Tarifa Antigua: ");
                    JTextField inputTarifaAntigua = new JTextField();



                    JLabel tarifa = new JLabel("Tarifa nueva servicio: ");
                    JTextField inputTarifanueva = new JTextField();


                    GroupLayout.SequentialGroup h = layout.createSequentialGroup();
                    h.addGroup(layout.createParallelGroup().addComponent(nombre).addComponent(tarifaAntigua).addComponent(tarifa));
                    h.addGroup(layout.createParallelGroup().addComponent(inputNombre).addComponent(inputTarifaAntigua).addComponent(inputTarifanueva));
                    layout.setHorizontalGroup(h);
            
                    GroupLayout.SequentialGroup v = layout.createSequentialGroup();
            
                    v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(nombre).addComponent(inputNombre));
                    v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(tarifaAntigua).addComponent(inputTarifaAntigua));
                    v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(tarifa).addComponent(inputTarifanueva));
                    layout.setVerticalGroup(v);

                    dialogoPlatos.add(panelPlatosCentro,BorderLayout.CENTER);

                    
                    JPanel panelBotonesInferior = new JPanel();
                    panelBotonesInferior.setLayout(new FlowLayout());
                    
                    JButton cambiar = new JButton("Cambiar");
                    cambiar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ///TODO: CODIGO PARA PODER CAMBIAR TARIFA UN PLATO


                        }
                    });
                    panelBotonesInferior.add(cambiar);

                    dialogoPlatos.add(panelBotonesInferior,BorderLayout.SOUTH);

                    dialogoPlatos.setLocationRelativeTo(this);
    
    
                }
                if(radio3.isSelected()){
                    // cambiar tarifa menu de bebidas


                    JDialog dialogoBebidas = new JDialog();
                    dialogoBebidas.setVisible(true);
                    dialogoBebidas.setSize(350, 160);
                    dialogoBebidas.setLayout(new BorderLayout());

                    
                    JLabel tituloBebidas = new JLabel("CAMBIAR TARIFA PLATO", SwingConstants.CENTER);
                    tituloBebidas.setFont(new Font("macOS SF Pro", Font.BOLD, 12));
                    tituloBebidas.setBorder(null);
                    tituloBebidas.setForeground(Color.BLACK);
                    tituloBebidas.setOpaque(false);

                    dialogoBebidas.add(tituloBebidas,BorderLayout.NORTH);
                    
                    JPanel panelBebidasCentro = new JPanel();
                    GroupLayout layout = new GroupLayout(panelBebidasCentro);
                    panelBebidasCentro.setLayout(layout);

                    JLabel nombre = new JLabel("Nombre Bebida: ");
                    JTextField inputNombre = new JTextField();

                    JLabel tarifaAntigua = new JLabel("Tarifa Antigua: ");
                    JTextField inputTarifaAntigua = new JTextField();



                    JLabel tarifa = new JLabel("Tarifa nueva servicio: ");
                    JTextField inputTarifanueva = new JTextField();


                    GroupLayout.SequentialGroup h = layout.createSequentialGroup();
                    h.addGroup(layout.createParallelGroup().addComponent(nombre).addComponent(tarifaAntigua).addComponent(tarifa));
                    h.addGroup(layout.createParallelGroup().addComponent(inputNombre).addComponent(inputTarifaAntigua).addComponent(inputTarifanueva));
                    layout.setHorizontalGroup(h);
            
                    GroupLayout.SequentialGroup v = layout.createSequentialGroup();
            
                    v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(nombre).addComponent(inputNombre));
                    v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(tarifaAntigua).addComponent(inputTarifaAntigua));
                    v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(tarifa).addComponent(inputTarifanueva));
                    layout.setVerticalGroup(v);

                    dialogoBebidas.add(panelBebidasCentro,BorderLayout.CENTER);

                    
                    JPanel panelBotonesInferior = new JPanel();
                    panelBotonesInferior.setLayout(new FlowLayout());
                    
                    JButton cambiar = new JButton("Cambiar");
                    cambiar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ///TODO: CODIGO PARA PODER CAMBIAR TARIFA UNA BEBIDA E INFORMAR QUE YA QUEDO HECHO


                        }
                    });
                    panelBotonesInferior.add(cambiar);

                    dialogoBebidas.add(panelBotonesInferior,BorderLayout.SOUTH);

                    dialogoBebidas.setLocationRelativeTo(this);
                }

            
        }
        if(e.getSource() == botonCancelar){
            this.setVisible(false);
            this.dispose();
            this.pack();
        }
    }



    


    
    
}
