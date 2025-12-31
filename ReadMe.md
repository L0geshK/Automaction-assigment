Java Test Automation Framework
This is a Java-based Test Automation Framework designed for scalable, maintainable, and cloud-ready test execution. The framework is built using modern automation best practices and supports local and cloud execution, headless runs, data-driven testing, and rich reporting.

It is suitable for UI automation, API automation, and end-to-end test execution

Author
@Logeshkanna
Features
Technology Stack Component Description Language Java 11 Build Tool Maven Test Framework TestNG UI Automation Selenium WebDriver API Automation REST Assured Design Pattern Page Object Model (POM) Data Handling Gson (JSON parsing) Test Data Generation Java Faker Logging Log4j Reporting Extent Reports Cloud Execution LambdaTest CI Friendly Maven Surefire Plugin Headless Execution Chrome Headless Mode

Framework Architecture
✔ Page Object Model (POM)

Each page is represented by a separate class

Improves readability, reusability, and maintenance

UI locators and actions are encapsulated

✔ Driver Management

Centralized Driver Factory

Supports:

Local browser execution

Headless mode

Cloud execution on LambdaTest

✔ Data-Driven Testing

JSON test data handled using Gson

Fake dynamic test data generated using Java Faker

Cloud Execution – LambdaTest
The framework supports execution on LambdaTest Cloud Grid using capability-based configuration.

To enable cloud execution:

Pass isLambdaTest=true via Maven

Browser, OS, and version are configured via desired capabilities
