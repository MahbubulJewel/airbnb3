Feature: Validate ebay logo

Scenario: Validate the search option
Given user open the browser
When user is on the home page
Then user can see the search option


Scenario: Validate the ebay logo
Given user open the website
When user is on the ebay home page
Then user can see the ebay logo

Scenario: Validate create new account
Given user is on the main page
When user enter first name
And last name
And enter valid new email address
And enter valid password
Then create account option will active

Scenario: Validate duplicate email will show error
Given user on the home page
When user enters first name
And user enters last name
And enter used email address
Then user will get error message


Scenario: Search for an item and verify search intelligence
Given user is on ebay website home page
When user search for SearchItem
And Click the search option
Then user can see result for the SearchItem


Scenario: Validate sell option is working
Given user can see the home page
When user click sell option
And Click list an item
Then Start your listing will appear

Scenario: Validate shop by category is working
Given customer is on home page
When user clicks shop by category
Then all option will appear


Scenario: Validate filter option
Given user is on ebay website
When user search for iphone
And click new filter option
Then only new iphone will show

