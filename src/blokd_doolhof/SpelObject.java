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
public abstract class SpelObject extends JComponent{
    
    Color kleur;
    
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(kleur);    
        g.fillRect(0, 0, getWidth(), getWidth()); 
    }
    
    public void doAction()
    {
        
    }
    
}
