import csv_processor.Converter;
import csv_processor.FileProcessor;

import java.io.IOException;

public class Run {
    public static void main(String[] args) throws IOException {
        FileProcessor.extractFromCSV();
        Converter.convertToJSON();
        FileProcessor.writeToCSV();
    }
}
