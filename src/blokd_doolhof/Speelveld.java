/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Sean
 */
public class Speelveld extends JPanel{
     static Veld[][] velden;
    Veld startPositie;
    Veld eindPositie;
    Speler speler = new Speler();
    Vriend vriend = new Vriend();

    JPanel mazePannel= new JPanel();
    JPanel buttonsPanel = new JPanel();
    public Speelveld()
    {
        addKeyListener(key);
        loadLevel1();
        //setF
        System.out.println(isFocusable());
        
    }
    public void loadLevel1()
    {
        setLayout(new GridLayout(10,10));
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
                add(kolommen);
                coordsX++;
            }
            coordY++;
        }
        startPositie = velden[1][1];
        startPositie.speler= speler;
        eindPositie = velden[1][8];
        eindPositie.spelObject = vriend;
        
        
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
    
    
}
