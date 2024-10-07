/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sio.paris2024.model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SIO2
 */
public class EpreuveTest {
    
    static Epreuve uneEpreuve;
    
    public EpreuveTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    
    uneEpreuve = new Epreuve();
    
    Athlete a1 = new Athlete();
    Athlete a2 = new Athlete();
    
    uneEpreuve.addAthlete(a1);
    uneEpreuve.addAthlete(a2);
    
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
     * Test of getId method, of class Epreuve.
     */
    @Test
    public void testGetNbAthletes() {
        System.out.println("getNbAthletes renvoyé par la méthode=" + uneEpreuve.getNbAthletes());
        int expResult = 2;
	int result = uneEpreuve.getNbAthletes();
        assertEquals(expResult, result);
        
    }
}
