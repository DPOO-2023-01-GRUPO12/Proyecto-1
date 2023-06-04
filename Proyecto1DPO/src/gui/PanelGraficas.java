package gui;


import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.*;
import javax.swing.border.Border;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.internal.chartpart.Chart;
import org.knowm.xchart.style.Styler.LegendPosition;

import model.PMS;

public class PanelGraficas extends JPanel implements ActionListener{
	
	
	private PMS system;
	
	private NormalButton btnGraficaProductosvsCantidad;
	private NormalButton btnGraficaProductosvsPrecio;
	private NormalButton btnGraficaValorFacturas;
	private NormalButton btnGraficaRelacionConsumoCostos;
	private NormalButton btnGraficaReservasPorMes;
	
	
	
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
	    
	     btnGraficaReservasPorMes =  new NormalButton("Reporte Reservas vs Tiempo");
	     btnGraficaReservasPorMes.addActionListener(this);
	     btnGraficaProductosvsCantidad = new NormalButton("Reporte Productosvs Cantidad");
	     btnGraficaProductosvsCantidad.addActionListener(this);
	     btnGraficaProductosvsPrecio = new NormalButton("Reporte ProductosvsCantidad");
	     btnGraficaProductosvsPrecio.addActionListener(this);
	     btnGraficaValorFacturas = new NormalButton("Reporte Valor Factura vs Tiempo");
	     btnGraficaValorFacturas.addActionListener(this);
	     btnGraficaRelacionConsumoCostos = new NormalButton("Reporte Relacion Consumos vs Costos");
	     btnGraficaRelacionConsumoCostos.addActionListener(this);
	     
	     
	     
	     
	     panelCentro.add(btnGraficaProductosvsCantidad);
	     panelCentro.add(btnGraficaProductosvsPrecio);
	     panelCentro.add(btnGraficaValorFacturas);
	     panelCentro.add(btnGraficaRelacionConsumoCostos);
	     panelCentro.add(btnGraficaReservasPorMes);
	     
	     
	     panelCentro.setVisible(true);
	     
	     add(panelCentro,BorderLayout.CENTER);
	     
	     
	     
	     
	     
	     
	
	     
	     
	     
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnGraficaProductosvsCantidad) {
		
			// Create Chart
			final CategoryChart chart = new CategoryChart(new CategoryChartBuilder().width(600).height(400).title("Producto vs Cantidad").xAxisTitle("X").yAxisTitle("Y"));
			
			Map<String,Integer> datosProductos = system.getProductosporCantidad();
			int i = 0;
			for (Entry<String, Integer> entry : datosProductos.entrySet()) {
				chart.addSeries(entry.getKey(), new double[] {i}, new double[] { entry.getValue()});
				i++;
			}
			
			
			// Customize Chart
			chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
			

			
			

			// Schedule a job for the event-dispatching thread:
			// creating and showing this application's GUI.
			javax.swing.SwingUtilities.invokeLater(new Runnable() {

			  @Override
			  public void run() {

			    // Create and set up the window.
			    JFrame frame = new JFrame("ProductosPorCantidad");
			    frame.setLayout(new BorderLayout());
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			    // chart
			    JPanel chartPanel = new XChartPanel(chart);
			    frame.add(chartPanel, BorderLayout.CENTER);

			    // label
			    JLabel label = new JLabel("Grafica productos", SwingConstants.CENTER);
			    frame.add(label, BorderLayout.SOUTH);

			    // Display the window.
			    frame.pack();
			    frame.setVisible(true);
			    frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
			  }
			});
			
		}
		
		
		
		if(e.getSource() == btnGraficaProductosvsPrecio) {
			
			
			// Create Chart
						final CategoryChart chart = new CategoryChart(new CategoryChartBuilder().width(600).height(400).title("Producto vs Precio").xAxisTitle("X").yAxisTitle("Y"));
						
						Map<String, Double> datosProductos = system.getProductosporPrecio();
						int i = 0;
						for (Entry<String, Double> entry : datosProductos.entrySet()) {
							chart.addSeries(entry.getKey(), new double[] {i}, new double[] { entry.getValue()});
							i++;
						}
						
						
						// Customize Chart
						chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
						

						
						

						// Schedule a job for the event-dispatching thread:
						// creating and showing this application's GUI.
						javax.swing.SwingUtilities.invokeLater(new Runnable() {

						  @Override
						  public void run() {

						    // Create and set up the window.
						    JFrame frame = new JFrame("Productos vs Precio");
						    frame.setLayout(new BorderLayout());
						    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

						    // chart
						    JPanel chartPanel = new XChartPanel(chart);
						    frame.add(chartPanel, BorderLayout.CENTER);

						    // label
						    JLabel label = new JLabel("Grafica productos", SwingConstants.CENTER);
						    frame.add(label, BorderLayout.SOUTH);

						    // Display the window.
						    frame.pack();
						    frame.setVisible(true);
						    
						    
						    frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
						    
						  }
						});
						
			
			
			
		}
		if(e.getSource() == btnGraficaValorFacturas ) {
			// Create Chart
			final CategoryChart chart = new CategoryChart(new CategoryChartBuilder().width(600).height(400).title("Valor Factura").xAxisTitle("X").yAxisTitle("Y"));
			
			Map<String, Integer> datosProductos = system.getValorFacturaPorTiempo();
			int i = 0;
			for (Entry<String, Integer> entry : datosProductos.entrySet()) {
				chart.addSeries(entry.getKey(), new double[] {i}, new double[] { entry.getValue()});
				i++;
			}
			
			
			// Customize Chart
			chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
			

			
			

			// Schedule a job for the event-dispatching thread:
			// creating and showing this application's GUI.
			javax.swing.SwingUtilities.invokeLater(new Runnable() {

			  @Override
			  public void run() {

			    // Create and set up the window.
			    JFrame frame = new JFrame("Valor Factura vs Tiempo");
			    frame.setLayout(new BorderLayout());
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			    // chart
			    JPanel chartPanel = new XChartPanel(chart);
			    frame.add(chartPanel, BorderLayout.CENTER);

			    // label
			    JLabel label = new JLabel("Grafica facturas", SwingConstants.CENTER);
			    frame.add(label, BorderLayout.SOUTH);

			    // Display the window.
			    frame.pack();
			    frame.setVisible(true);
			    
			    
			    frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
			    
			  }
			});
		}
		
		if(e.getSource() == btnGraficaRelacionConsumoCostos) {
			// Create Chart
						final CategoryChart chart = new CategoryChart(new CategoryChartBuilder().width(600).height(400).title("Consumos vs Costos").xAxisTitle("X").yAxisTitle("Y"));
						
						ArrayList<Integer> datosrelacion = system.getRelacionConsumosyCostos();
						
						chart.addSeries("ValorConsumos", new double[] {0}, new double[] { datosrelacion.get(0)});
						chart.addSeries("ValorHospedaje", new double[] {0}, new double[] { datosrelacion.get(1)});
						
						
						// Customize Chart
						chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
						

						
						

						// Schedule a job for the event-dispatching thread:
						// creating and showing this application's GUI.
						javax.swing.SwingUtilities.invokeLater(new Runnable() {

						  @Override
						  public void run() {

						    // Create and set up the window.
						    JFrame frame = new JFrame("Valor Consumos vs Costos");
						    frame.setLayout(new BorderLayout());
						    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

						    // chart
						    JPanel chartPanel = new XChartPanel(chart);
						    frame.add(chartPanel, BorderLayout.CENTER);

						    // label
						    JLabel label = new JLabel("Grafica relacion", SwingConstants.CENTER);
						    frame.add(label, BorderLayout.SOUTH);

						    // Display the window.
						    frame.pack();
						    frame.setVisible(true);
						    
						    
						    frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
						    
						  }
						});
		}
		
		
		if(e.getSource() == btnGraficaReservasPorMes) {
			// Create Chart
						final CategoryChart chart = new CategoryChart(new CategoryChartBuilder().width(600).height(400).title("Cantidad Reservas Por Mes").xAxisTitle("X").yAxisTitle("Y"));
						
						Map<String, Integer> datosProductos = system.getReservasPorMes();
						int i = 0;
						for (Entry<String, Integer> entry : datosProductos.entrySet()) {
							chart.addSeries(entry.getKey(), new double[] {i}, new double[] { entry.getValue()});
							i++;
						}
						
						
						// Customize Chart
						chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
						

						
						

						// Schedule a job for the event-dispatching thread:
						// creating and showing this application's GUI.
						javax.swing.SwingUtilities.invokeLater(new Runnable() {

						  @Override
						  public void run() {

						    // Create and set up the window.
						    JFrame frame = new JFrame("Cantidad Reservas Por Mes");
						    frame.setLayout(new BorderLayout());
						    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

						    // chart
						    JPanel chartPanel = new XChartPanel(chart);
						    frame.add(chartPanel, BorderLayout.CENTER);

						    // label
						    JLabel label = new JLabel("Grafica Reservas por mes", SwingConstants.CENTER);
						    frame.add(label, BorderLayout.SOUTH);

						    // Display the window.
						    frame.pack();
						    frame.setVisible(true);
						    
						    
						    frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
						    
						  }
						});
			
		}
	}
	
	
	

	
	
	
}
