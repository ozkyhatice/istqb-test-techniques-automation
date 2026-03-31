package com.example.pages;

import org.openqa.selenium.By;

import com.example.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.example.config.ConfigReader;

public class SearchFilterPage extends BasePage {
    private String path = "arama";
    public void openPage() {
        driver.get(ConfigReader.getFullUrl(path));
    }
    private By keywordInput = By.cssSelector("input[name='label']");
    private By categoryDropdown = By.cssSelector("select[name='category']");
    private By minPriceInput = By.name("minimumPrice");
    private By maxPriceInput = By.name("maximumPrice");
    private By searchButton = By.cssSelector("button[type='submit']");
    private By noResultsMessage = By.cssSelector(".information-content span");
    public void filterByPrice(String minPrice, String maxPrice) {
        type(minPriceInput, minPrice);
        type(maxPriceInput, maxPrice);
        click(searchButton);
    }
    public String getInformationMessage() {
        try {
            return getText(noResultsMessage).trim();
        } catch (Exception e) {
            return "";
        }
    }
    public void selectByVisibleText(By locator, String visibleText) {
        try {
            WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Select select = new Select(dropdown);
            select.selectByVisibleText(visibleText);
        } catch (Exception e) {
            System.out.println("Dropdown element not found: " + e.getMessage());
        }
    }
    public void fillKeyword(String keyword) {
        type(keywordInput, keyword);
    }
    public void selectCategory(String category) {
        selectByVisibleText(categoryDropdown, category);
    }
    
      
}
