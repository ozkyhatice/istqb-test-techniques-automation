package com.example.tests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.example.data.SearchDataProvider;
import com.example.pages.SearchFilterPage;
public class SearchFilterTest extends BaseTest {
    @Test(dataProvider = "priceFilterData", dataProviderClass = SearchDataProvider.class)
    public void testPriceFilterBoundaries(String min, String max, String scenarioType) {
        SoftAssert softAssert = new SoftAssert();
        SearchFilterPage advancedSearchPage = new SearchFilterPage();

        advancedSearchPage.openPage();

        advancedSearchPage.filterByPrice(min, max);

        String infoMessage = advancedSearchPage.getInformationMessage();

        switch (scenarioType) {
            case "Valid_Range":
                softAssert.assertFalse(infoMessage.contains("hata"), 
                    "BVA Valid Range");
                break;

            case "Valid_Same_Boundary":
                softAssert.assertTrue(infoMessage.isEmpty() || infoMessage.contains("bulunamamıştır"),
                    "BVA Same Boundary");
                break;

            case "Invalid_Negative":
                softAssert.assertFalse(infoMessage.contains("Exception"),
                    "BVA Negative Limit");
                break;
        }

        softAssert.assertAll();
    }
    @Test(dataProvider = "decisionTableData", dataProviderClass = SearchDataProvider.class)
    public void testSearchFilterDecisionTable(String keyword, String category, String minPrice, String maxPrice, String ruleName) {
        SoftAssert softAssert = new SoftAssert();
        SearchFilterPage searchFilterPage = new SearchFilterPage();

        searchFilterPage.openPage();
        searchFilterPage.fillKeyword(keyword);
        searchFilterPage.filterByPrice(minPrice, maxPrice);

        String infoMessage = searchFilterPage.getInformationMessage();

        if (ruleName.equals("R1_NoKeyword_NoCat_NoPrice")) {
            softAssert.assertTrue(infoMessage.contains("en az 2 karakter"), 
                ruleName + " Failed: search keyword is empty and should trigger a validation message.");
        } 
        else {
            softAssert.assertFalse(infoMessage.toLowerCase().contains("exception") || infoMessage.contains("hata"), 
                ruleName + " Failed: Unexpected error message for valid input.");
            
            if (infoMessage.contains("bulunamadı")) {
                System.out.println(ruleName + " ");
            } else {
                System.out.println(ruleName + " passed with results found.");
            }
        }

        softAssert.assertAll();
    }
}
