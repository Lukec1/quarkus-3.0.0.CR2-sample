package org.acme;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.acme.dtos.AnimalsDto;
import org.acme.model.Cat;
import org.acme.model.Dog;
import org.acme.model.Dolphin;
import org.acme.model.Rat;

@Path("/zoo")
@RequiredArgsConstructor
public class ZooResource {

  final ZooService zooService;

  @GET
  @Path("animals/{owner}")
  public Uni<AnimalsDto> getSampleObjects(@PathParam("owner") String owner) {
    Uni<List<Dog>> dogs = zooService.getDogs(owner);
    Uni<List<Cat>> cats = zooService.getCats(owner);
    Uni<List<Rat>> rats = zooService.getRats(owner);
    Uni<List<Dolphin>> dolphins = zooService.getDoplphins(owner);

    final AnimalsDto summary = new AnimalsDto();

    // recognized problems with this approach: https://github.com/quarkusio/quarkus/issues/28808
    //    return Uni.combine().all().unis(dogs, cats, rats, dolphins).asTuple().map(animal -> {
    //      summary.setDogs(animal.getItem1());
    //      summary.setCats(animal.getItem2());
    //      summary.setRats(animal.getItem3());
    //      summary.setDolphins(animal.getItem4());
    //      return summary;
    //    });

    return dogs.invoke(summary::setDogs)
        .chain(() -> cats.invoke(summary::setCats))
        .chain(() -> rats.invoke(summary::setRats))
        .chain(() -> dolphins.invoke(summary::setDolphins))
        .replaceWith(summary);
  }
}
