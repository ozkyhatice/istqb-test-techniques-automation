package com.example.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features", // feature files in this directory
    glue = "com.example.steps",              // Step definitions in this package
    plugin = {
        "pretty", 
        "html:target/cucumber-reports.html"  // HTML report generation
    },
    monochrome = true
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
    }