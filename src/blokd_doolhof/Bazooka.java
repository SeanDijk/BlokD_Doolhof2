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
       
    public Bazooka()
    {
        imagePath = "Img/Bazooka.png";
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
        Speler.pickup = this;        
    }

    @Override
    public void doActionpickup(Veld veldraket)
    {
        Raket raket = new Raket(veldraket);
    }
    
}
