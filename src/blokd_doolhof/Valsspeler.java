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
public class Valsspeler extends SpelObject{
    int aantal;
    
    
    public Valsspeler(int aantal)
    {
        this.aantal = aantal;
    }
    @Override
    public void doAction() //Terugdraaien Stappen
    {
        if(disabled == false)
        {
            Speler.aantalStappen-= aantal;
            System.out.println(Speler.aantalStappen);
            disabled = true;
        }

    }
    
}
