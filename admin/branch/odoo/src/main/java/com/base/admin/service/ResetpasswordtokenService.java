/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import java.util.UUID;

import com.base.admin.entity.Resetpasswordtoken;

public interface ResetpasswordtokenService {
    int deleteById(UUID userid);

    int insert(Resetpasswordtoken row);

    Resetpasswordtoken findById(UUID userid);

    int update(Resetpasswordtoken row);

    String validatePasswordResetToken(String token);
}
