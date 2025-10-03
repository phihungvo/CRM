package com.base.admin.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
public class JwtUserDetails implements UserDetails {

    private UUID userid;

    private UUID organizationid;

    private String username;

    @JsonIgnore
    private String password;

    private String fullname;

    private String jobtitle;

    private Boolean lockout;

    private Integer usertype;

    private Integer status;

    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails(UUID userid, UUID organizationid, String username, String password, String fullname, String jobtitle, Boolean lockout, Integer usertype, Integer status,
                          Collection<? extends GrantedAuthority> authorities) {
        this.userid = userid;
        this.organizationid = organizationid;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.jobtitle = jobtitle;
        this.lockout = lockout;
        this.usertype = usertype;
        this.status = status;
        this.authorities = authorities;
    }

    public static JwtUserDetails build(JwtUsers user) {
        List<GrantedAuthority> authorities = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityname()))
                .collect(Collectors.toList());

        return new JwtUserDetails(
                user.getUserid(),
                user.getOrganizationid(),
                user.getUsername(),
                user.getPassword(),
                user.getFullname(),
                user.getJobtitle(),
                user.getLockout(),
                user.getUsertype(),
                user.getStatus(),
                authorities);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
