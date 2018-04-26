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
public class ConverterTest {
    
    public ConverterTest() {
    }

    /**
     * Test of getRate method, of class Converter.
     */
    @Test
    public void testGetRate() {
        System.out.println("getRate");
        String from = "EUR";
        String to = "GBP";
        Converter instance = new Converter();
        Object result = instance.getRate(from, to);
        assertTrue(result instanceof Double);
    }

    /**
     * Test of convert method, of class Converter.
     */
    @Test
    public void testConvert() throws Exception {
        System.out.println("convert");
        double value = 10.0;
        double rate = 1.5;
        Converter instance = new Converter();
        double expResult = 15.0;
        double result = instance.convert(value, rate);
        assertEquals(expResult, result, 0.0);
        
    }
    
}
