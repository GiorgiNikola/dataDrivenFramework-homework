package ge.tbc.tbcitacademy.Steps.TechCanvassSteps;

import ge.tbc.tbcitacademy.Pages.RegistrationFormPage;

public class RegistrationFormSteps {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    public RegistrationFormSteps fillFirstName(String firstName){
        registrationFormPage.firstName.sendKeys(firstName);
        return this;
    }

    public RegistrationFormSteps fillLastName(String lastName){
        registrationFormPage.lastName.sendKeys(lastName);
        return this;
    }

    public RegistrationFormSteps selectGender(String gender){
        if (gender.equalsIgnoreCase("male")){
            registrationFormPage.genderMale.setSelected(true);
        }else if (gender.equalsIgnoreCase("female")){
            registrationFormPage.genderFemale.setSelected(true);
        }
        return this;
    }

    public RegistrationFormSteps fillAddress1(String address1){
        registrationFormPage.address1.sendKeys(address1);
        return this;
    }

    public RegistrationFormSteps fillAddress2(String address2){
        registrationFormPage.address2.sendKeys(address2);
        return this;
    }

    public RegistrationFormSteps fillCity(String city){
        registrationFormPage.city.sendKeys(city);
        return this;
    }

    public RegistrationFormSteps fillContact1(String contact1){
        registrationFormPage.contact1.sendKeys(contact1);
        return this;
    }

    public RegistrationFormSteps fillContact2(String contact2){
        registrationFormPage.contact2.sendKeys(contact2);
        return this;
    }
}
