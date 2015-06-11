
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Sean
 */
public class Raket extends JComponent implements Mover{
    
    Veld huidigVeld;
    String direction;
    boolean disabled = false;
    String imagePath;
    public Raket(Veld huidigVeld)
    {
       huidigVeld.Raket = this;
       huidigVeld = getHuidigVeld();
       direction = huidigVeld.speler.direction;
       move(direction);
       imagePath = "Img/Raket.png";
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
}
