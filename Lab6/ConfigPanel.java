package org.example;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinnerCols;
    JSpinner spinnerRows;
    JButton exitBtn = new JButton("Exit");
    JButton createBtn = new JButton("Create");
    int valueGrid;

    public ConfigPanel(MainFrame frame, int valueGrid) {
        this.frame = frame;
        this.valueGrid = valueGrid;
        init();
    }
    private void init() {
        //create the label and the spinner
        label = new JLabel("Grid size:");
        spinnerCols = new JSpinner(new SpinnerNumberModel(valueGrid, 2, 100, 1));
        spinnerRows = new JSpinner(new SpinnerNumberModel(valueGrid, 2, 100, 1));
        //create spinners for rows and cols, and the button

        add(label); //JPanel uses FlowLayout by default
        add(spinnerCols);
        add(spinnerRows);
        //add exit button to the panel
        add(createBtn);
        add(exitBtn);

        //configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);
        createBtn.addActionListener(this::createGame);
    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
    private void createGame(ActionEvent e) {frame.canvas.updateBoard();}

    public int getRows() {
        return (Integer) spinnerRows.getValue();
    }

    public int getCols() {
        return (Integer) spinnerCols.getValue();
    }

}
