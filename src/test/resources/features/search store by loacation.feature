Feature: Scenario:
  Background:
    Given the user opens "chrome" browser
    And the user navigates to "www.checkers.co.za" url

  Scenario:
    And the user taps "store_locator_drop_down" page element
    And the user types "textContent" into "search_store_text" page element
    And the user verifies that the text content of attribute of "monday_trading_hours" page element "contains" "expectedValue"

