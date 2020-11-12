package com.web.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.json.simple.parser.*;

import java.io.*;
import java.util.List;
import java.util.Map;

@Service
public class ReworkService {


    @Value("${mini.glechau.jsonLocation}")
    public String location;

    public void save(List<String> data) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Writing to a file
            System.out.println("ReworkService 26: Passed");
            mapper.writeValue(new File(location + "data.json"), data );
            System.out.println("ReworkService 28: Passed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPayload() throws JSONException, IOException {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(location + "data.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            return obj.toString();
    } catch (ParseException e) {
            e.printStackTrace();
        }
        return "failed to receive data, please connect to the network";
    }


    public void savetype(List<String> data) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Writing to a file
            mapper.writeValue(new File(location + "datatype.json"), data );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPayloadtype() throws JSONException, IOException {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(location + "datatype.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            return obj.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "failed to receive data, please connect to the network";
    }


}
