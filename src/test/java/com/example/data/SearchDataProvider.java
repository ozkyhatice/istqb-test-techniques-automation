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
    @DataProvider(name = "decisionTableData")
    public Object[][] decisionTableData() {
        return new Object[][] {
            {"", "0", "", "", "R1_NoKeyword_NoCat_NoPrice"},
            {"", "0", "100", "500", "R2_NoKeyword_NoCat_HasPrice"},
            {"", "1", "", "", "R3_NoKeyword_HasCat_NoPrice"},
            {"", "1", "100", "500", "R4_NoKeyword_HasCat_HasPrice"},
            {"çanta", "0", "", "", "R5_HasKeyword_NoCat_NoPrice"},
            {"çanta", "0", "100", "500", "R6_HasKeyword_NoCat_HasPrice"},
            {"çanta", "1", "", "", "R7_HasKeyword_HasCat_NoPrice"},
            {"çanta", "1", "100", "500", "R8_HasKeyword_HasCat_HasPrice"}
        };
    }
}
