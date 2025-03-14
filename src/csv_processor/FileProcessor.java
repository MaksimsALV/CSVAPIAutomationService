package csv_processor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileProcessor {

    //virtual list to hold data (lines) from extracted CSV
    public static List<String> allLinesFromCSV;

    //extract from CSV method
    public static void extractFromCSV() throws IOException {
        allLinesFromCSV = Files.readAllLines(Path.of(System.getProperty("user.home"), "Desktop", "INPUT.csv"));
        allLinesFromCSV.forEach(System.out::println); //for output analysis
    }

    //write to CSV method
    public static void writeToCSV() throws IOException {
        Path outputPath = Path.of(System.getProperty("user.home"), "Desktop", "OUTPUT1.csv");

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            for (String line : FileProcessor.allLinesFromCSV) {
                writer.write(line);
                writer.newLine();
                System.out.println(line); //for output analysis
            }
        }
    }
}
