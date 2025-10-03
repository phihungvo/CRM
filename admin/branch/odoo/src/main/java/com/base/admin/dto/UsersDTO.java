package com.base.admin.dto;

import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

import com.base.admin.constant.UserStatus;
import com.base.admin.entity.Users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class UsersDTO {
    private UUID userid;

    private UUID organizationid;

    private String username;

    private String fullname;

    private String emailaddress;

    private String jobtitle;

    private Integer gender;

    private String phonenumber;

    private Boolean lockout;

    private Integer usertype;

    private Integer status;

    public UsersDTO(
            UUID userid,
            UUID organizationid,
            String username,
            String fullname,
            String emailaddress,
            String jobtitle,
            Integer gender,
            String phonenumber,
            Boolean lockout,
            Integer usertype,
            Integer status) {
        this.userid = userid;
        this.organizationid = organizationid;
        this.username = username;
        this.fullname = fullname;
        this.emailaddress = emailaddress;
        this.jobtitle = jobtitle;
        this.gender = gender;
        this.phonenumber = phonenumber;
        this.lockout = lockout;
        this.usertype = usertype;
        this.status = status;
    }

    public UsersDTO(UUID userid, String username, String emailaddress, Integer usertype) {
        this.userid = userid;
        this.username = username;
        this.emailaddress = emailaddress;
        this.lockout = false;
        this.usertype = usertype;
        this.status = 1;
    }

    public boolean isEmail(String s) {
        final Pattern EMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        return EMAIL.matcher(s).matches();
    }

    public Users newEntity() {
        return Users.builder()
                .userid(UUID.randomUUID())
                .organizationid(this.organizationid)
                .username(this.username)
                .fullname(this.fullname)
                .password(null)
                .emailaddress(this.emailaddress)
                .jobtitle(this.jobtitle)
                .gender(this.gender)
                .phonenumber(this.phonenumber)
                .passwordencrypted(false)
                .passwordreset(false)
                .passwordmodifieddate(null)
                .gracelogincount(0)
                .languageid("VI")
                .timezoneid("Asia/Ho_Chi_Minh")
                .logindate(null)
                .loginip(null)
                .lastlogindate(null)
                .lastloginip(null)
                .lastfailedlogindate(null)
                .failedloginattempts(0)
                .lockout(this.lockout != null && this.lockout)
                .lockoutdate(null)
                .usertype(this.usertype)
                .createdate(new Date())
                .modifieddate(null)
                .userupdate(null)
                .status(UserStatus.FORCE_CHANGE_PASSWORD.getValue())
                //                .status(this.status == null ? 0 : this.status)
                .build();
    }
}
