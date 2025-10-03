package com.base.admin.inventory.mapstruct;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <D> for DTO.
 * @param <E> for Entity.
 * */
public interface EntityMapper<D, E> {
    D toDto(E entity);

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    E toEntity(D dto);

    List<D> toDtos(List<E> entities);

    List<E> toEntities(List<D> dtos);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget E entity, E dto);

    @Named("update")
    @BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget E entity, E dto);
}
