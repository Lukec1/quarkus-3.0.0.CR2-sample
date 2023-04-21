package org.acme.model;

import java.math.BigDecimal;
import lombok.Data;
import org.acme.enums.AnimalType;
import org.acme.enums.RatType;

@Data
public class Rat {
  private String name;
  private String description;
  private String ownerId;
  private AnimalType animalType;
  private RatType type;
  private BigDecimal length;
}
