/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Sean
 */
public class Raket extends JComponent implements Mover{
    
    Veld R;
    String direction;
    public Raket(Veld R)
    {
       R.Raket = this;
       R = getSpelerVeld();
       direction = R.speler.direction;
       
       move(direction);
    }
    @Override
    public void setHuidigVeld()
    {
        R.Raket =null;
        R = getHuidigVeld();
        R.Raket = this;
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
    public Veld getSpelerVeld()
    {
        for(Veld[] rijen: Speelveld.velden)
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
    public void setHuidigVeld(Veld veld)
    {
        R.Raket =null;
        R.repaint();
        R = veld;
        R.Raket = this;
    }
    
    @Override
    public void move(String direction)
    {
        R=getHuidigVeld();
        Veld nieuwVeld = null;
        
        if("left".equals(direction))
            nieuwVeld = R.getBuur("left");
        if("right".equals(direction))
            nieuwVeld = R.getBuur("right");
        if("up".equals(direction)) 
            nieuwVeld = R.getBuur("up");        
        if("down".equals(direction))
            nieuwVeld = R.getBuur("down");      
        
        if(nieuwVeld.isWalkable() == true)
        {
            setHuidigVeld(nieuwVeld);
            R.repaint();
            move(direction);
        }
        else{
            System.out.println("Cant move there, it's a wall! ");
        }
        
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);    
        g.fillOval(0, 0, this.getParent().getWidth(), this.getParent().getHeight());
    }
}
