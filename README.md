# Selenium E-Commerce Automation Framework

## Tech Stack

- **Language:** Java
- **Automation Framework:** Selenium WebDriver
- **Test Framework:** TestNG
- **Reporting:** Allure Reports
- **CI/CD:** GitHub Actions
- **Build Tool:** Maven

## Features
- Web UI automation framework built with Selenium WebDriver
- Maintainable test architecture using Page Object Model
- Test lifecycle management with TestNG annotations
- Configurable test execution using Maven
- Rich reporting with Allure
- CI pipeline integration using GitHub Actions
- Scalable and reusable automation components
- Easy test case creation and maintenance

## Framework Architecture
Test Cases (TestNG)
|
↓
Test Layer
|
↓
Page Objects (Selenium WebDriver)
|
↓
Reusable Components
|
├── Driver Manager
├── Wait Utilities
├── Configuration Manager
├── Test Data Manager
└── Common Helpers
|
↓
Reporting Layer (Allure)
|
↓
CI/CD Pipeline (GitHub Actions)

## Test Scenarios

### 🔐 Authentication
- Verify user login with valid credentials
- Verify login failure with invalid credentials
- Verify error messages for empty input fields
- Verify logout functionality

### 🛒 Application Workflows
- Verify end-to-end business workflows
- Validate page navigation
- Verify form submissions
- Verify data updates

### 🔍 UI Validation
- Verify page elements visibility
- Verify buttons, links, and labels
- Verify input field validations

### 📊 Data Validation
- Validate test data inputs
- Verify expected vs actual results
- Verify database/application data consistency (if applicable)

### ⚡ CI/CD Execution
- Run automated tests on code push
- Execute tests on pull requests
- Generate Allure execution reports
  
## Installation
Follow the steps below to set up and run the automation framework locally.

### 1. Clone the Repository

```bash
git clone <repository-url>
cd <project-folder>

### 2. Prerequisites

Make sure the following tools are installed.

☕ Java JDK 17+
📦 Maven
🌐 Google Chrome / Supported Browser
🔧 Git

Verify installations

java -version
mvn -version
git --version

### 3. Install Dependencies

Run the following command to download project dependencies: mvn clean install


## Running Tests
Execute the TestNG test suite:

mvn test
## Allure Reports
After test execution, generate the report:

allure serve allure-results
## GitHub Actions
Push changes to GitHub and the CI pipeline will automatically execute tests.

GitHub Repository
        ↓
GitHub Actions
        ↓
Maven Test Execution
        ↓
Allure Report
## Screenshots
