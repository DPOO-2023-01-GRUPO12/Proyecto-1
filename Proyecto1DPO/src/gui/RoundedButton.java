package gui;

import java.awt.AlphaComposite;
import java.awt.*;

import javax.swing.*;

public class RoundedButton extends JButton{
    public RoundedButton(String label) {
        super(label);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Set alpha value for transparency
        AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
        g2d.setComposite(alpha);

        // Draw rounded rectangle with gradient background
        int arcWidth = 20;
        int arcHeight = 20;
        int shadowWidth = 2;
        int shadowHeight = 2;
        int x = shadowWidth / 2;
        int y = shadowHeight / 2;
        int width = getWidth() - shadowWidth;
        int height = getHeight() - shadowHeight;

        GradientPaint gradientPaint = new GradientPaint(0, 0, new Color(190, 190, 190), 
                                                         getWidth(), getHeight(), new Color(204, 153, 255));
        g2d.setPaint(gradientPaint);

        g2d.fillRoundRect(x, y, width, height, arcWidth, arcHeight);

        g2d.dispose();

        super.paintComponent(g);
    }
}


