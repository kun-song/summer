package com.satansk.summer.site.repository;

import com.satansk.summer.site.domain.UserInfo;

/**
 * Author:  satansk
 * Email:   satansk@hotmail.com
 * Date:    17/6/10
 *
 * 增强 UserInfo 接口
 */
public interface UserInfoOptions {
    UserInfo findByName(String name);
}
