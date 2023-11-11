package ch.hslu.oop.temperature;

import java.util.Comparator;

public class ElementShortNameComparator implements Comparator<Element> {

    @Override
    public int compare(Element element1, Element element2) {
        return element1.getShortName().compareTo(element2.getShortName());
    }
}
