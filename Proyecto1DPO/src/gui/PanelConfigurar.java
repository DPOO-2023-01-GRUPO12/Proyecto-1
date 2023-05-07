package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;

import javax.swing.*;

import console.MenuAdministrador;
import model.Bebida;
import model.Plato;
import model.Servicio;

public class PanelConfigurar extends JPanel implements ActionListener {

    private MenuAdministrador menuAdmin;
    private JList<String> listaBebidas;
    private JList<String> listaPlatos;
    private JTextArea infoProducto;
    private JRadioButton bebida;
    private JRadioButton plato;
    private JRadioButton servicio;
    private Campo campo;
    private NormalButton botonBuscar;
    private Collection<Bebida> colBebidas;
    private Collection<Plato> colPlatos;
    private Collection<Servicio> colServicios;
    private JLabel cambiarPlato;
    private JLabel cambiarBebida;
    private JLabel cambiarSevicio;
    private JPanel cardPanel;
    private CardLayout cl;
    private Campo campoTarifaServicio;
    private NormalButton botonCambiar;

    private JRadioButton nombre;
    private Campo campoNom;
    private JRadioButton tarifa;
    private Campo campoTar;
    private JRadioButton rango;
    private Campo campoRan;
    private JRadioButton comida;
    private Campo campoCom;
    private JRadioButton lugar;
    private Campo campoLug;
    private JRadioButton servicioCuarto;
    private Campo campoSerCu;

    private JPanel fieldsProducto;
    private JPanel tarifaServicio;
    private JPanel derecha;

    public PanelConfigurar(MenuAdministrador menuAdministrador, Collection<Bebida> colBebidas,
            Collection<Plato> colPlatos, Collection<Servicio> colServicios) {
        menuAdmin = menuAdministrador;
        this.colBebidas = colBebidas;
        this.colPlatos = colPlatos;

        setLayout(new GridLayout(1, 2, 20, 20));

        /////
        derecha = new JPanel(new BorderLayout());

        cambiarPlato = new JLabel("Modificar Plato");
        cambiarBebida = new JLabel("Modificar Bebida");
        cambiarSevicio = new JLabel("Modificar Bebida");

        // cardPanel = new JPanel();
        // cl = new CardLayout();
        // cardPanel.setLayout(cl);

        fieldsProducto = new JPanel(new GridLayout(3, 2));
        fieldsProducto.setVisible(false);
        ButtonGroup g = new ButtonGroup();
        JPanel cas1 = new JPanel(new FlowLayout());
        nombre = new JRadioButton("Nombre");
        g.add(nombre);
        campoNom = new Campo(15, "");
        cas1.add(nombre);
        cas1.add(campoNom);

        fieldsProducto.add(cas1);

        JPanel cas2 = new JPanel(new FlowLayout());
        tarifa = new JRadioButton("Tarifa");
        g.add(tarifa);
        campoTar = new Campo(15, "");
        cas2.add(tarifa);
        cas2.add(campoTar);

        fieldsProducto.add(cas2);

        JPanel cas3 = new JPanel(new FlowLayout());
        rango = new JRadioButton("Rango");
        g.add(rango);
        campoRan = new Campo(15, "");
        cas3.add(rango);
        cas3.add(campoRan);

        fieldsProducto.add(cas3);

        JPanel cas4 = new JPanel(new FlowLayout());
        comida = new JRadioButton("Comida");
        g.add(comida);
        campoCom = new Campo(15, "");
        cas4.add(comida);
        cas4.add(campoCom);

        fieldsProducto.add(cas4);

        JPanel cas5 = new JPanel(new FlowLayout());
        lugar = new JRadioButton("Lugar");
        g.add(lugar);
        campoLug = new Campo(15, "");
        cas5.add(lugar);
        cas5.add(campoLug);

        fieldsProducto.add(cas5);

        JPanel cas6 = new JPanel(new FlowLayout());
        servicioCuarto = new JRadioButton("Servicio de cuarto");
        g.add(servicioCuarto);
        campoSerCu = new Campo(15, "");
        cas6.add(servicioCuarto);
        cas6.add(campoSerCu);

        fieldsProducto.add(cas6);

        derecha.add(fieldsProducto, BorderLayout.CENTER);
        add(derecha);

        tarifaServicio = new JPanel(new GridLayout(2, 1, 10, 10));
        tarifaServicio.setVisible(false);
        JLabel tituloTarifa = new JLabel("Ingrese nueva tarifa:");
        tarifaServicio.add(tituloTarifa);
        campoTarifaServicio = new Campo(15, "Tarifa Nueva");
        campoTarifaServicio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (campoTarifaServicio.getText().equals("Tarifa Nueva")) {
                    campoTarifaServicio.setText("");
                }
            };
        });
        tarifaServicio.add(campoTarifaServicio);

        derecha.add(tarifaServicio, BorderLayout.CENTER);

        botonCambiar = new NormalButton("CAMBIAR");
        botonCambiar.addActionListener(this);
        derecha.add(botonCambiar, BorderLayout.SOUTH);
        add(derecha);
        //////
        JPanel panelSeleccionar = new JPanel(new BorderLayout());

        // Buscar prodcuto de menu
        JPanel buscarProducto = new JPanel(new FlowLayout());

        ButtonGroup bg = new ButtonGroup();
        bebida = new JRadioButton("Bebida");
        bebida.addActionListener(null);
        plato = new JRadioButton("Plato");
        servicio = new JRadioButton("Servicio");

        bg.add(plato);
        bg.add(bebida);
        bg.add(servicio);

        buscarProducto.add(plato);
        buscarProducto.add(bebida);
        buscarProducto.add(servicio);

        campo = new Campo(15, "Nombre");
        campo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (campo.getText().equals("Nombre")) {
                    campo.setText("");
                }
            };
        });

        buscarProducto.add(campo);

        botonBuscar = new NormalButton("BUSCAR");
        botonBuscar.addActionListener(this);
        buscarProducto.add(botonBuscar);

        panelSeleccionar.add(buscarProducto, BorderLayout.NORTH);

        /////

        infoProducto = new JTextArea();
        infoProducto.setEditable(false);
        infoProducto.setLineWrap(true);
        infoProducto.setWrapStyleWord(true);
        infoProducto.setFont(new Font("Arial", Font.PLAIN, 20));

        panelSeleccionar.add(infoProducto);

        add(panelSeleccionar);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonBuscar) {
            if (bebida.isSelected()) {
                for (Bebida beb : colBebidas) {
                    if (beb.getNombre().equals(campo.getText())) {
                        infoProducto.setText(beb.toString());
                    }
                }

                fieldsProducto.setVisible(true);
            } else if (plato.isSelected()) {
                for (Plato pl : colPlatos) {
                    if (pl.getNombre().equals(campo.getText())) {
                        infoProducto.setText(pl.toString());
                    }
                }
                fieldsProducto.setVisible(true);
                derecha.add(fieldsProducto, BorderLayout.CENTER);
                add(derecha);

            } else if (servicio.isSelected()) {
                for (Servicio ser : colServicios) {
                    if (ser.getNombreTipo().equals(campo.getText())) {
                        infoProducto.setText(ser.toString());
                    }
                }

                tarifaServicio.setVisible(true);
                derecha.add(tarifaServicio, BorderLayout.CENTER);
                add(derecha);

            }

        } else if (e.getSource() == botonCambiar) {
            if (bebida.isSelected()) {
                if (nombre.isSelected()) {
                    menuAdmin.configurarBebidaNombre(campo.getText(), campoNom.getText());
                } else if (tarifa.isSelected()) {
                    menuAdmin.configurarBebidaTarifa(campo.getText(), Double.parseDouble(campoTar.getText()));
                } else if (rango.isSelected()) {
                    menuAdmin.configurarBebidaRangoHoras(campo.getText(), campoRan.getText());
                } else if (comida.isSelected()) {
                    menuAdmin.configurarBebidaDisponibilidadComida(campo.getText(), campoCom.getText());
                } else if (lugar.isSelected()) {
                    menuAdmin.configurarBebidaDisponibilidadLugar(campo.getText(), campoLug.getText());
                } else if (servicioCuarto.isSelected()) {
                    menuAdmin.configurarBebidaDisponibilidadServicioCuarto(campo.getText(),
                            Boolean.parseBoolean(campoSerCu.getText()));
                }
            } else if (plato.isSelected()) {
                if (nombre.isSelected()) {
                    menuAdmin.configurarPlatoNombre(campo.getText(), campoNom.getText());
                } else if (tarifa.isSelected()) {
                    menuAdmin.configurarPlatoTarifa(campo.getText(), Double.parseDouble(campoTar.getText()));
                } else if (rango.isSelected()) {
                    menuAdmin.configurarPlatoRangoHoras(campo.getText(), campoRan.getText());
                } else if (comida.isSelected()) {
                    menuAdmin.configurarPlatoDisponibilidadComida(campo.getText(), campoCom.getText());
                } else if (lugar.isSelected()) {
                    menuAdmin.configurarPlatoDisponibilidadLugar(campo.getText(), campoLug.getText());
                } else if (servicioCuarto.isSelected()) {
                    menuAdmin.configurarPlatoDisponibilidadServicioCuarto(campo.getText(),
                            Boolean.parseBoolean(campoSerCu.getText()));
                }

            } else if (servicio.isSelected()) {
                menuAdmin.cambiarTarifaServicio(campo.getText(), Double.parseDouble(campoTarifaServicio.getText()));
            }
        }

    }

}
