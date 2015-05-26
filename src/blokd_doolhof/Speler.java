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
            g.fillRect(0, 0, this.getWidth(), this.getWidth());     
     
    }
    
    public void move(String direction)
    {
        huidigveld=getHuidigVeld();
        
        if("left".equals(direction))
            setHuidigVeld(huidigveld.getBuur("left"));
        if("right".equals(direction))
            setHuidigVeld(huidigveld.getBuur("right"));
        if("up".equals(direction)) 
            setHuidigVeld(huidigveld.getBuur("up"));        
        if("down".equals(direction))
            setHuidigVeld(huidigveld.getBuur("down"));        
        
        huidigveld.repaint();
        spelObjectAction();
    }

    private Veld getHuidigVeld()
    {
         for(Veld[] rijen: velden)
        {
            
            for(Veld veld: rijen)
            {
               if(veld.speler != null)
               {
                   System.out.println("getHuidigVeld()"+veld);

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
    
}
