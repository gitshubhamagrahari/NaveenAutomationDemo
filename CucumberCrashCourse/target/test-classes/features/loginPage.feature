Feature:Login on the application 

  Background:
    Given I am  on the OpenCart login page
    
 Scenario: Successful login with valid credentials
 Given I have entered a valid email and password
 When I  click on the login button
 Then I should  be logged in successfully
 
 Scenario Outline: Unsuccessful login with invalid credentials
 Given I have entered a invalid "<email>" and "<password>"
 When I  click on the login button
 Then I should  see the error message indicating "<error_message>"
 
  Examples:
  |email              |password              |error_message|
  |invalid1@gmail.com|password1|  Warning: No match for E-Mail Address and/or Password. |
  |invalid2@gmail.com|password2|  Warning: No match for E-Mail Address and/or Password. |
  
  Scenario: Navigate to the forgotten password page
  When I  click on the "Forgotten Password" link
 Then I should  redirect to the forgot password page
  
  