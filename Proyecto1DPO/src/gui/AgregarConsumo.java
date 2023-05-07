package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import console.MenuEmpleado;

public class AgregarConsumo extends JDialog implements ActionListener{
    private JTextField inputDocumento;
    private JTextField inputGrupo;
    private JTextField inputConsumo;
    private JTextField inputvalor;


    private JButton botonOk;
    private JButton botonCancelar;


    private MenuEmpleado menu;

    public AgregarConsumo(MenuEmpleado menuEmpleado){
        menu = menuEmpleado;
        setBackground(Color.lightGray);
        setLocationRelativeTo(this);
        setLayout(new BorderLayout());

        // Panel central
        JPanel inputUsuario = new JPanel();
        GroupLayout layout = new GroupLayout(inputUsuario);
        inputUsuario.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel documento = new JLabel("Documento Huesped:", SwingConstants.LEFT);
        inputDocumento = new JTextField("", 15);
        JLabel grupo = new JLabel("¿Es Grupo? :", SwingConstants.LEFT);
        inputGrupo = new JTextField("", 15);
        JLabel consumo = new JLabel("Nombre Consumo:", SwingConstants.LEFT);
        inputConsumo = new JTextField("", 15);
        JLabel valor = new JLabel("Valor Consumo:", SwingConstants.LEFT);
        inputvalor = new JTextField("", 15);

        GroupLayout.SequentialGroup h = layout.createSequentialGroup();
        h.addGroup(layout.createParallelGroup().addComponent(documento).addComponent(grupo).addComponent(consumo).addComponent(valor));
        h.addGroup(layout.createParallelGroup().addComponent(inputDocumento).addComponent(inputGrupo).addComponent(inputConsumo).addComponent(inputvalor));
        layout.setHorizontalGroup(h);

        GroupLayout.SequentialGroup v = layout.createSequentialGroup();

        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(documento).addComponent(inputDocumento));
        v.addGroup(
                layout.createParallelGroup(Alignment.BASELINE).addComponent(grupo).addComponent(inputGrupo));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(consumo).addComponent(inputConsumo));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(valor).addComponent(inputvalor));
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


        if(e.getSource() == botonOk){

            JDialog dialogo = new JDialog();
                dialogo.setLayout(new BorderLayout());

                JLabel titulo = new JLabel("¿Desea cargar consumo a la habitacion?", SwingConstants.CENTER);

                Font f = titulo.getFont();
                titulo.setFont(new Font("macOS SF Pro", Font.BOLD, 12));
                titulo.setBorder(null);
                titulo.setForeground(Color.BLACK);
                titulo.setOpaque(false);

                dialogo.add(titulo, BorderLayout.NORTH);

                JRadioButton radioSi = new JRadioButton("Si");
                JRadioButton radioNo = new JRadioButton("No");

                double doubleValue = Double.parseDouble(inputvalor.getText());

                radioSi.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                            if(radioSi.isSelected()){
                               
                                // Añadir el consumo a la habitacion y a la factura 

                                menu.registrarConsumoHuesped(inputDocumento.getText(), inputGrupo.getText(),inputConsumo.getText(), doubleValue,"si");

                                JOptionPane.showMessageDialog(null, "Se ha asignado el consumo con exito");
                                dialogo.setVisible(false);
                                dialogo.dispose();
                                dialogo.pack();
                            }

                    }
                });

                radioNo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(radioNo.isSelected()){
                            
                            //SOLO añadir a lo de factura, no cargar a la habitacion

                            menu.registrarConsumoHuesped(inputDocumento.getText(), inputGrupo.getText(),inputConsumo.getText(), doubleValue,"no");
                            JOptionPane.showMessageDialog(null, "Se ha asignado el consumo con exito");
                            dialogo.setVisible(false);
                            dialogo.dispose();
                            dialogo.pack();
                        }

                }
                });

                ButtonGroup bg1 = new ButtonGroup();

                bg1.add(radioSi);
                bg1.add(radioNo);

                JPanel panelCentral =  new JPanel();
                panelCentral.add(radioSi);
                panelCentral.add(radioNo);


                dialogo.add(panelCentral, BorderLayout.CENTER);

                dialogo.setVisible(true);
                dialogo.setSize(244,100);
                dialogo.setLocationRelativeTo(this);

        }
        if(e.getSource() == botonCancelar){
            this.setVisible(false);
            this.dispose();
            this.pack();
        }
        
    }

    


   
    
}
