package ch.hslu.oop.temperature;

import java.util.ArrayList;

public class Temperature {
    private double celsius;
    private ArrayList<Element> elements;

    public Temperature () {
        this(20);
    }

    public Temperature (final double celsius) {
        this.celsius = celsius;

        this.elements = new ArrayList();
        this.elements.add(new N());
        this.elements.add(new Hg());
        this.elements.add(new Pb());
    }

    public double getCelsius(){
        return this.celsius;
    }

    public void setCelsius(final double celsius){
        this.celsius = celsius;
    }

    public double getKelvin() {
        return this.celsius + (double) 273.15;
    }

    public double getFahrenheit() {
        return (celsius * (double) 1.8) + (double) 32;
    }

    public void warmUpByCelsius(double warmUpBy) {
        this.celsius += warmUpBy;
    }

    public void coolDownByCelsius(double coolDownBy) {
        this.celsius -= coolDownBy;
    }

    public void warmUpByKelvin(double warmUpBy) {
        this.warmUpByCelsius(warmUpBy);
    }

    public void coolDownByKelvin(double coolDownBy) {
        this.coolDownByCelsius(coolDownBy);
    }

    public void warmUpByFahrenheit(float warmUpBy){
        this.warmUpByCelsius(this.celsiusStepsFromFahrenheitSteps(warmUpBy));
    }

    public void coolDownByFahrenheit(float coolDownBy){
        this.coolDownByCelsius(celsiusStepsFromFahrenheitSteps(coolDownBy));
    }

    public String stateOfMatterOf(String elementString) {
        Element element = this.elements.stream().filter(elementFromList -> elementString.equals(elementFromList.getShortName())).findFirst().orElse(null);
        return element.getStateOfMatter(this.getKelvin());
    }

    private double celsiusStepsFromFahrenheitSteps(double fahrenheit) {
        return fahrenheit / (double) 1.8;
    }
}
