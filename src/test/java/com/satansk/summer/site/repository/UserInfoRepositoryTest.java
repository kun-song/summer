package com.satansk.summer.site.repository;

import com.satansk.summer.site.domain.UserInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Author:  satansk
 * Email:   satansk@hotmail.com
 * Date:    17/6/17
 *
 * @DataMongoTest
 *  1. 默认设置一个内存嵌入式 MongoDB 数据库
 *  2. 配置 MongoTemplate
 *  3. 扫描 @Document 注解类（普通 @Component 类不会被加载到 ApplicationContext中）
 *  4. 配置 Repository
 */
@RunWith(SpringRunner.class)
@DataMongoTest
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
