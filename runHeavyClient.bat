@echo off


set "currentDir=%cd%"
cd /d "%currentDir%\Client\HeavyClient"

call mvn clean install

call mvn exec:java

pause