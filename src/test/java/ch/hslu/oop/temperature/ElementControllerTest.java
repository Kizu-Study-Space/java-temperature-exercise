package ch.hslu.oop.temperature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementControllerTest {
    @Test
    public void testStateOfMatterOf() {
        final ElementController elementController = new ElementController();
        assertEquals("Stickstoff ist gasförmig bei 20.00 Grad Celsius", elementController.stateOfMatterOf("N", 20));
        assertEquals("Quecksilber ist flüssig bei 20.00 Grad Celsius", elementController.stateOfMatterOf("Hg", 20));
        assertEquals("Blei ist fest bei 20.00 Grad Celsius", elementController.stateOfMatterOf("Pb", 20));

        assertEquals("Stickstoff ist gasförmig bei 1000.00 Grad Celsius", elementController.stateOfMatterOf("N", 1000));
        assertEquals("Quecksilber ist gasförmig bei 1000.00 Grad Celsius", elementController.stateOfMatterOf("Hg", 1000));
        assertEquals("Blei ist flüssig bei 1000.00 Grad Celsius", elementController.stateOfMatterOf("Pb", 1000));
    }
}
