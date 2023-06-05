package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

public class RoundedButton extends JButton{
    private static final Color BACKGROUND_COLOR = new Color(37,150,190);
    private static final int ARC_WIDTH = 20;
    private static final int ARC_HEIGHT = 20;
    
    public RoundedButton(String label) {
        super(label);
        setOpaque(false);
        setFont(new Font("Roboto", Font.BOLD, 14));
        setUI(new RoundedButtonUI());
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(new Color(1,60,162));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(new Color(2,94,254));
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Enable antialiasing for smoother edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw rounded rectangle with background color
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), ARC_WIDTH, ARC_HEIGHT));

        g2d.dispose();

        super.paintComponent(g);
    }
}


