package com.example.demo.model;

import com.example.demo.Common;

public class Email extends Channels {
    public Email(String username) {
        counter = 0;
        account = Common.Accounts.get(username);
        name = account.getEmail();
}
}