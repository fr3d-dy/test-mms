#!/bin/bash

sudo systemctl stop mattermost

tar czPf ~/logs/archive-pre-$BUILD_ID.tar.gz ~/mattermost/logs
cp -f ~/mattermost/logs/mattermost.log $WORKSPACE/mm-latest.log

rm -f mattermost.tar.gz

# Regular daily from master
# wget https://releases.mattermost.com/mattermost-platform/master/mattermost-enterprise-linux-amd64.tar.gz
# mv mattermost-enterprise-linux-amd64.tar.gz mattermost.tar.gz

# Use this to lock to specific version
wget https://releases.mattermost.com/5.16.0-rc3/mattermost-5.16.0-rc3-linux-amd64.tar.gz
mv mattermost-5.16.0-rc3-linux-amd64.tar.gz mattermost.tar.gz

# Regular daily from release branch
# wget https://releases.mattermost.com/mattermost-platform/release-5.16/mattermost-enterprise-linux-amd64.tar.gz
# mv mattermost-enterprise-linux-amd64.tar.gz mattermost.tar.gz


rm -rf ~/mattermost

mkdir -p ~/mattermost

tar -C ~/ -xzf mattermost.tar.gz

cp ~/config.json ~/mattermost/config/config.json

cd ~/mattermost
./bin/mattermost reset --confirm true

sleep 5
sudo systemctl start mattermost
sleep 5

./bin/mattermost user create --email admin@test.com --username admin --password passwd --system_admin
./bin/mattermost user create --email test@test.com --username test --password passwd
./bin/mattermost user create --email test2@test.com --username test2 --password passwd
./bin/mattermost user create --email test3@test.com --username test3 --password passwd
./bin/mattermost user create --email test4@test.com --username test4 --password passwd
./bin/mattermost user create --email test5@test.com --username test5 --password passwd
./bin/mattermost user create --email test6@test.com --username test6 --password passwd
./bin/mattermost user create --email test7@test.com --username test7 --password passwd
./bin/mattermost user create --email test8@test.com --username test8 --password passwd
./bin/mattermost user create --email test9@test.com --username test9 --password passwd
./bin/mattermost user create --email test10@test.com --username test10 --password passwd

./bin/mattermost team create --name ui-automation --display_name "UI Automation" --email "test2@test.com"
./bin/mattermost team add ui-automation admin@test.com test@test.com test2@test.com test3@test.com test4@test.com test5@test.com test6@test.com test7@test.com test8@test.com test9@test.com test10@test.com

./bin/mattermost team create --name ui-automation2 --display_name "UI Automation 2" --email "test6@test.com" --private=false
./bin/mattermost team add ui-automation2 admin@test.com test5@test.com test6@test.com test7@test.com test8@test.com test9@test.com test10@test.com

./bin/mattermost user create --email corey@test.com --username corey --password passwd
./bin/mattermost team add ui-automation corey@test.com

mysql -u mmuser -ppasswd -h localhost -e "UPDATE Preferences SET Value = '999' WHERE Category = 'tutorial_step';" mattermost
mysql -u mmuser -ppasswd -h localhost -e "UPDATE Teams SET AllowOpenInvite = '1' WHERE Name = 'ui-automation2';" mattermost

# Upload the license to the database to be able to remove when needed
./bin/mattermost license upload ~/mattermost.mattermost-license
sudo systemctl restart mattermost

