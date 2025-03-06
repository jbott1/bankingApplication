package com.thor.demo.dao;

import com.thor.demo.model.User;

public interface UserDAO {

    public boolean updateHealth(User U);
    public boolean createCharacter(User U);



    //TODO Get all characters,  Get one CHARACTER
}
