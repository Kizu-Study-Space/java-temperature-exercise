package ch.hslu.oop.temperature;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testEquals() {
        Element pb1 = new Pb();
        Element pb2 = new Pb();
        Element pb3 = new Pb();
        Element n = new N();

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
        Element pb1 = new Pb();
        Element pb2 = new Pb();
        Element pb3 = new Pb();
        Element n = new N();

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
}
