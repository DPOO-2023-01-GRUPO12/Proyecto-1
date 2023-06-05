package gui;

import java.awt.*;

import javax.swing.*;

import console.MenuRecepcionista;
import model.Huesped;
import model.PMS;
import model.Reserva;

public class FrameRecep extends JFrame {
    private PanelInfo panelInfo;

    private PMS sistema;
    private MenuRecepcionista menuRecep;
    private PanelConsulta panelConsulta;
    private PanelReserva panelReserva;
    private PanelRegistro panelRegistro;
    private PanelCancelar panelCancelar;
    private PanelCheck panelCheck;
    private PanelLog panelLog;
    private JPanel paneles;
    private CardLayout cardPane;

    public FrameRecep(PMS pms) {

        sistema = pms;
        menuRecep = new MenuRecepcionista(pms.getCargador(), pms);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(this.getDefaultCloseOperation()==JFrame.EXIT_ON_CLOSE) {
            cerrar();
        }
        
        int newWidth = (int) (1500 * 0.7);
        int newHeight = (int) (900 * 0.7);
        
        setSize(newWidth, newHeight);

        setLayout(new BorderLayout());
        JPanel arriba = new JPanel();
        arriba.setBackground(new Color(23, 35, 31));
        add(arriba, BorderLayout.NORTH);

        PanelOpcionesRecep panelOpcionesRecep = new PanelOpcionesRecep(this);
        add(panelOpcionesRecep, BorderLayout.WEST);
        
        cardPane =  new CardLayout();
        paneles = new JPanel();
        paneles.setVisible(true);
        paneles.setLayout(cardPane);
        
        panelInfo = new PanelInfo(this);
        paneles.add(panelInfo, "Info");
        add(paneles, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void mostrarUsuario() {
	cardPane.show(paneles,"Info");

    }

    public void consultarHabitaciones() {
        panelConsulta = new PanelConsulta(sistema);
        paneles.add(panelConsulta, "Consulta");
        cardPane.show(paneles,"Consulta");
    }

    public void hacerReserva() {
        panelReserva = new PanelReserva(this);
        paneles.add(panelReserva, "Reserva");
        cardPane.show(paneles,"Reserva");

    }

    public void hacerRegistro() {
        panelRegistro = new PanelRegistro(menuRecep);
        paneles.add(panelRegistro, "Registro");
        cardPane.show(paneles,"Registro");

    }

    public void cancelarReserva() {
        panelCancelar = new PanelCancelar(menuRecep);
        paneles.add(panelCancelar, "Cancelar");
        cardPane.show(paneles,"Cancelar");
    }

    public void hacerCheckout() {
        panelCheck = new PanelCheck(this,menuRecep);
        paneles.add(panelCheck, "Check");
        cardPane.show(paneles,"Check");
    }

    public void generarLog() {
        panelLog = new PanelLog(menuRecep);
        paneles.add(panelLog, "Log");
        cardPane.show(paneles,"Log");
    }

    public void cerrar() {
	/*
        GuardadorInformacion g = sistema.getGuardador();
        
        if(sistema.getCamas().size()>0 && sistema.getMenuBebidas().size()>0 && sistema.getMenuPlatos().size()>0) {
            g.guardarCamas();
            g.guardarConsumos();
            g.guardarHabitaciones();
            g.guardarHuespedes();
            g.guardarMenuBebidas();
            g.guardarMenuPlatos();
            g.guardarReservas();
            g.guardarServicios();
            g.guardarTarifasCuarto();
            g.guardarTipoHabitacones();
            //g.guardarUsusariosHotel();  
            
        }*/
        dispose();
    }

    

    public void realizarReserva(String nombre, String cantidadPersonas, String fechain, String fechaout) {
        int cantidad = Integer.parseInt(cantidadPersonas);
        Reserva res = menuRecep.RealizarReservaHuesped(nombre, cantidad, fechain, fechaout);
        
        

    }

    public void registroHuespedReserva(String nombre, String documento, String celular, String Correo, String edad) {
        Integer edadint = Integer.parseInt(edad);
        menuRecep.realizarRegistro(nombre, documento, celular, Correo, edadint);

    }

    public void pagoRealizado()
    {
	cerrar();
	
	
    }

    public void pagar(String documento)
    {
	Huesped huesped = sistema.getHuespedes().get(documento);
	Reserva res = menuRecep.buscarReserva(documento);
	JFrame framePago = new JFrame();
        framePago.setVisible(true);
        double montoHabitaciones = res.getTarifaTotal();
        
        PanelPago panelPagoReserva = new PanelPago(this,sistema,huesped,montoHabitaciones,0,res);
	
    }

}
