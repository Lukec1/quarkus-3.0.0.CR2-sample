package org.acme.mappers;

import java.util.List;
import org.acme.model.*;
import org.mapstruct.*;

@Mapper(config = CommonMapperConfig.class)
public interface AnimalEntityMapper {

    @Mapping(source = "dogType", target = "type")
    Dog mapToDog(AnimalEntity entity);
    List<Dog> mapToDogs(List<AnimalEntity> entities);

    @Mapping(source = "catType", target = "type")
    Cat mapToCat(AnimalEntity entity);
    List<Cat> mapToCats(List<AnimalEntity> entities);

    @Mapping(source = "ratType", target = "type")
    Rat mapToRat(AnimalEntity entity);
    List<Rat> mapToRats(List<AnimalEntity> entities);

    @Mapping(source = "dolphinType", target = "type")
    Dolphin mapToDolphin(AnimalEntity entity);
    List<Dolphin> mapToDolphins(List<AnimalEntity> entities);
}
