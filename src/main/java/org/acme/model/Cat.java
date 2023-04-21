package org.acme.model;

import java.math.BigDecimal;
import lombok.Data;
import org.acme.enums.AnimalType;
import org.acme.enums.CatType;

@Data
public class Cat {
  private String name;
  private String description;
  private String ownerId;
  private AnimalType animalType;
  private CatType type;
  private BigDecimal height;
}
