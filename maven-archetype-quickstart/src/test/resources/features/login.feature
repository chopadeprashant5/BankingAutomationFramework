Feature: Login functionality

Scenario: Successful login

Given user is on login page
When user enters username and password
Then dashboard should be displayed