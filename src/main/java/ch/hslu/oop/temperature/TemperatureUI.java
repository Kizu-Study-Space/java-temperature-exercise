package ch.hslu.oop.temperature;

import java.util.Scanner;

public class TemperatureUI {
    public static void main(String[] args) {
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        String input;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.nextLine();
            if (input.equals("exit")) break;
            try {
                Temperature temperature = Temperature.createWithKelvin(Double.valueOf(input));
                System.out.println(temperature.toString());
                temperatureHistory.add(temperature);
            } catch (NumberFormatException exception) {
                System.out.println("Diese Zahl ist ungültig...");
            }
        }
        System.out.println("================================");
        System.out.println("|| Temperatur Zusammenfassung ||");
        System.out.println("================================");
        System.out.printf("|| Anzahl:             %d\n", temperatureHistory.getCount());
        System.out.printf("|| Durchschnitt:       %.2fK\n", temperatureHistory.averageTemperature().getKelvin());
        System.out.printf("|| Minimaltemperatur:  %.2fK\n", temperatureHistory.lowestTemperature().getKelvin());
        System.out.printf("|| Maximaltemperatur:  %.2fK\n", temperatureHistory.highestTemperature().getKelvin());
        System.out.println("================================");
        System.out.println("Programm beendet.");
    }
}
