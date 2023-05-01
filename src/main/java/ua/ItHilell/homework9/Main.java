package ua.ItHilell.homework9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Main {

    public static void main(String[] args) throws IOException {

        FileLogger fileLogger = new FileLogger();

        FileLoggerConfiguration.setLevel(LoggingLevel.INFO);

        fileLogger.log(FileLoggerConfiguration.getLoggingLevel(), "Some text\n");

    }
}
