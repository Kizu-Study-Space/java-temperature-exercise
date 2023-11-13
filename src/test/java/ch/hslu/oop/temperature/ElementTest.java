package ch.hslu.oop.temperature;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElementTest {
    @Test
    public void testStateOfMatterOf() {
        assertEquals("Stickstoff ist gasförmig bei 20.00 Grad Celsius", Element.N.getStateOfMatterAt(Temperature.createWithCelsius(20)));
        assertEquals("Quecksilber ist flüssig bei 20.00 Grad Celsius", Element.HG.getStateOfMatterAt(Temperature.createWithCelsius(20)));
        assertEquals("Blei ist fest bei 20.00 Grad Celsius", Element.PB.getStateOfMatterAt(Temperature.createWithCelsius(20)));

        assertEquals("Stickstoff ist gasförmig bei 1000.00 Grad Celsius", Element.N.getStateOfMatterAt(Temperature.createWithCelsius(1000)));
        assertEquals("Quecksilber ist gasförmig bei 1000.00 Grad Celsius", Element.HG.getStateOfMatterAt(Temperature.createWithCelsius(1000)));
        assertEquals("Blei ist flüssig bei 1000.00 Grad Celsius", Element.PB.getStateOfMatterAt(Temperature.createWithCelsius(1000)));

        assertEquals("Blei ist fest bei 327.45 Grad Celsius", Element.PB.getStateOfMatterAt(new Temperature(600.60)));
        assertEquals("Blei ist flüssig bei 327.46 Grad Celsius", Element.PB.getStateOfMatterAt(new Temperature(600.61)));
        assertEquals("Blei ist flüssig bei 1748.84 Grad Celsius", Element.PB.getStateOfMatterAt(new Temperature(2021.99)));
        assertEquals("Blei ist gasförmig bei 1748.85 Grad Celsius", Element.PB.getStateOfMatterAt(new Temperature(2022)));

        assertEquals("Stickstoff ist fest bei -210.01 Grad Celsius", Element.N.getStateOfMatterAt(new Temperature(63.14)));
        assertEquals("Stickstoff ist flüssig bei -210.00 Grad Celsius", Element.N.getStateOfMatterAt(new Temperature(63.15)));
        assertEquals("Stickstoff ist flüssig bei -195.80 Grad Celsius", Element.N.getStateOfMatterAt(new Temperature(77.35)));
        assertEquals("Stickstoff ist gasförmig bei -195.79 Grad Celsius", Element.N.getStateOfMatterAt(new Temperature(77.36)));

        assertEquals("Quecksilber ist fest bei -38.84 Grad Celsius", Element.HG.getStateOfMatterAt(new Temperature(234.31)));
        assertEquals("Quecksilber ist flüssig bei -38.83 Grad Celsius", Element.HG.getStateOfMatterAt(new Temperature(234.32)));
        assertEquals("Quecksilber ist flüssig bei 357.04 Grad Celsius", Element.HG.getStateOfMatterAt(new Temperature(630.19)));
        assertEquals("Quecksilber ist gasförmig bei 357.05 Grad Celsius", Element.HG.getStateOfMatterAt(new Temperature(630.2)));
    }

    @Test
    public void testGetAtomicNumber() {
        assertEquals(7, Element.N.getAtomicNumber());
        assertEquals(80, Element.HG.getAtomicNumber());
        assertEquals(82, Element.PB.getAtomicNumber());
    }

    @Test
    public void testGetName() {
        assertEquals("Stickstoff", Element.N.getName());
        assertEquals("Quecksilber", Element.HG.getName());
        assertEquals("Blei", Element.PB.getName());
    }

    @Test
    public void testGetShortName() {
        assertEquals("N", Element.N.getShortName());
        assertEquals("Hg", Element.HG.getShortName());
        assertEquals("Pb", Element.PB.getShortName());
    }

    @Test
    public void testToString() {
        assertEquals("N: melting at 63.15K, boiling at 77.36K.", Element.N.toString());
        assertEquals("Hg: melting at 234.32K, boiling at 630.2K.", Element.HG.toString());
        assertEquals("Pb: melting at 600.61K, boiling at 2022.0K.", Element.PB.toString());
    }
}
