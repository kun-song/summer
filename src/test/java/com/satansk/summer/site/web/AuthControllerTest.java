package com.satansk.summer.site.web;

import com.satansk.summer.site.domain.UserInfo;
import com.satansk.summer.site.service.UserManagerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.matchers.JUnitMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Author:  satansk
 * Email:   satansk@hotmail.com
 * Date:    17/6/10
 *
 * @WebMvcTest 专门用于测试 SpringMvc Controller
 *
 * 1. 此注解仅扫描 @Controller @ControllerAdvice @JsonComponentFilter WebMvcConfigurer
 *      HandlerMethodArgumentResolver 的 Bean，不会扫描普通 @Component 修饰的 Bean。
 * 2. @WebMvcTest 一般只限于测试单个 Controller。
 * 3. @WebMvcTest + @MockBean 一起使用，@MockBean 一般用于模拟内部依赖的 Service。
 * 4. @WebMvcTest 会自动配置 MockMvc，使用时直接注入即可。
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AuthController.class)
public class AuthControllerTest extends BaseWebTest {
    @Autowired private MockMvc mockMvc;

    @MockBean private UserManagerService userManager;

    private UserInfo user;

    /**
     * 在每个 @Test 执行之前都会执行一次
     */
    @Before
    public void setUp() {
        user = new UserInfo();
        user.setName("SongKun");
        user.setPassword("12345678");
        user.setEmail("329015802@qq.com");
    }

    @Test
    public void registerTest() throws Exception {
        String url = "/auth/register";

        // 提示语句
        String usernameTooShort = "Username must be 4 chars or more";
        String passwordTooShort = "Password must be 8 chars or more";
        String registerSuccessfully = "register successfully";
        String usernameExist = "Username has already exists";

        // 验证用户名不小于 4 个字符
        user.setName("Kun");
        mockMvc.perform(post(url).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                                .content(json(user)))
                .andDo(print())
                .andExpect(status().isNotModified())
                .andExpect(content().string(containsString(usernameTooShort)));

        // 验证用户名不能为空
        user.setName("");
        mockMvc.perform(post(url).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(json(user)))
                .andDo(print())
                .andExpect(status().isNotModified())
                .andExpect(content().string(containsString(usernameTooShort)));

        // 验证密码不少于 8 个字符
        user.setName("SongKun");
        user.setPassword("1234567");
        mockMvc.perform(post(url).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(json(user)))
                .andDo(print())
                .andExpect(status().isNotModified())
                .andExpect(content().string(containsString(passwordTooShort)));

        // 验证满足条件可以注册成功
        user.setPassword("12345678");
        user.setId(null);

        given(this.userManager.add(user)).willReturn(user);

//        mockMvc.perform(post(url).accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(json(user)))
//                .andDo(print())
//                .andExpect(status().isCreated())
//                .andExpect(content().string(containsString(registerSuccessfully)));

        // 验证不可重复注册
        given(this.userManager.findByName(user.getName())).willReturn(user);

        mockMvc.perform(post(url).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(json(user)))
                .andDo(print())
                .andExpect(status().isNotModified())
                .andExpect(content().string(containsString(usernameExist)));
    }

    @After
    public void tearDown() {

    }

}
