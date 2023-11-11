package ch.hslu.oop.temperature;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TemperatureTest {

    @Test
    public void testGetCelsius() {
        Temperature temperature = new Temperature(5);
        assertEquals(5, temperature.getCelsius());
        temperature = new Temperature();
        assertEquals(20, temperature.getCelsius());
    }

    @Test
    public void testGetFahrenheit() {
        Temperature temperature = new Temperature(-40);
        assertEquals(-40, temperature.getFahrenheit());
    }

    @Test
    public void testGetKelvin() {
        Temperature temperature = new Temperature(20);
        assertEquals(293.15, temperature.getKelvin());
    }

    @Test
    public void testWarmUpByCelsius() {
        Temperature temperature = new Temperature(20);
        assertEquals(25, temperature.warmUpByCelsius(5).getCelsius());
    }

    @Test
    public void testCoolDownByCelsius() {
        Temperature temperature = new Temperature(20);
        assertEquals(15, temperature.coolDownByCelsius(5).getCelsius());
    }

    @Test
    public void testWarmUpByKelvin() {
        Temperature temperature = new Temperature(20);
        assertEquals(298.15, temperature.warmUpByKelvin(5).getKelvin());
    }

    @Test
    public void testCoolDownByKelvin() {
        Temperature temperature = new Temperature(20);
        assertEquals(290.15, temperature.coolDownByKelvin(3).getKelvin());
    }

    @Test
    public void testWarmUpByFahrenheit() {
        Temperature temperature = new Temperature(-40);
        assertEquals( 0, temperature.warmUpByFahrenheit(40).getFahrenheit());
    }

    @Test
    public void testCoolDownByFahrenheit() {
        Temperature temperature = new Temperature(-40);
        assertEquals( -80, temperature.coolDownByFahrenheit(40).getFahrenheit());
    }

    @Test
    public void testStateOfMatterOf() {
        Temperature temperature = new Temperature(20);
        assertEquals("gas", temperature.stateOfMatterOf("N"));
        assertEquals("liquid", temperature.stateOfMatterOf("Hg"));
        assertEquals("solid", temperature.stateOfMatterOf("Pb"));

        temperature = new Temperature(1000);
        assertEquals("gas", temperature.stateOfMatterOf("N"));
        assertEquals("gas", temperature.stateOfMatterOf("Hg"));
        assertEquals("liquid", temperature.stateOfMatterOf("Pb"));
    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Temperature.class).withOnlyTheseFields("celsius").verify();
    }

    @Test
    public void testCompareTo() {
        Temperature temperature1 = new Temperature(53);
        Temperature temperature2 = new Temperature(28);
        Temperature temperature3 = new Temperature(28);

        assertEquals(0, temperature2.compareTo(temperature3));
        assertTrue(temperature1.compareTo(temperature2) > 0);
        assertTrue(temperature2.compareTo(temperature1) < 0);
    }
}
