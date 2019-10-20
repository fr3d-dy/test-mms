#!/bin/bash

# this is the setup script used on the linux ubuntu 14.04 build machine

echo "deb http://dl.google.com/linux/chrome/deb/ stable main" | sudo tee -a /etc/apt/sources.list
wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | sudo apt-key add -

sudo apt-get install -y python-software-properties debconf-utils

sudo apt-get update

sudo apt-get -y install make

sudo apt-get -y install mailutils

sudo add-apt-repository -y ppa:webupd8team/java
echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 select true" | sudo debconf-set-selections
sudo apt-get install -y oracle-java8-installer

sudo apt-get -y install maven

sudo apt-get -y install xvfb

sudo apt-get -y install xserver-xorg-core

sudo apt-get -y install xfonts-cyrillic xfonts-100dpi xfonts-75dpi xfonts-base xfonts-scalable

sudo apt-get -y install libxpm4 libxrender1 libgtk2.0-0 libnss3 libgconf-2-4

sudo apt-get -y install xvfb gtk2-engines-pixbuf

sudo apt-get -y install imagemagick dbus-x11 x11-apps

sudo apt-get -y install firefox

sudo apt-get -y install google-chrome-stable

#sudo sed -i'' -e 's|exit 0| |g' /etc/rc.local
#echo "Xvfb :99 -ac -screen 0 1920x1080x24 2>&1 >/dev/null &" | sudo tee -a /etc/rc.local
#echo "export DISPLAY=:99" | sudo tee -a /etc/rc.local
#echo "exit 0" | sudo tee -a /etc/rc.local

# Make sure to install mattermost with on the same machine https://docs.mattermost.com/install/install-ubuntu-1604.html