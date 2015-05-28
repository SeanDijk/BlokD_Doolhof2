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
 * Abstracte superklasse voor velden.
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
            
            //Tekent het spelobject op het veld
            if(spelObject != null)
            {
                spelObject.paintComponent(g);
            }
            
            g.fillRect(0, 0, this.getWidth(), this.getHeight()); 
            
            //Tekent de speler op het veld
            if(speler != null)
            {
                speler.paintComponent(g);                
            }
            //Tekent het veld
             
    }
    
    //
    public Veld getBuur(String direction)
    {
        Veld veld = null;
        if("left".equals(direction))
            veld = Speelveld.velden[coordsY][coordsX-1];
        if("right".equals(direction))
            veld = Speelveld.velden[coordsY][coordsX+1];
        if("up".equals(direction))
            veld = Speelveld.velden[coordsY-1][coordsX];
        if("down".equals(direction)) 
            veld = Speelveld.velden[coordsY+1][coordsX];
        return veld;
    }


    
    public boolean isWalkable()
    {
        return true;
    }
    
    @Override
    public String toString()
    {
        return("X = " + coordsX +"  Y = " + coordsY);
    }
}
