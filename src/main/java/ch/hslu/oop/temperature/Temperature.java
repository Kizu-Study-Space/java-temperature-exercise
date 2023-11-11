package ch.hslu.oop.temperature;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Temperature {
    private final double celsius;
    private final List<Element> elements = new ArrayList<>();

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
        return this.celsius + (double) 273.15;
    }

    public double getFahrenheit() {
        return (celsius * (double) 1.8) + (double) 32;
    }

    public Temperature warmUpByCelsius(double warmUpBy) {
        //this.celsius += warmUpBy;
        return new Temperature(this.celsius + warmUpBy);
    }

    public Temperature coolDownByCelsius(double coolDownBy) {
        //this.celsius -= coolDownBy;
        return new Temperature(this.celsius - coolDownBy);
    }

    public Temperature warmUpByKelvin(double warmUpBy) {
        return this.warmUpByCelsius(warmUpBy);
    }

    public Temperature coolDownByKelvin(double coolDownBy) {
        return this.coolDownByCelsius(coolDownBy);
    }

    public Temperature warmUpByFahrenheit(float warmUpBy){
        return this.warmUpByCelsius(this.celsiusStepsFromFahrenheitSteps(warmUpBy));
    }

    public Temperature coolDownByFahrenheit(float coolDownBy){
        return this.coolDownByCelsius(celsiusStepsFromFahrenheitSteps(coolDownBy));
    }

    public String stateOfMatterOf(String elementString) {
        Element element = this.elements.stream().filter(elementFromList -> elementString.equals(elementFromList.getShortName())).findFirst().orElse(null);
        return element.getStateOfMatter(this.getKelvin());
    }

    private double celsiusStepsFromFahrenheitSteps(double fahrenheit) {
        return fahrenheit / (double) 1.8;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.celsius);
    }

    @Override
    public final boolean equals (Object object) {
        if (this == object) return true;
        if (object instanceof Temperature temperature) {
            return ((Double) this.celsius).equals((Double) temperature.celsius);
        }
        return false;
    }
}
