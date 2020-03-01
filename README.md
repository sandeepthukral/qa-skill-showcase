# qa-skill-showcase

## About
This is my attempt at the QA Skill Showcase

## Requirements
- Git
- Java 1.8

## Instructions for OsX
- Clone the repo \
`git clone https://github.com/sandeepthukral/qa-skill-showcase.git`
- Once done, move into the repo folder\
`cd qa-skill-showcase`
- Run the following command to execute the tests \
`./gradlew clean test`
- The report will be available in the folder `test-report/cucumber`. Open it using the command \
`open test-reports/cucumber/cucumber-html-reports/overview-features.html`

### Options
- The tests execute by default on Chrome. In order to run the tests on Firefox,\
`./gradlew -DBROWSER=firefox clean test`\
The options are `chrome`, `firefox`, `ie`, `edge`, `opera`

## Package information

### Components of the framework
- The framework uses Java, jUnit, Selenide, Cucumber JVM
- Selenide manages getting the relevant driver and also starts the webdriver. \
But it mainly is a wrapper on selenium webdriver, providing useful, fluent access to elements and commands on the same.
- The framework is ready for being executed on a remote driver. 
This will be useful when running on Jenkins using solutions like selenoid or zalenium.

### Structure
- `sandeep.qa.features` - Contains the feature files
- `sandeep.qa.pages` - Page Object implementation
- `sandeep.qa.runner` - Contains the TestRunner 
- `sandeep.qa.steps` - Contains the Step Definition Files
- `sandeep.qa.utils` - Utilities and Hooks code 

### Classes
- TestBase - Does one-time reading of properties and test data.
- Context - Helps share data across steps
- TestRunner - The runner for Cucumber 

## Further improvements for the framework
### Run the tests on CI platform
- Run tests on selenoid docker instances (using REMOTE_DRIVER option)
- Dockerize the text execution environment itself
- Wrap it in docker-compose
- Write a shell script to execute the tests. This can be extended to get inputs from Jenkins parameters.

### Parallel execution of tests. 
That *might* require replacing a few components of the framework. jUnit with TestNG and gradle with maven.

## Additional tests
Additional tests that could be added based on the limited understanding of the application under test have 
been mentioned as commented scenarios in the feature files.

Many of these can be added if there is more time and if there are non-UI methods to setup test data. 
Then we can make the execution quick and less flaky. 

## Observations about the Application Under Test

### Testability improvements
- The sign-up and login pages have forms with a specific ID. This has been used to ensure that the correct 
page has been loaded. But the password reset page has a form that can have an ID to identify the page.
 
- For individual pages, it could help if they have some attributes to identify the page and elements in them. 
Currently, I can rely either on (a subset of) the URL of the page or on `form[action='URL']` attribute to identify pages. 
There can be attributes like ‘QA classes’ or `data-*` attributes or `id`s to indicate what page one is on.

- The above also applies to all important buttons, sections and links. 
Currently, at times, I am relying on the order in which these appear. This is rather brittle and is not a good practice.
If these elements have 'QA classes' or `id`s then test can have more reliable selectors.

### Bugs noticed

#### When model cannot value a property, the 'Adjust Inputs' button does not work as expected
Steps
- On the search page, enter and select an address
- Enter a very high value for NOI (say 4,000,000,000,000)
- Enter a very high value for occupancy (say 4000000)
- Enter year of construction as 1900
- Run the valuation
- You get a page that mentions the model cannot value that property
- If you now click the 'Adjust Inputs', you expect to be returned to the search page with your inputs on the form pre-filled
- What you get is an empty form. This sounds like a bug to me. 

#### No visible feedback on Search form for missing inputs in certain condition

Steps
- On the Search page, enter the address and select a suggestion from the dropdown
- Do not enter any of the required fields
- Click on Run Valuation
- The user gets no visible feedback for missing inputs.

#### Negative values can be entered for number fields on the search page

This applies to all the fields on the Search page

#### The Next button on History page appears when no records are displayed

Steps
- On the History page, filter for some random, long text.
- The text 'No matching records found' is displayed
- The pagination should now disappear. 
- Instead, you still have the Next button on the page

### Application reliability  

When testing the application, I saw that at times it takes too long to load the login page. 
Since the page itself is really simple, it is usually some third-party library or asset group that slows that page down. 
This specifically does not impact end users (they can still begin to enter their credentials) but for automated tests 
it adds a few more seconds to the execution. 
One example of such delay was a slow response from fontawesome.

The valuation report generation is sometimes slower than expected. I first had a wait period for 10 seconds 
but, at times, it took longer to generate the report. So I bumped the wait period to 20 seconds. 

### UI improvements

Search page - When no info is added and Run Valuation is clicked the first time, it displays a HTML5 error. 
When focused on another element, or button is clicked again only then 
does the error message asking for address being entered appears.