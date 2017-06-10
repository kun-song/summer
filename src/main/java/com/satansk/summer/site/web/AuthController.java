package com.satansk.summer.site.web;

import com.satansk.summer.site.domain.UserInfo;
import com.satansk.summer.site.service.UserManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Author:  satansk
 * Email:   satansk@hotmail.com
 * Date:    17/6/10Ø
 */
@RestController
@RequestMapping(
        value = "auth",
        produces = "application/json; charset=UTF-8"
)
public class AuthController {
    private final static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired private HttpSession session;
    @Autowired private UserManagerService userManager;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody UserInfo userInfo) {
        // 输入有效性验证
        StringBuffer msg = new StringBuffer();
        if (! isValidUserInfo(userInfo, msg)) {
            logger.error(msg.toString());
            return new ResponseEntity<>(msg.toString(), HttpStatus.NOT_MODIFIED);
        }

        try {
            // 名字不能重复
            if (userManager.findByName(userInfo.getName()) != null) {
                logger.error("Username exists");
                return new ResponseEntity<>("Username has already exists", HttpStatus.NOT_MODIFIED);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_MODIFIED);
        }

        // 防止误传 id
        userInfo.setId(null);
        // 持久化
        UserInfo user = userManager.add(userInfo);

        // 持久化成功
        if (user != null) {
            // 添加 Session 属性
            session.setAttribute("username", user.getName());
        } else {
            // 持久化失败，提示再试一次
            return new ResponseEntity<>("Register failed, please try again", HttpStatus.CREATED);
        }

        return new ResponseEntity<>(msg.toString(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody UserInfo userInfo) {
        if (userInfo == null) {
            return "UserInfo can't be null";
        }

        UserInfo userFromDB = userManager.findByName(userInfo.getName());

        // 用户不存在
        if (userFromDB == null) {
            return "Username error, please try again";
        }

        // 密码错误
        if (! userFromDB.getPassword().equals(userInfo.getPassword())) {
            return "Password error, please try again";
        }

        // 登录成功，设置会话
        session.setAttribute("username", userInfo.getName());
        return "login successfully";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    @ResponseBody
    public String logout() {
        // 设置会话失效
        session.invalidate();
        return "logout successfully";
    }

    /********************************** Helper ************************************/

    private boolean isValidUserInfo(UserInfo userInfo, StringBuffer msg) {
        if (userInfo == null) {
            msg.append("UserInfo can't be null");
            return false;
        }

        String username = userInfo.getName();
        if (username == null || username.length() < 4) {
            msg.append("Username must be 4 chars or more");
            return false;
        }

        String password = userInfo.getPassword();
        if (password == null || password.length() < 8) {
            msg.append("Password must be 8 chars or more");
            return false;
        }

        msg.append("register successfully");
        return true;
    }
}
