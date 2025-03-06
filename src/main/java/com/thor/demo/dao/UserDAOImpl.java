package com.thor.demo.dao;

import com.thor.demo.model.User;
import com.thor.demo.util.Connections;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean updateHealth(User u) {

        try (Connection connection = Connections.getConnection()) {

            String updateSql = "update CHARACTERS set HEALTH = ? where CHARID = ?";
            if (connection != null) {
                var preparedStatement = connection.prepareStatement(updateSql);

                preparedStatement.setString(1, Integer.toString(u.getHealth()));
                preparedStatement.setString(2, u.getCharId());

                preparedStatement.execute();
                System.out.println("Record Updated");
                return true;

            } else {
                return false;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean createCharacter(User u) {

        try (Connection connection = Connections.getConnection()) {

            String insertSql = "insert into CHARACTERS (CHARID, NAME, STRENGTH, HEALTH, ITEMS) values (?, ?, ? , ?, ?)";
            if (connection != null) {
                var preparedStatement = connection.prepareStatement(insertSql);
                preparedStatement.setString(1, u.getCharId());
                preparedStatement.setString(2, u.getName());
                preparedStatement.setInt(3, u.getStrength());
                preparedStatement.setInt(4, u.getHealth());
                preparedStatement.setString(5, u.getItems());
                preparedStatement.execute();
                System.out.println("after Insert statement");
                return true;

            } else {
                return false;
            }
        } catch (SQLException e2) {
            e2.printStackTrace();
            return false;

        }
    }

}
