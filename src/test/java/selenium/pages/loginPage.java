package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.utlis.customWebDriver;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class loginPage extends customWebDriver {
    String jsonFilePath = "src\\test\\resources\\loginData.json";
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");

    public loginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String name) throws IOException {
        String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        JSONObject jsonObject = new JSONObject(jsonContent);
        String passwordTxt = jsonObject.getJSONObject("standard_user").getString("password");

        typeTextInfield(username, name);
        typeTextInfield(password, passwordTxt);
        clickOn(loginBtn);
    }

}
