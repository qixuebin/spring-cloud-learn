package com.itmuch.cloud.authorization.service.impl;

import com.itmuch.cloud.authorization.domain.ClientDetailsDO;
import com.itmuch.cloud.authorization.repository.UserRepository;
import com.itmuch.cloud.authorization.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description
 * ${DESCRIPTION}
 * DATE 2018/3/16.
 *
 * @author qixuebin.
 */
@Service
public class UserManageServcieImpl implements UserManageService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public ClientDetailsDO findByClientId(String clientId) {

        return userRepository.findOne(clientId);
    }
}
