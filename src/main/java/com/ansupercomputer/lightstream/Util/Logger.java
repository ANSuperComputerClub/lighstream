package com.ansupercomputer.lightstream.Util;

import lombok.extern.java.Log;

/**
 * A Logger object that logs messages to the standard output.
 */
public class Logger {
    private final String name;

    /**
     * Instantiates a logger object
     * @param name the name of the logger
     */
    public Logger(String name) {
        this.name = name;
    }

    /**
     * Log a message to the console with a given verbosity
     * @param verbosity the verbosity of the message
     * @param message the message to print
     */
    public void log(LogLevel verbosity, String message) {
        // This takes load off of RAM and onto the CPU... TODO: decide if this is the right decision
        String level = switch (verbosity) {
            case ERROR -> "ERROR";
            case WARNING -> "WARNING";
            case INFO -> "INFO";
        };
        System.out.println("[" + name + "][" + level + "]: {" + message + "}");
    }

    /**
     * Log a message to the console, with the warning verbosity
     * @param message the message to log
     */
    public void log(String message) { log(LogLevel.WARNING, message); }
}
