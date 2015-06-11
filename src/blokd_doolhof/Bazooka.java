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

/**
 *
 * @author Sean
 */
public class Bazooka extends SpelObject implements Pickupable{
    String imagePath;
    Veld b;
    public Bazooka(Veld b)
    {
        this.b = b;
        //kleur = Color.WHITE;
        
        imagePath = "Img/Bazooka.png";
    }
    public void paintComponent(Graphics g)
    {
        tekenObject(g, imagePath);
    }

    public void tekenObject(Graphics g, String path )
    {
        BufferedImage img = null;
        try {              
                img = ImageIO.read(new File(path));            
                                
                int middleWidth = (this.getParent().getWidth()/2  - img.getWidth()/2);
                int middleHeight= (this.getParent().getHeight()/2  - img.getHeight()/2);
                                
                g.drawImage(img, middleWidth, middleHeight, null);
            } 
        catch (IOException e) {
            }
    }
    
    @Override
    public void doAction()
    {
        pickup();
        System.out.println("Bazooka opgepakt");
        disabled = true;
        
    }

    @Override
    public void pickup() 
    {
        b.speler.pickup = this;
        
    }

    @Override
    public void doActionpickup(Veld veldraket)
    {
        
        Raket raket = new Raket(veldraket);
        
    }
    
}
