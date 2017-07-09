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
    static boolean dragIndex = false; //true, если перетаскивается объект
    public GameGUI gameGUI = new GameGUI();
    public JPanel mainPanel;
    public static Color backgroundColor = new Color(29, 14, 16);
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

        repaint();
    }

    public class MouseHandler implements MouseListener, MouseMotionListener{

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("нажата");
            mouseIndex = true;
            if((mouseIndex==true)&&(((e.getX()>=80)&&(e.getX()<=105))&&((e.getY()>=100)&&(e.getY()<=120))))
                dragIndex = true;

            if ((GameGUI.indOfGO == true)&&(((e.getX()>=310)&&(e.getX()<=490))&&((e.getY()>=300)&&(e.getY()<=380))))
                System.out.println("!!!!!");

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("отпущена");
            mouseIndex = false;
            dragIndex = false;
            repaint();

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
