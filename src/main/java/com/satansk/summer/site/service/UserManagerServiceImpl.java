package com.satansk.summer.site.service;

import com.satansk.summer.site.domain.UserInfo;
import com.satansk.summer.site.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author:  satansk
 * Email:   satansk@hotmail.com
 * Date:    17/6/10
 */
@Service
public class UserManagerServiceImpl implements UserManagerService {

    @Autowired private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo add(UserInfo user) {
        return userInfoRepository.insert(user);
    }

    @Override
    public UserInfo findByName(String name) {
        return userInfoRepository.findByName(name);
    }
}
