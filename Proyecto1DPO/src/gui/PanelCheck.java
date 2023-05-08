package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import console.MenuRecepcionista;

public class PanelCheck extends JPanel implements ActionListener {

    private Campo numeroDocRes;
    private NormalButton btn;
    private MenuRecepcionista menuRecep;

    public PanelCheck(MenuRecepcionista menuRecep) {
        menuRecep = menuRecep;

        setLayout(new BorderLayout());

        JPanel central = new JPanel(new GridLayout(4, 1, 110, 200));

        JPanel titulo = new JPanel();
        titulo.setBackground(new Color(23, 35, 31));
        JLabel label = new JLabel("Realizar Checkout");
        label.setFont(new Font("Roboto", Font.BOLD, 30));
        label.setForeground(Color.white);
        titulo.add(label);
        central.add(titulo);
        JLabel msg = new JLabel("Documento del huesped encargado:");
        numeroDocRes = new Campo(20, "Documento");
        central.add(msg);
        central.add(numeroDocRes);

        add(central, BorderLayout.CENTER);

        JPanel sur = new JPanel(new FlowLayout());
        btn = new NormalButton("OK");
        btn.addActionListener(this);
        sur.add(btn);
        add(sur, BorderLayout.SOUTH);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            menuRecep.realizarCheckOut(numeroDocRes.getText());
        }
    }
}
