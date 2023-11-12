package ch.hslu.oop.temperature;

public enum StateOfMatter {
    SOLID, LIQUID, GAS;

    public String toString(Element element, Temperature temperature) {
        switch (this) {
            case SOLID:
                return String.format("%s ist fest bei %.2f Grad Celsius", element.getName(), temperature.getCelsius());
            case LIQUID:
                return String.format("%s ist flüssig bei %.2f Grad Celsius", element.getName(), temperature.getCelsius());
            case GAS:
                return String.format("%s ist gasförmig bei %.2f Grad Celsius", element.getName(), temperature.getCelsius());
            default:
                return null;
        }
    }
}
