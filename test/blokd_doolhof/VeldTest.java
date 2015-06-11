/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blokd_doolhof;

import java.awt.Graphics;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Asus
 */
public class VeldTest {
    
    public VeldTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testIsWalkable() {
        //Test 1 Pad
        System.out.println("isWalkablePad");
        Veld instance = new Pad();
        boolean expResult1 = true;
        boolean result1 = instance.isWalkable();
        assertEquals(expResult1, result1);
        
        //Test 2 Muur
        System.out.println("isWalkableMuur");
        Veld instance1 = new Muur();
        boolean expResult2 = false;
        boolean result2 = instance1.isWalkable();
        assertEquals (expResult2 , result2);
        
    }

    public class VeldImpl extends Veld {
    }
}
