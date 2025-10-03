package com.base.admin.mapper;

import com.base.admin.dto.OrganizationsDTO;
import com.base.admin.entity.Organizations;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@Mapper
public interface OrganizationsMapper {
    @Select("SELECT EXISTS(SELECT 1 FROM organizations WHERE organizationid=#{organizationid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existsById(@Param("organizationid") UUID organizationid);

    @Select("SELECT organizationid FROM organizations WHERE upper(organizationname) = upper(#{organizationname})")
    UUID getIdByName(@Param("organizationname") String organizationname);

    @Select("SELECT EXISTS(SELECT 1 FROM organizations WHERE upper(organizationname)=upper(#{organizationname}))")
    boolean existsByOrganizationName(@Param("organizationname") String organizationname);

    @Select("SELECT EXISTS(SELECT 1 FROM organizations WHERE organizationid != #{organizationid, jdbcType=OTHER,typeHandler=UUIDTypeHandler} AND upper(organizationname)=upper(#{organizationname}))")
    boolean existsByNameAndDifferentId(@Param("organizationid") UUID organizationid, @Param("organizationname") String organizationname);

    Organizations findById(@Param("organizationid") UUID organizationid);

    List<OrganizationsDTO> findDTOByUserId(@Param("userid") UUID userid, @Param("isSuperAdmin") boolean isSuperAdmin);

    OrganizationsDTO findDTOById(@Param("organizationid") UUID organizationid);

    List<OrganizationsDTO> searchPaged(@Param("search") OrganizationsDTO search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);

    long countPaged(@Param("search") OrganizationsDTO search, @Param("exact") boolean exact);

    int insert(Organizations row);

    int update(Organizations row);

    int deleteById(UUID organizationid);

    @Delete("delete from organizations")
    int deleteAll();
}