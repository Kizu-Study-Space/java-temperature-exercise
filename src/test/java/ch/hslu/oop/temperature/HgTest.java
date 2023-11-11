package ch.hslu.oop.temperature;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HgTest {
    @Test
    public void testGetAtomicNumber() {
        Element hg = new Hg();
        assertEquals(80, hg.getAtomicNumber());
    }

    @Test
    public void testGetName() {
        Element hg = new Hg();
        assertEquals("Quecksilber", hg.getName());
    }

    @Test
    public void testGetShortName() {
        Element hg = new Hg();
        assertEquals("Hg", hg.getShortName());
    }

    @Test
    public void testGetStateOfMatter() {
        Element hg = new Hg();
        assertEquals("solid", hg.getStateOfMatter(234.31));
        assertEquals("liquid", hg.getStateOfMatter(234.32));
        assertEquals("liquid", hg.getStateOfMatter(630.19));
        assertEquals("gas", hg.getStateOfMatter(630.2));
    }

    @Test
    public void testToString() {
        Element hg = new Hg();
        assertEquals("GIFTIG\nHg: melting at 234.32K, boiling at 630.2K.", hg.toString());
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

    @Test
    public void testCompareTo() {
        Element hg1 = new Hg();
        Element hg2 = new Hg();
        Element n = new N();
        Element pb = new Pb();

        assertEquals(0, hg1.compareTo(hg2));
        assertTrue(hg1.compareTo(n) > 0);
        assertTrue(hg1.compareTo(pb) < 0);
    }
}
