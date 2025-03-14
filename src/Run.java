import csv_processor.Converter;
import csv_processor.FileProcessor;

import java.io.IOException;

public class Run {
    public static void main(String[] args) throws IOException {

        System.out.println("\nExtract result:"); //analysis purpose only to isolate extractFromCSV result
        FileProcessor.extractFromCSV();

        System.out.println("\nConverted result:"); //analysis purpose only to isolate convertToJSON result
        Converter.convertToJSON();

        System.out.println("\nWrite result:"); //analysis purpose only to isolate writeToCSV result
        FileProcessor.writeToCSV();
    }
}
