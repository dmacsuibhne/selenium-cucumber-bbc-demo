
# Tech task for Donnchadh Mac Suibhne

## Goal of the tech task
This is a chance to display your technical skill to test a public website.
The site is https://www.bbc.com/
You will need to launch the website and at a minimum
- Verify the top navigation links (Home, News, Sport, etc)
- Verify the day and date displayed on the page is correct.
- Navigate to the “News” section and verify url is correct.
- In the top navigation, perform a search for “Houghton Mifflin Harcourt” and
verify the search results.
You can use any language and framework you are comfortable with, bonus points for ability to run on chrome and firefox and the use of BDD.

**Please provide**
1. A project that we can run which demonstrates how you validated the endpoint.
Please document your code as you see fit to make it easily understandable.
2. Instructions how we can compile and run the Scenarios.

## How to run
1. Install maven
2. Run command: mvn clean surefire-report:report

## How to view test report
* The test report is saved at target/site/surefire-report.html

## What I would like to add (not included due to time constraints)
* Ability to specify which browsers/screen sizes you wish to execute (instead of always running them all)
* Use chromedriver's mobile emulation instead of just browser resizing
* Parallelisation
* A nicer test report
