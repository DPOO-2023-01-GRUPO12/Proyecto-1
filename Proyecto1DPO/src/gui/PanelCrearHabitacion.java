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
    private Campo tamañoMetros;
    private Campo tamañoCama;
    private Campo voltajeAC;
    

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
        
        
        tamañoMetros = new Campo(15, "Tamaño en metrocuadrados");
        tamañoMetros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tamañoMetros.getText().equals("Tamaño en metrocuadrados")) {
                	tamañoMetros.setText("");
                }
            };
        });
        divisionesCampos.add(tamañoMetros);
        
        
        
        tamañoCama = new Campo(15, "Tamaño Cama");
        tamañoCama.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tamañoCama.getText().equals("Tamaño Cama")) {
                	tamañoCama.setText("");
                }
            };
        });
        divisionesCampos.add(tamañoCama);
        
        
        
        voltajeAC = new Campo(15, "Voltaje AC");
        voltajeAC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (voltajeAC.getText().equals("Voltaje AC")) {
                	voltajeAC.setText("");
                }
            };
        });
        divisionesCampos.add(voltajeAC);
        
        

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
            DialogOpcHabitacion n = new DialogOpcHabitacion(menuAdmin);
        }

    }

}
