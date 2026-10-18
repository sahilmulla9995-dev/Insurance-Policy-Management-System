package com.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.LoginAccount;
import com.app.service.LoginAccountService;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginAccountService loginAccountService;

    public LoginController(LoginAccountService loginAccountService) {
        this.loginAccountService = loginAccountService;
    }

    @PostMapping("/login")
    public LoginAccount login(@RequestBody LoginAccount loginAccount) {

        return loginAccountService.login(
                loginAccount.getUsername(),
                loginAccount.getPassword());
    }
}