# SeleniumTest

Prerequisites:
- Java SDK
- Have set the Java SDK Environment Variable
- Chromedriver of the browser you are using (Right now only works on chrome)

Before running the test you need to make sure to download the chromedriver that is closest to your actual Chrome version.
https://chromedriver.chromium.org/downloads 

and then put the driver in the folder "drivers" inside the project.

if you want to run the tests in Windows you need to change line 42 of BaseTest.java and set the last part of the string to "chromedriver.exe"

To run the tests, you have to go to PostsTests and can run the tests individually.




Only 4 tests pass right now, i couldn't find how to get the text from the alert in test 2 and 3, any tip on that part would be apreciated.

 
