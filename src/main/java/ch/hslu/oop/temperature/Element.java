package ch.hslu.oop.temperature;

public enum Element implements Comparable<Element> {
  N(7, "N", "Stickstoff", 63.15, 77.36),
  HG(80, "Hg", "Quecksilber", 234.32, 630.2),
  PB(82, "Pb", "Blei", 600.61, 2022);

  private final Temperature meltingPoint;
  private final Temperature boilingPoint;
  private final int atomicNumber;
  private final String name;
  private final String shortName;
  
  Element (final int atomicNumber, final String shortName, final String name, final double meltingPoint, final double boilingPoint) {
    this.meltingPoint = Temperature.createWithKelvin(meltingPoint);
    this.boilingPoint = Temperature.createWithKelvin(boilingPoint);
    this.atomicNumber = atomicNumber;
    this.name = name;
    this.shortName = shortName;
  }

  final StateOfMatter getStateOfMatterAt(final Temperature temperature) {
    if (temperature.compareTo(meltingPoint) < 0) return StateOfMatter.SOLID;
    if (temperature.compareTo(boilingPoint)  < 0) return StateOfMatter.LIQUID;
    return StateOfMatter.GAS;
  }

  @Override
  public String toString() {
    return this.shortName + ": melting at " + this.meltingPoint.getKelvin() + "K, boiling at " + this.boilingPoint.getKelvin() + "K.";
  }

  public final int getAtomicNumber() {return this.atomicNumber;}

  public final String getName() {
    return this.name;
  }

  public final String getShortName() {
    return this.shortName;
  }
}
