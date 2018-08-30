package com.itmuch.cloud.authorization.service;

import com.itmuch.cloud.authorization.domain.ClientDetailsDO;

/**
 * Description
 * ${DESCRIPTION}
 * DATE 2018/3/16.
 *
 * @author qixuebin.
 */
public interface UserManageService {

    public ClientDetailsDO findByClientId(String clientId);
}
