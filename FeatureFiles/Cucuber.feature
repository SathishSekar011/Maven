Feature: Login Functionalities

  Background: Background
    Given Background Execution
	@Smoke
  Scenario Outline: Checking with invalid datas with Edge
    Given Facebook URL Launched "edge"
    When User Enters "<userName>" and "<Password>"
    #2D Datatable with header  #asMaps
    Then TakeScreenshot

    Examples: 
      | userName | password |
      | sathish  |     1234 |
      | sarath   |     7777 |
      | xavier   |     8888 |
@Sanity
  Scenario Outline: Checking with invalid datas with Firefox
    Given Facebook URL Launched "edge"
    When User Enters "<userName>" and "<Password>"
    #2D Datatable with header  #asMaps
    Then TakeScreenshot

    Examples: 
      | userName | password |
      | sathish  |     1234 |
      | sarath   |     7777 |
      | xavier   |     8888 |
@Smoke
@Sanity
  Scenario Outline: Checking with invalid datas with Chrome
    Given Facebook URL Launched "chrome"
    When User Enters "<userName>" and "<Password>"
    #2D Datatable with header  #asMaps
    Then TakeScreenshot

    Examples: 
      | userName | password |
      | sathish  |     1234 |
      | sarath   |     7777 |
      | xavier   |     8888 |
