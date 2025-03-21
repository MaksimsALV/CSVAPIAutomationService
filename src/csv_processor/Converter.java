package csv_processor;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static void convertToJSON() {
        Repository.jsonObjectsList = new ArrayList<>();

        try {
            List<String> allLinesFromCSV = FileProcessor.extractFromCSV(); //returning the inputfile stored list in the allLinesFromCSV list variable for convert needs

            for (String row : allLinesFromCSV) {
                try {
                    String[] rowValues = row.split(",");
                    JSONObject jsonObject = new JSONObject();

                    for (int i = 0; i < rowValues.length; i++) { //i = indicator, default value 0, which means first value will have indicator 1 thanks to i+1, then next is again +1 (so, indicator 2)
                        jsonObject.put("value" + (i + 1), rowValues[i]);
                    }
                    Repository.jsonObjectsList.add(jsonObject);
                    System.out.println(jsonObject);
                } catch (Exception csvRowErrorHandler) { //inner-layer error handler - checks the rows
                    System.out.println("Error processing row: " + row); //prints row that has problem
                    csvRowErrorHandler.printStackTrace(); //prints the exact error happened in Java with file mentioned above
                }
            }
        } catch (Exception csvFileErrorHandler) { //outer-layer error handler - checks the file itself is fine
            System.out.println("Error processing file: " + csvFileErrorHandler); //prints file that has problem
            csvFileErrorHandler.printStackTrace(); //prints exact error happened in Java with file mentioned above
        }
    }
}

