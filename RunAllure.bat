set ProjectPath=%~dp0
cd %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%libAllureReport\aspectjweaver-1.9.8.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllureReport\*;%ProjectPath%libExtentReportV5\*;%ProjectPath%libReportNG\*;%ProjectPath%libLog4J\*;%ProjectPath%libSelenium\*;%ProjectPath%libWebDriverManager\*" org.testng.TestNG "%ProjectPath%bin\runNopcommerceUser.xml"
pause