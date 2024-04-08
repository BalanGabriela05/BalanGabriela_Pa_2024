package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.*;

public class ControlPanelBottom extends JPanel {
    final MainFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");


    public ControlPanelBottom(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
       // frame.setLayout(new GridLayout(1, 2));


        //add exit button to the panel
        add(loadBtn);
        add(saveBtn);

        //configure listeners for all buttons
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);

    }

    private void saveGame(ActionEvent e) {
        try {
            // Salvăm starea jocului
            FileOutputStream fileOut = new FileOutputStream("gamestate.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(frame.game);
            out.close();
            fileOut.close();

            // Exportăm tabla de joc ca imagine PNG
            BufferedImage bi = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            frame.paint(g);
            g.dispose();
            ImageIO.write(bi, "PNG", new File("gameboard.png"));
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private void loadGame(ActionEvent e) {
        try {
            // Încărcăm starea jocului
            FileInputStream fileIn = new FileInputStream("gamestate.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            frame.game = (Game) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Game class not found");
            c.printStackTrace();
        }
        frame.repaint();
    }


}
