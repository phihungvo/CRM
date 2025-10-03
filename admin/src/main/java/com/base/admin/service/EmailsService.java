/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import com.base.admin.entity.Emails;

public interface EmailsService {
    int deleteById(Long id);

    int insert(Emails row);


    Emails findById(Long id);


    int update(Emails row);
}