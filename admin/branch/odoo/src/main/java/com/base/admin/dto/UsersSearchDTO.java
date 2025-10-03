package com.base.admin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersSearchDTO {
    UsersDTO dto;
    Pagination pagination;
}
