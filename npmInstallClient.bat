@echo off

REM Check if Node.js is installed
node -v >nul 2>&1
IF %ERRORLEVEL% NEQ 0 (
    echo Node.js is not installed
    pause
    exit /b
)

set "currentDir=%cd%"
cd /d "%currentDir%\Client\LightClient\light-client"

npm i --legacy-peer-deps