Feature: User Login

  @Login
  Scenario Outline: Successful login with valid credentials
    Given The user navigates to FirstCry Home Page
    When The user clicks on login
    And The user enters the <EmailID> or mobile no.
    And The user clicks on Continue
    And Click on Submit
    Then The user gets a message <actualMessage> that user is on home page <expectedResult>

    Examples: 
      | EmailID                          | actualMessage                     | expectedResult                    |
      | vaibhavagrahari3101998@gmail.com | My Account                        | My Account                        |
      | a435@gmail.com                   | Register                          | Register                          |
      |                                  | Enter your Email-Id or Mobile No. | Enter your Email-Id or Mobile No. |
      | vaibhavagrahari3101998@gmail.com | Verify your OTP                   | Verify your OTP                   |
