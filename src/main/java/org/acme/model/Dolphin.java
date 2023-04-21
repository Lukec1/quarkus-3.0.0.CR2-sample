package org.acme.model;

import java.math.BigDecimal;
import lombok.Data;
import org.acme.enums.AnimalType;
import org.acme.enums.DolphinType;

@Data
public class Dolphin {
  private String name;
  private String description;
  private String ownerId;
  private AnimalType animalType;
  private BigDecimal length;
  private DolphinType type;
}
