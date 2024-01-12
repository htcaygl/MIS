@checkout @smoke
  Feature: User should be able to checkout

    Background:
      Given the user is on the checkout page



      #DONE dev, test, uat

    Scenario Outline: user should be able to checkout on DEV and TEST env.
      When user tap "online" button for <merchant> on Checkout Page
      When user select <merchant> orderId and "<amount>"
      And user tap "english" button
      And user enter "<phone>" for <merchant>
      And user enter "valid" Otp
      And user tap "continue" button
      And user tap "goToPayment" button for <merchant> on Checkout Page
  #    And user tap "goToHome" button for <merchant> on Checkout Page
      Then the user is on the checkout page

    Examples:
      |merchant| |phone||amount|
      |        2||000000002||200.01|
      |        3||000000002||200.01 |
      |        4||000000001||200.01|


       #DONE ama otp hatasi prod haric diger env. larda almadigimiz ici diger testler icin dogru calismiyor simdilik sadece prod icin dogru calisiyor
    Scenario Outline: user should be able to try checkout on all environment
      When user tap "online" button for <merchant> on Checkout Page
      When user select <merchant> orderId and "<amount>"
      And user tap "english" button
      And user enter "<phone>" for <merchant>
      Then user enter "invalid" Otp
      Then user should see "<errorType>" error and click close button

      Examples:
        |merchant| |phone| |errorType||amount|
   #     |        2||000000001||otp error||200.01|
   #     |        3||000000001||otp error||200.01|
   #     |        4||000000001||otp error||200.01|
   #    |        11||000000001||otp error||200.01|
        |       12||000000001||otp error||200.01|


     #DONE Test env. purchase amount check

    Scenario Outline: user should not be able to checkout with invalid Amount/Credit
      When user tap "online" button for <merchant> on Checkout Page
      When user select <merchant> orderId and "<amount>"
      And user tap "english" button
      And user enter "<phone>" for <merchant>
      And user enter "valid" Otp
      Then user should see "<errorType>" error and click close button on Checkout Page

      Examples:
        |merchant| |phone| |errorType| |amount|
        |        3||000000002||purchase limit error||199.99|
        |        3||000000002||purchase limit error||3000.1|
        #credit limit = 0
        |        3||000001234||insufficient limit error||300|
        #available limit = 1585
        |        3||000000005||insufficient limit error||2500|
        |        3||000000004||score error||400|
        |        3||000000006||bnplAmount error||1800|
        |        3||000000008||bnplStatus ERROR||302|






      #DONE
    Scenario Outline: user should be able to cancel checkout
      When user tap "online" button for <merchant> on Checkout Page
      When user select <merchant> orderId and "<amount>"
      And user tap "english" button
      And user tap "returnToStore" button for <merchant> on Checkout Page
      Then user see "<status>" url

      Examples:
        |merchant| |status| |amount|
        |        3||cancel||400|
   #      |        3||cancel||401|
