package com.example.pages;
import com.example.base.BasePage;
import com.example.config.ConfigReader;
import org.openqa.selenium.By;

public class CartPage extends BasePage {
    private String path = "sepet";
    public void openPage() {
        driver.get(ConfigReader.getFullUrl(path));
    }
    private By completeButton = By.id("checkout-complete-shopping");
    public void clickCheckout() {
        openPage();
        click(completeButton);
    }

}
