package com.example.pages;
import com.example.base.BasePage;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import java.util.List;

public class ProductPage extends BasePage {

    private By productCardLocator = By.cssSelector(".showcase-container .showcase");
    private By addToCartBtnLocator = By.cssSelector(".add-to-cart-button");
    private By variantOptionsLocator = By.cssSelector(".showcase-variant-content-inside [data-option-id]");
    private By cartAmountLocator = By.cssSelector(".cart-amount");

    public void clickFirstProduct() {
        click(productCardLocator);
    }
    public void selectVariantOption(String optionName) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(variantOptionsLocator));
            List<WebElement> options = driver.findElements(variantOptionsLocator);
            for (WebElement option : options) {
                if (option.getText().trim().equalsIgnoreCase(optionName)) {
                    option.click();
                    return;
                }
            }
            System.out.println("Variant option not found: " + optionName);
        } catch (Exception e) {
            System.out.println("Error selecting variant option: " + e.getMessage());
        }
    }
    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtnLocator));
        click(addToCartBtnLocator);
    }
    public String getCartAmount() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.textToBePresentInElementLocated(cartAmountLocator, "1"));
            return getText(cartAmountLocator).trim();
        } catch (Exception e) {
            return "0";
        }
    }
}
