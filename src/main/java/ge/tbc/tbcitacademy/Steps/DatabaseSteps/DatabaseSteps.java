package ge.tbc.tbcitacademy.Steps.DatabaseSteps;

import ge.tbc.tbcitacademy.MSSQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSteps {
    public ResultSet returnRegistrationData(Connection connection){
        try {
            String SQLCommand = "SELECT * FROM RegistrationData";
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(SQLCommand);
            return set;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
