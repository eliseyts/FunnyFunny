package com.company;

import com.sun.prism.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GameGUI extends JComponent{
    public Color objColor = new Color(255, 200, 115);
    public Color cursorColor = new Color(180, 50, 61);
    public static boolean indOfGO = false; //true, если игра проиграна
   // public Color curColor = new Color(180, 50, 61);
    public GameOverGUI gameOverMode = new GameOverGUI();
    int[] arrX1 = {60,60,560,560,200,200,150,150,520,520};
    int[] arrY1 = {100,60,60,300,300,500,500,250,250,100};

    int[] arrX2 = {60,60,260,260,100,100,300,300,500,500,450,450,350,350,60,60,230,230};
    int[] arrY2 = {100,60,60,300,300,400,400,200,200,500,500,250,250,450,450,250,250,100};

    int[] arrX3 = {60,60,200,200,250,250,400,400,375,375,500,500,550,550,350,350,275,275,175,175};
    int[] arrY3 = {100,60,60,250,250,100,100,200,200,325,325,200,200,350,350,150,150,300,300,100};




    GameGUI(){
        indOfGO = false;
    }

    public void soundFunction(){
        try{
            AudioClip ac = Applet.newAudioClip(new URL("file:audio/doom.wav"));
            ac.loop();
        }catch(Exception e){}
    }

    public void paint(Graphics g){
        if (indOfGO == true) gameOverMode.gameOverGUI(g);
        else {
            Polygon poly1 = new Polygon(arrX1, arrY1, 10);
            Polygon poly2 = new Polygon(arrX2, arrY2, 18);
            Polygon poly3 = new Polygon(arrX3, arrY3, 20);
            g.setColor(objColor);

            if (GameExplorer.levelIndex==1) g.fillPolygon(poly1);
            if (GameExplorer.levelIndex==2) g.fillPolygon(poly2);
            if (GameExplorer.levelIndex==3) g.fillPolygon(poly3);
            g.setColor(cursorColor);

            //проверка перемещения и нажатия мыши
            if ((GameExplorer.mouseIndex == true) && (GameExplorer.dragIndex == true)) {
                g.fillOval(GameExplorer.xx - 5, GameExplorer.yy - 30, 15, 15);
            } else g.fillOval(80, 80, 15, 15);

            g.drawString(""+GameExplorer.levelIndex, 750,60);

            if(GameExplorer.levelIndex==1)
                {
                    if (poly1.contains(GameExplorer.xx + 5, GameExplorer.yy - 25)) {g.drawString("YES", 50, 190);}
                    else if ((GameExplorer.mouseIndex == true) && (GameExplorer.dragIndex == true)) {
                        indOfGO = true;
                        //drawFace(g);
                        // soundFunction();
                    }
                }
            if(GameExplorer.levelIndex==2)
                {
                    if (poly2.contains(GameExplorer.xx + 5, GameExplorer.yy - 25)) {g.drawString("YES", 50, 190);}
                    else if ((GameExplorer.mouseIndex == true) && (GameExplorer.dragIndex == true)) {
                        indOfGO = true;
                        //drawFace(g);
                        // soundFunction();
                    }
                }

            if(GameExplorer.levelIndex==3)
                {
                    if (GameExplorer.scr == true){
                        drawFace(g);
                        soundFunction();
                    }
                    if (poly3.contains(GameExplorer.xx + 5, GameExplorer.yy - 25)) {g.drawString("YES", 50, 190);}
                    else if ((GameExplorer.mouseIndex == true) && (GameExplorer.dragIndex == true)) {
                        //indOfGO = true;
                        drawFace(g);
                        soundFunction();
                    }
                }
        }
    }

    public void drawFace(Graphics g){
        BufferedImage monster = null;
        try
        {
            monster = ImageIO.read(new File("images/monster.png"));
        } catch (IOException e){e.printStackTrace();}
        g.drawImage(monster,0,0,800,600,null);
    }

}
