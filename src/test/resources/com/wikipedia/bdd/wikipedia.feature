Feature: "Did you mean" suggestion control on Wikipedia
  Background:
    Given The Visitor is on the wikipedia home page

  Scenario:
    When The visitor searches for ‘furry rabbits’
    Then A ‘did you mean’ suggestion is displayed

  Scenario:
    When The visitor searches for ‘furry rabbits’ for case
    Then The visitor can see 20 results


  Scenario:
   Given A visitor is on the search result page for ‘furry rabbits’
   When The visitor uses the “Did you mean” feature to correct his search  And select the first entry
   Then The visitor is on the article page of the first hit