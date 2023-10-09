package temperature;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementTest {

    @Test
    public void getName() {
        Element element = new Element("N", "Stickstoff", 10, 100);
        assertEquals("Stickstoff", element.getName());
    }

    @Test
    public void getShortName() {
        Element element = new Element("N", "Stickstoff", 10, 100);
        assertEquals("N", element.getShortName());
    }

    @Test
    public void getStateOfMatter() {
        Element element = new Element("N", "Stickstoff", 10, 100);
        assertEquals("solid", element.getStateOfMatter(9.9));
        assertEquals("liquid", element.getStateOfMatter(10));
        assertEquals("liquid", element.getStateOfMatter(99.99));
        assertEquals("gas", element.getStateOfMatter(100));
    }
}