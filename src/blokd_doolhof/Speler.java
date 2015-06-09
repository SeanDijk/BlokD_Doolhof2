/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import static blokd_doolhof.Speelveld.velden;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Sean
 */
public class Speler extends JComponent implements Mover{
    Veld huidigveld;
    static int aantalStappen=0;
    static Pickupable pickup;
    String direction;
    String imagePath;
    String[] images;
    
    public Speler()
    {
        direction = "down";
        imagePath = "Img/Mario_South.png";
        //addKeyListener(key);
    }
    @Override
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
    public void move(String direction)
    {
        this.direction = direction;
        
        Veld nieuwVeld = null;
        
        if("left".equals(direction))
        {
            nieuwVeld = huidigveld.buurLinks;
            imagePath = "Img/Mario_West.png";
        }
        if("right".equals(direction))
        {
            nieuwVeld = huidigveld.buurRechts;
            imagePath = "Img/Mario_East.png";
        }
        if("up".equals(direction)) 
        {
            nieuwVeld = huidigveld.buurBoven; 
            imagePath = "Img/Mario_North.png";
        }
        if("down".equals(direction))
        {
            nieuwVeld = huidigveld.buurOnder;  
            imagePath = "Img/Mario_South.png";
        }
        
        if(nieuwVeld.isWalkable() == true)
        {
            setHuidigVeld(nieuwVeld);
            aantalStappen++;
            huidigveld.repaint();
            System.out.println("Moved to: "+huidigveld);
            System.out.println("Aantal stappen: " + aantalStappen);
            spelObjectAction();

        }
        else{
            huidigveld.repaint();
            System.out.println("Cant move there, it's a wall! ");
        }
        
    }
    @Override
    public Veld getHuidigVeld()
    {
        for(Veld[] rijen: velden)
        {            
            for(Veld veld: rijen)
            {
               if(veld.speler != null)
               {

                   return veld;
               }
            }
        }
        return null;
    }
    @Override
    public void setHuidigVeld()
    {
        huidigveld.speler =null;
        huidigveld = getHuidigVeld();
        huidigveld.speler = this;
    }
    @Override
    public void setHuidigVeld(Veld veld)
    {
        huidigveld.speler =null;
        huidigveld.repaint();
        huidigveld = veld;
        huidigveld.speler = this;
    }
    
    public void spelObjectAction()
    {
        if(huidigveld.spelObject != null)
        {
            huidigveld.spelObject.doAction();
        }
        
    }
    
    /*
     * Pakt gebruikt de pickup
     */
    public void usePickup(Veld pickupVeld)
    {
        
        if (pickup != null)
                {
                    System.out.println("Schiet");
                    pickup.doActionpickup(pickupVeld);
                    pickup = null;
                }
    }
    public void winAnimation(final int i )
    {
        images = new String[6];
        images[0]  ="Img/1.png";
        images[1]  ="Img/2.png";
        images[2]  ="Img/3.png";
        images[3]  ="Img/4.png";
        images[4]  ="Img/5.png";
        images[5]  ="Img/6.png";
        
        Timer timer = new Timer();
            timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(i<6)
                {
                    imagePath = images[i];
                    huidigveld.repaint();
                    winAnimation(i+1);
                }
            }
            }, 80);

    }
   
}
    
   /* 
    KeyListener key = new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            String key = Character.toString(e.getKeyChar());
            System.out.println(key);
            if("w".equals(key))
            {
                move("up");
            }
            if("a".equals(key))
            {
                move("left");
            }
            if("s".equals(key))
            {
                move("down");
            }
            if("d".equals(key))
            {
                move("right");
            }
            if("p".equals(key))
            {
                usePickup(huidigveld);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    };
    * 
    */

