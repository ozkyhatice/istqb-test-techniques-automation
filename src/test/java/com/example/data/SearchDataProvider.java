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
}
