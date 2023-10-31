package ch.hslu.oop.temperature;

public abstract class Element {
  private final double kelvinMeltingPoint;
  private final double kelvinBoilingPoint;
  private final String name;
  private final String shortName;
  
  public Element (final String shortName, final String name, final double kelvinMeltingPoint, final double kelvinBoilingPoint) {
    this.kelvinMeltingPoint = kelvinMeltingPoint;
    this.kelvinBoilingPoint = kelvinBoilingPoint;
    this.name = name;
    this.shortName = shortName;
  }

  String getStateOfMatter(final double currentKelvinTemperature) {
    if (currentKelvinTemperature < kelvinMeltingPoint) return "solid";
    if (currentKelvinTemperature < kelvinBoilingPoint) return "liquid";
    return "gas";
  }

  @Override
  public String toString() {
    return this.shortName + ": melting at " + this.kelvinMeltingPoint + "K, boiling at " + this.kelvinBoilingPoint + "K.";
  }

  String getName() {
    return this.name;
  }

  String getShortName() {
    return this.shortName;
  }
}
