/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import java.util.UUID;

import com.base.admin.entity.Tokens;

public interface TokensService {
    int deleteById(UUID tokenid);

    int insert(Tokens row);

    Tokens findById(UUID tokenid);

    int update(Tokens row);
}
