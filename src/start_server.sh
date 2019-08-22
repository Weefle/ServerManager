#!/bin/bash
cd /home/waze/servers/$1
screen -d -m -S $1 java -Xmx$2M -Xms32M -DIReallyKnowWhatIAmDoingISwear -Dcom.mojang.eula.agree=true -jar /home/waze/servers/$1/spigot.jar --port $3