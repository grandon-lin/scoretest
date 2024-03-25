# Mobile Test Framework

## Overview

This framework is generated to perform automation testing for the Android application for The Score using Appium and Java.
The automation tests include one scenario with two test cases to cover the functionality of checking a league as a new user and an existing user.

## Setting Up and Running the Tests
### Prerequisites
The framework was built with the following information
- Android Studio for virtual Android device Pixel 6 Pro API 33
- Appium Server version 2.5.1
- Java version 11.0.17
- The Score app apk used for testing: com.fivemobile.thescore_24.4.0-24040.apk, and is located under /src/test/resources/thescore.MobileTestFramework.apps
- Test data file: exceldata.xlsx, and is located under /src/test/resources/thescore.MobileTestFramework.testData
- This is a maven project, pom.xml file includes the related dependencies

### Running Tests with Maven
- Download the project
- Navigate to the project directory in terminal
- Simply execute the command:
```
mvn test
```

## Test Scenario: Open a league
- Description: Verify the app opens the correct pages when user opens a league and navigate back to the Leagues Page
- Test Case 1: Verify the flow as a guest
    - Test Steps:
      - Launch the app
      - Click on the Get Started button
      - Click on the Continue button
      - Choose a favorite team
      - Click on the Continue button
      - Click on the Done button
      - Close the popup dialog
      - Click on the Leagues tab
      - Verify the Leagues page is displayed
      - Click on a league, which is selected from the test data file, for example, NHL
      - Verify the app takes the user to the NHL page
      - Click on the Navigate back button
      - Verify the user is redirected back to the Leagues page
- Test Case 2: Verify the flow as a registered user
    - Test Steps:
      - Launch the app
      - Click on the LOG IN link
      - Enter valid email and password
      - Click on the Login button
      - Close the popup dialog
      - Click on the Leagues tab
      - Verify the Leagues page is displayed
      - Click on a league, which is selected from the test data file, for example, NHL
      - Verify the app takes the user to the NHL page
      - Click on the Navigate back button
      - Verify the user is redirected back to the Leagues page

## Test Approach Rationale
The test approach was based on the two possible flows of how a new user or a registered user opens a league page beginning from launching the app. It's one of the critical user flows of how the user use the app.

## Coverage Assessment
The tests covers a major feature of the app, which is to open different leagues to check the updated information. The test steps include not only tapping on the element on the screen, but also swiping the screen horizontally or vertically to find the desired element in order to verify the page is displayed accurately. It is designed to validate the regular user interaction with the app and the  app behaves accordingly as expected.
