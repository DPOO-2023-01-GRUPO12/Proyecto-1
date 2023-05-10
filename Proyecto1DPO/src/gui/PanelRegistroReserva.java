package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;

import console.MenuRecepcionista;

public class PanelRegistroReserva extends JPanel implements ActionListener{

    private Campo campoNombre;
    private Campo campoDoc;
    private Campo campoCel;
    private Campo campoCorr;
    private Campo campoEdad;
    private NormalButton botonRegistrar;
    private FrameRecep frame;



    public PanelRegistroReserva(FrameRecep recep) {
        this.frame = recep;
        setForeground(Color.WHITE);

        ///////////////////////////////////// Titulo frame
        JPanel panelTitulo = new JPanel();
        panelTitulo.setOpaque(true);
        Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);
        panelTitulo.setBorder(whiteLine);
        panelTitulo.setBackground(new Color(6, 57, 112));
        JLabel titulo = new JLabel("Consultar Inventario", SwingConstants.CENTER);
        titulo.setFont(new Font("Roboto", Font.BOLD, 30));
        titulo.setForeground(getForeground());
        panelTitulo.add(titulo);

        add(panelTitulo, BorderLayout.NORTH);
        //////////////////////////////////////////
        setLayout(new BorderLayout());
        

        JPanel izq = new JPanel();
        izq.setBackground(new Color(23, 35, 31));
        add(izq, BorderLayout.WEST);

        JPanel central = new JPanel();
        GroupLayout layout = new GroupLayout(central);
        central.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel nombre = new JLabel("Nombre:");
        nombre.setFont(new Font("Roboto", Font.BOLD, 15));
        campoNombre = new Campo(15, "Nombre");

        JLabel documento = new JLabel("Documento:");
        documento.setFont(new Font("Roboto", Font.BOLD, 15));
        campoDoc = new Campo(15, "Documento");

        JLabel celular = new JLabel("Celular:");
        celular.setFont(new Font("Roboto", Font.BOLD, 15));
        campoCel = new Campo(15, "Celular");

        JLabel correo = new JLabel("Correo:");
        correo.setFont(new Font("Roboto", Font.BOLD, 15));
        campoCorr = new Campo(15, "Correo");

        JLabel edad = new JLabel("Edad:");
        edad.setFont(new Font("Roboto", Font.BOLD, 15));
        campoEdad = new Campo(15, "Edad");

        GroupLayout.SequentialGroup h = layout.createSequentialGroup();

        h.addGroup(layout.createParallelGroup().addComponent(nombre).addComponent(documento).addComponent(celular)
                .addComponent(correo).addComponent(edad));
        h.addGroup(
                layout.createParallelGroup().addComponent(campoNombre).addComponent(campoDoc).addComponent(campoCel)
                        .addComponent(campoCorr).addComponent(campoEdad));
        layout.setHorizontalGroup(h);

        GroupLayout.SequentialGroup v = layout.createSequentialGroup();

        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(nombre).addComponent(campoNombre));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(documento).addComponent(campoDoc));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(celular).addComponent(campoCel));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(correo).addComponent(campoCorr));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(edad).addComponent(campoEdad));
        layout.setVerticalGroup(v);

        add(central, BorderLayout.CENTER);

        botonRegistrar = new NormalButton("AGREGAR HUESPED");
        //botonRegistrar.setPreferredSize(new Dimension(100, 70));
        botonRegistrar.addActionListener(this);

        add(botonRegistrar, BorderLayout.SOUTH);
        //setPreferredSize(new Dimension(700, 750));
        setVisible(true);
        

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonRegistrar){
            frame.registroHuespedReserva(campoNombre.getText(),campoDoc.getText(),campoCel.getText(),campoCorr.getText(),campoEdad.getText());

        }
    }
    
}
