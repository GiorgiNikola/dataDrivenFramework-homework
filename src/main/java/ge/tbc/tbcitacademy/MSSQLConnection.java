package ge.tbc.tbcitacademy;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSQLConnection {
    public static Connection connect() throws SQLException {
        try {
            DriverManager.registerDriver(new SQLServerDriver());

            String jdbcUrl = DBConfiguration.getURL();
            String password = DBConfiguration.getPassword();
            String username = DBConfiguration.getUsername();

            return DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
