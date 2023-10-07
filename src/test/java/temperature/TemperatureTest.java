package temperature;

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
    public void setCelsius() {
        Temperature temperature = new Temperature();
        temperature.setCelsius((double) 3);
        assertEquals(3, temperature.getCelsius());
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
        temperature.warmUpByCelsius(5);
        assertEquals( 25, temperature.getCelsius());
    }

    @Test
    public void coolDownByCelsius() {
        Temperature temperature = new Temperature((double) 20);
        temperature.coolDownByCelsius(5);
        assertEquals( 15, temperature.getCelsius());
    }

    @Test
    public void warmUpByKelvin() {
        Temperature temperature = new Temperature((double) 20);
        temperature.warmUpByKelvin(5);
        assertEquals( 298.15, temperature.getKelvin());
    }

    @Test
    public void coolDownByKelvin() {
        Temperature temperature = new Temperature((double) 20);
        temperature.coolDownByKelvin(3);
        assertEquals( 290.15, temperature.getKelvin());
    }

    @Test
    public void warmUpByFahrenheit() {
        Temperature temperature = new Temperature((double) -40);
        temperature.warmUpByFahrenheit(40);
        assertEquals( 0, temperature.getFahrenheit());
    }

    @Test
    public void coolDownByFahrenheit() {
        Temperature temperature = new Temperature((double) -40);
        temperature.coolDownByFahrenheit(40);
        assertEquals( -80, temperature.getFahrenheit());
    }
}
