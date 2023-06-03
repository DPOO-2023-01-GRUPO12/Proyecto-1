package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

import model.Habitacion;
import model.PMS;

public class PanelReservaHuesped extends JPanel implements ActionListener
{
    private VentanaHuesped ventanaHuesped;
    private PMS sistema;
    private Campo campoNom;
    private Campo campoCantPer;
    private JLabel fechaInTexto;
    private JLabel fechaOutTexto;
    private NormalButton botonReservar;
    
    public PanelReservaHuesped(VentanaHuesped ventanaHuesped, PMS pms, Habitacion habitacion, String rango)
    {
	this.ventanaHuesped = ventanaHuesped;
	sistema = pms;
	String[] fechas = rango.split("-");
	
	setLayout(new BorderLayout());
        JPanel izq = new JPanel();

        PanelRegistroReservaHuesped panelRegistro = new PanelRegistroReservaHuesped(ventanaHuesped);
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
        fechaInTexto = new JLabel(fechas[0]);

        JLabel fechaOut = new JLabel("Ingrese la fecha de salida:");
        fechaOutTexto = new JLabel(fechas[1]);

        GroupLayout.SequentialGroup h = layout.createSequentialGroup();

        h.addGroup(layout.createParallelGroup().addComponent(nombre).addComponent(cantidadPer).addComponent(fechaIn)
                .addComponent(fechaOut));
        h.addGroup(
                layout.createParallelGroup().addComponent(campoNom).addComponent(campoCantPer)
                        .addComponent(fechaInTexto)
                        .addComponent(fechaOutTexto));
        layout.setHorizontalGroup(h);

        GroupLayout.SequentialGroup v = layout.createSequentialGroup();

        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(nombre).addComponent(campoNom));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(cantidadPer).addComponent(campoCantPer));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(fechaIn).addComponent(fechaInTexto));
        v.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(fechaOut).addComponent(fechaOutTexto));
        layout.setVerticalGroup(v);

        add(central, BorderLayout.CENTER);

        botonReservar = new NormalButton("RESERVAR");
        botonReservar.addActionListener(this);

        add(botonReservar, BorderLayout.SOUTH);
        setVisible(true);
	
	
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonReservar) {
            for (int i = 0; i < Integer.valueOf(campoCantPer.getText()); i++) {
        	ventanaHuesped.realizarReserva(campoNom.getText(),campoCantPer.getText(),fechaInTexto.getText(),fechaOutTexto.getText());
                

            }
        }
    }

}
