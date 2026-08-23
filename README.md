# Selenium Java Automation Framework

A UI test automation framework developed with **Java, Selenium WebDriver, TestNG, and Maven**.

This project was created to demonstrate practical QA automation skills including Page Object Model design, data-driven testing, browser configuration, automated reporting, and failure screenshot handling.

## Technologies Used

- Java 21
- Selenium WebDriver
- TestNG
- Maven
- Apache POI
- Extent Reports
- IntelliJ IDEA
- Git & GitHub

## Framework Features

- Page Object Model (POM)
- Reusable BasePage structure
- Centralized WebDriver management with DriverFactory
- BaseTest setup and teardown structure
- Configuration management using `config.properties`
- Data-driven testing using Excel and TestNG DataProvider
- Apache POI integration for reading Excel test data
- Test execution using TestNG XML
- Maven Surefire integration
- TestNG Listener implementation
- Automatic screenshot capture on test failure
- HTML test reporting with Extent Reports
- Browser selection through configuration

## Automated Test Scenarios

The project contains Selenium examples covering:

- Login testing
- Data-driven login testing
- Explicit waits
- Dropdown interactions
- Alerts
- Mouse hover actions
- Multiple windows/tabs
- iFrames
- File uploads

## Project Structure

```text
src
├── main
│   └── java
│       └── com.enes.qa
│           ├── base
│           ├── driver
│           ├── listeners
│           ├── pages
│           └── utils
│
└── test
    ├── java
    │   └── com.enes.qa
    │       └── tests
    └── resources
        ├── LoginData.xlsx
        └── config.properties
```

## Running the Tests

The complete test suite can be executed using Maven:

```bash
mvn clean test
```

Test execution is managed through `testng.xml`.

## Test Reporting

The framework generates an **Extent HTML Report** after test execution.

When a test fails:

1. The TestNG Listener detects the failure.
2. A screenshot is captured automatically.
3. The failure details are added to the Extent Report.
4. The screenshot is attached to the failed test result.

Generated reports and screenshots are excluded from version control.

## Data-Driven Testing

Login test data can be stored in:

```text
src/test/resources/LoginData.xlsx
```

The `ExcelReader` utility reads the Excel data using Apache POI and provides it to TestNG through a DataProvider.

This allows multiple test scenarios to run without hardcoding test data inside the test method.

## Purpose

This project is a personal QA Automation portfolio project created to demonstrate the design and implementation of a maintainable Selenium test automation framework.

It demonstrates practical experience with automation framework structure, reusable components, test data management, reporting, and common web UI automation scenarios.