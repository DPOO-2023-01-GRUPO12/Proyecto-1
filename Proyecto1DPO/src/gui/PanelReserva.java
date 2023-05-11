package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;


public class PanelReserva extends JPanel implements ActionListener {

    private Campo campoNom;
    private Campo campoCantPer;
    private Campo campoFechaIn;
    private Campo campoFechaOut;
    private NormalButton botonReservar;
    private FrameRecep frameRecep;

    public PanelReserva(FrameRecep frameRecep) {
        this.frameRecep = frameRecep;
        setLayout(new BorderLayout());
        JPanel izq = new JPanel();

        PanelRegistroReserva panelRegistro = new PanelRegistroReserva(frameRecep);
        izq.add(panelRegistro);
        add(izq, BorderLayout.WEST);

        JPanel der = new JPanel();
        der.setBackground(new Color(23, 35, 31));
        add(der, BorderLayout.EAST);

        JPanel central = new JPanel();
        GroupLayout layout = new GroupLayout(central);
        central.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel nombre = new JLabel("Ingrese su documento:");
        campoNom = new Campo(10, "Documento");

        JLabel cantidadPer = new JLabel("Ingrese la cantidad de personas en la reserva:");
        campoCantPer = new Campo(10, "Cantidad de personas");

        JLabel fechaIn = new JLabel("Ingrese la fecha de ingreso:");
        campoFechaIn = new Campo(10, "Fecha de ingreso");

        JLabel fechaOut = new JLabel("Ingrese la fecha de salida:");
        campoFechaOut = new Campo(10, "Fecha de salida");

        GroupLayout.SequentialGroup h = layout.createSequentialGroup();

        h.addGroup(layout.createParallelGroup().addComponent(nombre).addComponent(cantidadPer).addComponent(fechaIn)
                .addComponent(fechaOut));
        h.addGroup(
                layout.createParallelGroup().addComponent(campoNom).addComponent(campoCantPer)
                        .addComponent(campoFechaIn)
                        .addComponent(campoFechaOut));
        layout.setHorizontalGroup(h);

        GroupLayout.SequentialGroup v = layout.createSequentialGroup();

        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(nombre).addComponent(campoNom));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(cantidadPer).addComponent(campoCantPer));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(fechaIn).addComponent(campoFechaIn));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(fechaOut).addComponent(campoFechaOut));
        layout.setVerticalGroup(v);

        add(central, BorderLayout.CENTER);

        botonReservar = new NormalButton("REGISTRAR");
        botonReservar.addActionListener(this);

        add(botonReservar, BorderLayout.SOUTH);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonReservar) {
            for (int i = 0; i < Integer.valueOf(campoCantPer.getText()); i++) {
                frameRecep.realizarReserva(campoNom.getText(),campoCantPer.getText(),campoFechaIn.getText(),campoFechaOut.getText());
                

            }
        }
    }

}
