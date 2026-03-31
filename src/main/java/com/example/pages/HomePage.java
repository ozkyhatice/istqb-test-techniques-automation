package com.example.pages;

import com.example.base.BasePage;
import com.example.config.ConfigReader;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {
    private By searchInput = By.name("q");
    private By searchButton = By.cssSelector(".search form button");
    private By showcaseContainer = By.cssSelector(".showcase-container");
    private By noResultsMessage = By.cssSelector(".information-content span");
    String path = "";
    public void openPage() {
        driver.get(ConfigReader.getFullUrl(path));
    }
    public void searchForProduct(String productName) {
        type(searchInput, productName);
        click(searchButton);
    }
    public boolean verifySearchResults(String productName) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(showcaseContainer));
            return element.getText().toLowerCase().contains(productName.toLowerCase());
        } catch (Exception e) {
            return false;
        }
    }
    public String verifyNoResultsMessage() {
        try {
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(noResultsMessage));
            System.out.println("No results message: " + getText(noResultsMessage).trim());
            return getText(noResultsMessage).trim();
        } catch (Exception e) {
            return "";
        }
    }
}
