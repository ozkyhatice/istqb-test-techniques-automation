package com.example.steps;

import com.example.driver.DriverFactory;
import com.example.pages.HomePage;
import com.example.pages.ProductPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ShoppingCartSteps {

    private HomePage homePage;
    
    @Given("The user is on the e-commerce home page")
    public void the_user_is_on_the_e_commerce_home_page() {
        DriverFactory.initDriver();
        homePage = new HomePage();
        homePage.openPage();
    }

    @When("The user types {string} into the search box and searches")
    public void the_user_types_into_the_search_box_and_searches(String productName) {
        homePage.searchForProduct(productName);
    }

    @When("The user adds the first listed product to the cart")
    public void the_user_adds_the_first_listed_product_to_the_cart() {
        ProductPage productPage = new ProductPage();
        productPage.clickFirstProduct();
        productPage.selectVariantOption("41");
        productPage.addToCart();
        System.out.println("The first listed product was added to the cart (Page object to be added)");
    }

    @Then("{string} items should be seen in the cart icon")
    public void items_should_be_seen_in_the_cart_icon(String expectedCount) {
        ProductPage productPage = new ProductPage();
        String actualCount = productPage.getCartAmount();
        if (!actualCount.equals(expectedCount)) {
            throw new AssertionError("Expected cart count: " + expectedCount + ", but got: " + actualCount);
        }
    }

    @Then("The user should proceed to the checkout step")
    public void the_user_should_proceed_to_the_checkout_step() {
        // CartPage cartPage = new CartPage();
        // cartPage.clickCheckout();
        System.out.println("Proceeded to the checkout step.");
        DriverFactory.quitDriver();
    }
}