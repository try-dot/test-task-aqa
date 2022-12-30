## Test task structure:
1. `TestCases.pdf` - 3 test cases
2. `BugReports.pdf` - 3 bug reports
3. `src/test/java/LoginPageTest.java` - 3 autotests for login form
   * `src/test/java/pages/LoginPage.java` - Page Object for login page
3. `src/test/java/APITest.java` - autotest to receive data from the endpoint and compare
   response JSON schema with the provided schema
   * `src/test/java/resources/WEHatfgD.json` - the provided schema

Test results are stored in `target/surefire-reports`   
For Allure report enter `allure serve target/surefire-reports/` (require installed Allure CLI)
