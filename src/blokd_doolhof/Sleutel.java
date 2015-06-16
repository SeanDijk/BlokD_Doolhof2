/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;


/**
 *
 * @author Sean
 */
public class Sleutel extends SpelObject implements Pickupable{
    public Sleutel()
    {
        imagePath = "Img/Key.png";
    }
    
    @Override
    public void pickup() {
        
        Speler.keys.add(this);
    }

    @Override
    public void doActionpickup(Veld veldraket) {
        
    }
    
    
    @Override
    public void doAction()
    {
        pickup();
        System.out.println("Sleutel opgepakt");
        disabled = true;        
    }
    
}
