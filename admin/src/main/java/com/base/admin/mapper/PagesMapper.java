package com.base.admin.mapper;

import com.base.admin.dto.PagesDTO;
import com.base.admin.dto.PermissionsDTO;
import com.base.admin.dto.authentication.MenuDTO;
import com.base.admin.entity.Pages;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
public interface PagesMapper {
    Pages findById(@Param("pageid") UUID pageid, @Param("moduleid") UUID moduleid);

    List<Pages> findByModuleId(@Param("moduleid") UUID moduleid);

    List<PagesDTO> findMenuItemByRoleIdAndModuleId(@Param("roleid") UUID roleid, @Param("moduleid") UUID moduleid);

    int insert(Pages row);

    int update(Pages row);

    List<MenuDTO> getUserMenuForOrganization(@Param("userid") UUID userid, @Param("organizationid") UUID organizationid);

    List<MenuDTO> getUserMenuForOrganizationNormal(@Param("userid") UUID userid, @Param("organizationid") UUID organizationid);

    List<PermissionsDTO> getMenuPermission(@Param("userid") UUID userid, @Param("organizationid") UUID organizationid);

//    List<Pages> getUserMenuNormal(@Param("userid") UUID userid);

    int deleteById(@Param("pageid") UUID pageid, @Param("moduleid") UUID moduleid);

    @Delete("delete from pages")
    int deleteAll();

    int saveAll(@Param("list") List<Pages> list);
}