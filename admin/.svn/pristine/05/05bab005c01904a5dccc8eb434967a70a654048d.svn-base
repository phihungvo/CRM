package com.base.admin.mapper;

import com.base.admin.dto.UsersDTO;
import com.base.admin.entity.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@Mapper
public interface UsersMapper {
    @Select("SELECT EXISTS(SELECT 1 FROM users WHERE userid=#{userid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existsById(@Param("userid") UUID userid);

    @Select("SELECT EXISTS(SELECT 1 FROM users WHERE UPPER(username)=UPPER(#{username}))")
    boolean existsByUsername(@Param("username") String username);

    @Select("SELECT EXISTS(SELECT 1 FROM users WHERE UPPER(emailaddress)=UPPER(#{emailaddress}))")
    boolean existsByEmailaddress(@Param("emailaddress") String emailaddress);

    @Select("SELECT EXISTS(SELECT 1 FROM users WHERE userid != #{userid,jdbcType=OTHER,typeHandler=UUIDTypeHandler} AND username=#{username})")
    boolean existsByUsernameAndDifferentUserId(@Param("userid") UUID userid, @Param("username") String username);

    @Select("SELECT EXISTS(SELECT 1 FROM users WHERE userid != #{userid,jdbcType=OTHER,typeHandler=UUIDTypeHandler} AND UPPER(emailaddress)=UPPER(#{emailaddress}))")
    boolean existsByEmailaddressAndDifferentUserId(@Param("userid") UUID userid, @Param("emailaddress") String emailaddress);


    @Select("SELECT userid, organizationid, username, fullname, emailaddress, jobtitle, gender, phonenumber, lockout, usertype, status" +
            " FROM users WHERE userid=#{userid,jdbcType=OTHER,typeHandler=UUIDTypeHandler}")
    UsersDTO findDTOById(@Param("userid") UUID userid);

    Users findById(UUID userid);

    List<UsersDTO> searchPaged(@Param("search") UsersDTO search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);

    long countPaged(@Param("search") UsersDTO search, @Param("exact") boolean exact);

    List<UsersDTO> searchPagedByOrganizationId(@Param("search") UsersDTO search, @Param("pageable") Pageable pageable, @Param("organizationid") UUID organizationid, @Param("inOrOut") boolean inOrOut, @Param("exact") boolean exact);

    long countPagedByOrganizationId(@Param("search") UsersDTO search, @Param("organizationid") UUID organizationid, @Param("inOrOut") boolean inOrOut, @Param("exact") boolean exact);

//    List<UsersDTO> searchPagedWithGroupId(@Param("search") UsersDTO search, @Param("pageable") Pageable pageable, @Param("groupid") UUID groupid, @Param("inOrOut") boolean inOrOut, @Param("exact") boolean exact);

//    long countPagedWithGroupId(@Param("search") UsersDTO search, @Param("groupid") UUID groupid, @Param("exact") boolean exact);

    long countByListUserId(@Param("list") List<UUID> list);

    int saveAll(@Param("list") List<Users> list);

    int deleteListByIds(@Param("list") List<UUID> list);

    int insert(Users row);

    int update(Users row);

    @Delete("DELETE FROM users WHERE userid=#{userid,jdbcType=OTHER,typeHandler=UUIDTypeHandler}")
    int deleteById(@Param("userid") UUID userid);

    @Delete("DELETE FROM users")
    int deleteAll();


    @Select("SELECT userid, organizationid, username, fullname, emailaddress, jobtitle, gender, phonenumber, lockout, usertype, status" +
            " FROM users WHERE emailaddress=#{emailaddress,jdbcType=VARCHAR}")
    UsersDTO findDTOByEmailaddress(@Param("emailaddress") String emailaddress);
}