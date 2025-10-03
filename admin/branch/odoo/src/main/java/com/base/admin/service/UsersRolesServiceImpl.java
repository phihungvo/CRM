/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import org.springframework.stereotype.Service;

import com.base.admin.mapper.UsersRolesMapper;

@Service
public class UsersRolesServiceImpl implements UsersRolesService {
    private final UsersRolesMapper usersRolesMapper;

    public UsersRolesServiceImpl(UsersRolesMapper usersRolesMapper) {
        this.usersRolesMapper = usersRolesMapper;
    }

    //    @Override
    //    public int deleteById(UUID userid, UUID roleid) {
    //        return usersRolesMapper.deleteById(userid, roleid);
    //    }
    //
    //    @Override
    //    public int insert(UsersRoles row) {
    //        return usersRolesMapper.insert(row);
    //    }
}
