package com.base.admin.dto;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {

    private int page;
    private int size;
    private String sortField;
    private String sortDirection;

    public boolean isValidSortField(List<String> fields) {
        if (!StringUtils.isEmpty(sortField) && !StringUtils.isEmpty(sortDirection)) {
            if (!("asc".equalsIgnoreCase(sortDirection) || "desc".equalsIgnoreCase(sortDirection))) {
                this.sortDirection = "ASC";
            }
            return fields.parallelStream().anyMatch(this.sortField::equalsIgnoreCase);
        }
        return true;
    }

    public Pageable convertToPageable() {
        if (StringUtils.isEmpty(sortField) || StringUtils.isEmpty(sortDirection))
            return PageRequest.of(this.getPage(), this.getSize());

        if (("asc".equalsIgnoreCase(sortDirection))) {
            return PageRequest.of(
                    this.getPage(), this.getSize(), Sort.by(this.getSortField()).ascending());
        }
        return PageRequest.of(
                this.getPage(), this.getSize(), Sort.by(this.getSortField()).descending());
    }
}
