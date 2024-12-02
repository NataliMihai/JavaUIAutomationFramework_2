Feature: The Register Flow test suite

  @run
  Scenario: The system redirects the user to Account page after successful registration with valid data
    Given The Home Page is displayed
    And Register Page is accessed from the Home Page buttons
    And the register form is populated with data
    And the privacy toggle bar is enabled
    When  the continueButton is clicked
    Then the Url contains the following keyword "succes"

  @run
  Scenario: The system keeps the user on Register page using valid data when registring without accepting the privacy rules
    Given The Home Page is displayed
    And Register Page is accessed from the Home Page buttons
    And the register form is populated with data
    # And the privacy toggle bar is enabled
    When  the continueButton is clicked
    Then the Url contains the following keyword "register"