$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("VOXITest.feature");
formatter.feature({
  "line": 1,
  "name": "VOXI new user journey",
  "description": "",
  "id": "voxi-new-user-journey",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 2,
  "name": "Select Phone and Plan",
  "description": "",
  "id": "voxi-new-user-journey;select-phone-and-plan",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 3,
  "name": "I am on VOXI landing Page",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "VOXI url loads",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "I selects Phone and Plan",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "skip extra",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "submit order to checkout \u003cTestCaseID\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "voxi-new-user-journey;select-phone-and-plan;",
  "rows": [
    {
      "cells": [
        "TestCaseID"
      ],
      "line": 10,
      "id": "voxi-new-user-journey;select-phone-and-plan;;1"
    },
    {
      "cells": [
        "\"TC01\""
      ],
      "line": 11,
      "id": "voxi-new-user-journey;select-phone-and-plan;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 11,
  "name": "Select Phone and Plan",
  "description": "",
  "id": "voxi-new-user-journey;select-phone-and-plan;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 3,
  "name": "I am on VOXI landing Page",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "VOXI url loads",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "I selects Phone and Plan",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "skip extra",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "submit order to checkout \"TC01\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefination.I_am_on_VOXI_landing_Page()"
});
