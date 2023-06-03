package gui;

import java.awt.Graphics;

import javax.swing.AbstractButton;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;

public class RoundedButtonUI extends BasicButtonUI 
{
    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton button) {
        // Do not paint the default button pressed state
    }
}
