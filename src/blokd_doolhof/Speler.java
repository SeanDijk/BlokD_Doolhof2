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
    
    public Speler()
    {
        direction = "down";
        
        //addKeyListener(key);
    }
    @Override
    public void paintComponent(Graphics g)
    {
        tekenObject(g);
        //g.setColor(Color.green);           
        //g.fillOval(0, 0, getHuidigVeld().getWidth(), getHuidigVeld().getHeight());   
        // g.drawImage(img, this.getParent().getWidth(), this.getParent().getHeight(), null);

    }
    public void tekenObject(Graphics g)
    {
        BufferedImage img = null;
        try {
            if("down".equals(direction))                
                img = ImageIO.read(new File("Img/Mario_South.png"));
            if("up".equals(direction))                
                img = ImageIO.read(new File("Img/Mario_North.png"));
            if("left".equals(direction))                
                img = ImageIO.read(new File("Img/Mario_West.png"));
            if("right".equals(direction))                
                img = ImageIO.read(new File("Img/Mario_East.png"));            
                
                
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
            nieuwVeld = huidigveld.buurLinks;
        if("right".equals(direction))
            nieuwVeld = huidigveld.buurRechts;
        if("up".equals(direction)) 
            nieuwVeld = huidigveld.buurBoven;        
        if("down".equals(direction))
            nieuwVeld = huidigveld.buurOnder;      
        
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
}
