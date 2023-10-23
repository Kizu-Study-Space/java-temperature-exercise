package ch.hslu.oop.temperature;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NTest {
    @Test
    public void getName() {
        Element element = new N();
        assertEquals("Stickstoff", element.getName());
    }

    @Test
    public void getShortName() {
        Element element = new N();
        assertEquals("N", element.getShortName());
    }

    @Test
    public void getStateOfMatter() {
        Element element = new N();
        assertEquals("solid", element.getStateOfMatter(63.14));
        assertEquals("liquid", element.getStateOfMatter(63.15));
        assertEquals("liquid", element.getStateOfMatter(77.35));
        assertEquals("gas", element.getStateOfMatter(77.36));
    }
}
