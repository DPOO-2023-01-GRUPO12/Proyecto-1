package gui;

import java.io.IOException;

import javax.swing.*;

import org.knowm.xchart.*;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.XYChart;

public class GraficasProductos {
	
	
	
	public GraficasProductos() {
	
		double[] xData = new double[] { 0.0, 1.0, 2.0 };
		double[] yData = new double[] { 2.0, 1.0, 0.0 };

		// Create Chart
		XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);

		// Show it
		new SwingWrapper<XYChart>(chart).displayChart();

	
	}
	
	
	public static void main(String[] args) {
		GraficasProductos g = new GraficasProductos();
	}
	

}
