package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;

import model.PMS;

public class PanelArchivos extends JPanel implements ActionListener {
    private PMS sistema;
    private NormalButton btnCargar;

    public PanelArchivos(FrameAdmin frameAdmin, PMS pms) {
        this.sistema = pms;
        setLayout(new BorderLayout());
        setForeground(Color.WHITE);

        JPanel panelTitulo = new JPanel();
        panelTitulo.setOpaque(true);
        Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);
        panelTitulo.setBorder(whiteLine);
        panelTitulo.setBackground(new Color(6, 57, 112));
        JLabel titulo = new JLabel("Cargar Archivos", SwingConstants.CENTER);
        titulo.setFont(new Font("Roboto", Font.BOLD, 30));
        titulo.setForeground(getForeground());
        panelTitulo.add(titulo);

        add(panelTitulo, BorderLayout.NORTH);
        
        btnCargar = new NormalButton("CARGAR");
        btnCargar.addActionListener(this);
        add(btnCargar,BorderLayout.CENTER);
        
        

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
	if(e.getSource()==btnCargar) {
	    String[] pathNames = { "Proyecto1DPO", "data"};
	        String path = String.join(File.separator, pathNames);
	        JFileChooser fc = new JFileChooser(path);
	        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        fc.setDialogTitle("Seleccione los archivos a cargar");
	        fc.setApproveButtonText("Cargar");
	        fc.setApproveButtonToolTipText("Cargar los archivos seleccionados");
	        

	        
	        FileFilter filtroTXT = new FileFilter() {

	            public boolean accept(File file) {

	                if (file.getName().endsWith(".txt")) {
	                    return true;
	                }

	                return false;
	            }

	            public String getDescription() {
	                return "Archivos de texto TXT (*.txt)";
	            }
	        };
	        fc.setFileFilter(filtroTXT);
	        


	        //fc.setMultiSelectionEnabled(true);
	        
	        fc.setFileHidingEnabled(true);
	        /// fc.setFileFilter(new FiltroArchivos());
	        /// fc.setAcceptAllFileFilterUsed(false);
	        /// fc.setAccessory(new PanelVistaPrevia(fc));
	        int resultado = fc.showOpenDialog(this);
	        if (resultado == JFileChooser.APPROVE_OPTION) {
	            File archivoHotel = fc.getSelectedFile();
		    try
		    {
			sistema.getCargador().cargarInformacionHotel(archivoHotel);
		    } catch (IOException e1)
		    {
			System.out.println("No se cargó el archivo");
		    }
	        }
	    
	}
        

        

    }

}
