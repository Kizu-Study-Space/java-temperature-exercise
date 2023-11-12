package ch.hslu.oop.temperature;

import java.util.*;

public final class TemperatureHistory {
    private final List<Temperature> temperatures = new ArrayList<>();

    public void add(Temperature temperature) {
        this.temperatures.add(temperature);
    }

    public int getCount() {
        return temperatures.size();
    }

    public void clear() {
        temperatures.clear();
    }

    public Temperature highestTemperature() throws EmptyTemperatureHistoryException {
        if (temperatures.isEmpty()) throw new EmptyTemperatureHistoryException();
        return Collections.max(temperatures);
    }

    public Temperature lowestTemperature() throws EmptyTemperatureHistoryException {
        if (temperatures.isEmpty()) throw new EmptyTemperatureHistoryException();
        return Collections.min(temperatures);
    }

    public Temperature averageTemperature() {
        return new Temperature(temperatures.stream().mapToDouble(Temperature::getCelsius).average().orElseThrow());
    }
}
