/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import com.base.admin.constant.ApiRole;
import com.base.admin.entity.Authorities;
import com.base.admin.mapper.AuthoritiesMapper;
import com.base.admin.mapper.UsersAuthoritiesMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {
    private final UsersAuthoritiesMapper usersAuthoritiesMapper;
    private final AuthoritiesMapper authoritiesMapper;

    public AuthoritiesServiceImpl(UsersAuthoritiesMapper usersAuthoritiesMapper, AuthoritiesMapper authoritiesMapper) {
        this.usersAuthoritiesMapper = usersAuthoritiesMapper;
        this.authoritiesMapper = authoritiesMapper;
    }

//    @Override
//    public int deleteById(UUID authorityid) {
//        return authoritiesMapper.deleteById(authorityid);
//    }
//
//    @Override
//    public int insert(Authorities row) {
//        return authoritiesMapper.insert(row);
//    }
//
//    @Override
//    public Authorities findById(UUID authorityid) {
//        return authoritiesMapper.findById(authorityid);
//    }
//
//    @Override
//    public int update(Authorities row) {
//        return authoritiesMapper.update(row);
//    }

    @Override
    public boolean initializeAuthorities() {
        try {
            usersAuthoritiesMapper.deleteAll();
            authoritiesMapper.deleteAll();
            List<Authorities> authorities = new ArrayList<>();

            Arrays.asList(ApiRole.values())
                    .forEach(name -> authorities.add(new Authorities(UUID.randomUUID(), name.toString()))
                    );

            authoritiesMapper.saveAll(authorities);
//            Authorities row = new Authorities(UUID.randomUUID(), "test");
//            UUID ret = authoritiesMapper.inserttest(row);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}