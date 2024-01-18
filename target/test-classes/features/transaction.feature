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

    Scenario Outline: user should be able to pay statement debt and available credit is updated

      When the user is on the checkout page
      When user tap "online" button for <merchant> on Checkout Page
      When user select <merchant> orderId and "<amount>"
      And user tap "english" button
      And user enter "<phone>" for <merchant>
      And user enter "valid" Otp
      And user tap "continue" button
      And user tap "goToPayment" button for <merchant> on Checkout Page
      And user enter card information <merchant>
      And the user is on the checkout page
      And the user is on the login page
      When user enter login "<phone>"
      When user enter "valid" Otp
      And user see the Available Credit "Before"
      And user tap "Payment Plan" tab
      And user tap "Pay" button
      And user tap "Pay with Apple Pay" button
      And user enter card information <merchant>
      And user tap 'Mispay Logo' button
      And user see the Available Credit "After"
      Then available credit is updated
      Then user tap "logout" button

      Examples:
        |merchant| |phone||amount|
        |        3||000000011||200.01 |
        |        3||000000011||300    |


      #Done
    @wip
    Scenario Outline: user should be able to cancel the payment of the statement debt

      When user enter login "<phone>"
      When user enter "valid" Otp
      And user tap "Payment Plan" tab
      And user tap "Pay" button
      And user tap "Pay with Apple Pay" button
      And user tap 'Cancel on Bank Page' button
      And user should see "Payment Unsuccessful" text
      And user should be able to click profile button
      And user should be able to see profile info "<phone>" and "<email>"

        Examples:
         |phone| |email|
         |000000003| |hatice.aygul+03v1@finbyte.com|



