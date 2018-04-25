package com.example.ngz.miniproject;

/**
 * Created by NGz on 4/25/2018.
 */

public class Users {

    public int _user_id;
    public String _users_name;
    public String _password;

    public Users(){//for getAllUsers
    }

    public Users(int _user_id) {
        this._user_id = _user_id;
    }
}
