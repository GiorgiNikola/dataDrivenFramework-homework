package ge.tbc.tbcitacademy.Steps.DatabaseSteps;

import ge.tbc.tbcitacademy.MSSQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSteps {
    public ResultSet returnRegistrationData(){
        ResultSet set;
        try (Connection connection = MSSQLConnection.connect()){
            String SQLCommand = "SELECT * FROM RegistrationData";
            Statement statement = connection.createStatement();
            set = statement.executeQuery(SQLCommand);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return set;
    }
}
