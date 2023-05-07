package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class GrupoBotones extends ButtonGroup {
    private List<CustomButton> buttons;
    private CustomButton selectedButton;

    public GrupoBotones() {

        buttons = new ArrayList<>();
    }

    public void add(CustomButton b) {
        super.add(b);
        if (b instanceof CustomButton) {
            buttons.add((CustomButton) b);
        }

    }

    public void setSelectedButton(CustomButton selectedButton) {
        if (selectedButton != this.selectedButton) {
            if (this.selectedButton != null) {
                this.selectedButton.setSelected(false);
            }
            this.selectedButton = selectedButton;
        }
    }

    public void clearSelection() {
        if (this.selectedButton != null) {
            this.selectedButton.setSelected(false);
            this.selectedButton = null;
        }
    }

    public CustomButton getSelectedButton() {
        return selectedButton;
    }

}
