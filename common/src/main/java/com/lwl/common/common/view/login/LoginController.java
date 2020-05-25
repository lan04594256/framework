package com.lwl.common.common.view.login;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController("user")
public class LoginController {
    @PostMapping("123")
    public void login() {
        System.out.println("login");
    }

}
