package ch.hslu.oop.temperature;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testToString() {
        Element element = new Hg();
        assertEquals("GIFTIG\nHg: melting at 234.32K, boiling at 630.2K.", element.toString());
    }

    @Test
    public void testEquals() {
        Element hg1 = new Hg();
        Element hg2 = new Hg();
        Element hg3 = new Hg();
        Element n = new N();

        // Reflexivity
        assertEquals(hg1, hg1);
        // Symmetry
        assertEquals(hg1, hg2);
        assertEquals(hg2, hg1);
        // Transitivity
        assertEquals(hg1, hg2);
        assertEquals(hg1, hg3);
        assertEquals(hg2, hg3);
        // Consistency
        assertNotEquals(hg1, n);
        assertNotEquals(hg1, n);
        assertEquals(hg1, hg2);
        assertEquals(hg1, hg2);
        // null Comparison
        assertNotEquals(hg1, null);
        // Comparison with different types
        assertNotEquals(hg1, "hello");
    }

    @Test
    public void testHashCode() {
        Element hg1 = new Hg();
        Element hg2 = new Hg();
        Element hg3 = new Hg();
        Element n = new N();

        // Reflexivity
        assertEquals(hg1.hashCode(), hg1.hashCode());
        // Symmetry
        assertEquals(hg1.hashCode(), hg2.hashCode());
        assertEquals(hg2.hashCode(), hg1.hashCode());
        // Transitivity
        assertEquals(hg1.hashCode(), hg2.hashCode());
        assertEquals(hg1.hashCode(), hg3.hashCode());
        assertEquals(hg2.hashCode(), hg3.hashCode());
        // Consistency
        assertNotEquals(hg1.hashCode(), n.hashCode());
        assertNotEquals(hg1.hashCode(), n.hashCode());
        assertEquals(hg1.hashCode(), hg2.hashCode());
        assertEquals(hg1.hashCode(), hg2.hashCode());
        // Comparison with different types
        assertNotEquals(hg1.hashCode(), "hello".hashCode());
    }
}
