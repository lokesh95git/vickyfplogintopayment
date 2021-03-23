#Author: your.email@your.domain.com

@tag
Feature: Login to payment page
  I want to use this template for my feature file

  @tag1
  Scenario: login page
    Given User launches flipkart application
    When user enter credentials
    And user clicks on login button
    When user search for mobile
    And user click on search button
    And user switch to child window
    When user click on Add to cart button
    And user click on placeorder and continue button
    Then user check payment visibility
     
   

  