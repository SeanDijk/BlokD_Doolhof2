/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Sean
 */
public class BlokD_Doolhof {

    /**
     * @param args the command line arguments
     */
    static MainFrame frame;
    static StartupFrame start;
    public static void main(String[] args) {
        
        start = new StartupFrame();
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.setSize(200, 100);
        start.setVisible(true);
    }
    
}

