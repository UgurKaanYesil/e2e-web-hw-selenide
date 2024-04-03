package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaTables {

    PageElements pageElements = new PageElements();

    @BeforeTest
    public void setUp() {
        //timeout hatası için
        Configuration.timeout = 40000;
    }


    @Test
    public void submitAndEditNewEntry() {
        open("https://demoqa.com/webtables");

        pageElements.addNewRecordButton.scrollTo().click();

        pageElements.registrationForm.shouldBe(Condition.visible);


        pageElements.firstNameField.setValue("Özge");
        pageElements.lastNameField.setValue("Güney");
        pageElements.emailField.setValue("asdeaf@example.com");
        pageElements.ageField.setValue("27");
        pageElements.salaryField.setValue("50000");
        pageElements.departmentField.setValue("IT");

        pageElements.submitButton.click();

        pageElements.editButton.click();


        pageElements.lastNameField.clear();
        pageElements.lastNameField.setValue("Yeşil");
        pageElements.submitButton.click();

        System.out.println("Field modified as: " + $(".rt-tbody > div:nth-child(4) > div > div:nth-child(1)").getText());
    }

    @AfterTest
    public void tearDown() {
    }
}
