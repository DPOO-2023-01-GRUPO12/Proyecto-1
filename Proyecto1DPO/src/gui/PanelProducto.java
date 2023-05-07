package gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelProducto extends JPanel implements{
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

    public PanelProducto() {
        setLayout(new GridLayout(4, 2));
        ButtonGroup bg = new ButtonGroup();
        JPanel cas1 = new JPanel(new FlowLayout());
        nombre = new JRadioButton("Nombre");
        bg.add(nombre);
        campoNom = new Campo(15, "");
        cas1.add(nombre);
        cas1.add(campoNom);

        JPanel cas2 = new JPanel(new FlowLayout());
        tarifa = new JRadioButton("Tarifa");
        bg.add(tarifa);
        campoTar = new Campo(15, "");
        cas2.add(tarifa);
        cas2.add(campoTar);

        JPanel cas3 = new JPanel(new FlowLayout());
        rango = new JRadioButton("Rango");
        bg.add(rango);
        campoRan = new Campo(15, "");
        cas3.add(rango);
        cas3.add(campoRan);

        JPanel cas4 = new JPanel(new FlowLayout());
        comida = new JRadioButton("Comida");
        bg.add(comida);
        campoCom = new Campo(15, "");
        cas4.add(comida);
        cas4.add(campoCom);

        JPanel cas5 = new JPanel(new FlowLayout());
        lugar = new JRadioButton("Lugar");
        bg.add(lugar);
        campoLug = new Campo(15, "");
        cas5.add(lugar);
        cas5.add(campoLug);

        JPanel cas6 = new JPanel(new FlowLayout());
        servicioCuarto = new JRadioButton("Servicio de cuarto");
        bg.add(servicioCuarto);
        campoSerCu = new Campo(15, "");
        cas6.add(servicioCuarto);
        cas6.add(campoSerCu);

        setVisible(true);
    }
}
