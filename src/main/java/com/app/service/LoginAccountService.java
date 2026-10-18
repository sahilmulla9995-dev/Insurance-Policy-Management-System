package com.app.service;

import com.app.entity.LoginAccount;

public interface LoginAccountService {

    LoginAccount createLoginAccount(Long customerId, LoginAccount loginAccount);

    LoginAccount login(String username, String password);
}