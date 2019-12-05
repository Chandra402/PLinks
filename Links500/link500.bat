@echo on
SET PROJECT_PATH=..

cd /E %PROJECT_PATH%

call mvn clean
call mvn test

pause
