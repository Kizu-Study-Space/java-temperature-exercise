package ch.hslu.oop.temperature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PbTest {
    @Test
    public void getName() {
        Element element = new Pb();
        assertEquals("Blei", element.getName());
    }

    @Test
    public void getShortName() {
        Element element = new Pb();
        assertEquals("Pb", element.getShortName());
    }

    @Test
    public void getStateOfMatter() {
        Element element = new Pb();
        assertEquals("solid", element.getStateOfMatter(600.60));
        assertEquals("liquid", element.getStateOfMatter(600.61));
        assertEquals("liquid", element.getStateOfMatter(2021.99));
        assertEquals("gas", element.getStateOfMatter(2022));
    }

    @Test
    public void testToString() {
        Element element = new Pb();
        assertEquals("Pb: melting at 600.61K, boiling at 2022.0K.", element.toString());
    }
}
