Feature: Test login functionalities

  Background:
    Given user is on the ebay home page1
  Scenario: Validate login with valid credentials

    When user enters email "mahbubulalam5253@gmail.com"
    And user clicks continue
    And user enters password "Bangladesh1971"
    And user clicks signIn
    Then user can starts shopping



  Scenario Outline: Validate login with valid credentials for multiple users

    When user enters email "<email>"
    And user clicks continue
    And user enters password "<password>"
    And user clicks signIn
    Then user can starts shopping
    Examples:
      | email                     | password      |
      |ummemoon1109@gmail.com     |Moonmimo1128   |
      |mahbubulalam5253@gmail.com |Bangladesh1971 |

  Scenario: Check logon successful using data table

    When user click on login upon valid credentials
    |email                 |password      |
    |ummemoon1109@gmail.com|Moonmimo1128  |
    Then user can starts shopping








