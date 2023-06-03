package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Habitacion;
import model.PMS;
import model.TarifaCuarto;

public class PanelDisponibilidad extends JPanel implements ActionListener, ListSelectionListener
{
    private PMS pms;
    private Campo fechas;
    private RoundedButton btnBuscar;
    private RoundedButton btnSelect;
    private JList<Habitacion> listaHabs;
    private DefaultListModel<Habitacion> lm;
    
    public PanelDisponibilidad(PMS pms)
    {
	this.pms = pms;
	
	setLayout(new BorderLayout());
	
	//Filtrar fechas
	
	JPanel panelFechas = new JPanel();
	panelFechas.setLayout(new FlowLayout());
	
	fechas = new Campo(30, "Inicio - fin (15/10/2023-20/10/2023)");
	btnBuscar = new RoundedButton("SEARCH");
	btnBuscar.addActionListener(this);
	btnBuscar.setFont(new Font("Roboto",getFont().BOLD,14));
	btnBuscar.setBackground(new Color(0,0,0));
	btnBuscar.setFocusPainted(false);
	btnBuscar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
	
	panelFechas.add(fechas);
	panelFechas.add(btnBuscar);
	
	add(panelFechas,BorderLayout.NORTH);
	
	///lista
	
	
	JPanel panelLista = new JPanel(new GridLayout(1,3));
	
	lm = new DefaultListModel<>();
        listaHabs = new JList<>(lm);
        listaHabs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaHabs.addListSelectionListener(this);
        //listaHabs.setVisible(false);
        
        
        for (Habitacion hab : pms.getInventarioHabitaciones().values()) {
            lm.addElement(hab);
        }

        JScrollPane scroll = new JScrollPane(listaHabs);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelLista.add(scroll);
	
	
	add(panelLista,BorderLayout.CENTER);
	
	
	
	///Boton reserva
	btnSelect = new RoundedButton("SELECT");
	btnSelect.setFont(new Font("Roboto",getFont().BOLD,14));
	btnSelect.setBackground(new Color(0,0,0));
	btnSelect.setFocusPainted(false);
	btnSelect.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
	
	btnSelect.setEnabled(false);
	btnSelect.addActionListener(this);
	
	add(btnSelect,BorderLayout.SOUTH);
	
	
	setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
	if(e.getSource()==btnBuscar) {
	    
	    String[] dias = (fechas.getText().strip()).split("-");
	    String fechaIn = dias[0];
	    String fechaOut = dias[1];
	    
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate initialDate = LocalDate.parse(fechaIn, formatter);
	    LocalDate finalDate = LocalDate.parse(fechaOut, formatter);
	    
	    
	    for(int i = 0; i < lm.getSize();i++) {
		Habitacion hab = lm.getElementAt(i);
		boolean sirve = true;
		boolean funciona = true;
		if(hab.getFechasBloqueadas().contains(fechas.getText().strip())) {
		    lm.removeElementAt(i);
		} else {
		    for(TarifaCuarto tar: hab.getTipoHabitacion().getTarifas()) {
		    	String[] rango2 = tar.getRangoFechas().split("-");
		    	String range2InitialDateStr = rango2[0];
		    	String range2FinalDateStr = rango2[1];
		    	LocalDate range2InitialDate = LocalDate.parse(range2InitialDateStr, formatter);
		        LocalDate range2FinalDate = LocalDate.parse(range2FinalDateStr, formatter);
		        
		       
		        funciona = (initialDate.isEqual(range2InitialDate) && finalDate.isEqual(range2FinalDate)) ||
		        	( (initialDate.isAfter(range2InitialDate) && initialDate.isBefore(finalDate) ) && (finalDate.isBefore(range2FinalDate) && finalDate.isAfter(range2InitialDate)));
		        	
		        	
		        	
	
		        
		    }
		    if(!funciona) {
			lm.removeElementAt(i);
		    }
		    
		}
		
	    }
	    
	    
	    
	    
	    listaHabs.setVisible(true);
	    
	} else if(e.getSource()==btnSelect) {
	    Habitacion habitacion = lm.getElementAt(listaHabs.getSelectedIndex());
	    
	}
	
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == listaHabs) {
            // Check if the JList selection is not empty
            boolean empty = listaHabs.isSelectionEmpty();
            if(!empty) {
        	
        	btnSelect.setEnabled(true);
            } else {
        	btnSelect.setEnabled(false);
            }

        }
    }

}
