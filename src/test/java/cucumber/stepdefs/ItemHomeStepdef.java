package cucumber.stepdefs;

import cucumber.hooks.scenarioHook;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import selenium.pages.ItemHomePage;
import selenium.pages.loginPage;
import selenium.pages.shippingCartPage;

import java.io.IOException;


public class ItemHomeStepdef {

    private WebDriver driver;

    public ItemHomeStepdef(scenarioHook hooks) {
        this.driver = hooks.getDriver();
    }

    @Given("I am {string} in the home page")
    public void isTheUserInHomePage(String name) throws IOException {
        loginPage login = new loginPage(driver);
        login.login(name);
    }

    @When("I select {string}")
    public void selectItemFromProductsList(String itemName) {
        ItemHomePage itemPage = new ItemHomePage(driver);
        itemPage.selectAnItemFromProducts(itemName);
    }

    @And("I click on the {string} button")
    public void clickOnTheButton(String btn) {
        ItemHomePage itemPage = new ItemHomePage(driver);
        itemPage.clickOnButton(btn);
    }

    @Then("The {string} should be added to shipping cart")
    public void isTheItemAddedToCart(String item) {
        shippingCartPage shippingPage = new shippingCartPage(driver);
        clickOnTheButton("Shipping cart icon");
        Assert.assertTrue("the item is not added to the shipping cart", shippingPage.isTheItemAddedToShippingCart(item));
    }

    @When("I filter for {string} from the filtration list")
    public void filterTheItems(String filterVal) {
        ItemHomePage itemPage = new ItemHomePage(driver);
        itemPage.filterTheDisplayedItems(filterVal);
    }

    @Then("verify all the displayed items from low price to low")
    public void verify_all_the_displayed_items_from_low_price_to_low() {
        ItemHomePage itemPage = new ItemHomePage(driver);
        Assert.assertTrue("the item is not added to the shipping cart", itemPage.isTheItemDisplayingAscending());
    }

    @When("I scroll down to the footer item home page")
    public void scrollDownToTheFooterPage() {
        ItemHomePage itemPage = new ItemHomePage(driver);
        itemPage.scrollDownToFooterItemHomePage();
    }

    @When("verify the footer is displayed at the bottom of the home page")
    public void isTheFooterDisplayedCorrectly() {
        ItemHomePage itemPage = new ItemHomePage(driver);
        Assert.assertTrue("the item is not added to the shipping cart", itemPage.isTheFooterTxtCorrect("© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"));
    }
}
