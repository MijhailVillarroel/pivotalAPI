package com.fundacionjala.pivotalapi;

import com.jayway.restassured.response.Response;

import java.util.Map;

/**
 * Created by mijhailvillarroel on 7/4/2016.
 */
public class DataBase {

    public static String endPoint(String endPoint, Map<String, Response> valuesResponse) {
        if (endPoint.contains("[")) {
            for (String endPontSplit : endPoint.split("/")) {
                if (endPontSplit.matches("[\\[]+[\\w.]+[^\\(]+\\]")) {
                    String[] mapString = endPontSplit.split("^\\[|\\]|\\.");
                    String value = "" + valuesResponse.get(mapString[1]).jsonPath().get(mapString[2]);
                    endPoint = endPoint.replace(endPontSplit, value);
                }
            }
        }
        return endPoint;
    }
}
