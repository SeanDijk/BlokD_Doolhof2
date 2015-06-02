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
import javax.swing.JComponent;

/**
 *
 * @author Sean
 */
public class Speler extends JComponent implements Mover{
    Veld huidigveld;
    static int aantalStappen=0;
    static Pickupable pickup;
    
    
    public Speler()
    {
        addKeyListener(key);
    }
    @Override
    public void paintComponent(Graphics g)
    {
            g.setColor(Color.green);           
            g.fillOval(0, 0, getHuidigVeld().getWidth(), getHuidigVeld().getHeight());     
     
    }
    
    @Override
    public void move(String direction)
    {
        huidigveld=getHuidigVeld();
        Veld nieuwVeld = null;
        
        if("left".equals(direction))
            nieuwVeld = huidigveld.getBuur("left");
        if("right".equals(direction))
            nieuwVeld = huidigveld.getBuur("right");
        if("up".equals(direction)) 
            nieuwVeld = huidigveld.getBuur("up");        
        if("down".equals(direction))
            nieuwVeld = huidigveld.getBuur("down");      
        
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

    private Veld getHuidigVeld()
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
    private void setHuidigVeld()
    {
        huidigveld.speler =null;
        huidigveld = getHuidigVeld();
        huidigveld.speler = this;
    }
    private void setHuidigVeld(Veld veld)
    {
        huidigveld.speler =null;
        huidigveld.repaint();
        huidigveld = veld;
        huidigveld.speler = this;
    }
    
    private void spelObjectAction()
    {
        if(huidigveld.spelObject != null)
        {
            huidigveld.spelObject.doAction();
        }
    }
    
    public void BazookaAfschieten()
    {
        if (pickup != null)
                {
                    System.out.println("Schiet");
                    pickup.doActionpickup();
                    pickup = null;
                }
    }
    
    
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
                BazookaAfschieten();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    };
}
