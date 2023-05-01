package ua.ItHilell.homework9;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FileLogger fileLogger = new FileLogger();

        FileLoggerConfiguration.setLevel(LoggingLevel.INFO);

        fileLogger.log(FileLoggerConfiguration.getLoggingLevel(), "Some text\n");

    }
}
