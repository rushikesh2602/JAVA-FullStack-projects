package net.banking_app.service.impl;

import net.banking_app.Mapper.AccountMapper;
import net.banking_app.dto.AccountDto;
import net.banking_app.entity.Account;
import net.banking_app.repository.AccountRepository;
import net.banking_app.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.mapAccount(accountDto);
       Account saveaccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(saveaccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {

      Account account =  accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Dose Not Exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account =  accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Dose Not Exist"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
       Account savedAccount =  accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdrawl(Long id, double amount) {

        Account account =  accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Dose Not Exist"));

        if(account.getBalance() < amount) {
            throw new RuntimeException("insufficient balance");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
      Account savedAccount =  accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
       List<Account> accounts = accountRepository.findAll();

      return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
               .collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {

        Account account =  accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account Dose Not Exist"));

        accountRepository.deleteById(id);

    }
}
