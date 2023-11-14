package ch.hslu.oop.temperature;

public enum StateOfMatter {
    SOLID("fest"), LIQUID("flüssig"), GAS("gasförmig");

    private final String germanName;

    StateOfMatter(String germanName) {
        this.germanName = germanName;
    }

    public String toGermanString(Element element, Temperature temperature) {
        return String.format("%s ist %s bei %.2f Grad Celsius", element.getName(), this.germanName, temperature.getCelsius());
    }
}
