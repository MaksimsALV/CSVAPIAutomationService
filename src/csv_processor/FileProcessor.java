package csv_processor;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileProcessor {

    //extract from CSV method
    public static void extractFromCSV() throws IOException {
        Repository.allLinesFromCSV = Files.readAllLines(Path.of(System.getProperty("user.home"), "Desktop", "INPUT.csv"));
        Repository.allLinesFromCSV.forEach(System.out::println); //for output analysis
    }

    //write to CSV method
    public static void writeToCSV() throws IOException {
        Path outputPath = Path.of(System.getProperty("user.home"), "Desktop", "OUTPUT1.csv");

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            for (JSONObject jsonObject : Repository.jsonObjectsList) {
                writer.write(String.valueOf(jsonObject));
                writer.newLine();
                System.out.println(jsonObject); //for output analysis
            }
        }
    }
}
