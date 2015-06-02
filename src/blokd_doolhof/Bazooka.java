/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import java.awt.Color;

/**
 *
 * @author Sean
 */
public class Bazooka extends SpelObject implements Pickupable{
    
    public Bazooka()
    {
        kleur = Color.YELLOW;
    }
    
    
    @Override
    public void doAction()
    {
        System.out.println("Bazooka opgepakt");
        disabled = true;
        Speler.BazookaOpgepakt = true;
    }
}
