/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.entity.Resetpasswordtoken;
import com.base.admin.mapper.ResetpasswordtokenMapper;

@Service
public class ResetpasswordtokenServiceImpl implements ResetpasswordtokenService {
    private final ResetpasswordtokenMapper resetpasswordtokenMapper;

    public ResetpasswordtokenServiceImpl(ResetpasswordtokenMapper resetpasswordtokenMapper) {
        this.resetpasswordtokenMapper = resetpasswordtokenMapper;
    }

    @Override
    public int deleteById(UUID userid) {
        return resetpasswordtokenMapper.deleteById(userid);
    }

    @Override
    public int insert(Resetpasswordtoken row) {
        return resetpasswordtokenMapper.insert(row);
    }

    @Override
    public Resetpasswordtoken findById(UUID userid) {
        return resetpasswordtokenMapper.findById(userid);
    }

    @Override
    public int update(Resetpasswordtoken row) {
        return resetpasswordtokenMapper.update(row);
    }

    @Override
    public String validatePasswordResetToken(String token) {
        final Resetpasswordtoken passToken = resetpasswordtokenMapper.findByToken(token);

        return !isTokenFound(passToken) ? "invalidToken" : isTokenExpired(passToken) ? "expired" : null;
    }

    //    public String validatePasswordResetToken(String token) {
    //        final Resetpasswordtoken passToken = resetpasswordtokenMapper.findByToken(token);
    //
    //        return !isTokenFound(passToken) ? "invalidToken"
    //                : isTokenExpired(passToken) ? "expired"
    //                : null;
    //    }

    private boolean isTokenFound(Resetpasswordtoken passToken) {
        return passToken != null;
    }

    private boolean isTokenExpired(Resetpasswordtoken passToken) {
        final Calendar cal = Calendar.getInstance();
        return passToken.getExpirydate().before(cal.getTime());
    }
}
