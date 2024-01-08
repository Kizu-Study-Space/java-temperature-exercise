package ch.hslu.oop.temperature;

import java.util.*;

public final class TemperatureHistory {
    private final Collection<Temperature> temperatures = new ArrayList<>();
    private final List<MaxTemperatureListener> maxTemperatureListeners = new ArrayList<>();
    private final List<MinTemperatureListener> minTemperatureListeners = new ArrayList<>();

    public void addMaxTemperatureListener(final MaxTemperatureListener maxTemperatureListener) {
        this.maxTemperatureListeners.add(maxTemperatureListener);
    }

    public void removeMaxTemperatureListener(final MaxTemperatureListener maxTemperatureListener) {
        this.maxTemperatureListeners.remove(maxTemperatureListener);
    }

    public void addMinTemperatureListener(final MinTemperatureListener minTemperatureListener) {
        this.minTemperatureListeners.add(minTemperatureListener);
    }

    public void removeMinTemperatureListener(final MinTemperatureListener minTemperatureListener) {
        this.minTemperatureListeners.remove(minTemperatureListener);
    }

    public void fireMaxTemperatureEvent(final MaxTemperatureEvent maxTemperatureEvent) {
        for (final MaxTemperatureListener maxTemperatureListener : this.maxTemperatureListeners) {
            maxTemperatureListener.maxTemperatureChange(maxTemperatureEvent);
        }
    }

    public void fireMinTemperatureEvent(final MinTemperatureEvent minTemperatureEvent) {
        for (final MinTemperatureListener minTemperatureListener : this.minTemperatureListeners) {
            minTemperatureListener.minTemperatureChange(minTemperatureEvent);
        }
    }

    public void add(Temperature temperature) {
        this.temperatures.add(temperature);
        if (this.highestTemperature().equals(temperature)) {
            this.fireMaxTemperatureEvent(new MaxTemperatureEvent(this));
        }
        if (this.lowestTemperature().equals(temperature)) {
            this.fireMinTemperatureEvent(new MinTemperatureEvent(this));
        }
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

    public Temperature averageTemperature() throws EmptyTemperatureHistoryException {
        return Temperature.createWithKelvin(temperatures.stream().mapToDouble(Temperature::getKelvin).average().orElseThrow(EmptyTemperatureHistoryException::new));
    }

    public double[] kelvinValues() {
        double[] kelvinArray = new double[this.getCount()];
        for(int iterator = 0; iterator < this.getCount(); iterator++)  {
            ArrayList<Temperature> temporary = (ArrayList<Temperature>) this.temperatures;
            kelvinArray[iterator] = temporary.get(iterator).getKelvin();
        }
        return kelvinArray;
    }
}
