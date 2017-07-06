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
    int[] arrX = {60,60,560,560,200,200,150,150,520,520};
    int[] arrY = {100,60,60,300,300,500,500,250,250,100};

    GameGUI(){
    }

    public void soundFunction(){
        try{

            AudioClip ac = Applet.newAudioClip(new URL("file:audio/doom.wav"));

            ac.loop();

        }catch(Exception e){}
    }
    public void paint(Graphics g){
        Polygon poly = new Polygon(arrX, arrY, 10);
        g.setColor(objColor);
        g.fillPolygon(poly);
        g.setColor(cursorColor);
        g.fillOval(GameExplorer.xx-5, GameExplorer.yy-30,15, 15);
        if (poly.contains(GameExplorer.xx+5,GameExplorer.yy-25)){
            g.drawString("YES",50,190);

        }
        else if (GameExplorer.mouseIndex == true) {
            drawFace(g);
            soundFunction();
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
