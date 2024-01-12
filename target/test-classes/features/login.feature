@login @smoke
  Feature: User should be able to login

    Background:
      Given the user is on the login page


    Scenario Outline: Login as a user
      When user enter login "<credential>"
      When user enter "valid" Otp
      Then user should be able to login
      Then user tap "logout" button
      Examples:
      |credential|
      |000000003|
      |000000004|


    Scenario Outline: User should be able to redirect to Console via Marketing page when user has active session
      When user enter login "<credential>"
      When user enter "valid" Otp
      And user should be able to login
      And the user is on the marketing page
      And user tap "Go to Console" button
      And user should be able to click profile button
      And user should be able to see profile info "<phone>" and "<email>"
      Examples:
        |credential|   |phone| |email|
        |000000003| |000000003| |hatice.aygul+03v1@finbyte.com|




    Scenario Outline: User should not be login with not registered phone number
      When user enter login "<credential>"
      Then user should see "<errorType>" error and click close button
      Examples:
        |credential| |errorType|
        |763485362|  |IamInfoError|
        |561994681|  |IamInfoError|


    Scenario Outline: User should not be login with inactive user
      When user enter login "<credential>"
      Then user should see "<errorType>" error and click close button
      Examples:
        |credential| |errorType|
        |000000010|  |inactiveError|


    Scenario Outline: User should be able to see Profile info
      When user enter login "<phone>"
      When user enter "valid" Otp
      And user should be able to login
      And user should be able to click profile button
      And user should be able to see profile info "<phone>" and "<email>"
      Then user tap "logout" button

        Examples:
          |phone| |email|
          |000000003|  |hatice.aygul+03v1@finbyte.com|
          |000000005|  |hatice.aygul+05v1@finbyte.com|

    Scenario Outline: User should not be able login with invalid Otp
      When user enter login credentials
      When user enter "invalid" Otp
      Then user should see "<errorType>" error and click close button

      Examples:
      |errorType|
      |otp error|


      # login to Prod env.


    Scenario Outline: Login as a user to Test/Production Env.
      When the user is on the login page for "<environment>"
      When user enter login "<credential>"
      When user enter "valid" Otp
      Then user should be able to login
      Then user tap "logout" button
      Examples:
        |credential||environment|
        |000000003| |test|
        |000000004| |test|
        |000000001| |prod|

