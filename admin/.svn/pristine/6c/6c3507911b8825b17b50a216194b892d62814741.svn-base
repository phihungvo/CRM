package com.base.admin.masterdata.mapper;

import com.base.admin.masterdata.entity.DmTinhtrangbaohiem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface DmTinhtrangbaohiemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmTinhtrangbaohiem row);

    int insertSelective(DmTinhtrangbaohiem row);

    DmTinhtrangbaohiem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmTinhtrangbaohiem row);

    int updateByPrimaryKey(DmTinhtrangbaohiem row);

    long countPaged(@Param("search") DmTinhtrangbaohiem search, @Param("exact") boolean exact);

    List<DmTinhtrangbaohiem> searchPaged(@Param("search") DmTinhtrangbaohiem search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);
}