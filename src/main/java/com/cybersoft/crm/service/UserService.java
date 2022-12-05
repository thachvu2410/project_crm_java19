package com.cybersoft.crm.service;

import com.cybersoft.crm.model.UsersModel;
import com.cybersoft.crm.repository.UsersRepository;

import java.util.List;

public class UserService {

    UsersRepository usersRepository = new UsersRepository();

    public List<UsersModel> getAllUsers(){
        return usersRepository.getAllUsers();
    }
    public boolean deleteUserById(int id){

        int result  = usersRepository.deleteUserById(id);

        return result > 0 ? true : false;

    }

    public boolean editUserById(int id, String fullname, int roleId){
        int result = usersRepository.editUserById(id, fullname, roleId);

        return result > 0 ? true : false;
    }
}
