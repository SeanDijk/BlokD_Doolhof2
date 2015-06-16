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
public class Pad extends Veld{
    
    public Pad()
    {
        imagePath = "Img/Path.png";
        setBackground(Color.blue);
        walkable= true;
    }
    
}
