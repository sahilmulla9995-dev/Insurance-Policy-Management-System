package com.app.serviceImpl;

import org.springframework.stereotype.Service;

import com.app.entity.Customer;
import com.app.entity.LoginAccount;
import com.app.repository.CustomerRepository;
import com.app.repository.LoginAccountRepository;
import com.app.service.LoginAccountService;

@Service
public class LoginAccountServiceImpl implements LoginAccountService {

    private final LoginAccountRepository loginAccountRepository;
    private final CustomerRepository customerRepository;

    public LoginAccountServiceImpl(
            LoginAccountRepository loginAccountRepository,
            CustomerRepository customerRepository) {

        this.loginAccountRepository = loginAccountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public LoginAccount createLoginAccount(
            Long customerId,
            LoginAccount loginAccount) {

        Customer customer =
                customerRepository.findById(customerId).orElse(null);

        if (customer != null) {

            loginAccount.setCustomer(customer);
            loginAccount.setRole("CUSTOMER");
            loginAccount.setActive(true);

            return loginAccountRepository.save(loginAccount);
        }

        return null;
    }

    @Override
    public LoginAccount login(String username, String password) {

        LoginAccount account =
                loginAccountRepository.findByUsername(username);

        if (account != null
                && account.getPassword().equals(password)
                && Boolean.TRUE.equals(account.getActive())) {

            return account;
        }

        return null;
    }
}