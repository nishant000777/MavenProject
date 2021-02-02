Feature: VOXI new user journey
  Scenario Outline: Select Phone and Plan
    Given I am on VOXI landing Page
    When VOXI url loads
    And I selects Phone and Plan
    And skip extra
    Then submit order to checkout <TestCaseID>

  Examples:
    | TestCaseID  |
    | "TC01"      |
# allure serve /IdeaProjects/MavenProject/target/surefire-reports
  Scenario Outline: Select Phone and Plan with extra
    Given I am on VOXI landing Page
    When VOXI url loads
    And I selects Phone and Plan
    And Select Extra
    Then submit order to checkout <TestCaseID>

    Examples:
      | TestCaseID  |
      | "TC03"      |

