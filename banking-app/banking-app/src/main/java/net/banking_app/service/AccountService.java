package net.banking_app.service;

import net.banking_app.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdrawl(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);


}
