package model.dao;

import model.Group;
import java.sql.SQLException;

public interface GroupDaoInterface {
    Group findById(String id) throws SQLException, ClassNotFoundException;
    Group findByName(String name) throws SQLException, ClassNotFoundException;
}
