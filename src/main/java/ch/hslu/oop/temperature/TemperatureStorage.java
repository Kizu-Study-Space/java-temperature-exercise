package ch.hslu.oop.temperature;

import java.io.*;

public class TemperatureStorage {
    private final String file;

    public TemperatureStorage(String file) {
        this.file = file;
    }

    public void storeTemperatures(double[] temperatures) {
        try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.file))) {
            dataOutputStream.writeInt(temperatures.length);
            for(double temperature : temperatures) {
                dataOutputStream.writeDouble(temperature);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public double[] readTemperatures() {
        try(DataInputStream dataInputStream = new DataInputStream(new FileInputStream(this.file))) {
            int count = dataInputStream.readInt();
            double[] temperatures = new double[count];
            for(int iteration = 0; iteration < count; iteration++) {
                temperatures[iteration] = dataInputStream.readDouble();
            }
            return temperatures;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
