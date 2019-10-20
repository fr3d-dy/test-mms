Mattermost Selenium 
==========================

# Setup for Mac:

1. Make sure you have the latest versions of Firefox and Chrome installed.
1. Install the Selenium IDE from http://www.seleniumhq.org/
1. Install java JDK 1.8 from  http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
1. Set `export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home` in your `.bash_profile`
1. Install Maven from http://maven.apache.org/install.html
1. Verify Maven in installed correctly with `mvn -version`
1. Start a local Mattermost server
1. Run `make` 

# Selenium IDE Setup:

`Options` > `Options ...` > `Format`

Select `Java / JUnit 4 / WebDriver`

Set the following properties

Variable for Selenium instance:
```
driver
```

Package:
```java
com.mattermost.selenium.tests
```

Header:
```java
package ${packageName};

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class ${className} extends DriverBase {

    @Test
    public void ${methodName}() throws Exception {

```

Footer:
```
    }
}
```

Indent:
```
4 spaces
```

# Teams and Users created by the setup script
Team Name: ui-automation

Test Account 1 (System Admin): Email: `test@test.com` | Password: `passwd`

Test Account 2 (Team Admin): Email: `test2@test.com` | Password: `passwd`

Test Account 3 (Normal): Email: `test3@test.com` | Password: `passwd`

Test Account 4 (Normal): Email: `test4@test.com` | Password: `passwd`

Also all the accounts are set to bypass the tutorial.


# Build machine
1. Run the script `setup-test-machine.sh` to configure the machine
2. Our jenkins job runs

```
# setup the server for the run
bash -ex ./setup-for-run.sh

export DISPLAY=:99

# run both chrome and firefox automated UI tests
make
```


# Selenium Server

To use Selenium Server you can use the docker-compose file and this will spin up the Selenium Server and two nodes (one Chrome and one Firefox). With that you dont need to install Chrome or Firefox in your local development.

To run (assuming you have docker installed):

```
$ docker-compose up
```
