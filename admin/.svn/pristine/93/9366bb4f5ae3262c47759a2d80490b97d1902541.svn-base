package com.base.admin.mapper;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;

import com.base.admin.dto.RolesDTO;
import com.base.admin.entity.Roles;

@Mapper
public interface RolesMapper {
    @Select("SELECT EXISTS(SELECT 1 FROM roles WHERE roleid=#{roleid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existById(@Param("roleid") UUID roleid);

    @Select("SELECT EXISTS(SELECT 1 FROM roles WHERE UPPER(rolename)=UPPER(#{rolename}))")
    boolean existsByRolename(@Param("rolename") String rolename);

    @Select(
            "SELECT EXISTS(SELECT 1 FROM roles WHERE UPPER(rolename)=UPPER(#{rolename}) AND organizationid=#{organizationid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existsByRolenameAndOrganizationId(
            @Param("rolename") String rolename, @Param("organizationid") UUID organizationid);

    @Select(
            "SELECT EXISTS(SELECT 1 FROM roles WHERE UPPER(rolename)=UPPER(#{rolename}) AND organizationid=#{organizationid,jdbcType=OTHER,typeHandler=UUIDTypeHandler} AND roleid!=#{roleid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existsByRolenameAndOrganizationIdAndDiffRoleId(
            @Param("rolename") String rolename,
            @Param("organizationid") UUID organizationid,
            @Param("roleid") UUID roleid);

    long countByListRoleId(@Param("list") List<UUID> list);

    int insert(Roles row);

    Roles findById(@Param("roleid") UUID roleid);

    RolesDTO findDTOById(@Param("roleid") UUID roleid);

    List<RolesDTO> searchPaged(
            @Param("search") RolesDTO search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);

    long countPaged(@Param("search") RolesDTO search, @Param("exact") boolean exact);

    //    List<RolesDTO> searchPagedWithGroupId(@Param("search") RolesDTO search, @Param("pageable") Pageable pageable,
    // @Param("groupid") UUID groupid, @Param("exact") boolean exact);
    //
    //    long countPagedWithGroupId(@Param("search") RolesDTO search, @Param("groupid") UUID groupid, @Param("exact")
    // boolean exact);

    List<UUID> getIdsByName(@Param("list") List<String> list);

    List<RolesDTO> findByOrganizationIdAndUserId(
            @Param("organizationid") UUID organizationid, @Param("userid") UUID userid);

    List<Roles> findAll();

    int update(Roles row);

    int saveAll(@Param("list") List<Roles> list);

    int deleteById(UUID roleid);

    @Delete("DELETE FROM roles")
    int deleteAll();

    @Select(
            "SELECT EXISTS(SELECT 1 FROM roles WHERE organizationid=#{organizationid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existsByOrganizationId(@Param("organizationid") UUID organizationid);

    @Delete("DELETE FROM roles WHERE organizationid=#{organizationid,jdbcType=OTHER,typeHandler=UUIDTypeHandler}")
    int deleteByOrganizationId(@Param("organizationid") UUID organizationid);
}
