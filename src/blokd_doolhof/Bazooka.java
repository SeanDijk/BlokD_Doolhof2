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
    
    Veld b;
    public Bazooka(Veld b)
    {
        this.b = b;
        kleur = Color.WHITE;
    }
    
    @Override
    public void doAction()
    {
        pickup();
        System.out.println("Bazooka opgepakt");
        disabled = true;
        
    }

    @Override
    public void pickup() 
    {
        b.speler.pickup = this;
        
    }

    @Override
    public void doActionpickup(Veld veldraket)
    {
        
        Raket raket = new Raket(veldraket);
        
    }
    
}
