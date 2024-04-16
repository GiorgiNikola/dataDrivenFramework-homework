package ge.tbc.tbcitacademy.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormPage {
    public SelenideElement firstName = $("input[value='First Name']"),
    lastName = $("input[value='Last Name']"),
    genderMale = $("input[value='male']"),
    genderFemale = $("input[value='female']"),
    address1 = $("input[value='Address1']"),
    address2 = $("input[value='Address2']"),
    city = $("input[value='City']"),
    contact1 = $("input[value='Contact1']"),
    contact2 = $("input[value='Contact2']");
}
