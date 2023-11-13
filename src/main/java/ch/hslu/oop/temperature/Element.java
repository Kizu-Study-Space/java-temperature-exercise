package ch.hslu.oop.temperature;

import java.util.Objects;

public abstract class Element implements Comparable<Element> {
  private final double kelvinMeltingPoint;
  private final double kelvinBoilingPoint;
  private final int atomicNumber;
  private final String name;
  private final String shortName;
  
  protected Element (final int atomicNumber, final String shortName, final String name, final double kelvinMeltingPoint, final double kelvinBoilingPoint) {
    this.kelvinMeltingPoint = kelvinMeltingPoint;
    this.kelvinBoilingPoint = kelvinBoilingPoint;
    this.atomicNumber = atomicNumber;
    this.name = name;
    this.shortName = shortName;
  }

  protected final String getStateOfMatter(final Temperature currentTemperature) {
    if (currentTemperature.getKelvin() < kelvinMeltingPoint) return StateOfMatter.SOLID.toGermanString(this, currentTemperature);
    if (currentTemperature.getKelvin() < kelvinBoilingPoint) return StateOfMatter.LIQUID.toGermanString(this, currentTemperature);
    return StateOfMatter.GAS.toGermanString(this, currentTemperature);
  }
  
  @Override
  public final boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null) return false;
    return obj.getClass() == this.getClass();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(this.getClass());
  }

  @Override
  public String toString() {
    return this.shortName + ": melting at " + this.kelvinMeltingPoint + "K, boiling at " + this.kelvinBoilingPoint + "K.";
  }

  @Override
  public final int compareTo(Element element) {
    return Integer.compare(this.atomicNumber, element.atomicNumber);
  }

  public final int getAtomicNumber() {return this.atomicNumber;}

  public final String getName() {
    return this.name;
  }

  public final String getShortName() {
    return this.shortName;
  }
}
