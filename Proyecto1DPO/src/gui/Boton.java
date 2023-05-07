package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;

public class Boton extends JButton {
    private Shape shape;

    public Boton(String text) {
        super(text);

        setFocusable(false);

        setBackground(new Color(25, 25, 112));
        setForeground(Color.white);

        setContentAreaFilled(false);
    }

    @Override
    public void paint(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(new Color(25, 25, 112));
        } else {
            g.setColor(getBackground());
        }

        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paint(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(new Color(25, 25, 112));
        } else {
            g.setColor(getBackground());
        }

        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(new Color(25, 25, 112));
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);

    }

    @Override
    public boolean contains(int x, int y) {
        // If the button has changed size, make a new shape object.
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }
        return shape.contains(x, y);
    }

}
