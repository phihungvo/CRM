package com.base.admin.jwt;

import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.admin.constant.UserStatus;
import com.base.admin.mapper.JwtUsersMapper;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final JwtUsersMapper jwtUsersMapper;

    public UserDetailsServiceImpl(JwtUsersMapper jwtUsersMapper) {
        this.jwtUsersMapper = jwtUsersMapper;
    }

    @Override
    @Transactional
    public JwtUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JwtUsers jwtUser = jwtUsersMapper.loadJwtUserByUsername(username);
        if (jwtUser == null) {
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }
        // TODO Enable full flow
        if (jwtUser.getLockout() || jwtUser.getStatus() == UserStatus.STATUS_LOCKED.getValue()) {
            throw new LockedException("User Locked");
        }
        //        if (jwtUser.getStatus() == UserStatus.FORCE_CHANGE_PASSWORD.getValue()) {
        //            throw new DisabledException("It is first login. Password change is required!");
        //        }
        return JwtUserDetails.build(jwtUser);
    }
}
