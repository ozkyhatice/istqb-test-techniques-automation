package com.example.pages;

import org.openqa.selenium.By;

import com.example.base.BasePage;
import com.example.config.ConfigReader;

public class SearchFilterPage extends BasePage {
    private String path = "arama";
    public void openPage() {
        driver.get(ConfigReader.getFullUrl(path));
    }

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
}
