Toy Robot Simulator
===================

##Compile and Run
### Compile from command line
./gradlew assemble
### Run the program using INPUT from command line
* ./gradlew run --console=plain
<br>OR
*  java -jar build/libs/rea-toy-robot-1.0.jar
<br>OR
* java -jar build/libs/rea-toy-robot-1.0.jar src/test/resources/SampleA.txt

### tests
* ./gradlew test
#### To run the tests with test report
* ./gradlew test jacocoTestReport

###Libraries and Tools used for Development
* java 1.8+
* Gradle
* JUnit4, JaCoCo
* Intellij IDE for development
* Plant UML (Class and sequence diagram)

###Class information:
**TableTop**        : The TableTop class where the Robot will be placed.<br>
**RobotPosition**   : The ToyRobot position with X, Y(co-ordinates) and F(Facing direction).<br>
**FacingDirection** : The enum FacingDirection(NORTH, EAST, SOUTH, WEST).<br>
####For more information see the UML diagrams in [package-info.java](https://github.com/ramkrishnapatil/rea-toy-robot/package-info.java)

###Sample Input and Output:
A)

	PLACE 0,0,NORTH
    MOVE
    REPORT

	Output: 0,1,NORTH

B)

	PLACE 0,0,NORTH
	LEFT
	REPORT
	
	Output: 0,0,WEST

C)

	PLACE 1,2,EAST
	MOVE
	MOVE
	LEFT
	MOVE
	REPORT

	Output: 3,3,NORTH
