/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import java.awt.Color;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;

/**
 *
 * @author Sean
 */
public class Vriend extends SpelObject{
    Veld v;
    public Vriend(Veld v)
    {
        kleur = Color.MAGENTA;
        this.v = v;
    }
    
    @Override
    public void doAction()
    {
        
        System.out.println("Gewonnen!!");
        v.speler.winAnimation(0);
        JOptionPane.showMessageDialog(BlokD_Doolhof.frame, "Level gehaald!");
        
    }
}
