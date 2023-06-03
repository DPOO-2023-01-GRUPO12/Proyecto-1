package gui;

import java.awt.AlphaComposite;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.*;

import javax.swing.*;

public class RoundedButtonHues extends JButton{
    private static final Color BACKGROUND_COLOR = new Color(255,255,255);
    private static final int ARC_WIDTH = 40;
    private static final int ARC_HEIGHT = 40;

    public RoundedButtonHues(String label) {
        super(label);
        setOpaque(false);
        setFont(new Font("Roboto", Font.BOLD, 14));
        setUI(new RoundedButtonUI());

     // Add a mouse listener to handle button press/release events
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(new Color(196,250,240));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(BACKGROUND_COLOR);
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


