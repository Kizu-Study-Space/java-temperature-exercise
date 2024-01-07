package ch.hslu.oop.temperature;

public class MinTemperatureEvent {
    private TemperatureHistory temperatureHistory;

    public MinTemperatureEvent(TemperatureHistory temperatureHistory) {
        this.temperatureHistory = temperatureHistory;
    }

    public TemperatureHistory getTemperatureHistory() {
        return this.temperatureHistory;
    }
}
