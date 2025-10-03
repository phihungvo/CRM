package com.base.admin.inventory.util;

import com.base.admin.inventory.dto.request.PagedRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageUtil {
    int limit;
    int offset;
    Pageable pageable;
    public PageUtil(PagedRequest o){
        Pageable pageable = PageRequest.of(o.getPage(), o.getSize());
        this.limit = pageable.getPageSize();
        this.offset = (int) pageable.getOffset();
        this.pageable = pageable;
    }
}
