Feature: Youtube search
  Scenario: the user searchs for testNG on youtube
    Given the user is on youtube page
    When the user searchs for TestNG
    Then the youtube results for TestNG are displayed