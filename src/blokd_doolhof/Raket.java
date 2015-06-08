/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 *
 * @author Sean
 */
public class Raket extends JComponent implements Mover{
    
    Veld huidigVeld;
    String direction;
    boolean disabled = false;
    public Raket(Veld huidigVeld)
    {
       huidigVeld.Raket = this;
       huidigVeld = getHuidigVeld();
       direction = huidigVeld.speler.direction;
       
       move(direction);
    }
    @Override
    public void setHuidigVeld()
    {
        huidigVeld.Raket =null;
        huidigVeld = getHuidigVeld();
        huidigVeld.Raket = this;
    }
    
    @Override
    public Veld getHuidigVeld()
    {
        for(Veld[] rijen: Speelveld.velden)
        {
            
            for(Veld veld: rijen)
            {
               if(veld.Raket != null)
               {

                   return veld;
               }
            }
            
        }
        return null;
    }

    
    @Override
    public void setHuidigVeld(Veld veld)
    {
        huidigVeld.Raket =null;
        huidigVeld.repaint();
        huidigVeld = veld;
        huidigVeld.Raket = this;
    }
    
    @Override
    public void move(final String direction)
    {
        huidigVeld=getHuidigVeld();
        Veld nieuwVeld = null;
        
        if("left".equals(direction))
            nieuwVeld = huidigVeld.getBuur("left");
        if("right".equals(direction))
            nieuwVeld = huidigVeld.getBuur("right");
        if("up".equals(direction)) 
            nieuwVeld = huidigVeld.getBuur("up");        
        if("down".equals(direction))
            nieuwVeld = huidigVeld.getBuur("down");      
        
        if(nieuwVeld.isWalkable() == true)
        {
            
            setHuidigVeld(nieuwVeld);
            huidigVeld.repaint();
            
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
            @Override
            public void run() {
                move(direction);
            }
            }, 200);
            
            
        }
        else{
            nieuwVeld.walkable = true;
            nieuwVeld.imagePath = "Img/Path.png";
            disabled = true;
            huidigVeld.repaint();
            nieuwVeld.repaint();
        }
        
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);    
        g.fillOval(0, 0, this.getParent().getWidth(), this.getParent().getHeight());
    }
}
