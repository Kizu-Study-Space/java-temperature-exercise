package ch.hslu.oop.temperature;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureTest {

    @Test
    public void getCelsius() {
        Temperature temperature = new Temperature(5);
        assertEquals(5, temperature.getCelsius());
        temperature = new Temperature();
        assertEquals(20, temperature.getCelsius());
    }

    @Test
    public void getFahrenheit() {
        Temperature temperature = new Temperature((double) -40);
        assertEquals((double) -40, temperature.getFahrenheit());
    }

    @Test
    public void getKelvin() {
        Temperature temperature = new Temperature((double) 20);
        assertEquals( 293.15, temperature.getKelvin());
    }

    @Test
    public void warmUpByCelsius() {
        Temperature temperature = new Temperature((double) 20);
        assertEquals( 25, temperature.warmUpByCelsius(5).getCelsius());
    }

    @Test
    public void coolDownByCelsius() {
        Temperature temperature = new Temperature((double) 20);
        assertEquals( 15, temperature.coolDownByCelsius(5).getCelsius());
    }

    @Test
    public void warmUpByKelvin() {
        Temperature temperature = new Temperature((double) 20);
        assertEquals( 298.15, temperature.warmUpByKelvin(5).getKelvin());
    }

    @Test
    public void coolDownByKelvin() {
        Temperature temperature = new Temperature((double) 20);
        assertEquals( 290.15, temperature.coolDownByKelvin(3).getKelvin());
    }

    @Test
    public void warmUpByFahrenheit() {
        Temperature temperature = new Temperature((double) -40);
        assertEquals( 0, temperature.warmUpByFahrenheit(40).getFahrenheit());
    }

    @Test
    public void coolDownByFahrenheit() {
        Temperature temperature = new Temperature((double) -40);
        assertEquals( -80, temperature.coolDownByFahrenheit(40).getFahrenheit());
    }

    @Test
    public void stateOfMatterOf() {
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
}
