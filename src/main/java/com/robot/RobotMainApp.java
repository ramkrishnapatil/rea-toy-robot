package com.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.stream.Stream;

import com.robot.command.RobotCommandFactory;
import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main application
 */
public class RobotMainApp {

    private static final Logger LOGGER = LogManager.getLogger(RobotMainApp.class.getSimpleName());

    /**
     * Main method
     * @param args 0 - User Input, 1 - File Input
     */
    public static void main(final String[] args) {
        final TableTop tableTop = new TableTop();
        final ToyRobot robot = new ToyRobot();
        Stream<String> argsStream = new RobotMainApp().input(args);
        argsStream.forEach(command -> RobotCommandFactory.getInstance().getCommand(command).execute(tableTop, robot));
    }

    public Stream<String> input(final String[] args) {
        switch (args.length) {
        case 0:
            return stdinStream();
        case 1:
            return fileStream(args[0]);
        default:
            LOGGER.info(() -> "For file Input: run as java -jar <app>.jar <filename with path> ");
            LOGGER.info(() -> "For console input: run as java -jar <app>.jar");
            return Stream.empty();
        }
    }

    /**
     * Converts stdin data into stream.
     */
    private Stream<String> stdinStream() {
        return new BufferedReader(new InputStreamReader(System.in)).lines();
    }

    /**
     * Reads the input file.
     */
    private Stream<String> fileStream(String filePath) {
        try {
            return Files.lines(Paths.get(filePath));
        } catch (IOException e) {
            LOGGER.error("File read error: {}", e::getMessage);
            LOGGER.info(() -> "File Input: run as java -jar <app>.jar <filename with path> ");
            LOGGER.info(() -> "Console input: run as java -jar <app>.jar");
            return Stream.empty();
        }
    }
}
