Feature: Registration



  Scenario: Registration with email

    Given the user navigate to the registration page
    When the user type wrong email and click submit
    Then the error msg appear
    

