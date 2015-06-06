/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import static blokd_doolhof.Speelveld.velden;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sean
 */
public class HelperTest {
    
    public HelperTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of doAction method, of class Helper.
     */
    @Test
    public void testDoAction() {
        System.out.println("doAction");
        Helper instance = null;
        instance.doAction();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeVeldCount method, of class Helper.
     */
    @Test
    public void testMakeVeldCount() {
        System.out.println("makeVeldCount");
        
        Speelveld speelveld = new Speelveld();

        
        Helper instance = new Helper(velden[4][1], speelveld.eindPositie);
        instance.makeVeldCount();
        // TODO review the generated test code and remove the default call to fail.
        
        int expected = Integer.MAX_VALUE;
        
        for(int[] rij :instance.veldCount)
       { 
           for(int vakje: rij)
           {
               assertEquals(expected, vakje);
           }
       }
        System.out.println("");
        System.out.println("");
        
    }

    
    /**
     * Test of recursiveSolver method, of class Helper.
     */
    @Test
    public void testRecursiveSolver() {
        System.out.println("recursiveSolver");
        
        Speelveld speelveld = new Speelveld();
        
        
        //Test 1----------------------
        Veld v = velden[10][8];
        int count = 1;
        Helper instance = new Helper(velden[10][8], speelveld.eindPositie);
        instance.makeVeldCount();
        
        instance.recursiveSolver(v, count);
        
        //The shortest route is 35 steps form velden[4][1]
        int expected = 35;
        assertEquals(expected, instance.veldCount[speelveld.eindPositie.coordsY][speelveld.eindPositie.coordsX]);
        //----------------------------
        
        //Test 2----------------------
        v = velden[1][1];
        count = 1;
        instance = new Helper(velden[1][1], speelveld.eindPositie);
        instance.makeVeldCount();
        
        instance.recursiveSolver(v, count);
        
        //The shortest route is 35 steps form velden[4][1]
        expected = 63;
        assertEquals(expected, instance.veldCount[speelveld.eindPositie.coordsY][speelveld.eindPositie.coordsX]);
        //----------------------------
        
        
    }
    
}
