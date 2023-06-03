package gui;


import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.util.Collection;

import javax.swing.*;
import javax.swing.border.Border;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import model.PMS;

public class PanelGraficas extends JPanel implements ActionListener{
	
	
	private PMS system;
	
	private NormalButton btnGrafica1;
	private NormalButton btnGrafica2;
	private NormalButton btnGrafica3;
	private NormalButton btnGrafica4;
	
	
	public PanelGraficas(PMS sistema) {
		system = sistema;
		
		
		setLayout(new BorderLayout());
		
		
		JPanel panelTitulo = new JPanel();
		
		 panelTitulo.setOpaque(true);
	     Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);
	     panelTitulo.setBorder(whiteLine);
	     panelTitulo.setBackground(new Color(6, 57, 112));
	     JLabel titulo = new JLabel("Graficas", SwingConstants.CENTER);
	     titulo.setFont(new Font("Roboto", Font.BOLD, 30));
	     titulo.setForeground(getForeground());
	     panelTitulo.add(titulo);

	     add(panelTitulo, BorderLayout.NORTH);
	     setVisible(true);
	     
	     
	     JPanel panelCentro = new JPanel(new GridLayout(3,1));
	    
	     
	     
	     
	     btnGrafica1 = new NormalButton("Reporte Productos");
	     btnGrafica1.addActionListener(this);
	     btnGrafica2 = new NormalButton("Reporte Facturas");
	     btnGrafica2.addActionListener(this);
	     btnGrafica3 = new NormalButton("Reporte Consumos-Costos");
	     btnGrafica3.addActionListener(this);
	     btnGrafica4 = new NormalButton("Reporte Reservas");
	     btnGrafica4.addActionListener(this);
	     
	     
	     
	     
	     panelCentro.add(btnGrafica1);
	     panelCentro.add(btnGrafica2);
	     panelCentro.add(btnGrafica3);
	     panelCentro.add(btnGrafica4);
	     
	     
	     panelCentro.setVisible(true);
	     
	     add(panelCentro,BorderLayout.CENTER);
	     
	     
	     
	     
	     
	     
	
	     
	     
	     
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnGrafica1) {
			GraficasProductos grafica = new GraficasProductos();
		 
		}
		
	}

	
	
	
}
