package com.mihainataliaqa.stepdefinitions;

import com.mihainataliaqa.managers.DriverManager;
import io.cucumber.java.*;
//import io.cucumber.java.After;
//import io.cucumber.java.AfterAll;
//import io.cucumber.java.Before;
//import io.cucumber.java.BeforeAll;

public class Hooks {

    @BeforeAll
    public static void executeBeforeAllTest() {
        System.out.println("The execution of the test suite started");
    }

    @Before
    public void executeBeforeEachTest() {
        System.out.println("Test started...");
    }

    @After
    public void executeAfterEachTest() {
        System.out.println("The test is completed.");
        DriverManager.getInstance().quiteTheDriver();
    }

    @AfterAll
    public static void executeAfterAllTest() {
        System.out.println("The test execution is finished!");
    }
}
