package ch.hslu.oop.temperature;

import java.util.Comparator;

public class ElementNameComparator implements Comparator<Element> {

    @Override
    public int compare(Element element1, Element element2) {
        return element1.getName().compareTo(element2.getName());
    }
}
