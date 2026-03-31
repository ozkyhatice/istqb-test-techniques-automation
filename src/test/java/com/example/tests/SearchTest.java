package com.example.tests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.example.data.SearchDataProvider;
import com.example.pages.HomePage;


public class SearchTest extends BaseTest {
    @Test (dataProvider = "searchData", dataProviderClass = SearchDataProvider.class)
    public void testSearch(String productName, String testType) {
        HomePage homePage = new HomePage();
        SoftAssert softAssert = new SoftAssert();
        homePage.openPage();
        
        
        homePage.searchForProduct(productName);
        
        if (testType.equals("Valid")) {
            softAssert.assertTrue(homePage.verifySearchResults(productName), "Expected search results to contain the product name.");
        } else if (testType.equals("Invalid")) {
            softAssert.assertFalse(homePage.verifySearchResults(productName), "Expected no search results for invalid product name.");
        } else if (testType.equals("Empty")) {
            softAssert.assertEquals(homePage.verifyNoResultsMessage(),"Arama kriterleri en az 2 karakter olmalıdır.", "Expected 'No results found' message for empty search.");
        }
        
        softAssert.assertAll();
    }
}
