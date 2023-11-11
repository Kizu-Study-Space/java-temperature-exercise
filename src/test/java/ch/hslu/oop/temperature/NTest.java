package ch.hslu.oop.temperature;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testToString() {
        Element element = new N();
        assertEquals("N: melting at 63.15K, boiling at 77.36K.", element.toString());
    }

    @Test
    public void testEquals() {
        Element n1 = new N();
        Element n2 = new N();
        Element n3 = new N();
        Element hg = new Hg();

        // Reflexivity
        assertEquals(n1, n1);
        // Symmetry
        assertEquals(n1, n2);
        assertEquals(n2, n1);
        // Transitivity
        assertEquals(n1, n2);
        assertEquals(n1, n3);
        assertEquals(n2, n3);
        // Consistency
        assertNotEquals(n1, hg);
        assertNotEquals(n1, hg);
        assertEquals(n1, n2);
        assertEquals(n1, n2);
        // null Comparison
        assertNotEquals(n1, null);
        // Comparison with different types
        assertNotEquals(n1, "hello");
    }

    @Test
    public void testHashCode() {
        Element n1 = new N();
        Element n2 = new N();
        Element n3 = new N();
        Element hg = new Hg();

        // Reflexivity
        assertEquals(n1.hashCode(), n1.hashCode());
        // Symmetry
        assertEquals(n1.hashCode(), n2.hashCode());
        assertEquals(n2.hashCode(), n1.hashCode());
        // Transitivity
        assertEquals(n1.hashCode(), n2.hashCode());
        assertEquals(n1.hashCode(), n3.hashCode());
        assertEquals(n2.hashCode(), n3.hashCode());
        // Consistency
        assertNotEquals(n1.hashCode(), hg.hashCode());
        assertNotEquals(n1.hashCode(), hg.hashCode());
        assertEquals(n1.hashCode(), n2.hashCode());
        assertEquals(n1.hashCode(), n2.hashCode());
        // Comparison with different types
        assertNotEquals(n1.hashCode(), "hello".hashCode());
    }
}
