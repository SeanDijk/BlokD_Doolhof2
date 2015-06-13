/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static blokd_doolhof.BlokD_Doolhof.frame;

/**
 *
 * @author Sean
 */
public class StartupFrame extends JFrame{
    JPanel selectPanel;
    JComboBox<Integer> levelselect;
    public StartupFrame()
    {
        setLayout(new BorderLayout());
        
        makeSelectPanel();
        
        
        JButton button = new JButton("Start");
        
        button.addActionListener(makeMainFrame);
        add(button, BorderLayout.SOUTH);
    }
    private void makeSelectPanel()
    {
        selectPanel = new JPanel();
        JLabel label = new JLabel("Selecteer het level: ");

        Integer[] list = {1,2,3};
        levelselect = new JComboBox<>(list);
        
        selectPanel.add(label);
        selectPanel.add(levelselect);
        
        add(selectPanel, BorderLayout.CENTER);
    }
    ActionListener makeMainFrame = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        frame = new MainFrame((int) levelselect.getSelectedItem());
        //frame.setDefaultCloseOperation(JFrame.);
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        }
    }; 
    
}
