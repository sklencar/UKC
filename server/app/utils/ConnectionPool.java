package utils;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {
    public Connection getConnection() throws SQLException;
    public void closeConnection(Connection connection) throws SQLException;
}
