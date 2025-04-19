package net.banking_app.controller;

import net.banking_app.dto.AccountDto;
import net.banking_app.entity.Account;
import net.banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add account Rest api
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){

        return  new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Get account by id
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    //deposit rest api
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id ,@RequestBody Map<String, Double> request) {
        double ammount = request.get("amount");
      AccountDto accountDto = accountService.deposit(id, ammount);
      return  ResponseEntity.ok(accountDto);
    }

    //widrawal rest api

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdrawl(@PathVariable Long id , @RequestBody Map<String, Double> request){

        double amount = request.get("amount");

        AccountDto accountDto = accountService.withdrawl(id , amount);

        return  ResponseEntity.ok(accountDto);

    }

    //Get all account rest api

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountService.getAllAccounts();
        return  ResponseEntity.ok(accounts);
    }

    //Delete Account Rest Api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccoutn(@PathVariable Long id) {

        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account Deleted Successfully !");
    }


}