package org.acme;

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.acme.enums.AnimalType;
import org.acme.mappers.AnimalEntityMapper;
import org.acme.model.AnimalEntity;
import org.acme.model.Cat;
import org.acme.model.Dog;
import org.acme.model.Dolphin;
import org.acme.model.Rat;

@Log4j2
@ApplicationScoped
@RequiredArgsConstructor
public class ZooRepository implements PanacheRepositoryBase<AnimalEntity, Long> {

  private final AnimalEntityMapper animalEntityMapper;

  private Uni<List<AnimalEntity>> getAnimals(String ownerId, AnimalType animalType) {
    return list("ownerId = ?1 AND animalType = ?2", ownerId, animalType).log()
        .onItem()
        .invoke(
            result ->
                log.debug(
                    "Found {} entities for parameters '{}' - '{}'",
                    result.size(),
                    ownerId,
                    animalType))
        .onFailure()
        .invoke(
            throwable ->
                log.error(
                    "Error while getting accounts for parameters '{}' - '{}'",
                    ownerId,
                    animalType,
                    throwable));
  }

  @WithSession
  public Uni<List<Dog>> getDogs(String ownerId) {
    return getAnimals(ownerId, AnimalType.DOG).map(animalEntityMapper::mapToDogs);
  }

  @WithSession
  public Uni<List<Cat>> getCats(String ownerId) {
    return getAnimals(ownerId, AnimalType.CAT).map(animalEntityMapper::mapToCats);
  }

  @WithSession
  public Uni<List<Rat>> getRats(String ownerId) {
    return getAnimals(ownerId, AnimalType.RAT).map(animalEntityMapper::mapToRats);
  }

  @WithSession
  public Uni<List<Dolphin>> getDoplphins(String ownerId) {
    return getAnimals(ownerId, AnimalType.DOLPHIN).map(animalEntityMapper::mapToDolphins);
  }
}
