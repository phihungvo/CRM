/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import com.base.admin.entity.Emails;
import com.base.admin.mapper.EmailsMapper;
import org.springframework.stereotype.Service;

@Service
public class EmailsServiceImpl implements EmailsService {
    private final EmailsMapper emailsMapper;

    public EmailsServiceImpl(EmailsMapper emailsMapper) {
        this.emailsMapper = emailsMapper;
    }

    @Override
    public int deleteById(Long id) {
        return emailsMapper.deleteById(id);
    }

    @Override
    public int insert(Emails row) {
        return emailsMapper.insert(row);
    }


    @Override
    public Emails findById(Long id) {
        return emailsMapper.findById(id);
    }


    @Override
    public int update(Emails row) {
        return emailsMapper.update(row);
    }
}