package com.base.admin.mapper;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.dto.ModulesDTO;
import com.base.admin.entity.Modules;

@Mapper
public interface ModulesMapper {
    List<Modules> findAll();

    long countByListModuleId(@Param("list") List<UUID> moduleids);

    Modules findById(@Param("moduleid") UUID moduleid);

    int insert(Modules row);

    int saveAll(@Param("list") List<Modules> list);

    int update(Modules row);

    int deleteById(UUID moduleid);

    @Delete("DELETE FROM modules")
    int deleteAll();

    ModulesDTO findDTOById(UUID moduleid);

    long countPaged(@Param("search") ModulesDTO search, @Param("exact") boolean exact);

    List<ModulesDTO> searchPaged(
            @Param("search") ModulesDTO search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);

    List<ModulesDTO> findByRoleId(@Param("roleId") UUID roleId);
}
