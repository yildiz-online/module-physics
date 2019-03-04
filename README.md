# Yildiz-Engine module-physics.

This is the official repository of the Physics Module, part of the Yildiz-Engine project.
The physics module is an abstract component to handle the physics, it is meant to be materialized.

## Features

* Mesh and primitive shapes.
* Different worlds support.
* Static, and dynamic objects.
* Masking.
* Forces(gravity,...).
* ...

## Requirements

To build this module, you will need a java 9 JDK and Maven 3.

## Coding Style and other information

Project website:
https://engine.yildiz-games.be

Issue tracker:
https://yildiz.atlassian.net

Wiki:
https://yildiz.atlassian.net/wiki

Quality report:
https://sonarqube.com/overview?id=be.yildiz-games:module-physics

## License

All source code files are licensed under the permissive MIT license
(http://opensource.org/licenses/MIT) unless marked differently in a particular folder/file.

## Build instructions

Go to your root directory, where you POM file is located.

Then invoke maven

	mvn clean install

This will compile the source code, then run the unit tests, and finally build a jar file.

## Usage

In your maven project, add the dependency

```xml
<dependency>
    <groupId>be.yildiz-games</groupId>
    <artifactId>module-physics</artifactId>
    <version>1.0.7</version>
</dependency>
```

## Contact
Owner of this repository: Grégory Van den Borre