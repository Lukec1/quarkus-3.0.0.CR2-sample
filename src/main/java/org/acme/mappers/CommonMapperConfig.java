package org.acme.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingInheritanceStrategy;

@MapperConfig(
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    componentModel = MappingConstants.ComponentModel.JAKARTA,
    mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface CommonMapperConfig {}
