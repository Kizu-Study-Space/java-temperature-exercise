package ch.hslu.oop.temperature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElementNameComparatorTest {

    @Test
    public void testCompare() {
        final Element stickstoff = Element.N;
        final Element stickstoff2 = Element.N;
        final Element quecksilber = Element.HG;
        final Element blei = Element.PB;

        final ElementNameComparator comparator = new ElementNameComparator();
        assertEquals(0, comparator.compare(stickstoff, stickstoff2));
        assertTrue(comparator.compare(stickstoff, quecksilber) > 0);
        assertTrue(comparator.compare(stickstoff, blei) > 0);
        assertTrue(comparator.compare(blei, quecksilber) < 0);
    }
}
