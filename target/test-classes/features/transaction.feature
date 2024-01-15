@transaction @smoke
  Feature: User should be able to transaction

    Background:
      Given the user is on the login page

    Scenario: user should be able to see transaction page
      When user enter login "000000002"
      When user enter "valid" Otp
      And user tap "Purchases" tab
      Then user should be able to see datas
      Then user tap "logout" button


