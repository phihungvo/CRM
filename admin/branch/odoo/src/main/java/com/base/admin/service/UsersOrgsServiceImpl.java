/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import org.springframework.stereotype.Service;

import com.base.admin.mapper.UsersOrgsMapper;

@Service
public class UsersOrgsServiceImpl implements UsersOrgsService {
    private final UsersOrgsMapper usersOrgsMapper;

    public UsersOrgsServiceImpl(UsersOrgsMapper usersOrgsMapper) {
        this.usersOrgsMapper = usersOrgsMapper;
    }

    //    @Override
    //    public int deleteById(UUID organizationid, UUID userid) {
    //        return usersOrgsMapper.deleteById(organizationid, userid);
    //    }
    //
    //    @Override
    //    public int insert(UsersOrgs row) {
    //        return usersOrgsMapper.insert(row);
    //    }
    //
    //    @Override
    //    public int deleteByOrganizationId(UUID organizationid) {
    //        return usersOrgsMapper.deleteByOrganizationId(organizationid);
    //    }

}
