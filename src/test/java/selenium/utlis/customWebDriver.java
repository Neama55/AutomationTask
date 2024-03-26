package selenium.utlis;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class customWebDriver {

    public WebDriver driver;

    public customWebDriver(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOn(By by) {
        driver.findElement(by).click();
    }

    public void typeTextInfield(By by, String txt) {
        driver.findElement(by).sendKeys(txt);
    }

    public String generateFakeNames() {
        return new Faker().name().firstName();
    }

    public void selectByValue(By by, String value) {
        final Select combo = new Select(driver.findElement(by));
        combo.selectByVisibleText(value);
    }


    public static List<String> deleteDollarSignFromThePrices(List<WebElement> priceElements) {
        List<String> pricesWithoutDollar = new ArrayList<>();

        for (WebElement priceElement : priceElements) {
            String priceWithDollar = priceElement.getText();
            String priceWithoutDollar = priceWithDollar.replace("$", "");
            pricesWithoutDollar.add(priceWithoutDollar); // Add to the result list
        }
        return pricesWithoutDollar;
    }

    public static boolean isTheItemsDisplayingAscending(List<String> pricesWithoutDollar) {
        for (int i = 0; i < pricesWithoutDollar.size() - 1; i++) {
            double currentPrice = Double.parseDouble(pricesWithoutDollar.get(i));
            double nextPrice = Double.parseDouble(pricesWithoutDollar.get(i + 1));
            if (currentPrice > nextPrice) {
                return false;
            }
        }
        return true;
    }

    public void scrollToElement(By by) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
    }

    public String getElementTxt(By by){
        return driver.findElement(by).getText();
    }

}
