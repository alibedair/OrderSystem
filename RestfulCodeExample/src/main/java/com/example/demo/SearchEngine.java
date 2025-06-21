package com.example.demo;

import com.example.demo.model.Account;

public class SearchEngine {
    public Account getAccount(String username) {
        if (Common.Accounts.containsKey(username)) {
            return Common.Accounts.get(username);
        } else {
            return null;
        }
    }
}
