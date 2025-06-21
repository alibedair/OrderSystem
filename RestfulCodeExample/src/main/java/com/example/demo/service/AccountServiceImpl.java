package com.example.demo.service;
import com.example.demo.Common;
import com.example.demo.model.Account;
import com.example.demo.model.Product;

import org.springframework.stereotype.Service;



@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public Boolean addAccount(Account A) {
        try {
            if(Common.Accounts.get(A.getusername()) != null){
                return false;
            }
            Common.Accounts.put(A.getusername(), A);
        } catch (Exception e) {
            System.out.println("Exception in addAccount as" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Boolean deleteAccount(String username) {
        try {
            if(Common.Accounts.get(username) == null){
                return false;
            }
            Common.Accounts.remove(username);
        } catch (Exception e) {
            System.out.println("Exception in deleteaccount as" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Account getAccount(String username) {
        try {
            return Common.Accounts.get(username);
        } catch (Exception e) {
            System.out.println("Exception in getaccount as" + e.getMessage());
        }
        return null;
    }
    @Override
    public void updateAcccount(Account account) {
        Common.Accounts.put(account.getusername(), account);
}

}