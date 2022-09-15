Feature: Registration



  @prio1
  @run2
  Scenario: Registration with email

    Given the user navigate to the registration page
    When the user type wrong email and click submit
    Then the error msg appear "this is error"
    

@smoketest
 Scenario Outline: Registration with email second

    Given the user navigate to the registration page
    When the user type  username "<Username>" type password "<Password>" and  click submit
    Then this error msg "<Error>" appear

    Examples:
    | Username          | Password               | Error                        |
    |    summer     |   correctpassword1      |    erros msg : wrong user1   |
    |    yasmin   |   wrong password2     |   erros msg : wrong password2 |