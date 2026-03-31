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
}
