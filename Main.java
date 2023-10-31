package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

    public static void main(String[] args) {
        String json = readString("new_data.json");
        List<Employee> list = jsonToList(json);
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    public static String readString(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static List<Employee> jsonToList(String json) {
        List<Employee> list = new ArrayList<>();
        JSONParser parser = new JSONParser();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(json);
            for (Object obj : jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                Employee employee = gson.fromJson(jsonObject.toString(), Employee.class);
                list.add(employee);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

}
