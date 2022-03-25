# Wikipedia_Cucumber_TestAutomation
Wikipedia_Cucumber_TestAutomation


The purpose of this application is to automate the wikipedia page using BDD Test Framework.
Maven is used by this test automation That's why cucumber dependencies have been added in pom.xml.
CAUTION : 
The application uses selenium libraries, Therefore you need to add the "selenium-server-4.1.2.jar" file externally.
If you are using Intellij IDEA, you can make your automation ready by following the steps below.
- Clone all git files from github
- Open Intellij, Click "File" Tab
- Click Project with Version Control
- Paste github clone url
- After downloading process is completed , You need press "CTRL+ALT+SHIFT+S"
- Go to "Modules" 
- Click "Add" then select JARs or Directories and select "selenium-server-4.1.2.jar" and upload it.
- Then Run "Wikipedia_Test" Class


BaseClass includes some static variables. This main class is being extended by all sub-class.
This case is built on the basis of 2 features. You can read BDD Structure below.
//////////////////////////////////////////////////////////////////////////////////////////////
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
////////////////////////////////////////////////////////////////////////////////////////////////////

Uğur Ulaş.
Senior Test Automation Engineer

