# selenium_POM_github
Selenium example that uses PageFactory to browse GitHub.

# What is this?
This is a code example that leverages PageFactory / Page Object Models to run really basic tests on the github website. This is an organized base that could easily be built upon to write full-blown test suites. This test is currently designed to only run on Chrome but could be readily modified to also work on Firefox or even run in parallel.

# What language is this written in?
The code is written in Java.

# What software do I need to make this run?
* Docker
* My Repo

# How to get up and running
* Pull down Repo
* Install Docker
* Run `docker run -d -p 4444:4444 -p 5901:5900 selenium/standalone-chrome-debug` to start server with VNC
* Navigate to the repo download and execute `./gradlew Test -PallRegression` to kick off the test

NOTE: the password test may fail if you do not have defined username / passwords in your env settings

# Frequently Asked Questions:
Q: How can I tell this test is actually running?
A: If you want to see what is happening during the run you can connect to the container via VNC. The VNC port being exposed with the directions above is 5901. Ideally you'd want to have a step after this in your CI system to parse the TestNG results.

Q: How do I know if docker is running?
A: Run `docker ps` to see the process running.
