package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Accounts {
    private List<Account> users;

    public Accounts(){
        users = new ArrayList<Account>();
        users.add(new Account("123-1234","Liao guolong","530593***@qq.com","18180420***"));
    }

    public List<Account> getUsers(){
        return users;
    }
}
