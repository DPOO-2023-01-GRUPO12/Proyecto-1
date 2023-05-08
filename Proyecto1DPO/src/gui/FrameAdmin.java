package gui;

import java.awt.*;

import javax.swing.*;

import console.MenuAdministrador;
import model.PMS;

public class FrameAdmin extends JFrame {
    private PanelInfo panelInfo;
    private PanelArchivos panelArchivos;
    private PanelCrearHabitacion panelHabitacion;
    private PMS sistema;
    private MenuAdministrador menuAdmin;
    private PanelTipoHabitacion panelTipoHabitacion;
    private PanelConfigurar panelConfigurar;

    public FrameAdmin(PMS pms) {

        sistema = pms;
        menuAdmin = new MenuAdministrador(pms.getCargador(), pms);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 900);

        setLayout(new BorderLayout());
        JPanel arriba = new JPanel();
        arriba.setBackground(new Color(23, 35, 31));

        PanelOpciones panelOpciones = new PanelOpciones(this);

        panelInfo = new PanelInfo(this);
        panelArchivos = new PanelArchivos(this, sistema);

        add(arriba, BorderLayout.NORTH);
        add(panelOpciones, BorderLayout.WEST);
        add(panelInfo, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void mostrarUsuario() {
        if (panelTipoHabitacion != null) {
            panelTipoHabitacion.setVisible(false);
        }
        if (panelArchivos != null) {
            panelArchivos.setVisible(false);
        }
        if (panelHabitacion != null) {
            panelHabitacion.setVisible(false);
        }
        if (panelConfigurar != null) {
            panelConfigurar.setVisible(false);
        }
        panelInfo.setVisible(true);
        add(panelInfo, BorderLayout.CENTER);

    }

    public void cerrar() {
        dispose();
    }

    public void mostrarArchivos() {
        if (panelInfo != null) {
            panelInfo.setVisible(false);
        }
        if (panelTipoHabitacion != null) {
            panelTipoHabitacion.setVisible(false);
        }
        if (panelHabitacion != null) {
            panelHabitacion.setVisible(false);
        }
        if (panelConfigurar != null) {
            panelConfigurar.setVisible(false);
        }
        panelArchivos.setVisible(true);
        add(panelArchivos, BorderLayout.CENTER);

    }

    public void crearHabitacion() {
        panelHabitacion = new PanelCrearHabitacion(menuAdmin, sistema);
        if (panelInfo != null) {
            panelInfo.setVisible(false);
        }
        if (panelArchivos != null) {
            panelArchivos.setVisible(false);
        }
        if (panelTipoHabitacion != null) {
            panelTipoHabitacion.setVisible(false);
        }
        if (panelConfigurar != null) {
            panelConfigurar.setVisible(false);
        }
        panelHabitacion.setVisible(true);
        add(panelHabitacion, BorderLayout.CENTER);

    }

    public void crearTipoHabitacion() {
        panelTipoHabitacion = new PanelTipoHabitacion(menuAdmin);
        if (panelInfo != null) {
            panelInfo.setVisible(false);
        }
        if (panelArchivos != null) {
            panelArchivos.setVisible(false);
        }
        if (panelHabitacion != null) {
            panelHabitacion.setVisible(false);
        }
        if (panelConfigurar != null) {
            panelConfigurar.setVisible(false);
        }
        panelTipoHabitacion.setVisible(true);
        add(panelTipoHabitacion, BorderLayout.CENTER);

    }

    public void mostrarConfigurar() {
        panelConfigurar = new PanelConfigurar(menuAdmin, sistema);
        if (panelInfo != null) {
            panelInfo.setVisible(false);
        }
        if (panelArchivos != null) {
            panelArchivos.setVisible(false);
        }
        if (panelHabitacion != null) {
            panelHabitacion.setVisible(false);
        }
        if (panelTipoHabitacion != null) {
            panelTipoHabitacion.setVisible(false);
        }
        panelConfigurar.setVisible(true);
        add(panelConfigurar, BorderLayout.CENTER);
    }

}
