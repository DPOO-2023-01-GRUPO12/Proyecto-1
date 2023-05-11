package gui;


import java.util.ArrayList;

import java.util.List;


import javax.swing.ButtonGroup;


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
