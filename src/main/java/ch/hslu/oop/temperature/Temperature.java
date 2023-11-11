package ch.hslu.oop.temperature;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Temperature implements Comparable<Temperature> {
    private final double celsius;
    private final List<Element> elements = new ArrayList<>();
    private static final double KELVIN_OFFSET = 273.15;
    private static final int FAHRENHEIT_OFFSET = 32;
    private static final double FAHRENHEIT_FACTOR = 1.8;

    public Temperature () {
        this(20);
    }

    public Temperature (final double celsius) {
        this.celsius = celsius;

        this.elements.add(new N());
        this.elements.add(new Hg());
        this.elements.add(new Pb());
    }

    public double getCelsius(){
        return this.celsius;
    }

    public double getKelvin() {
        return this.celsius + KELVIN_OFFSET;
    }

    public double getFahrenheit() {
        return fahrenheitFromCelsius(this.celsius);
    }

    public Temperature warmUpByCelsius(double warmUpBy) {
        return new Temperature(this.celsius + warmUpBy);
    }

    public Temperature coolDownByCelsius(double coolDownBy) {
        return new Temperature(this.celsius - coolDownBy);
    }

    public Temperature warmUpByKelvin(double warmUpBy) {
        return this.warmUpByCelsius(warmUpBy);
    }

    public Temperature coolDownByKelvin(double coolDownBy) {
        return this.coolDownByCelsius(coolDownBy);
    }

    public Temperature warmUpByFahrenheit(float warmUpBy){
        return this.warmUpByCelsius(celsiusStepsFromFahrenheitSteps(warmUpBy));
    }

    public Temperature coolDownByFahrenheit(float coolDownBy){
        return this.coolDownByCelsius(celsiusStepsFromFahrenheitSteps(coolDownBy));
    }

    public String stateOfMatterOf(String elementString) {
        Element element = this.elements.stream().filter(elementFromList -> elementString.equals(elementFromList.getShortName())).findFirst().orElse(null);
        return element.getStateOfMatter(this.getKelvin());
    }

    public static double fahrenheitFromCelsius(double celsius) {
        return celsius * FAHRENHEIT_FACTOR + FAHRENHEIT_OFFSET;
    }

    public static double celsiusFromFahrenheit(double fahrenheit) {
        return celsiusStepsFromFahrenheitSteps(fahrenheit - FAHRENHEIT_OFFSET);
    }

    private static double celsiusStepsFromFahrenheitSteps(double fahrenheit) {
        return fahrenheit / FAHRENHEIT_FACTOR;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.celsius);
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object instanceof Temperature temperature) {
            return ((Double) this.celsius).equals(temperature.celsius);
        }
        return false;
    }

    @Override
    public int compareTo(Temperature temperature) {
        return Double.compare(this.celsius, temperature.celsius);
    }
}
