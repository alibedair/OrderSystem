package com.example.demo.model;

import com.example.demo.Common;

public class PhoneNumber extends Channels {
    public PhoneNumber(String username) {
        counter = 0;
        account = Common.Accounts.get(username);
        name = account.getPhone_Number();
}

}
