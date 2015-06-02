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
public class Helper extends SpelObject{
    
    Veld v;
    Veld[][] level; 
    int[][] veldCount;
    public Helper(Veld v)
    {
        this.v =v;
        kleur = Color.GRAY;
    }
    
    @Override
    public void doAction()
    {
        //Startveld = Speelveld.velden[v.coordsY][v.coordsX]
       level = Speelveld.velden.clone();
       v= level[v.coordsY][v.coordsX];
       veldCount = new int[level.length][level[0].length];
             
    }
    //Recursieve methode nodig voor het lopen
    public boolean recursiveSolver(Veld v)
    {
        if(v.getBuur("left").isWalkable())
        {
            
        }
        if(v.getBuur("right").isWalkable())
        {
            
        }
        if(v.getBuur("up").isWalkable())
        {
            
        }
        if(v.getBuur("down").isWalkable())
        {
            
        }
                
        return true;
    }
}
