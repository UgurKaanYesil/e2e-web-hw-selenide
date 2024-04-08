package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class ButtonsPageElements {
    protected SelenideElement buttonsButton = $(byId("item-4"));
    protected SelenideElement clickMeButton = $(byCssSelector(".col-md-6 div:nth-of-type(3) > .btn"));
    protected SelenideElement dynamicMessage = $(byId("dynamicClickMessage"));
}
