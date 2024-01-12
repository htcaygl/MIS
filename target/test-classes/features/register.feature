@register
  Feature: User should be able to register

   # Background:
      # Given the user is on the register page

    Scenario: user should be able to register by using checkout page
      Given the user is on the checkout page
      And user enter orderId and amount to the new Phone
      And Terms and Cond and PP is clickable



