package graphics;

import javax.swing.*;

public class SupportModel {

    private JButton btnSubmit;
    private JButton back;
    //init text
    private JLabel lblDescription;

    //private String securityQuestions;

    private JFormattedTextField description;
    private JComboBox probArea;

    public JButton getBtnSubmit() {
        return btnSubmit;
    }

    public void setBtnSubmit(JButton btnSubmit) {
        this.btnSubmit = btnSubmit;
    }

    public JLabel getLblDescription() {
        return lblDescription;
    }

    public void setLblDescription(JLabel lblDescription) {
        this.lblDescription = lblDescription;
    }

    public JFormattedTextField getDescription() {
        return description;
    }

    public void setDescription(JFormattedTextField description) {
        this.description = description;
    }

    public JComboBox getProbArea() {
        return probArea;
    }

    public void setProbArea(JComboBox probArea) {
        this.probArea = probArea;
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }
}