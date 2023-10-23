package ch.hslu.oop.temperature;

public class Temperature {
    private double celsius;

    public Temperature () {
        this.celsius = (double) 20;
    }

    public Temperature (final double celsius) {
        this.celsius = celsius;
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

    private double celsiusStepsFromFahrenheitSteps(double fahrenheit) {
        return fahrenheit / (double) 1.8;
    }
}
