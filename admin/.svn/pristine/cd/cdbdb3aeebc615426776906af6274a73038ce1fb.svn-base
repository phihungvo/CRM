package com.base.admin.masterdata.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmTinhtrangbaohiem;

@Mapper
public interface DmTinhtrangbaohiemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmTinhtrangbaohiem row);

    int insertSelective(DmTinhtrangbaohiem row);

    DmTinhtrangbaohiem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmTinhtrangbaohiem row);

    int updateByPrimaryKey(DmTinhtrangbaohiem row);

    long countPaged(@Param("search") DmTinhtrangbaohiem search, @Param("exact") boolean exact);

    List<DmTinhtrangbaohiem> searchPaged(
            @Param("search") DmTinhtrangbaohiem search,
            @Param("pageable") Pageable pageable,
            @Param("exact") boolean exact);
}
