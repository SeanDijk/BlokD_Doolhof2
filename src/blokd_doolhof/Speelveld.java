/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Sean
 */
public class Speelveld extends JFrame{
    static Veld[][] velden;
    Veld startPositie;
    Speler speler = new Speler();

    JPanel mazePannel= new JPanel();
    public Speelveld()
    {
        //makeMazePannel(20 , 20);
        makeLevel1();
        add(mazePannel);
        addKeyListener(key);
    }

    public void makeLevel1()
    {
        mazePannel.setLayout(new GridLayout(10,10));
        
        Veld[] paden = new Pad[100];
        for (int i = 0; i < 100; i++) {
            Pad object = new Pad();
            paden[i] = object;            
        }
        Veld[] muren = new Muur[100];
        for (int i = 0; i < 100; i++) {
            Muur object = new Muur();
            muren[i] = object;            
        }
        
        int i =1;
        int y = 1;
        
        
        Veld[] rij1 = {muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++]};
        Veld[] rij2 = {muren[i++], paden[y++], muren[i++], paden[y++], paden[y++],paden[y++], muren[i++], paden[y++],paden[y++], muren[i++]};
        Veld[] rij3 = {muren[i++], paden[y++], muren[i++], paden[y++],muren[i++], paden[y++], muren[i++], paden[y++], paden[y++],muren[i++] };
        Veld[] rij4 = {muren[i++], paden[y++], muren[i++], paden[y++],muren[i++], paden[y++], muren[i++], paden[y++], muren[i++],muren[i++]};
        Veld[] rij5 = {muren[i++], paden[y++], paden[y++], paden[y++],muren[i++], paden[y++], muren[i++], paden[y++], paden[y++],muren[i++]};
        Veld[] rij6 = {muren[i++], paden[y++], muren[i++], muren[i++],muren[i++], paden[y++], muren[i++], muren[i++], paden[y++],muren[i++]};
        Veld[] rij7 = {muren[i++], paden[y++], muren[i++] ,paden[y++],  paden[y++], paden[y++], muren[i++], paden[y++], paden[y++], muren[i++]};
        Veld[] rij8 = {muren[i++], paden[y++], muren[i++] ,paden[y++],  paden[y++], paden[y++], paden[y++], paden[y++], paden[y++], muren[i++]};
        Veld[] rij9 = {muren[i++], paden[y++],paden[y++],paden[y++],muren[i++],muren[i++], paden[y++],paden[y++],paden[y++],muren[i++]};
        Veld[] rij10 = {muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++], muren[i++]};
        
        velden = new Veld[][]{rij1, rij2, rij3, rij4, rij5, rij6, rij7, rij8, rij9, rij10};
        
        int coordY=0;
        int coordsX;
        for(Veld[] rijen: velden)
        {
            coordsX=0;
            for(Veld kolommen: rijen)
            {
                kolommen.coordsY = coordY;
                kolommen.coordsX = coordsX;
                mazePannel.add(kolommen);
                coordsX++;
            }
            coordY++;
        }
        startPositie = velden[1][1];
        startPositie.speler= speler;
        
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
                System.out.println("w");
                speler.moveUp();
            }
            if("a".equals(key))
            {
                System.out.println("a");
                speler.moveLeft();
            }
            if("s".equals(key))
            {
                System.out.println("s");
                speler.moveDown();
            }
            if("d".equals(key))
            {
                System.out.println("d");
                speler.moveRight();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    };
    
}