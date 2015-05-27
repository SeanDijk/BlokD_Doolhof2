/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 *
 * @author Sean
 */
public class MainFrame extends JFrame{

    JPanel buttonsPanel = new JPanel();
    Speelveld level = new Speelveld();
    
    public MainFrame()
    {
        setLayout(new BorderLayout());
        add(level, BorderLayout.CENTER);
        addKeyListener(key);
        //makeButtonsPanel();
    }

    
    
    
    public void makeButtonsPanel()
    {
        Border b = new BevelBorder(WIDTH);
        
        buttonsPanel.setLayout(new GridLayout(1,1));
        JButton pause = new JButton("Pause");
        buttonsPanel.add(pause);
        buttonsPanel.setBorder(b);
        add(buttonsPanel, BorderLayout.SOUTH);
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
                level.speler.move("up");
            }
            if("a".equals(key))
            {
                level.speler.move("left");
            }
            if("s".equals(key))
            {
                level.speler.move("down");
            }
            if("d".equals(key))
            {
                level.speler.move("right");
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    };
    
    
    
    
    
 
    
}