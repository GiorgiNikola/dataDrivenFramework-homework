package ge.tbc.tbcitacademy.Steps.DatabaseSteps;

import ge.tbc.tbcitacademy.MSSQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public DatabaseSteps createPhonesTable() {
        try (Connection connection = MSSQLConnection.connect()){
            String sql = """
                    use Registration;
                    CREATE TABLE Phones (
                                            phoneNumber VARCHAR(20) PRIMARY KEY,
                                            ownerId INT,
                                            FOREIGN KEY (ownerId) REFERENCES RegistrationData(id)
                    );
                    """;
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public DatabaseSteps insertRegistrations(){
        try(Connection connection = MSSQLConnection.connect()) {
            String sql = "INSERT INTO dbo.RegistrationData VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i < 5; i++) {
                preparedStatement.setInt(1, 1006 + i);
                preparedStatement.setString(2, "FirstName " + i);
                preparedStatement.setString(3, "LastName " + i);
                preparedStatement.setString(4, "Gender " + i);
                preparedStatement.setString(5, "Mega 123 Large screen");
                preparedStatement.setString(6, "Addr1 " + i);
                preparedStatement.setString(7, "Addr2 " + i);
                preparedStatement.setString(8, "City " + i);
                preparedStatement.setString(9, "Cont1 " + i);
                preparedStatement.setString(10, "Cont2 " + i);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public DatabaseSteps insertPhoneNumbers(){
        try (Connection connection = MSSQLConnection.connect()) {
            String sql = "INSERT INTO Phones (phoneNumber, ownerId) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (int i = 1; i <= 8; i++) {
                preparedStatement.setString(1, "PhoneNumber" + i);
                preparedStatement.setInt(2, 1000 + i);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public DatabaseSteps updateTwoRegistrations(){
        try (Connection connection = MSSQLConnection.connect()) {
            String updateRegistrationSql = "UPDATE RegistrationData SET firstName = ?, lastName = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateRegistrationSql);

            preparedStatement.setString(1, "Givi");
            preparedStatement.setString(2, "Sikharulidze");
            preparedStatement.setInt(3, 1007);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "Heath");
            preparedStatement.setString(2, "Ledger");
            preparedStatement.setInt(3, 1008);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public DatabaseSteps updateTwoPhoneNumbers(){
        try (Connection connection = MSSQLConnection.connect()) {
            String updatePhoneSql = "UPDATE Phones SET phoneNumber = ? WHERE ownerId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updatePhoneSql);

            preparedStatement.setString(1, "UpdatedPhoneNumber1");
            preparedStatement.setInt(2, 1007);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "UpdatedPhoneNumber2");
            preparedStatement.setInt(2, 1008);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public ResultSet innerJoinData(Connection connection){
        try {
            String sql = "SELECT rd.firstName, rd.lastName, p.phoneNumber " +
                    "FROM RegistrationData rd " +
                    "INNER JOIN Phones p ON rd.id = p.ownerId";
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getDataFromResultSet(ResultSet rs) throws SQLException {
        List<Object[]> data = new ArrayList<>();
        while (rs.next()) {
            Object[] row = new Object[] {
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("phoneNumber")
            };
            data.add(row);
        }
        return data;
    }

    public DatabaseSteps insertRegistrationInstance(Connection connection) throws SQLException {
        String sql = "INSERT INTO dbo.RegistrationData VALUES(1011, 'Giorgi', 'Nikoladze', 'male', 'Mega 123 Large screen', 'Addre1', 'Addre2', 'Tbilisi', 'Conta1', 'Conta2')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        return this;
    }

    public DatabaseSteps updateLastName(Connection connection) throws SQLException {
        String sql = "UPDATE RegistrationData SET lastName = 'Saakadze' WHERE firstName = 'Giorgi' AND lastName = 'Nikoladze';";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        return this;
    }

}
