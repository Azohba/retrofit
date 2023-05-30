@GitlabIssues
Feature: Gitlab Issue Tests
  In this feature i demonstrate my api test automation design. Please see the readme file for more insight.

  @IssueCreation
  Scenario: Issue Creation & Verification
    This scenario is made of a single test step which composes necessary variables to create an issue, creates it and
    compares the original values with the ones in the response body. Ideally BDD scenarios are composed of multiple
    steps however its appropriate to combine multi stage tests into a single step in such occasions where a single step
    makes sense.
    * Perform an issue creation test on project ISSUES_API
    * Delete last issue created

  @Utilities
  Scenario: Utility Steps
    * Create issue for project ISSUES_API
    * Create new PUBLIC project named Public-Test-Project without readme
    * Print issue number 1 in project ISSUES_API
    * Print all the issues