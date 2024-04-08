package org.example;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public Game game;
    ConfigPanel configPanel;
    ControlPanelBottom controlPanelBottom;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        configPanel = new ConfigPanel(this,10);
        controlPanelBottom = new ControlPanelBottom(this); // For Save and Load
        canvas = new DrawingPanel(this);

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanelBottom, BorderLayout.SOUTH);


        //invoke the layout manager
        pack();
        setSize(new Dimension(1000, 700));
    }


}
