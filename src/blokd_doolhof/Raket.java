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
    
    @Override
    public void move(String direction)
    {
        
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);    
        g.fillOval(0, 0, this.getParent().getWidth(), this.getParent().getHeight());
    }
}
