package ch.hslu.oop.temperature;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureHistoryTest {

    @Test
    public void testAdd() {
        final TemperatureHistory temperatureHistory = new TemperatureHistory();
        final Temperature temperature = new Temperature();
        temperatureHistory.add(temperature);
        assertEquals(1, temperatureHistory.getCount());
    }

    @Test
    public void testClear() {
        final TemperatureHistory temperatureHistory = new TemperatureHistory();
        final Temperature temperature0 = new Temperature();
        final Temperature temperature1 = new Temperature();
        final Temperature temperature2 = new Temperature();

        temperatureHistory.add(temperature0);
        temperatureHistory.add(temperature1);
        temperatureHistory.add(temperature2);
        assertEquals(3, temperatureHistory.getCount());

        temperatureHistory.clear();
        assertEquals(0, temperatureHistory.getCount());
    }

    @Test
    public void testGetCount() {
        final TemperatureHistory temperatureHistory = new TemperatureHistory();
        assertEquals(0, temperatureHistory.getCount());

        final Temperature temperature0 = new Temperature();
        final Temperature temperature1 = new Temperature();
        final Temperature temperature2 = new Temperature();
        temperatureHistory.add(temperature0);
        temperatureHistory.add(temperature1);
        temperatureHistory.add(temperature2);
        assertEquals(3, temperatureHistory.getCount());

        temperatureHistory.clear();
        assertEquals(0, temperatureHistory.getCount());
    }

    @Test
    public void testHighestTemperature() throws Exception {
        final TemperatureHistory temperatureHistory = new TemperatureHistory();
        assertThrows(EmptyTemperatureHistoryException.class, temperatureHistory::highestTemperature);

        final Temperature temperature0 = Temperature.createWithKelvin(12);
        final Temperature temperature1 = Temperature.createWithKelvin(23);
        final Temperature temperature2 = Temperature.createWithKelvin(14);
        temperatureHistory.add(temperature0);
        temperatureHistory.add(temperature1);
        temperatureHistory.add(temperature2);

        assertEquals(temperature1, temperatureHistory.highestTemperature());
    }

    @Test
    public void testLowestTemperature() throws Exception {
        final TemperatureHistory temperatureHistory = new TemperatureHistory();
        assertThrows(EmptyTemperatureHistoryException.class, temperatureHistory::lowestTemperature);

        final Temperature temperature0 = Temperature.createWithKelvin(17);
        final Temperature temperature1 = Temperature.createWithKelvin(23);
        final Temperature temperature2 = Temperature.createWithKelvin(14);
        temperatureHistory.add(temperature0);
        temperatureHistory.add(temperature1);
        temperatureHistory.add(temperature2);

        assertEquals(temperature2, temperatureHistory.lowestTemperature());
    }

    @Test
    public void testAverageTemperature() {
        final TemperatureHistory temperatureHistory = new TemperatureHistory();
        assertThrows(EmptyTemperatureHistoryException.class, temperatureHistory::averageTemperature);

        final Temperature temperature0 = Temperature.createWithCelsius(17);
        final Temperature temperature1 = Temperature.createWithCelsius(23);
        final Temperature temperature2 = Temperature.createWithCelsius(14);
        temperatureHistory.add(temperature0);
        temperatureHistory.add(temperature1);
        temperatureHistory.add(temperature2);

        assertEquals(18, temperatureHistory.averageTemperature().getCelsius());
    }
}
