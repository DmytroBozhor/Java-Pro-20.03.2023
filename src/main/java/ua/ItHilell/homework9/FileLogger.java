package ua.ItHilell.homework9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileLogger {


    private void debug(String massage) throws IOException, FileMaxSizeReachedException {

        FileOutputStream os = new FileOutputStream(FileLoggerConfiguration.getFile(), true);

        StringBuilder sb = new StringBuilder();

        sb.append(LocalDateTime.now()).append(" ").append(LoggingLevel.DEBUG).append(" Massage: ").append(massage);

        if (FileLoggerConfiguration.getFile().length() >= FileLoggerConfiguration.getMaxSize()) {
            throw new FileMaxSizeReachedException();
        } else {
            os.write(sb.toString().getBytes());
        }

        os.close();
    }

    private void info(String massage) throws IOException, FileMaxSizeReachedException {

        FileOutputStream os = new FileOutputStream(FileLoggerConfiguration.getFile(), true);

        StringBuilder sb = new StringBuilder();

        sb.append(LocalDateTime.now()).append(" ").append(LoggingLevel.INFO).append(" Massage: ").append(massage);

        if (FileLoggerConfiguration.getFile().length() >= FileLoggerConfiguration.getMaxSize()) {
            throw new FileMaxSizeReachedException();
        } else {
            os.write(sb.toString().getBytes());
        }

        os.close();
    }

    public void log(LoggingLevel loggingLevel, String massage) throws IOException {
        if (loggingLevel == LoggingLevel.INFO) {
            info(massage);
        } else if (loggingLevel == LoggingLevel.DEBUG) {
            info(massage);
            debug(massage);
        }
    }

}
