/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import static blokd_doolhof.Speelveld.velden;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Sean
 */
public class Speler extends JComponent{
    Veld huidigveld;
    
    
    @Override
    public void paintComponent(Graphics g)
    {
            g.setColor(Color.green);            
            System.out.println("LOL");
            g.fillRect(0, 0, this.getWidth(), this.getWidth());     
     
    }
    private void moveUp()
    {
        
    }
    public void moveRight()
    {
            
    }
    private void moveDown()
    {
        
    }
    private void moveLeft()
    {
        
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
}
