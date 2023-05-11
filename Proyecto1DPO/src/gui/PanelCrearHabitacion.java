package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import console.MenuAdministrador;
import model.Cama;
import model.PMS;
import model.TipoHabitacion;

public class PanelCrearHabitacion extends JPanel implements ActionListener {

    private NormalButton botonCrear;
    private Campo campoId;
    private Campo ubicacion;
    private Campo descripcion;

    private ButtonGroup bgCocina;
    private JRadioButton tiene;
    private JRadioButton noTiene;

    private ButtonGroup bgBalcon;
    private JRadioButton tiene1;
    private JRadioButton noTiene1;

    private ButtonGroup bgVista;
    private JRadioButton tiene2;
    private JRadioButton noTiene2;

    private JList<String> listaTipoHabs;
    private JList<String> listaCamas;

    private MenuAdministrador menuAdmin;

    public PanelCrearHabitacion(MenuAdministrador menuAdministrador, PMS pms) {
        menuAdmin = menuAdministrador;

        setLayout(new BorderLayout());
        setForeground(Color.WHITE);

        ///////////////////////////////////// Titulo frame
        JPanel panelTitulo = new JPanel();
        panelTitulo.setOpaque(true);
        Border whiteLine = BorderFactory.createLineBorder(Color.WHITE);
        panelTitulo.setBorder(whiteLine);
        panelTitulo.setBackground(new Color(6, 57, 112));
        JLabel titulo = new JLabel("Crear Habitacion", SwingConstants.CENTER);
        titulo.setFont(new Font("Roboto", Font.BOLD, 30));
        titulo.setForeground(getForeground());
        panelTitulo.add(titulo);

        add(panelTitulo, BorderLayout.NORTH);
        //////////////////////////////////////////

        JPanel general = new JPanel(new GridLayout(1, 2, 10, 10));

        ////////////////////////////////// Miramos los campos de habitacion
        JPanel campos = new JPanel(new BorderLayout());
        //campos.setPreferredSize(new Dimension(800, 900));
        //////////// Titulo Habitacion
        JLabel titleHab = new JLabel("Habitacion", SwingConstants.CENTER);
        titleHab.setFont(new Font("Roboto", Font.BOLD, 30));
        titleHab.setForeground(Color.black);
        campos.add(titleHab, BorderLayout.NORTH);
        /////////////////
        ///////////////////////////// Panel campos
        JPanel divisionesCampos = new JPanel(new GridLayout(6, 1, 10, 10));
        //divisionesCampos.setPreferredSize(new Dimension(800, 900));

        //////////////// Fields
        campoId = new Campo(15, "Identificador");
        campoId.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (campoId.getText().equals("Identificador")) {
                    campoId.setText("");
                }
            };
        });
        divisionesCampos.add(campoId);

        ubicacion = new Campo(15, "Ubicacion");
        ubicacion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (ubicacion.getText().equals("Ubicacion")) {
                    ubicacion.setText("");
                }
            };
        });
        divisionesCampos.add(ubicacion);

        descripcion = new Campo(15, "Descripcion");
        descripcion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (descripcion.getText().equals("Descripcion")) {
                    descripcion.setText("");
                }
            };
        });
        divisionesCampos.add(descripcion);

        ///////////////////

        //////////////// Buttons Cocina
        JPanel cocina = new JPanel(new BorderLayout());
        cocina.setBackground(Color.white);
        JLabel tituloCocina = new JLabel("Tiene Cocina", SwingConstants.CENTER);
        tituloCocina.setFont(new Font("Roboto", Font.BOLD, 15));
        cocina.add(tituloCocina, BorderLayout.NORTH);

        JPanel radiobuttons = new JPanel(new FlowLayout());
        radiobuttons.setBackground(Color.white);
        bgCocina = new ButtonGroup();

        tiene = new JRadioButton("Si");
        noTiene = new JRadioButton("No");
        tiene.setBackground(Color.white);
        //tiene.setPreferredSize(new Dimension(100, 10));
        noTiene.setBackground(Color.white);

        bgCocina.add(tiene);
        bgCocina.add(noTiene);
        radiobuttons.add(tiene);
        radiobuttons.add(noTiene);

        cocina.add(radiobuttons, BorderLayout.CENTER);

        divisionesCampos.add(cocina);
        //////////////////////

        ////////////////////// Buttons Balcon

        JPanel balcon = new JPanel(new BorderLayout());
        balcon.setBackground(Color.WHITE);
        JLabel tituloBalcon = new JLabel("Tiene Balcon", SwingConstants.CENTER);
        tituloBalcon.setFont(new Font("Roboto", Font.BOLD, 15));
        balcon.add(tituloBalcon, BorderLayout.NORTH);

        JPanel radiobuttons1 = new JPanel(new FlowLayout());
        radiobuttons1.setBackground(Color.WHITE);
        bgBalcon = new ButtonGroup();

        tiene1 = new JRadioButton("Si");
        noTiene1 = new JRadioButton("No");
        tiene1.setBackground(Color.WHITE);
        //tiene1.setPreferredSize(new Dimension(100, 10));
        noTiene1.setBackground(Color.WHITE);

        bgBalcon.add(tiene1);
        bgBalcon.add(noTiene1);
        radiobuttons1.add(tiene1);
        radiobuttons1.add(noTiene1);

        balcon.add(radiobuttons1, BorderLayout.CENTER);
        divisionesCampos.add(balcon);
        //////////////////////////////

        ////////////////////////////// Buttons Vista
        JPanel vista = new JPanel(new BorderLayout());
        vista.setBackground(Color.WHITE);
        JLabel tituloVista = new JLabel("Tiene Vista", SwingConstants.CENTER);
        tituloVista.setFont(new Font("Roboto", Font.BOLD, 15));
        vista.add(tituloVista, BorderLayout.NORTH);

        JPanel radiobuttons2 = new JPanel(new FlowLayout());

        radiobuttons2.setBackground(Color.WHITE);
        bgVista = new ButtonGroup();

        tiene2 = new JRadioButton("Si");
        noTiene2 = new JRadioButton("No");
        tiene2.setBackground(Color.WHITE);
        //tiene2.setPreferredSize(new Dimension(100, 10));
        noTiene2.setBackground(Color.WHITE);

        bgVista.add(tiene2);
        bgVista.add(noTiene2);
        radiobuttons2.add(tiene2);
        radiobuttons2.add(noTiene2);

        vista.add(radiobuttons2, BorderLayout.CENTER);
        /////////////////////////////////

        divisionesCampos.add(vista);
        ///////////////////////
        campos.add(divisionesCampos, BorderLayout.CENTER);
        //////////////////////////
        general.add(campos);

        ////////////////////// C
        JPanel listas = new JPanel(new GridLayout(2, 1));

        ///////////////// crear lista de tipos de habitaciones/
        JPanel tiposHabitaciones = new JPanel();
        tiposHabitaciones.setLayout(new BorderLayout());
        JLabel tituloTipoHab = new JLabel("Seleccione el tipo de habitacion", SwingConstants.CENTER);
        tituloTipoHab.setFont(new Font("Roboto", Font.BOLD, 15));
        tituloTipoHab.setBorder(null);
        tituloTipoHab.setForeground(Color.BLACK);
        tituloTipoHab.setOpaque(false);
        tiposHabitaciones.add(tituloTipoHab, BorderLayout.NORTH);

        DefaultListModel<String> lm = new DefaultListModel<>();
        listaTipoHabs = new JList<>(lm);
        listaTipoHabs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        for (TipoHabitacion tipo : pms.getTipoHabitaciones().values()) {
            lm.addElement(tipo.getNombreTipo());
        }

        JScrollPane scroll = new JScrollPane(listaTipoHabs);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tiposHabitaciones.add(scroll, BorderLayout.CENTER);

        listas.add(tiposHabitaciones);
        //////////////////////////////// crear lista camas

        JPanel camas = new JPanel();

        camas.setLayout(new BorderLayout());
        JLabel tituloCamas = new JLabel("Seleccionee la/las cama/camas", SwingConstants.CENTER);
        tituloCamas.setFont(new Font("macOS SF Pro", Font.BOLD, 15));
        tituloCamas.setBorder(null);
        tituloCamas.setForeground(Color.BLACK);
        tituloCamas.setOpaque(false);
        camas.add(tituloCamas, BorderLayout.NORTH);

        // JPanel panelLista = new JPanel();
        DefaultListModel<String> lmC = new DefaultListModel<>();
        listaCamas = new JList<>(lmC);
        for (Cama cama : pms.getCamas()) {
            lmC.addElement(cama.toString());
        }

        JScrollPane scrollC = new JScrollPane(listaCamas);
        scrollC.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollC.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        camas.add(scrollC, BorderLayout.CENTER);

        listas.add(camas);

        //////////////////////////
        general.add(listas);

        add(general, BorderLayout.CENTER);

        botonCrear = new NormalButton("CREAR");
        botonCrear.addActionListener(this);
        add(botonCrear, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonCrear) {
            String tipoSeleccionado = listaTipoHabs.getSelectedValue();
            boolean tieneCocina = false;
            boolean tieneBalcon = false;
            boolean tieneVista = false;

            if (tiene.isSelected()) {
                tieneCocina = true;
            }

            if (tiene1.isSelected()) {
                tieneBalcon = true;
            }

            if (tiene2.isSelected()) {
                tieneVista = true;
            }

            menuAdmin.crearHabitacion(campoId.getText(), ubicacion.getText(), descripcion.getText(), tieneCocina,
                    tieneBalcon, tieneVista, tipoSeleccionado, listaCamas.getSelectedIndices());

        }

    }

}
