# Automation Framework - Swag Labs 🤖

## Description

A robust and scalable End-to-End (E2E) test automation framework for the [Swag Labs](https://www.saucedemo.com/) application. Built with **Java 11** and **Selenium WebDriver**, this project stands out for its professional architecture implementing the **Page Object Model (POM)**, Thread-Safe parallel execution, and dynamic browser configuration.

## 🎯 Objectives (Test Cases)

The framework covers the following business scenarios defined in Gherkin (BDD):

- **UC-1**: Error validation when attempting to login with empty fields.
- **UC-2**: Error validation when the password field is omitted.
- **UC-3**: Successful login flow verifying multiple users (Data Driven Testing using Scenario Outline).

## 🛠️ Tech Stack

| Component | Technology / Version |
|-----------|----------------------|
| **Language** | Java 11 (OpenJDK) |
| **Automation Engine** | Selenium WebDriver 4.28.1 |
| **Dependency Manager** | Maven |
| **Test Runner** | JUnit 4 |
| **BDD Framework** | Cucumber 7.15.0 |
| **Architecture** | Page Object Model (POM) |
| **Concurrency** | Maven Surefire + ThreadLocal |

## 🏗️ Implemented Design Patterns

The code demonstrates an advanced level of test engineering through:

1.  **Page Object Model (POM):** Logical separation between web elements (`pages`) and test steps (`steps`), utilizing an abstract `BasePage` to reuse common actions.
2.  **Singleton:** Implemented in `DriverManager` to guarantee a global and controlled access point to the driver instance.
3.  **Strategy / Factory (via Enum):** Use of `BrowserType` with `Supplier<WebDriver>` for polymorphic and clean browser creation (Chrome, Edge, Firefox, Safari).
4.  **ThreadLocal Pattern:** Ensures Thread-Safety, allowing multiple browsers to run in parallel without session collisions.

## 🌐 Supported Browsers

Thanks to the `BrowserType` implementation, the framework supports:

- Google Chrome (Default)
- Microsoft Edge
- Mozilla Firefox
- Apple Safari

## 📋 Prerequisites

- **Java JDK 11** or higher configured in the PATH.
- **Maven 3.6+**.
- Web browsers installed corresponding to the tests.

## 🚀 Installation and Setup

```bash
# 1. Clone the repository
git clone <REPOSITORY_URL>
cd Automation_Framework

# 2. Install dependencies and build
mvn clean install -DskipTests
