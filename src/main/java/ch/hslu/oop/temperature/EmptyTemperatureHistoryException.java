package ch.hslu.oop.temperature;

public class EmptyTemperatureHistoryException extends Exception{
    public EmptyTemperatureHistoryException() {
        super("Calculation cannot be made without stored temperatures!");
    }
}
