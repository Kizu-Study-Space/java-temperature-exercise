package ch.hslu.oop.temperature;

import java.util.Scanner;

public class TemperatureUI {
    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.nextLine();
            if (input.equals("exit")) break;
            try {
                Temperature temperature = Temperature.createWithKelvin(Double.valueOf(input));
                System.out.println(temperature.toString());
            } catch (NumberFormatException exception) {
                System.out.println("Diese Zahl ist ungültig...");
            }
        }
        System.out.println("Programm beendet.");
    }
}
