package ch.hslu.oop.temperature;

public class Element{
  private double kelvinMeltingPoint;
  private double kelvinBoilingPoint;
  private String name;
  private String shortName;
  
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

  String getName() {
    return this.name;
  }

  String getShortName() {
    return this.shortName;
  }
}
