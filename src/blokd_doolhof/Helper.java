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
       level = Speelveld.velden.clone();
       
       v= level[v.coordsY][v.coordsX];
       makeVeldCount();

       recursiveSolver( v, 1);
       
       printVeldCount();
       this.disabled=true;
    }
    
    public void makeVeldCount()
    {
       veldCount = new int[level.length][level[0].length];
       for(int[] rij :veldCount)
       {
           for(int vakje: rij)
           {
               vakje = Integer.MAX_VALUE;
           }
           
       }
    }
    public void printVeldCount()
    {
       for(int[] rij :veldCount)
       {
           for(int vakje: rij)
           {
               int getal = vakje;
               if(vakje == Integer.MAX_VALUE)
               {
                   getal = -1;
               }
               
               System.out.print("[" +getal +"]");
           }
           System.out.println("");
       }
    }
    
    //Recursieve methode nodig voor het lopen
    public boolean recursiveSolver(Veld v, int count)
    {   
        if(veldCount[v.coordsY][v.coordsX] < count)
        {
            return false;
        }
        
        veldCount[v.coordsY][v.coordsX] = count; 
        if(v.getBuur("left").isWalkable())
        {
            recursiveSolver(v.getBuur("left"), (count + 1));
        }
        if(v.getBuur("right").isWalkable())
        {
            recursiveSolver(v.getBuur("right"), (count + 1));
        }
        if(v.getBuur("up").isWalkable())
        {
            recursiveSolver(v.getBuur("up"), (count + 1));
        }
        if(v.getBuur("down").isWalkable())
        {
            recursiveSolver(v.getBuur("down"), (count + 1));
        }
                
        return true;
    }
    
    
}
