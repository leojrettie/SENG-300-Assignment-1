# SENG-300-Assignment-1

## Group Members:
|Name|UCID|Email|
|-|-|-|
|Nico MacDonald|10195401|nico.macdonald@ucalgary.ca|
|Sachit Pegallapati|30242305|sachit.pegallapati@ucalgary.ca|
|Tyrone De jesus|30248724|tyrone.dejesus@ucalgary.ca|
|Stya Indriliunas|30256090|stya.indriliunas@ucalgary.ca|
|Leo Rettie|30333025|leo.rettie@ucalgary.ca|
|Ncomo Kenyata|30091606|ncomo.kenyata@ucalgary.ca|

## Run Instructions
Requirements: Java JDK 17 or newer
1. Build
Windows (Command Promt):
mkdir bin
dir /s /b src\*.java > sources.txt
javac -d bin @sources.txt

Windows (PowerShell):
mkdir bin
Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { $_FullName } | Out-File -Encoding ascii sources.txt 
javac -d bin "@sources.txt"

2. Run
The demo is in the Main class:
java -cp bin Main

VS Code:
Open the project folder with the Java Extension Pack installed, open Main.java, and click Run above the main method

Main is a demo (a "story") that shows how the station part of GoCycle works:
stations, docking points, vehicles, and the control room.
It does not use a real app or screen; it just prints what happens.:

Creates two stations (Downtown in English, Campus in French) and docks three vehicles, showing each zone's theme colours and language.
Checks which vehicles a rider can take. The scooter, at 15% battery, is unavailable because electric vehicles need at least 20%.
A rider tries to take the scooter and is refused.
A rider takes the e-bike, returns it to Campus, and the trip ends only once the vehicle is locked into a docking point.
A fault is reported on the pedal bike, and the control room takes it out of service.
The control room moves the e-bike back to Downtown and restores the pedal bike.
Prints the final state of both stations.

