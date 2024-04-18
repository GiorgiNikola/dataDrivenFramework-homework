package ge.tbc.tbcitacademy.DataProvider;

import ge.tbc.tbcitacademy.MSSQLConnection;
import ge.tbc.tbcitacademy.Steps.DatabaseSteps.DatabaseSteps;
import org.testng.annotations.DataProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class DatabaseProvider {
    DatabaseSteps databaseSteps = new DatabaseSteps();
    @DataProvider
    public Object[][] getRegistrationData() {
        try (Connection connection = MSSQLConnection.connect()) {
            ResultSet rs = databaseSteps.innerJoinData(connection);
            List<Object[]> data = databaseSteps.getDataFromResultSet(rs);
            return data.toArray(new Object[0][]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
