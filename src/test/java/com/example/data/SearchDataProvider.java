package com.example.data;

import org.testng.annotations.DataProvider;
public class SearchDataProvider {
    @DataProvider(name = "searchData")
    public Object[][] searchData() {
        return new Object[][] {
            { "ayakkabı", "Valid" },
            { "xyz123", "Invalid" },
            { "", "Empty" },
        };
    }
    @DataProvider(name = "bvaSearchData")
    public Object[][] bvaSearchData() {
        return new Object[][] {
            { "a", "Invalid_Below_Boundary" },
            { "ay", "Valid_Boundary" },
            { "aya", "Valid_Above_Boundary" }
        };
    }
    @DataProvider(name = "priceFilterData")
    public Object[][] priceFilterData() {
        return new Object[][] {
            { "100", "5000", "Valid Range" },
            { "800", "800", "Valid_Same_Boundary" },
            { "-10", "100", "Invalid_Negative" }
        };
    }
}
