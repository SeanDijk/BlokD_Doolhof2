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

            if(speler != null)
            {
                speler.paintComponent(g);
                System.out.println("yolo");
            }
            g.fillRect(0, 0, this.getWidth(), this.getWidth());  
    }
    
    
    
    public Veld getBuurRechts()
    { 
        Veld veld = Speelveld.velden[coordsX+1][coordsY];
        return veld;
    }
    public Veld getBuurLinks()
    {
        Veld veld = Speelveld.velden[coordsX+1][coordsY];
        return veld;
    }
    public Veld getBuurBoven()
    {
        Veld veld = Speelveld.velden[coordsX][coordsY+1];
        return veld;
    }
    public Veld getBuurOnder()
    {
        Veld veld = Speelveld.velden[coordsX][coordsY-1];
        return veld;
    }


}
