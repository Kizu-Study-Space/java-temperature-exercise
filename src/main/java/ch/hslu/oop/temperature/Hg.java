package ch.hslu.oop.temperature;

public class Hg extends Element {
    public Hg() {
        super("Hg", "Quecksilber", 234.32, 630.2);
    }

    @Override
    public String toString() {
        return "GIFTIG\n" + super.toString();
    }
}
