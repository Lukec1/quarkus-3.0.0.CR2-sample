package org.acme.model;

import java.math.BigDecimal;
import org.acme.enums.AnimalType;
import org.acme.enums.DogType;

public class Dog {
  private String name;
  private String description;
  private String ownerId;
  private AnimalType animalType;
  private DogType type;
  private BigDecimal height;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public AnimalType getAnimalType() {
    return animalType;
  }

  public void setAnimalType(AnimalType animalType) {
    this.animalType = animalType;
  }

  public DogType getType() {
    return type;
  }

  public void setType(DogType type) {
    this.type = type;
  }

  public BigDecimal getHeight() {
    return height;
  }

  public void setHeight(BigDecimal height) {
    this.height = height;
  }

}
