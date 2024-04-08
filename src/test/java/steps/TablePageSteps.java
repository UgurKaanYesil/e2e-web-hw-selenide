package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.*;
import pages.TablePageElements;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class TablePageSteps extends TablePageElements {

    private String currentUrl;

    @Given("I open the web tables page")
    public void navigateAndAssert () {
        open("https://demoqa.com/webtables");
        $("#addNewRecordButton").should(Condition.exist);
        currentUrl = getWebDriver().getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://demoqa.com/webtables");
    }

    @When("I add a new record")
    public void addNewRecord() {
        addNewRecordButton.scrollTo().click();
        registrationForm.shouldBe(Condition.visible);

        //Setting form fields
        firstNameField.setValue("Özge");
        lastNameField.setValue("Güney");
        emailField.setValue("sdfdsl@example.com");
        ageField.setValue("28");
        salaryField.setValue("30000");
        departmentField.setValue("IT Support");

        submitButton.click();
    }

    @Then("I should see the newly added record in the table")
    public void addedRecordIsVisible() {
        lastAddedEntry.shouldBe(Condition.visible);
    }

    @When("I clicked to edit button for new record")
    public void editNewRecord () {
        editButton.click();
    }

    @Then("I should be able to edit the record and save")
    public void theRecordShouldBeUpdated() {
        lastNameField.clear();
        lastNameField.setValue("Jane");
        submitButton.click();
        System.out.println("Field modified as: " + $(".rt-tbody > div:nth-child(4) > div > div:nth-child(1)").getText());
    }

    @AfterTest
    public void tearDown() {
    }
}
