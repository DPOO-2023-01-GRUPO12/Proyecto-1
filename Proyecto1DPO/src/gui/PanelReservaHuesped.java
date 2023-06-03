package gui;

import javax.swing.JPanel;

import model.Habitacion;
import model.PMS;

public class PanelReservaHuesped extends JPanel
{
    private VentanaHuesped ventanaHuesped;
    private PMS sistema;
    
    public PanelReservaHuesped(VentanaHuesped ventanaHuesped, PMS pms, Habitacion habitacion)
    {
	this.ventanaHuesped = ventanaHuesped;
	sistema = pms;
	
	setVisible(true);
    }

}
