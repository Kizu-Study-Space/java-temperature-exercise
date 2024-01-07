package ch.hslu.oop.temperature;

public final class MinTemperatureEvent {
    private final TemperatureHistory temperatureHistory;

    public MinTemperatureEvent(TemperatureHistory temperatureHistory) {
        this.temperatureHistory = temperatureHistory;
    }

    public TemperatureHistory getTemperatureHistory() {
        return this.temperatureHistory;
    }
}
