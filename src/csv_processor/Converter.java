package csv_processor;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static List<JSONObject> convertToJSON() {
        List<JSONObject> jsonOjectsList = new ArrayList<>();

        for (String row : FileProcessor.allLinesFromCSV) {
            String[] rowValues = row.split(",");
            JSONObject jsonObject = new JSONObject();

            for (int i = 0; i < rowValues.length; i++) { //i = indicator, default value 0, which means first value will have indicator 1 thanks to i+1, then next is again +1 (so, indicator 2)
                jsonObject.put("value" + (i + 1), rowValues[i]);
            }
            jsonOjectsList.add(jsonObject);
            System.out.println(jsonObject);
            }
        return jsonOjectsList;
    }
}

