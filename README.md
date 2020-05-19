To execute tests:

```mvn clean verify allure:serve -Dbrowser=chrome -DcustomBrowserImpl=com.frameworkium.bdd.CustomChromeImpl -Dcucumber.options="--tags @" -Denv=test```

where @test-to-be-run specifies the tag above the test you would like to run.

Alternatively, use:

```mvn clean verify allure:serve -Dbrowser=chrome -DcustomBrowserImpl=com.frameworkium.bdd.CustomChromeImpl -Dheadless=true -Dthreads=2 -Denv=test```

to run all tests.

When running tests within jenkins, add the following batch command to run "On Build":

```mvn clean verify -Dbrowser=chrome -DcustomBrowserImpl=com.frameworkium.bdd.CustomChromeImpl -Dheadless=true -Dthreads=4 -Denv=test```

and add "allure report" as a Post-Build step.