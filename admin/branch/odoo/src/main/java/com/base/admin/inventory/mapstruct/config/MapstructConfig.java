package com.base.admin.inventory.mapstruct.config;

@org.mapstruct.MapperConfig(
        componentModel = "spring",
        imports = {java.util.UUID.class} // optional
        )
public interface MapstructConfig {}
