package ch.hslu.oop.temperature;

public class InvalidTemperatureException extends RuntimeException {
    public InvalidTemperatureException() {
        super("This temperature is invalid. Make sure that the temperature is a valid number and isn't below 0 Kelvin (-273.15 degrees Celsius).");
    }
}
