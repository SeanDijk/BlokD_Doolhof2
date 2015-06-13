/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Sean
 */
public class Speelveld extends JPanel{
    Veld[] paden;
    Veld[] muren;
    
    static Veld[][] velden;
    Veld startPositie;
    Veld eindPositie;
    Speler speler = new Speler();
    Vriend vriend;
    
    int currentLevel = 0;
    
    public Speelveld()
    {
        //addKeyListener(key);
        //loadLevel1();
        loadLevel2();        
    }
    public Speelveld(int levelNumber)
    {
        //addKeyListener(key);
        if(levelNumber == 1)
        {
            loadLevel1();
        }
        else if(levelNumber ==2)
        {
            loadLevel2();
        }
        else if(levelNumber ==3)
        {
            loadLevel3();
        }
        Speler.aantalStappen = 0;
    }
    private void maakPaden(int aantal)
    {
        paden = new Pad[aantal];
        for (int i = 0; i < aantal; i++) {
            Pad object = new Pad();
            paden[i] = object;            
        }
    }
    private void maakMuren(int aantal )
    {
        muren = new Muur[aantal];
        for (int i = 0; i < aantal; i++) {
            Muur object = new Muur();
            muren[i] = object;            
        }
    }
    
    public void loadLevel1()
    { 
        currentLevel =1;
        setLayout(new GridLayout(20,20));
        maakPaden(400);
        maakMuren(400);

        
        int i =0;
        int y = 0;        
        
        //              1           2           3           4           5           6           7           8           9           10          11          12          13          14          15          16          17          18          19          20              
        Veld[] rij1 = {muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++]};
        Veld[] rij2 = {muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij3 = {muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij4 = {muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij5 = {muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], muren[i++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij6 = {muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij7 = {muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++]};
        Veld[] rij8 = {muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++]};
        Veld[] rij9 = {muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++]};
        Veld[] rij10 ={muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij11 ={muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij12 ={muren[i++], muren[i++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij13 ={muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij14 ={muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij15 ={muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij16 ={muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], paden[y++], muren[i++]};
        Veld[] rij17 ={muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++]};
        Veld[] rij18 ={muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++]};
        Veld[] rij19 ={muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], paden[y++], muren[i++]};
        Veld[] rij20 ={muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++]};
        System.out.println("Aantal muren: " + (i) + " Aantal paden: " + (y));
        velden = new Veld[][]{rij1, rij2, rij3, rij4, rij5, rij6, rij7, rij8, rij9, rij10, rij11, rij12, rij13, rij14, rij15, rij16, rij17, rij18, rij19, rij20};
        
        giveCoords();
        setBuren(); 
        
        startPositie = velden[1][1];
        startPositie.speler= speler;
        speler.huidigveld = startPositie;
        eindPositie = velden[18][18];
        eindPositie.spelObject = (vriend = new Vriend(eindPositie));
        velden[3][3].spelObject = new Valsspeler(10);
        velden[4][10].spelObject = new Valsspeler(10);
        velden[8][8].spelObject = new Bazooka(velden[8][8]);
        velden[8][12].spelObject = new Helper(velden[8][12], eindPositie);
        
    }
    public void loadLevel2()
    {
        currentLevel =2;
        setLayout(new GridLayout(20,20));
        maakPaden(180);
        maakMuren(220);
        
        int i =0;
        int y = 0;   
        
        //              1           2           3           4           5           6           7           8           9           10          11          12          13          14          15          16          17          18          19          20              
        Veld[] rij1 = {muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++]};
        Veld[] rij2 = {muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++]};
        Veld[] rij3 = {muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij4 = {muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij5 = {muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij6 = {muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij7 = {muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij8 = {muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij9 = {muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij10 ={muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++]};
        Veld[] rij11 ={muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij12 ={muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij13 ={muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij14 ={muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij15 ={muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij16 ={muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij17 ={muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij18 ={muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij19 ={muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++]};
        Veld[] rij20 ={muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++]};
        System.out.println("Aantal muren: " + (i) + " Aantal paden: " + (y));
        velden = new Veld[][]{rij1, rij2, rij3, rij4, rij5, rij6, rij7, rij8, rij9, rij10, rij11, rij12, rij13, rij14, rij15, rij16, rij17, rij18, rij19, rij20};
        
        giveCoords();
        setBuren(); 
        
        
        startPositie = velden[1][1];
        startPositie.speler= speler;
        speler.huidigveld = startPositie;
        eindPositie = velden[18][18];
        eindPositie.spelObject = (vriend = new Vriend(eindPositie));
        velden[11][18].spelObject = new Valsspeler(5);
        velden[2][1].spelObject = new Bazooka(velden[2][1]);
        velden[10][8].spelObject = new Helper(velden[10][8], eindPositie);
    }
    public void loadLevel3()
    {
        currentLevel =3;
        setLayout(new GridLayout(20,20));
        maakPaden(400);
        maakMuren(400);
        
        int i =0;
        int y = 0;   
        
        //              1           2           3           4           5           6           7           8           9           10          11          12          13          14          15          16          17          18          19          20              
        Veld[] rij1 = {muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++]};
        Veld[] rij2 = {muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij3 = {muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij4 = {muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++]};
        Veld[] rij5 = {muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij6 = {muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++]};
        Veld[] rij7 = {muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij8 = {muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij9 = {muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij10 ={muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++]};
        Veld[] rij11 ={muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij12 ={muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij13 ={muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij14 ={muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij15 ={muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij16 ={muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij17 ={muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij18 ={muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++], muren[i++], muren[i++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], muren[i++]};
        Veld[] rij19 ={muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++], paden[y++], muren[i++], muren[i++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++]};
        Veld[] rij20 ={muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++]};
        System.out.println("Aantal muren: " + (i) + " Aantal paden: " + (y));
        velden = new Veld[][]{rij1, rij2, rij3, rij4, rij5, rij6, rij7, rij8, rij9, rij10, rij11, rij12, rij13, rij14, rij15, rij16, rij17, rij18, rij19, rij20};
        
        giveCoords();
        setBuren(); 
        
        
        startPositie = velden[1][1];
        startPositie.speler= speler;
        speler.huidigveld = startPositie;
        eindPositie = velden[18][18];
        eindPositie.spelObject = (vriend = new Vriend(eindPositie));
        velden[11][18].spelObject = new Valsspeler(5);
        velden[2][1].spelObject = new Bazooka(velden[2][1]);
        velden[10][8].spelObject = new Helper(velden[10][8], eindPositie);
    }
    public void giveCoords()
    {
        int coordY=0;
        int coordsX;
        for(Veld[] rijen: velden)
        {
            coordsX=0;
            for(Veld kolommen: rijen)
            {
                kolommen.coordsY = coordY;
                kolommen.coordsX = coordsX;
                add(kolommen);
                coordsX++;
            }
            coordY++;
        }
    }
    
    
       KeyListener key = new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            String key = Character.toString(e.getKeyChar());
            System.out.println(key);
            if("w".equals(key))
            {
                speler.move("up");
            }
            if("a".equals(key))
            {
                speler.move("left");
            }
            if("s".equals(key))
            {
                speler.move("down");
            }
            if("d".equals(key))
            {
                speler.move("right");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    };


    private void setBuren() 
    {
        for(Veld[] veldRij:velden)
        {
            for(Veld veld :veldRij)
            {
                //System.out.println("Huidigveld: " + veld);
                veld.buurBoven = veld.getBuur("up");
                veld.buurLinks = veld.getBuur("left");
                veld.buurOnder = veld.getBuur("down");
                veld.buurRechts  =veld.getBuur("right");
                
            }
        } 
    }
    
    
}
