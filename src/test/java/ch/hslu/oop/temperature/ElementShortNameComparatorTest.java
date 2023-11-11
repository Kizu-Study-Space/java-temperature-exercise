package ch.hslu.oop.temperature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElementShortNameComparatorTest {

    @Test
    public void testCompare() {
        final Element n1 = new N();
        final Element n2 = new N();
        final Element hg = new Hg();
        final Element pb = new Pb();

        final ElementShortNameComparator comparator = new ElementShortNameComparator();
        assertEquals(0, comparator.compare(n1, n2));
        assertTrue(comparator.compare(n1, hg) > 0);
        assertTrue(comparator.compare(n1, pb) < 0);
        assertTrue(comparator.compare(hg, pb) < 0);
    }
}
