package org.acme;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.acme.model.Cat;
import org.acme.model.Dog;
import org.acme.model.Dolphin;
import org.acme.model.Rat;

@ApplicationScoped
@RequiredArgsConstructor
public class ZooService {

  final ZooRepository zooRepository;

  public Uni<List<Dog>> getDogs(String owner) {
    return zooRepository.getDogs(owner);
  }

  public Uni<List<Cat>> getCats(String owner) {
    return zooRepository.getCats(owner);
  }

  public Uni<List<Rat>> getRats(String owner) {
    return zooRepository.getRats(owner);
  }

  public Uni<List<Dolphin>> getDoplphins(String owner) {
    return zooRepository.getDoplphins(owner);
  }
}
