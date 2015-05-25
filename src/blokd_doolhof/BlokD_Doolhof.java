/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import javax.swing.JFrame;

/**
 *
 * @author Sean
 */
public class BlokD_Doolhof {

    /**
     * @param args the command line arguments
     */
    static Speelveld frame;
    public static void main(String[] args) {
        frame = new Speelveld();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
    
}
