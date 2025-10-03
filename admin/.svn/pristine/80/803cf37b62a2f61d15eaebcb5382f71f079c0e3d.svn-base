/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.entity.Tokens;
import com.base.admin.mapper.TokensMapper;

@Service
public class TokensServiceImpl implements TokensService {
    private final TokensMapper tokensMapper;

    public TokensServiceImpl(TokensMapper tokensMapper) {
        this.tokensMapper = tokensMapper;
    }

    @Override
    public int deleteById(UUID tokenid) {
        return tokensMapper.deleteById(tokenid);
    }

    @Override
    public int insert(Tokens row) {
        return tokensMapper.insert(row);
    }

    @Override
    public Tokens findById(UUID tokenid) {
        return tokensMapper.findById(tokenid);
    }

    @Override
    public int update(Tokens row) {
        return tokensMapper.update(row);
    }
}
