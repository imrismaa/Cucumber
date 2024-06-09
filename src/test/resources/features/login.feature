Feature : User Login

Scenario: Successful login with valid credentials
    Given user is on the login page
    When user submit valid credentials
    Then user should be redirected to the dashboard