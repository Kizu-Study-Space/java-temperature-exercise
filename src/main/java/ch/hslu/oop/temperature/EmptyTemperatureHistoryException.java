package ch.hslu.oop.temperature;

public class EmptyTemperatureHistoryException extends RuntimeException {
    public EmptyTemperatureHistoryException() {
        super("Calculation cannot be made without stored temperatures! Please insert a Temperature to the history by using the add() method of the TemperatureHistory class");
    }
}
