Feature: Test the End to End flow of Employee API functionality

  Scenario: Validate get request As per the Employee Id
    Given get the request specification object and pass basepath as "/posts/"
    When user hit get request as per the emp id as 2
    Then user validate status code as 200
    Then user validate status line as "HTTP/1.1 200 OK"
    Then user validate response content-type header

  Scenario: validate delete request as per the Employee Id
    Given get the request specification object and pass basepath as "/posts/"
    When user hit delete request as per the emp id as 2
    Then user validate status code as 200
    Then user validate status line as "HTTP/1.1 200 OK"
    Then user validate response content-type header

  Scenario: Validate get request As per the Employee Id
    Given get the request specification object and pass basepath as "/posts/"
    When user hit get request as per the emp id as 2
    Then user validate status code as 404
    Then user validate status line as "HTTP/1.1 404 Not Found"
    Then user validate response content-type header
