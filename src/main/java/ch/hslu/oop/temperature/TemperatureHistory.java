package ch.hslu.oop.temperature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public Temperature highestTemperature() {
        return Collections.max(temperatures);
    }

    public Temperature lowestTemperature() {
        return Collections.min(temperatures);
    }

    public Temperature averageTemperature() {
        return new Temperature(temperatures.stream().mapToDouble(Temperature::getCelsius).average().orElse(0.0));
    }
}
