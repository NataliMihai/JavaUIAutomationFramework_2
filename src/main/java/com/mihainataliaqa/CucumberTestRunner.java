package com.mihainataliaqa;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/com/mihainataliaqa/features",
        glue = "com.mihainataliaqa.stepdefinitions",
        tags = "@run"

)

public class CucumberTestRunner {


}
