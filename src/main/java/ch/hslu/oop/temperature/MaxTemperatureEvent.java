package ch.hslu.oop.temperature;

public final class MaxTemperatureEvent {
    private final TemperatureHistory temperatureHistory;

    public MaxTemperatureEvent(TemperatureHistory temperatureHistory) {
        this.temperatureHistory = temperatureHistory;
    }

    public TemperatureHistory getTemperatureHistory() {
        return this.temperatureHistory;
    }
}
