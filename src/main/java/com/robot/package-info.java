/**
@startuml
Actor actor
actor           ->  RobotMainApp            : Run, give command
RobotMainApp    ->  RobotCommandFactory     : Parse and getCommand
RobotCommandFactory    ->  IRobotCommand     : execute command
@enduml

@startuml
interface   IRobotCommand
IRobotCommand   <|-- PlaceRobotCommand
IRobotCommand   <|-- MoveRobotCommand
IRobotCommand   <|-- ReportRobotCommand
IRobotCommand   <|-- RotateLeftRobotCommand
IRobotCommand   <|-- RotateRightRobotCommand
@enduml

@startuml
enum            CommandType
CommandType     *--     PlaceRobotCommand
CommandType     *---     MoveRobotCommand
CommandType     *--     ReportRobotCommand
CommandType     *---     RotateLeftRobotCommand
CommandType     *--     RotateRightRobotCommand
CommandType     <-     RobotCommandFactory
@enduml

@startuml
enum            FacingDirection
class           RobotPosition
class           ToyRobot
class           TableTop
class           RobotMainAppTest
FacingDirection     --*     RobotPosition
RobotPosition       --*     ToyRobot
ToyRobot            --*     RobotMainAppTest
TableTop            --*     RobotMainAppTest
@enduml
*/

package com.robot;

