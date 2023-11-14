package ch.hslu.oop.temperature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateOfMatterTest {

    @Test
    public void testToGermanString() {
        assertEquals("Stickstoff ist flüssig bei 46.00 Grad Celsius", StateOfMatter.LIQUID.toGermanString(Element.N, Temperature.createWithCelsius(46)));
        assertEquals("Blei ist fest bei 893.85 Grad Celsius", StateOfMatter.SOLID.toGermanString(Element.PB, Temperature.createWithCelsius(893.846)));
        assertEquals("Quecksilber ist gasförmig bei -94.37 Grad Celsius", StateOfMatter.GAS.toGermanString(Element.HG, Temperature.createWithCelsius(-94.37)));
    }
}
