package net.banking_app.Mapper;

import net.banking_app.dto.AccountDto;
import net.banking_app.entity.Account;

public class AccountMapper {

    public  static Account mapAccount(AccountDto accountDto){
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );

        return account;
    }


    public  static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return  accountDto;
    }
}
