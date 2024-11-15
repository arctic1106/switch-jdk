mvn -Pnative package

Copy-Item ".\target\switch-jdk.exe" "C:\scripts\switch-jdk.exe" -Force
Write-Host "Successfully copied the executable to C:\scripts\switch-jdk.exe" -ForegroundColor Green