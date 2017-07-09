package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by eliseyts on 09.07.17.
 */
public class GameOverGUI {

    public Color bckgColor = new Color(115, 6, 9);
    public void gameOverGUI(Graphics g){
        g.setColor(GameExplorer.backgroundColor);
        g.fillRect(0,0, 800,600);
        Font font = new Font("Tahoma", Font.BOLD|Font.ITALIC, 80);
        g.setFont(font);
        g.setColor(bckgColor);
        g.drawString("GAME OVER", 150,200);
        BufferedImage restartButton = null;
        try
        {
            restartButton = ImageIO.read(new File("images/restartButton.png"));
        } catch (IOException e){e.printStackTrace();}
        g.drawImage(restartButton,310,300,180,80,null);
    }
}
