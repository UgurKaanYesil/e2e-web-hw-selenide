package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.*;
import pages.ButtonsPageElements;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;
public class ButtonsPageSteps extends ButtonsPageElements {

    private String currentUrl;

    @Given("I open the elements page")
    public void printDynamicMessageTest() {
        open("https://demoqa.com/elements");
        currentUrl = getWebDriver().getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://demoqa.com/elements");

    }

    @When("I click on Buttons button")
    public void clickButtonsSection() {
        buttonsButton.click();
        currentUrl = getWebDriver().getCurrentUrl();
        assertThat(currentUrl).isEqualTo("https://demoqa.com/buttons");

    }

    @And("I click on the click me button")
    public void clickButton() {
        clickMeButton.scrollTo().click();
    }


    @Then("I should see the message")
    public void iShouldSeeTheMessage() {
        dynamicMessage.shouldBe(visible);
        System.out.println(dynamicMessage.getText());
    }

    @AfterTest
    public void tearDown() {
    }
}
