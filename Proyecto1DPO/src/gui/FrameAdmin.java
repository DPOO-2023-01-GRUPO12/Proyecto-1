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

    public FrameAdmin(PMS pms) {

        sistema = pms;
        menuAdmin = new MenuAdministrador(pms.getCargador(), pms);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 900);

        setLayout(new BorderLayout());
        JPanel arriba = new JPanel();

        PanelOpciones panelOpciones = new PanelOpciones(this);

        panelInfo = new PanelInfo(this);
        panelArchivos = new PanelArchivos(this);
        panelHabitacion = new PanelCrearHabitacion(menuAdmin, sistema.getTipoHabitaciones().values(),
                sistema.getCamas());

        add(arriba, BorderLayout.NORTH);
        add(panelOpciones, BorderLayout.WEST);
        add(panelInfo, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void mostrarUsuario() {
        panelHabitacion.setVisible(false);
        panelArchivos.setVisible(false);
        panelInfo.setVisible(true);
        add(panelInfo, BorderLayout.CENTER);

    }

    public void cerrar() {
        dispose();
    }

    public void mostrarArchivos() {
        panelInfo.setVisible(false);
        panelHabitacion.setVisible(false);
        panelArchivos.setVisible(true);
        add(panelArchivos, BorderLayout.CENTER);

    }

    public void crearHabitacion() {
        panelInfo.setVisible(false);
        panelArchivos.setVisible(false);
        panelHabitacion.setVisible(true);
        add(panelHabitacion, BorderLayout.CENTER);

    }

}
