package org.acme.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.acme.enums.*;

@Entity(name = "animals")
@Getter
@Setter
@ToString
public class AnimalEntity {
  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "owner_id")
  private String ownerId;

  @Enumerated(EnumType.STRING)
  @Column(name = "animal_type")
  private AnimalType animalType;

  @Enumerated(EnumType.STRING)
  @Column(name = "cat_type")
  private CatType catType;

  @Enumerated(EnumType.STRING)
  @Column(name = "dog_type")
  private DogType dogType;

  @Enumerated(EnumType.STRING)
  @Column(name = "dolphin_type")
  private DolphinType dolphinType;

  @Enumerated(EnumType.STRING)
  @Column(name = "rat_type")
  private RatType ratType;

  @Column(name = "height")
  private String height;

  @Column(name = "length")
  private String length;
}
