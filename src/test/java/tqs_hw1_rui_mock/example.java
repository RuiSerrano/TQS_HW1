/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqs_hw1_rui_mock;

import static org.easymock.EasyMock.*;
import org.easymock.*;
import org.junit.*;
import tqs_hw1_rui.Converter;
import tqs_hw1_rui.RateService;

/**
 *
 * @author ruiserrano
 */
public class example extends EasyMockSupport {

    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @Mock
    private RateService rateservice; // 1

    @TestSubject
    private Converter converter = new Converter(); // 2

    @Test
    public void addDocument() {
        double tax = rateservice.getRate("EUR"); // 3
        replayAll(); // 4
        //converter.convert(50,); // 5
        verifyAll(); // 6
    }
}
