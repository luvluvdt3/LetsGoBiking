@echo off

set "currentDir=%cd%"

cd /d "%currentDir%\Server\LetsGoBiking\bin\Debug"

powershell Start-Process activemq start
powershell Start-Process -FilePath "RoutingServer.exe" -Verb RunAs
