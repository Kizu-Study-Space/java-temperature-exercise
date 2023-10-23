package ch.hslu.oop.temperature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HgTest {
    @Test
    public void getName() {
        Element element = new Hg();
        assertEquals("Quecksilber", element.getName());
    }

    @Test
    public void getShortName() {
        Element element = new Hg();
        assertEquals("Hg", element.getShortName());
    }

    @Test
    public void getStateOfMatter() {
        Element element = new Hg();
        assertEquals("solid", element.getStateOfMatter(234.31));
        assertEquals("liquid", element.getStateOfMatter(234.32));
        assertEquals("liquid", element.getStateOfMatter(630.19));
        assertEquals("gas", element.getStateOfMatter(630.2));
    }
}
