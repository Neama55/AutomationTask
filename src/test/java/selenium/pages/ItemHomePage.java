package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.utlis.customWebDriver;

import java.util.List;

public class ItemHomePage extends customWebDriver {

    By itemsNames = By.xpath("//div[@class=\"inventory_item_name \"]");
    By addToCartBtn = By.xpath("//div//button[contains(@class,'btn_primary')]");
    By backToProductsBtn = By.xpath("//div//button[contains(@class,'back')]");
    By shippingCartIcon = By.id("shopping_cart_container");
    By filterOptions = By.xpath("//select[@class=\"product_sort_container\"]");
    By itemsPrices = By.xpath("//div[@class='inventory_item_price']");
    By footer=By.xpath("//div[@class=\"footer_copy\"]");

    public ItemHomePage(WebDriver driver) {
        super(driver);
    }

    public void selectAnItemFromProducts(String item) {
        List<WebElement> items = driver.findElements(itemsNames);
        items.stream()
                .filter(link -> link.getText().equals(item))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public void clickOnButton(String btn) {
        By buttonLoc;
        switch (btn) {
            case "Add to Cart":
                buttonLoc = addToCartBtn;
                break;
            case "Back to products":
                buttonLoc = backToProductsBtn;
                break;
            case "Shipping cart icon":
                buttonLoc = shippingCartIcon;
                break;
            default:
                throw new IllegalStateException("Unexpected button value: " + btn);
        }
        clickOn(buttonLoc);
    }

    public void filterTheDisplayedItems(String filterValue) {
        selectByValue(filterOptions, filterValue);
    }

    public boolean isTheItemDisplayingAscending() {
        List<String> pricesWithoutDollar= deleteDollarSignFromThePrices(driver.findElements(itemsPrices));
        return isTheItemsDisplayingAscending(pricesWithoutDollar);
    }

    public void scrollDownToFooterItemHomePage(){
        scrollToElement(footer);
    }

    public boolean isTheFooterTxtCorrect(String txt){
        return getElementTxt(footer).equals(txt);
    }

}
