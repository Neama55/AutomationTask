Feature: Add New Item to shipping cart and filter based on specific property

  Scenario: as a standard user add new item
    Given I am "standard_user" in the home page
    When I select "Sauce Labs Bike Light"
    And  I click on the "Add to Cart" button
    Then The "Sauce Labs Bike Light" should be added to shipping cart



  Scenario: as a standard user filter the items based on low prices
    Given I am "standard_user" in the home page
    When I filter for "Price (low to high)" from the filtration list
    Then verify all the displayed items from low price to low


  Scenario: as a standard user
    Given I am "standard_user" in the home page
    When I scroll down to the footer item home page
    Then verify the footer is displayed at the bottom of the home page

