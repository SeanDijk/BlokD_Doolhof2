/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;


/**
 *
 * @author Sean
 */
public class Helper extends SpelObject{
    
    Veld v;
    Veld eindveld;
    int[][] veldCount;
    ArrayList<Veld> solution= new ArrayList<>();
    String imagePath;
    public Helper(Veld eigenVeld, Veld eindveld)
    {
        v =eigenVeld;
        this.eindveld = eindveld;
        imagePath = "Img/Helper.png";
    }
    @Override
    public void paintComponent(Graphics g)
    {
        tekenObject(g, imagePath);
    }

    public void tekenObject(Graphics g, String path )
    {
        BufferedImage img = null;
        try {              
                img = ImageIO.read(new File(path));            
                                
                int middleWidth = (this.getParent().getWidth()/2  - img.getWidth()/2);
                int middleHeight= (this.getParent().getHeight()/2  - img.getHeight()/2);
                                
                g.drawImage(img, middleWidth, middleHeight, null);
            } 
        catch (IOException e) {
            }
    }
    
    @Override
    public void doAction()
    {
       if(disabled ==false)
       {
            v= Speelveld.velden[v.coordsY][v.coordsX];
            makeVeldCount();

            recursiveSolver( v, 1);

            printVeldCount();
            getSolution(eindveld);

            for(Veld veld:solution)
            {
                veld.imagePath = "Img/Path_Optimal.png";
                veld.repaint();
            }

            this.disabled=true;
       }
    }
    
    //Initialiseert de veldCount Array.
    public void makeVeldCount()
    {
       veldCount = new int[Speelveld.velden.length][Speelveld.velden[0].length];
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

        if(v == eindveld)
        {
            System.out.println("This route is " + count + " steps");
        }
        if(veldCount[v.coordsY][v.coordsX] < count)
        {
            return;
        }
        
        veldCount[v.coordsY][v.coordsX] = count; 
        if(v.buurLinks!= null && v.buurLinks.isWalkable())
        {
            recursiveSolver(v.buurLinks, (count + 1));
            
        }
        if(v.buurRechts!= null && v.buurRechts.isWalkable())
        {
            recursiveSolver(v.buurRechts, (count + 1));
        }
        if(v.buurBoven!= null && v.buurBoven.isWalkable())
        {
            recursiveSolver(v.buurBoven, (count + 1));
        }
        if(v.buurOnder!= null && v.buurOnder.isWalkable())
        {
            recursiveSolver(v.buurOnder, (count + 1));
        }
        v.imagePath = "Img/Path.png";
        v.repaint();
    }
    private void getSolution(Veld v)
    {
        solution.add(v);
        //Left
        if(veldCount[v.coordsY][v.coordsX - 1] < veldCount[v.coordsY][v.coordsX])
        {
            getSolution(Speelveld.velden[v.coordsY][v.coordsX - 1]);
        }
        //Right
        if(veldCount[v.coordsY][v.coordsX + 1] < veldCount[v.coordsY][v.coordsX])
        {
            getSolution(Speelveld.velden[v.coordsY][v.coordsX + 1]);
        }
        //Up
        if(veldCount[v.coordsY -1][v.coordsX] < veldCount[v.coordsY][v.coordsX])
        {
            getSolution(Speelveld.velden[v.coordsY-1][v.coordsX ]);
        }
        //Down
        if(veldCount[v.coordsY +1][v.coordsX] < veldCount[v.coordsY][v.coordsX])
        {
            getSolution(Speelveld.velden[v.coordsY+1][v.coordsX]);
        }
        
    }
    
    
}
