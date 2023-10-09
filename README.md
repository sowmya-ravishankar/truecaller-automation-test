# truecaller-automation-test

The repo hosts the test framework and tests for the Login flow for Truecaller.

The test framework is based on Appium which enables implementing a single implementation, if designed & implemented properly, supporting test execution on both iOS and Android mobile platforms. 
Following are important features of the framework
1. Page Object Model & Action (POMA) based test implementation
2. Simplifies the process of supporting new devices and platforms for test execution
3. Eases implementation of tests by providing drivers and utilities
4. Flexible to support different locator strategy, flow and different screens in Android & iOS apps
5. CI/CD friendly
6. TestNG
7. Maven

The automation code base is a maven project. Use the following command to execute the tests. 

mvn test -DsuiteXmlFile=testng.xml -Dtarget=android.0

-DsuiteXmlFile defines the test suite. You can provide your own test suite file if the test set differs from those defined in testng.xml. It is a TestNG XML file
-Dtarget defines the target the tests run on.

Add your device details in configFile.json
Modify phone number in LoginTest.java

The test scenario is here - https://github.com/sowmya-ravishankar/truecaller-automation-test/blob/main/src/test/java/com/truecaller/test/LoginTest.java
