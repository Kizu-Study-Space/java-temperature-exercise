package ch.hslu.oop.temperature;

import java.util.Objects;

public abstract class Element {
  private final double kelvinMeltingPoint;
  private final double kelvinBoilingPoint;
  private final String name;
  private final String shortName;
  
  protected Element (final String shortName, final String name, final double kelvinMeltingPoint, final double kelvinBoilingPoint) {
    this.kelvinMeltingPoint = kelvinMeltingPoint;
    this.kelvinBoilingPoint = kelvinBoilingPoint;
    this.name = name;
    this.shortName = shortName;
  }

  protected final String getStateOfMatter(final double currentKelvinTemperature) {
    if (currentKelvinTemperature < kelvinMeltingPoint) return "solid";
    if (currentKelvinTemperature < kelvinBoilingPoint) return "liquid";
    return "gas";
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

  public final String getName() {
    return this.name;
  }

  public final String getShortName() {
    return this.shortName;
  }
}
