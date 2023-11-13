package ch.hslu.oop.temperature;

import java.util.HashSet;
import java.util.Set;

public class ElementController {
    private final Set<Element> elements = new HashSet<>();

    public ElementController() {
        this.elements.add(new N());
        this.elements.add(new Hg());
        this.elements.add(new Pb());
    }
    public String stateOfMatterOf(String elementString, double temperatureNumber) {
        return elementFrom(elementString).getStateOfMatter(Temperature.createWithCelsius(temperatureNumber));
    }

    private Element elementFrom(String shortName) {
        return this.elements.stream().filter(element -> element.getShortName().equals(shortName)).findFirst().orElseThrow();
    }
}
