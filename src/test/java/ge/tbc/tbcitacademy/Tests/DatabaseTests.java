package ge.tbc.tbcitacademy.Tests;

import com.codeborne.selenide.Selenide;
import ge.tbc.tbcitacademy.Data.Constants;
import ge.tbc.tbcitacademy.Steps.DatabaseSteps.DatabaseSteps;
import ge.tbc.tbcitacademy.Steps.TechCanvassSteps.RegistrationFormSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class DatabaseTests extends ConfigTests{
    RegistrationFormSteps registrationFormSteps;
    DatabaseSteps databaseSteps;
    @BeforeMethod
    public void setup(){
        registrationFormSteps = new RegistrationFormSteps();
        databaseSteps =  new DatabaseSteps();

    }

    @Test
    public void techCanvassTest() throws SQLException {
            ResultSet resultSet = databaseSteps.returnRegistrationData();
            open("https://techcanvass.com/examples/register.html");
            while (resultSet.next()) {
                registrationFormSteps
                        .fillFirstName(resultSet.getString(Constants.firstName))
                        .fillLastName(resultSet.getString(Constants.lastName))
                        .selectGender(resultSet.getString(Constants.gender))
                        .fillAddress1(resultSet.getString(Constants.address1))
                        .fillAddress2(resultSet.getString(Constants.address2))
                        .fillCity(resultSet.getString(Constants.city))
                        .fillContact1(resultSet.getString(Constants.contact1))
                        .fillContact2(resultSet.getString(Constants.contact2));
                Selenide.refresh();
            }
    }

}
