@echo off

set "currentDir=%cd%"

cd /d "%currentDir%\Server\JCDecauxProxy\bin\Debug"

powershell Start-Process -FilePath "JCDecauxProxy.exe" -Verb RunAs


