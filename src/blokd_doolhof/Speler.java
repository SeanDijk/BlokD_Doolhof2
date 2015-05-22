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
    public void moveUp()
    {
       huidigveld=getHuidigVeld();
       setHuidigVeld(huidigveld.getBuurBoven());
       huidigveld.repaint();
    }
    public void moveRight()
    {
       huidigveld=getHuidigVeld();
       setHuidigVeld(huidigveld.getBuurRechts());
       huidigveld.repaint();
    }
    public void moveDown()
    {
       huidigveld=getHuidigVeld();
       setHuidigVeld(huidigveld.getBuurOnder());
       huidigveld.repaint();
    }
    public void moveLeft()
    {
       huidigveld=getHuidigVeld();
       setHuidigVeld(huidigveld.getBuurLinks());
       huidigveld.repaint();
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
}
