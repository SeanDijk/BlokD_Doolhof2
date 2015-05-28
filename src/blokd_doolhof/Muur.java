/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 *
 * @author Sean
 */
public class Muur extends Veld{
    
    public Muur()
    {
        kleur = Color.red;
        Border border = new BevelBorder(1);
        setBackground(Color.red);
        setBorder(border);
        
        
    }
    @Override
        public boolean isWalkable()
    {
        return false;
    }
    

}
