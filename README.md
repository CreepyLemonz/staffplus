# staffplus
it does some staff things but with a +

## Building

To build staffplus, you need JDK 17 or higher installed on your system.

1. `git clone https://github.com/CreepyLemonz/staffplus.git` the project
2. `cd staffplus` into the directory
3. `gradle build` the project
4. staffplus.jar should be located in build/libs

## Features
- Toggleable staff chat
- Silent join notifications for other staff
- List online staff via command, will show if they are vanished and afk
- Automatically get a list of online staff on join
- Configurable permission via LuckPerms `staffplus.staffchat`, set to false by default.

## Commands
- `/staffchat <message>`
- - sends a message straight to staff chat
- `/staffchat toggle`
- - toggles the staff chat channel, so you can staff chat without the command each time
- `/sc` as an alias to `/staffchat`
- `/stafflist`
-  - lists online staff and their statuses
-  `/sl` as an alias to `/stafflist`