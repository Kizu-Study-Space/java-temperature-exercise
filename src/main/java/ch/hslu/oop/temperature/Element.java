package ch.hslu.oop.temperature;

public enum Element implements Comparable<Element> {
  N(7, "N", "Stickstoff", 63.15, 77.36),
  HG(80, "Hg", "Quecksilber", 234.32, 630.2),
  PB(82, "Pb", "Blei", 600.61, 2022);
  private final double kelvinMeltingPoint;
  private final double kelvinBoilingPoint;
  private final int atomicNumber;
  private final String name;
  private final String shortName;
  
  Element (final int atomicNumber, final String shortName, final String name, final double kelvinMeltingPoint, final double kelvinBoilingPoint) {
    this.kelvinMeltingPoint = kelvinMeltingPoint;
    this.kelvinBoilingPoint = kelvinBoilingPoint;
    this.atomicNumber = atomicNumber;
    this.name = name;
    this.shortName = shortName;
  }

  final String getStateOfMatterAt(final Temperature temperature) {
    if (temperature.getKelvin() < kelvinMeltingPoint) return StateOfMatter.SOLID.toGermanString(this, temperature);
    if (temperature.getKelvin() < kelvinBoilingPoint) return StateOfMatter.LIQUID.toGermanString(this, temperature);
    return StateOfMatter.GAS.toGermanString(this, temperature);
  }

  @Override
  public String toString() {
    return this.shortName + ": melting at " + this.kelvinMeltingPoint + "K, boiling at " + this.kelvinBoilingPoint + "K.";
  }

  public final int getAtomicNumber() {return this.atomicNumber;}

  public final String getName() {
    return this.name;
  }

  public final String getShortName() {
    return this.shortName;
  }
}
