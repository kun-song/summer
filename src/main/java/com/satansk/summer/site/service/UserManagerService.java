package com.satansk.summer.site.service;

import com.satansk.summer.site.domain.UserInfo;

/**
 * Author:  satansk
 * Email:   satansk@hotmail.com
 * Date:    17/6/10
 */
public interface UserManagerService {

    UserInfo add(UserInfo user);

    UserInfo findByName(String name);
}
