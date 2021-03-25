# spring-boot-war-jndi-demo

### Checkout the code

```
git@github.com:briantanseng/spring-boot-war-jndi-demo.git
```

### Build the Project

```
cd spring-boot-war-jndi-demo 
./gradlew clean build bootWar
```

### Run the War File

```
java -jar build/libs/demo-0.0.1-SNAPSHOT.war
```
To check the active profile, browse http://localhost:8080/profile

### Deploy the War File to an Application Server

Add the following JNDI Entry:

#### On IBM Websphere Application Server (WAS)

Using the web admin console, navigate to Environment > Naming > Name space bindings.

Add an entry to Scope: Node, then select the Binding Type: String

Enter these values:
```
Scope: cells/DefaultCell01/nodes/DefaultNode01
Binding type: String 
Binding identifier: Profile
Name in name space relative to lookup name prefix 'cell/nodes/DefaultNode01/persistent/': Profile
String value: [Enter Profile Here]
```
Here's the resulting jndi name: 
```
cell/nodes/DefaultNode01/persistent/Profile
```

Upload the war file then start the application.

To check the active profile, browse http://localhost:9080/profile
