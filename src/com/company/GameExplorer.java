package com.company;

import com.apple.laf.AquaTabbedPaneUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ColorModel;
import java.awt.image.Raster;

public class GameExplorer extends JFrame{

    static int xx=90;
    static int yy=90;
    static boolean mouseIndex = false; //true, если была зажата
    public GameGUI gameGUI = new GameGUI();
    public JPanel mainPanel;
    public Color backgroundColor = new Color(29, 14, 16);
    public Color backgroundCdfolor = new Color(250, 250, 250);
    GameExplorer(){
        super("Funny Game");
        setBounds(200,200,800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        mainPanel=  new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(backgroundColor);
        mainPanel.add(gameGUI, BorderLayout.CENTER);

        this.addMouseListener(new MouseHandler());
        this.addMouseMotionListener(new MouseHandler());

        setContentPane(mainPanel);
        setVisible(true);

    }

    public class MouseHandler implements MouseListener, MouseMotionListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(e.getX()+" "+e.getY());

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            xx = e.getX();
            yy = e.getY();
            mouseIndex = true;
            System.out.println(xx + " " + yy);

            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
    public static void main(String[] args) {
        new GameExplorer();
    }
}
