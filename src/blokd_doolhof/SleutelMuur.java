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
public class SleutelMuur extends Muur{
    int aantalSleutels;
    public SleutelMuur(int aantalSleutels)
    {
        this.aantalSleutels = aantalSleutels;
        imagePath = "Img/Wallkey.png";
        walkable=false;      
    }
    @Override
    public boolean isWalkable()
    {      
        if(walkable == false)
            return unlock();
        else 
            return walkable;
    }
    public boolean unlock()
    {
        if(Speler.keys.size() >= aantalSleutels)
        {
            walkable = true;
            imagePath = "Img/path.png";
            
            for (int i = 0; i < aantalSleutels; i++) 
            {
                Speler.keys.remove();
            }
            
            return true;
        }
        else{
            return false;
        }
    }
}
