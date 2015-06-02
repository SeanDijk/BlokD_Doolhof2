/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Sean
 */
public class Helper extends SpelObject{
    
    Veld v;
    Veld eindveld;
    Veld[][] level; 
    int[][] veldCount;
    ArrayList<Veld> solution= new ArrayList<>();
    public Helper(Veld eigenVeld, Veld eindveld)
    {
        v =eigenVeld;
        kleur = Color.GRAY;
        this.eindveld = eindveld;
    }
    
    @Override
    public void doAction()
    {
       level = Speelveld.velden.clone();
       
       v= level[v.coordsY][v.coordsX];
       makeVeldCount();

       recursiveSolver( v, 1);
       
       printVeldCount();
       getSolution(eindveld);
       
       for(Veld veld:solution)
       {
           veld.kleur = Color.ORANGE;
       }
       
       this.disabled=true;
    }
    
    //Initialiseert de veldCount Array.
    public void makeVeldCount()
    {
       veldCount = new int[level.length][level[0].length];
       int i=0;
       int j;
       for(int[] rij :veldCount)
       { 
           j=0;
           for(int vakje: rij)
           {
              veldCount[i][j] = Integer.MAX_VALUE;
              j++;
           }
           i++;
       }
    }
    //Print de veldCount Array, deze methode is voor dingen testen.
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
    
    //Recursieve methode nodig voor het doorlopen van het doolhof
    public void recursiveSolver(Veld v, int count)
    {   
        if(veldCount[v.coordsY][v.coordsX] < count)
        {
            return;
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
    }
    private void getSolution(Veld v)
    {
        solution.add(v);
        //Left
        if(veldCount[v.coordsY][v.coordsX - 1] < veldCount[v.coordsY][v.coordsX])
        {
            getSolution(level[v.coordsY][v.coordsX - 1]);
        }
        //Right
        if(veldCount[v.coordsY][v.coordsX + 1] < veldCount[v.coordsY][v.coordsX])
        {
            getSolution(level[v.coordsY][v.coordsX + 1]);
        }
        //Up
        if(veldCount[v.coordsY -1][v.coordsX] < veldCount[v.coordsY][v.coordsX])
        {
            getSolution(level[v.coordsY-1][v.coordsX ]);
        }
        //Down
        if(veldCount[v.coordsY +1][v.coordsX] < veldCount[v.coordsY][v.coordsX])
        {
            getSolution(level[v.coordsY+1][v.coordsX]);
        }
        
    }
    
    
}
