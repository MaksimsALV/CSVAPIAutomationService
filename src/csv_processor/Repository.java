package csv_processor;

import org.json.JSONObject;

import java.util.List;

public class Repository {
    public static List<String> allLinesFromCSV; //virtual list to hold data (lines) from extracted CSV
    public static List<JSONObject> jsonObjectsList; //virtual list to hold converted data as JSON
}
