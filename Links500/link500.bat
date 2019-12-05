@echo on
SET PROJECT_PATH=..

cd  %PROJECT_PATH%

call mvn clean
call mvn test

pause
