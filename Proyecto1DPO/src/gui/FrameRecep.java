package gui;

import java.awt.*;

import javax.swing.*;

import console.MenuAdministrador;
import console.MenuRecepcionista;
import model.PMS;

public class FrameRecep extends JFrame {
    private PanelInfo panelInfo;

    private PMS sistema;
    private MenuRecepcionista menuRecep;
    private PanelConsulta panelConsulta;
    private PanelReserva panelReserva;
    private PanelRegistro panelRegistro;

    public FrameRecep(PMS pms) {

        sistema = pms;
        menuRecep = new MenuRecepcionista(pms.getCargador(), pms);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 900);

        setLayout(new BorderLayout());
        JPanel arriba = new JPanel();

        PanelOpcionesRecep panelOpcionesRecep = new PanelOpcionesRecep(this);

        panelInfo = new PanelInfo(this);

        // panelArchivos = new PanelArchivos(this);
        // panelHabitacion = new PanelCrearHabitacion(menuAdmin,
        // sistema.getTipoHabitaciones().values(),
        // sistema.getCamas());
        // panelTipoHabitacion = new PanelTipoHabitacion(menuAdmin);
        // panelConfigurar = new PanelConfigurar(menuAdmin,
        // sistema.getMenuBebidas().values(),
        // sistema.getMenuPlatos().values(), sistema.getServicios().values());

        add(arriba, BorderLayout.NORTH);
        add(panelOpcionesRecep, BorderLayout.WEST);
        add(panelInfo, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void mostrarUsuario() {
        if (panelConsulta != null) {
            panelConsulta.setVisible(false);
        }
        if (panelRegistro != null) {
            panelRegistro.setVisible(false);
        }
        if (panelReserva != null) {
            panelReserva.setVisible(false);
        }
        panelInfo.setVisible(true);
        add(panelInfo, BorderLayout.CENTER);

    }

    public void consultarHabitaciones() {
        panelConsulta = new PanelConsulta(sistema);
        if (panelInfo != null) {
            panelInfo.setVisible(false);
        }
        if (panelRegistro != null) {
            panelRegistro.setVisible(false);
        }
        if (panelReserva != null) {
            panelReserva.setVisible(false);
        }
        panelConsulta.setVisible(true);
        add(panelConsulta, BorderLayout.CENTER);
    }

    public void hacerReserva() {
        panelReserva = new PanelReserva();
        if (panelInfo != null) {
            panelInfo.setVisible(false);
        }
        if (panelRegistro != null) {
            panelRegistro.setVisible(false);
        }
        if (panelConsulta != null) {
            panelConsulta.setVisible(false);
        }
        add(panelReserva, BorderLayout.CENTER);

    }

    public void hacerRegistro() {
        panelRegistro = new PanelRegistro(menuRecep);
        if (panelInfo != null) {
            panelInfo.setVisible(false);
        }
        if (panelReserva != null) {
            panelReserva.setVisible(false);
        }
        if (panelConsulta != null) {
            panelConsulta.setVisible(false);
        }
        panelRegistro.setVisible(true);
        add(panelRegistro, BorderLayout.CENTER);
    }

    public void cerrar() {
        dispose();
    }

    public static void main(String[] args) {
        new FrameRecep(new PMS());

    }

}
