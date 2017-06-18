package com.satansk.summer.site.service;

import com.satansk.summer.site.domain.UserInfo;
import com.satansk.summer.site.repository.UserInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;

/**
 * Author:  satansk
 * Email:   satansk@hotmail.com
 * Date:    17/6/17
 *
 * 使用 @MockBean 注入依赖
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerServiceImplTest {
    @MockBean private UserInfoRepository userInfoRepository;
    @Autowired private UserManagerServiceImpl userManagerService;

    @Test
    public void addTest() {
        String id = "123456";
        String name = "Kyle";
        String password = "329015802";
        String email = "329015802@qq.com";
        UserInfo user = new UserInfo(id, name, password, email);

        // 模拟 UserInfoRepository
        given(userInfoRepository.insert(user)).willReturn(user);

        // 测试 UserManagerService
        UserInfo result = userManagerService.add(user);
        Assert.assertEquals(id, result.getId());
        Assert.assertEquals(name, result.getName());
        Assert.assertEquals(password, result.getPassword());
        Assert.assertEquals(email, result.getEmail());
    }
}
