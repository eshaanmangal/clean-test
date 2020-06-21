package com.xebia.service.impl;

import com.xebia.service.GetMappingFromJSON;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;

public class GetMappingFromJSONImpl implements GetMappingFromJSON {

    public static final String MAPPING_JSON_FILE_PATH = "./src/data/mapping.json";

    @Override
    public HashMap<String, String> getMapping() throws Exception {

        JSONParser jsonParser = new JSONParser();
        HashMap<String,String> mappingFromJson = new HashMap<>();

        try {
            Object obj = jsonParser.parse(new FileReader(MAPPING_JSON_FILE_PATH));
            JSONObject jsonObject = (JSONObject) obj;

            jsonObject.keySet().forEach(keyStrColumnName ->
            {
                Object keyValueLocationOfCell = jsonObject.get(keyStrColumnName);
                mappingFromJson.put((keyStrColumnName.toString()).toLowerCase(),
                                    (keyValueLocationOfCell.toString()).toLowerCase());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

//        for (Map.Entry mapElement : hashMap.entrySet()) {
//            String key = (String)mapElement.getKey();
//            String value = (String) mapElement.getValue();
//            System.out.println(key + " : " + value);
//        }
        return mappingFromJson;
    }
}
