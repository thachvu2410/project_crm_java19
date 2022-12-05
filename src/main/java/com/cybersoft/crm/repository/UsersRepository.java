package com.cybersoft.crm.repository;

import com.cybersoft.crm.config.MySQLConnection;
import com.cybersoft.crm.model.UsersModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsersRepository {

    public List<UsersModel> getUsersByEmailAndPassword(String email, String password){

        List<UsersModel> list = new ArrayList();

        try{
            String query = "select * from users u where u.email = ? and u.password = ?";
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
            UsersModel usersModel = new UsersModel();
            usersModel.setId(resultSet.getInt("id"));
            usersModel.setEmail(resultSet.getString("email"));
            usersModel.setAvatar(resultSet.getString("avatar"));
            usersModel.setFullName(resultSet.getString("fullname"));
            usersModel.setRoleId(resultSet.getInt("role_id"));

            list.add(usersModel);
            }

            connection.close();

        }catch (Exception e){
            System.out.println("Error getUsersByEmailAndPassword " + e.getMessage());
        }

        return list;
    }

    public List<UsersModel> getAllUsers(){

        List<UsersModel> list = new ArrayList();

        try{
            String query = "select * from users u right join roles r on u.role_id = r.id";
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                UsersModel usersModel = new UsersModel();
                usersModel.setId(resultSet.getInt("id"));
                usersModel.setEmail(resultSet.getString("email"));
                usersModel.setAvatar(resultSet.getString("avatar"));
                usersModel.setFullName(resultSet.getString("fullname"));


                usersModel.setRoleName(resultSet.getString("role_name"));

                list.add(usersModel);


            }
//            System.out.println(list.get(0).getRoleName());
//            System.out.println(list.get(1).getRoleName());
//            System.out.println(list.get(2).getRoleName());

            connection.close();

        }catch (Exception e){
            System.out.println("Error getUsersByEmailAndPassword " + e.getMessage());
        }

        return list;
    }

    public int deleteUserById(int id){

        int result = 0;
        try{
            String query = "delete from users u where u.id = ?;";
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeUpdate();


            connection.close();

        }catch (Exception e){
            System.out.println("Error deleteUser " + e.getMessage());
        }

        return result;
    }

    public int deleteRolesById(int id){
        int result = 0;
        try{
            String query = "delete from roles r where r.id = ?";
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeUpdate();


            connection.close();

        }catch (Exception e){
            System.out.println("Error deleteRoles " + e.getMessage());
        }

        return result;
    }

    public int editUserById(int id, String fullname, int roleId){
        int result = 0;
        try {
            String query = "update users u set u.fullname = ?, u.role_id = ? where u.id = ?";
            Connection connection = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(3,id);
            preparedStatement.setString(1, fullname);
            preparedStatement.setInt(2, roleId);
            result = preparedStatement.executeUpdate();
            connection.close();
        }
        catch (Exception e){
            System.out.println("Error editUserInfo " + e.getMessage());
        }
//        System.out.println("kiem tra edit: " + result);
        return result;
    }
}
