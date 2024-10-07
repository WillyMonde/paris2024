/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sio.paris2024.model;

import java.time.LocalDate;
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
public class AthleteTest {
    
    static Athlete unAthlete;
    
    public AthleteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    
    unAthlete = new Athlete();
    
    Epreuve e1 = new Epreuve();
    Epreuve e2 = new Epreuve();
    
    unAthlete.addEpreuve(e1);
    unAthlete.addEpreuve(e2);
    
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
    public void testGetNbEpreuves() {
        System.out.println("getNbEpreuves renvoyé par la méthode=" + unAthlete.getNbEpreuves());
        int expResult = 2;
	int result = unAthlete.getNbEpreuves();
        assertEquals(expResult, result);
        
    }
    
}
