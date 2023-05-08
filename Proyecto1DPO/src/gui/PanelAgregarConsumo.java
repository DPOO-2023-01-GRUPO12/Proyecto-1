package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

import console.MenuEmpleado;

public class PanelAgregarConsumo extends JPanel implements ActionListener {


    private FrameEmple frame;

    private MenuEmpleado menuEmpleado;
   


    private Campo inputdocumento;
    private Campo inputesgrupo;
    private Campo inputconsumo;
    private Campo inputvalorConsumo;


    private NormalButton botonFinal;
    private ButtonGroup bg;
    private JRadioButton siQuiere;
    private JRadioButton noQuiere;



    public  PanelAgregarConsumo(MenuEmpleado menu){
        menuEmpleado = menu;

       
        setLayout(new BorderLayout());
        setBackground(new Color(117, 149, 114));
        setPreferredSize(new Dimension(300, 700));




        JPanel panelTitulo = new JPanel();
        panelTitulo.setOpaque(true);
        Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);
        panelTitulo.setBorder(whiteLine);
        panelTitulo.setBackground(new Color(240, 240, 250));
        JLabel titulo = new JLabel("Asignar Consumo", SwingConstants.CENTER);
        titulo.setFont(new Font("Roboto", Font.BOLD, 30));
        titulo.setForeground(getForeground());
        panelTitulo.add(titulo);

        add(panelTitulo, BorderLayout.NORTH);

     

        inputdocumento = new Campo(15,"Documento");
        inputdocumento.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (inputdocumento.getText().equals("Documento")) {
                    inputdocumento.setText("");
                }
            };
        });
        inputesgrupo = new Campo(15,"Es Grupo (si/no)");
        inputesgrupo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (inputesgrupo.getText().equals("Es Grupo (si/no)")) {
                    inputesgrupo.setText("");
                }
            };
        });
        inputconsumo = new Campo(15,"Nombre Consumo");
        inputconsumo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (inputconsumo.getText().equals("Nombre Consumo")) {
                    inputconsumo.setText("");
                }
            };
        });
        inputvalorConsumo = new Campo(15,"ValorConsumo");
        inputvalorConsumo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (inputvalorConsumo.getText().equals("ValorConsumo")) {
                    inputvalorConsumo.setText("");
                }
            };
        });




        JPanel cargar = new JPanel(new BorderLayout());
        cargar.setBackground(Color.white);
        JLabel tituloCocina = new JLabel("Desea Cargarlo a la habitacion", SwingConstants.CENTER);
        tituloCocina.setFont(new Font("Roboto", Font.BOLD, 15));
        cargar.add(tituloCocina, BorderLayout.NORTH);

        JPanel radiobuttons = new JPanel(new FlowLayout());
        radiobuttons.setBackground(Color.white);
        bg = new ButtonGroup();

        siQuiere = new JRadioButton("Si");
        noQuiere = new JRadioButton("No");
        siQuiere.setBackground(Color.white);
        
        noQuiere.setBackground(Color.white);

        bg.add(siQuiere);
        bg.add(noQuiere);
        radiobuttons.add(siQuiere);
        radiobuttons.add(noQuiere);

        cargar.add(radiobuttons, BorderLayout.CENTER);


        


        JPanel divisionesCampos = new JPanel(new GridLayout(5, 1, 20, 40));

        divisionesCampos.add(inputdocumento);
        divisionesCampos.add(inputesgrupo);
        divisionesCampos.add(inputconsumo);
        divisionesCampos.add(inputvalorConsumo);
        divisionesCampos.add(cargar);
        divisionesCampos.setBackground(new Color(117, 149, 114));
        add(divisionesCampos,BorderLayout.CENTER);








        botonFinal = new NormalButton("ASIGNAR CONSUMO");
        botonFinal.setEnabled(false);
        botonFinal.setFocusable(false);

        add(botonFinal,BorderLayout.SOUTH);

        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == botonFinal){
            String cargoAHabitacion = "si";
            if(siQuiere.isSelected()){cargoAHabitacion ="si";}
            if(noQuiere.isSelected()){cargoAHabitacion ="no";}
            double valor = Double.parseDouble(inputvalorConsumo.getText());

            menuEmpleado.registrarConsumoHuesped(inputdocumento.getText(), inputesgrupo.getText()
            , inputconsumo.getText(), valor, cargoAHabitacion);
            
        }
       
    }

 
    
}
