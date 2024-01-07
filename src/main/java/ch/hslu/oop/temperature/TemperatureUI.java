package ch.hslu.oop.temperature;

import java.util.Scanner;

public class TemperatureUI implements MaxTemperatureListener{

    TemperatureHistory temperatureHistory;

    public TemperatureUI() {
        this.temperatureHistory = new TemperatureHistory();
        this.temperatureHistory.addMaxTemperatureListener(this);
    }

    public static void main(String[] args) {
        TemperatureUI temperatureUI = new TemperatureUI();
        String input;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.nextLine();
            if (input.equals("exit")) break;
            try {
                Temperature temperature = Temperature.createWithKelvin(Double.valueOf(input));
                System.out.println(temperature.toString());
                temperatureUI.temperatureHistory.add(temperature);
            } catch (NumberFormatException exception) {
                System.out.println("Diese Zahl ist ungültig...");
            }
        }
        System.out.println("================================");
        System.out.println("|| Temperatur Zusammenfassung ||");
        System.out.println("================================");
        System.out.printf("|| Anzahl:             %d\n", temperatureUI.temperatureHistory.getCount());
        System.out.printf("|| Durchschnitt:       %.2fK\n", temperatureUI.temperatureHistory.averageTemperature().getKelvin());
        System.out.printf("|| Minimaltemperatur:  %.2fK\n", temperatureUI.temperatureHistory.lowestTemperature().getKelvin());
        System.out.printf("|| Maximaltemperatur:  %.2fK\n", temperatureUI.temperatureHistory.highestTemperature().getKelvin());
        System.out.println("================================");
        System.out.println("Programm beendet.");
    }

    @Override
    public void maxTemperatureChange(MaxTemperatureEvent event) {
        System.out.println("The new max is " + event.getTemperatureHistory().highestTemperature());
    }
}
