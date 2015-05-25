/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 *
 * @author Sean
 */
public abstract class Veld extends JComponent{
    Color kleur;
    Speler speler;
    SpelObject spelObject;
    int coordsX;
    int coordsY;
    public Veld()
    {
        kleur = Color.red;
        Border border = new BevelBorder(1);
        setBackground(Color.green);
        setBorder(border);
    }
    @Override
    public void paintComponent(Graphics g)
    {
            g.setColor(kleur);            

            if(spelObject != null)
            {
                spelObject.paintComponent(g);
            }
            if(speler != null)
            {
                speler.paintComponent(g);
                //getBuurRechts().kleur =Color.BLACK;
            }


            g.fillRect(0, 0, this.getWidth(), this.getWidth());  
    }
    
    
    
    public Veld getBuurRechts()
    { 
        Veld veld = Speelveld.velden[coordsY][coordsX+1];
        System.out.println("getBuurRechts()"+veld);
        return veld;
    }
    public Veld getBuurLinks()
    {
        Veld veld = Speelveld.velden[coordsY][coordsX-1];
        return veld;
    }
    public Veld getBuurBoven()
    {
        Veld veld = Speelveld.velden[coordsY-1][coordsX];
        return veld;
    }
    public Veld getBuurOnder()
    {
        Veld veld = Speelveld.velden[coordsY+1][coordsX];
        return veld;
    }

    @Override
    public String toString()
    {
        return("X = " + coordsX +"  Y = " + coordsY);
    }
}
