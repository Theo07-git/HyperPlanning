package model.dao;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDaoInterface {
    boolean create(User user);

    User updatePassword(User user) throws SQLException;

    boolean delete(User obj);

    User findById(String id) throws SQLException, ClassNotFoundException;

    User findByEmail(String email) throws SQLException, ClassNotFoundException;

    User findByLastName(String last_name) throws SQLException, ClassNotFoundException;

    void ResultSetByName();
    boolean ResultSetByNameNext(User user);
}
