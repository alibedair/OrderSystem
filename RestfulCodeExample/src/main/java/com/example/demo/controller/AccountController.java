package com.example.demo.controller;


import com.example.demo.model.Account;
import com.example.demo.model.Product;
import com.example.demo.service.AccountServiceImpl;
import com.example.demo.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountServiceImpl accountService;

    @PostMapping("/add")
    public Response addaccount(@RequestBody Account p) {
        System.out.println("in add account with"+ p);
        boolean res = accountService.addAccount(p);
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("com.example.demo.Account Already Exists");
            return response;
        }

        response.setStatus(true);
        response.setMessage("com.example.demo.Account created successfully");
        return response;
    }

    @DeleteMapping("/delete/{username}")
    public Response deleteaccount (@PathVariable("username") String username) {
        System.out.println("in delete with username:"+username);
        boolean res = accountService.deleteAccount(username);
        Response response = new Response();
        if (!res) {
            response.setStatus(false);
            response.setMessage("com.example.demo.Account Doesn't Exists");
            return response;
        }
        response.setStatus(true);
        response.setMessage("com.example.demo.Account deleted successfully");
        return response;
    }

    @PutMapping("/put/{username}")
    public ResponseEntity<String> updateaccount(@PathVariable String username, @RequestBody Account account) {
        if (!username.trim().equals(account.getusername().trim())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("username in the path does not match the username in the request body");
        }

        Account existingAccount = accountService.getAccount(username);
        if (existingAccount == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account with username  " + username + " is not found");
        }
        accountService.updateAcccount(account);
        return ResponseEntity.status(HttpStatus.OK).body("Account updated successfully");
    }
    @GetMapping("/get/{username}")
    public Account getaccount(@PathVariable("username") String username) {
        System.out.println("in get with username:"+username);
        return accountService.getAccount(username);
    }
}