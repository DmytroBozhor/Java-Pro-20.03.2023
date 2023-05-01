package ua.ItHilell.homework9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileLoggerConfiguration {

    private static File file = new File("loggs.txt");

    private static LoggingLevel loggingLevel;

    private static final long FILE_MAX_SIZE = 1024 * 1024; // 1 mb

    public FileLoggerConfiguration() throws FileNotFoundException {

    }

    public static void setLevel(LoggingLevel loggingLevel) {
        FileLoggerConfiguration.loggingLevel = loggingLevel;
    }

    public static void setFile(File file) {
        FileLoggerConfiguration.file = file;
    }

    public static long getMaxSize() {
        return FILE_MAX_SIZE;
    }

    public static File getFile() {
        return file;
    }

    public static LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }
}
