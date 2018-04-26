/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqs_hw1_rui;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ruiserrano
 */
public class RateServiceTest {
    
    public RateServiceTest() {
    }

    /**
     * Test of getRate method, of class RateService.
     */
    @Test
    public void testGetRate() throws Exception {
        System.out.println("getRateWrongName");
        String to = "qwerty";
        RateService instance = new RateService();
        double expResult = 0.0;
        double result = instance.getRate(to);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of validateCurrencieName method, of class RateService.
     */
    @Test
    public void testValidateCurrencieName() {
        System.out.println("validateCurrencieName");
        String name = "EUR";
        RateService instance = new RateService();
        boolean result = instance.validateCurrencieName(name);
        assertTrue(result);
    }
    
}
