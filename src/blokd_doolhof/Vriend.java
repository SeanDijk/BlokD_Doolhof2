/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import static blokd_doolhof.BlokD_Doolhof.frame;

/**
 *
 * @author Sean
 */
public class Vriend extends SpelObject{
    Veld v;
    String imagePath;
    public Vriend(Veld v)
    {
        this.v = v;
        imagePath = "Img/Vriend.png";
        
    }
    @Override
    public void paintComponent(Graphics g)
    {
        tekenObject(g, imagePath);
    }

    @Override
    public void doAction()
    {
        
        System.out.println("Gewonnen!!");
        v.speler.winAnimation(0);
        JOptionPane.showMessageDialog(BlokD_Doolhof.frame, "Level gehaald in " + Speler.aantalStappen + " Stappen!");
        BlokD_Doolhof.frame.setVisible(false);
    }
}
