package com.satansk.summer.site.repository;

import com.satansk.summer.site.domain.UserInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Author:  satansk
 * Email:   satansk@hotmail.com
 * Date:    17/6/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByNameTest() {
        // 创建 UserInfoRepository接口的 Mock 对象
        UserInfoRepository userInfoRepository = mock(UserInfoRepository.class);

        UserInfo userInfo = new UserInfo();
        userInfo.setName("Kyle");

        // 设置 findByName 方法的预期返回值
        when(userInfoRepository.findByName("Kyle")).thenReturn(userInfo);

        UserInfo result = userInfoRepository.findByName("Kyle");

        // 验证是否调用了 findByName 方法
        verify(userInfoRepository).findByName("Kyle");

        // Junit 断言
        Assert.assertEquals("Kyle", result.getName());

        String noName = "noName";
        when(userInfoRepository.findByName(noName)).thenReturn(null);
        result = userInfoRepository.findByName(noName);
        verify(userInfoRepository).findByName(noName);
        Assert.assertEquals(null, result);
    }
}
