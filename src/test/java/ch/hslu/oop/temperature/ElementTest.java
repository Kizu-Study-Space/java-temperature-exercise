package ch.hslu.oop.temperature;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElementTest {
    @Test
    public void testStateOfMatterOf() {
        assertEquals(StateOfMatter.SOLID, Element.PB.getStateOfMatterAt(Temperature.createWithKelvin(600.60)));
        assertEquals(StateOfMatter.LIQUID, Element.PB.getStateOfMatterAt(Temperature.createWithKelvin(600.61)));
        assertEquals(StateOfMatter.LIQUID, Element.PB.getStateOfMatterAt(Temperature.createWithKelvin(2021.99)));
        assertEquals(StateOfMatter.GAS, Element.PB.getStateOfMatterAt(Temperature.createWithKelvin(2022)));

        assertEquals(StateOfMatter.SOLID, Element.N.getStateOfMatterAt(Temperature.createWithKelvin(63.14)));
        assertEquals(StateOfMatter.LIQUID, Element.N.getStateOfMatterAt(Temperature.createWithKelvin(63.15)));
        assertEquals(StateOfMatter.LIQUID, Element.N.getStateOfMatterAt(Temperature.createWithKelvin(77.35)));
        assertEquals(StateOfMatter.GAS, Element.N.getStateOfMatterAt(Temperature.createWithKelvin(77.36)));

        assertEquals(StateOfMatter.SOLID, Element.HG.getStateOfMatterAt(Temperature.createWithKelvin(234.31)));
        assertEquals(StateOfMatter.LIQUID, Element.HG.getStateOfMatterAt(Temperature.createWithKelvin(234.32)));
        assertEquals(StateOfMatter.LIQUID, Element.HG.getStateOfMatterAt(Temperature.createWithKelvin(630.19)));
        assertEquals(StateOfMatter.GAS, Element.HG.getStateOfMatterAt(Temperature.createWithKelvin(630.2)));
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
