package ch.hslu.oop.temperature;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TemperatureTest {

    @Test
    public void testGetCelsius() {
        final Temperature temperature = Temperature.createWithCelsius(5);
        assertEquals(5, temperature.getCelsius());
        final Temperature defaultTemperature = new Temperature();
        assertEquals(20, defaultTemperature.getCelsius());
    }

    @Test
    public void testGetFahrenheit() {
        final Temperature temperature = Temperature.createWithCelsius(-40);
        assertEquals(-40, temperature.getFahrenheit());
    }

    @Test
    public void testGetKelvin() {
        final Temperature temperature = Temperature.createWithCelsius(20);
        assertEquals(293.15, temperature.getKelvin());
    }

    @Test
    public void testWarmUpByCelsius() {
        final Temperature temperature = Temperature.createWithCelsius(20);
        assertEquals(25, temperature.warmUpByCelsius(5).getCelsius());
    }

    @Test
    public void testCoolDownByCelsius() {
        final Temperature temperature = Temperature.createWithCelsius(20);
        assertEquals(15, temperature.coolDownByCelsius(5).getCelsius());
    }

    @Test
    public void testWarmUpByKelvin() {
        Temperature temperature = Temperature.createWithCelsius(20);
        assertEquals(298.15, temperature.warmUpByKelvin(5).getKelvin());
    }

    @Test
    public void testCoolDownByKelvin() {
        final Temperature temperature = Temperature.createWithCelsius(20);
        assertEquals(290.15, temperature.coolDownByKelvin(3).getKelvin());
    }

    @Test
    public void testWarmUpByFahrenheit() {
        final Temperature temperature = Temperature.createWithCelsius(-40);
        assertEquals( 0, temperature.warmUpByFahrenheit(40).getFahrenheit(), 0.00000000001);
    }

    @Test
    public void testCoolDownByFahrenheit() {
        final Temperature temperature = Temperature.createWithCelsius(-40);
        assertEquals( -80, temperature.coolDownByFahrenheit(40).getFahrenheit(), 0.00000000001);
    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Temperature.class).withOnlyTheseFields("kelvin").verify();
    }

    @Test
    public void testCompareTo() {
        final Temperature temperature1 = new Temperature(53);
        final Temperature temperature2 = new Temperature(28);
        final Temperature temperature3 = new Temperature(28);

        assertEquals(0, temperature2.compareTo(temperature3));
        assertTrue(temperature1.compareTo(temperature2) > 0);
        assertTrue(temperature2.compareTo(temperature1) < 0);
    }

    @Test
    public void testFahrenheitFromCelsius() {
        assertEquals(-40, Temperature.fahrenheitFromCelsius(-40));
        assertEquals(32, Temperature.fahrenheitFromCelsius(0));
        assertEquals(-459.67, Temperature.fahrenheitFromCelsius(-273.15),0.0000000000001);
    }

    @Test
    public void testCelsiusFromFahrenheit() {
        assertEquals(-40, Temperature.celsiusFromFahrenheit(-40));
        assertEquals(0, Temperature.celsiusFromFahrenheit(32));
        assertEquals(-273.15, Temperature.celsiusFromFahrenheit(-459.67),0.0000000000001);
    }
}
