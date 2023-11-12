package ch.hslu.oop.temperature;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PbTest {
    @Test
    public void testGetAtomicNumber() {
        final Element pb = new Pb();
        assertEquals(82, pb.getAtomicNumber());
    }

    @Test
    public void testGetName() {
        final Element pb = new Pb();
        assertEquals("Blei", pb.getName());
    }

    @Test
    public void testGetShortName() {
        final Element pb = new Pb();
        assertEquals("Pb", pb.getShortName());
    }

    @Test
    public void testGetStateOfMatter() {
        final Element pb = new Pb();
        assertEquals("Blei ist fest bei 327.45 Grad Celsius", pb.getStateOfMatter(new Temperature(600.60)));
        assertEquals("Blei ist flüssig bei 327.46 Grad Celsius", pb.getStateOfMatter(new Temperature(600.61)));
        assertEquals("Blei ist flüssig bei 1748.84 Grad Celsius", pb.getStateOfMatter(new Temperature(2021.99)));
        assertEquals("Blei ist gasförmig bei 1748.85 Grad Celsius", pb.getStateOfMatter(new Temperature(2022)));
    }

    @Test
    public void testToString() {
        final Element pb = new Pb();
        assertEquals("Pb: melting at 600.61K, boiling at 2022.0K.", pb.toString());
    }

    @Test
    public void testEquals() {
        final Element pb1 = new Pb();
        final Element pb2 = new Pb();
        final Element pb3 = new Pb();
        final Element n = new N();

        // Reflexivity
        assertEquals(pb1, pb1);
        // Symmetry
        assertEquals(pb1, pb2);
        assertEquals(pb2, pb1);
        // Transitivity
        assertEquals(pb1, pb2);
        assertEquals(pb1, pb3);
        assertEquals(pb2, pb3);
        // Consistency
        assertNotEquals(pb1, n);
        assertNotEquals(pb1, n);
        assertEquals(pb1, pb2);
        assertEquals(pb1, pb2);
        // null Comparison
        assertNotEquals(pb1, null);
        // Comparison with different types
        assertNotEquals(pb1, "hello");
    }

    @Test
    public void testHashCode() {
        final Element pb1 = new Pb();
        final Element pb2 = new Pb();
        final Element pb3 = new Pb();
        final Element n = new N();

        // Reflexivity
        assertEquals(pb1.hashCode(), pb1.hashCode());
        // Symmetry
        assertEquals(pb1.hashCode(), pb2.hashCode());
        assertEquals(pb2.hashCode(), pb1.hashCode());
        // Transitivity
        assertEquals(pb1.hashCode(), pb2.hashCode());
        assertEquals(pb1.hashCode(), pb3.hashCode());
        assertEquals(pb2.hashCode(), pb3.hashCode());
        // Consistency
        assertNotEquals(pb1.hashCode(), n.hashCode());
        assertNotEquals(pb1.hashCode(), n.hashCode());
        assertEquals(pb1.hashCode(), pb2.hashCode());
        assertEquals(pb1.hashCode(), pb2.hashCode());
        // Comparison with different types
        assertNotEquals(pb1.hashCode(), "hello".hashCode());
    }

    @Test
    public void testCompareTo() {
        final Element pb1 = new Pb();
        final Element pb2 = new Pb();
        final Element n = new N();
        final Element hg = new Hg();

        assertEquals(0, pb1.compareTo(pb2));
        assertTrue(pb1.compareTo(n) > 0);
        assertTrue(pb1.compareTo(hg) > 0);
    }
}
