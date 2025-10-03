/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import org.springframework.stereotype.Service;

import com.base.admin.mapper.PagesMapper;

@Service
public class PagesServiceImpl implements PagesService {
    private final PagesMapper pagesMapper;

    public PagesServiceImpl(PagesMapper pagesMapper) {
        this.pagesMapper = pagesMapper;
    }

    //    @Override
    //    public int deleteById(UUID pageid, UUID moduleid) {
    //        return pagesMapper.deleteById(pageid, moduleid);
    //    }
    //
    //    @Override
    //    public int insert(Pages row) {
    //        return pagesMapper.insert(row);
    //    }
    //
    //    @Override
    //    public Pages findById(UUID pageid, UUID moduleid) {
    //        return pagesMapper.findById(pageid, moduleid);
    //    }
    //
    //
    //    @Override
    //    public int update(Pages row) {
    //        return pagesMapper.update(row);
    //    }

}
