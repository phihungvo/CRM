package com.base.admin.hrm.service;


import com.base.admin.hrm.dto.AccomplishmentObjectdetailDTO;
import com.base.admin.hrm.entity.AccomplishmentObjectdetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccomplishmentObjectdetailService {
    int deleteByPrimaryKey(Integer accomplishmentobjectdetailid);

    int addRecord(String accomplishmentobjectdetailname);

    int insert(AccomplishmentObjectdetail record);

    int insertSelective(AccomplishmentObjectdetail record);

    AccomplishmentObjectdetail selectByPrimaryKey(Integer accomplishmentobjectdetailid);

    int updateByPrimaryKeySelective(AccomplishmentObjectdetail record);

    int updateByPrimaryKey(AccomplishmentObjectdetail record);

    AccomplishmentObjectdetailDTO findById(@Param("accomplishmentobjectdetailid") Integer accomplishmentobjectdetailid);

    Page<AccomplishmentObjectdetailDTO> searchPaged(@Param("pageable") Pageable pageable);

    boolean existByName(String name);

    int udpate(AccomplishmentObjectdetail accomplishmentObjectdetail);

    int deleteById(Integer accomplishmentobjectdetailid);
}
