package ch.hslu.oop.temperature;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NTest {
    @Test
    public void testGetAtomicNumber() {
        final Element n = new N();
        assertEquals(7, n.getAtomicNumber());
    }

    @Test
    public void testGetName() {
        final Element n = new N();
        assertEquals("Stickstoff", n.getName());
    }

    @Test
    public void testGetShortName() {
        final Element n = new N();
        assertEquals("N", n.getShortName());
    }

    @Test
    public void testGetStateOfMatter() {
        final Element n = new N();
        assertEquals("Stickstoff ist fest bei -210.01 Grad Celsius", n.getStateOfMatter(new Temperature(63.14)));
        assertEquals("Stickstoff ist flüssig bei -210.00 Grad Celsius", n.getStateOfMatter(new Temperature(63.15)));
        assertEquals("Stickstoff ist flüssig bei -195.80 Grad Celsius", n.getStateOfMatter(new Temperature(77.35)));
        assertEquals("Stickstoff ist gasförmig bei -195.79 Grad Celsius", n.getStateOfMatter(new Temperature(77.36)));
    }

    @Test
    public void testToString() {
        final Element n = new N();
        assertEquals("N: melting at 63.15K, boiling at 77.36K.", n.toString());
    }

    @Test
    public void testEquals() {
        final Element n1 = new N();
        final Element n2 = new N();
        final Element n3 = new N();
        final Element hg = new Hg();

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
        final Element n1 = new N();
        final Element n2 = new N();
        final Element n3 = new N();
        final Element hg = new Hg();

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

    @Test
    public void testCompareTo() {
        final Element n1 = new N();
        final Element n2 = new N();
        final Element hg = new Hg();
        final Element pb = new Pb();

        assertEquals(0, n1.compareTo(n2));
        assertTrue(n1.compareTo(hg) < 0);
        assertTrue(n1.compareTo(pb) < 0);
    }
}
