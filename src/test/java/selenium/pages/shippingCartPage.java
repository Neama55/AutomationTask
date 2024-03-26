package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.utlis.customWebDriver;

public class shippingCartPage extends customWebDriver {

    By itemsNamesInShippingCart = By.xpath("//div[@class=\"inventory_item_name\"]");

    public shippingCartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTheItemAddedToShippingCart(String item) {
        System.out.print(driver.findElement(itemsNamesInShippingCart).getText());
        return driver.findElements(itemsNamesInShippingCart)
                .stream()
                .anyMatch((i -> i.getText().equals(item)));

    }
}
