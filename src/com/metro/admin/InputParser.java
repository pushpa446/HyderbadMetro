package com.metro.admin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class InputParser {
    
    static RouteMap prepareRouteMap(String fileName) {
        RouteMap routeMap = new RouteMap();
        try {
            Station prevStation = null;
            String currentLine;
            FileReader fileReader = new FileReader(new File("").getAbsolutePath() + "/resources/"+fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((currentLine = bufferedReader.readLine()) != null) {
                if (currentLine.isEmpty()) {
                    prevStation = null;
                    continue;
                }
                String[] stationDetails = currentLine.split(",");
                Station currentStation = routeMap.getStationByCode(stationDetails[0]);
                currentStation = currentStation == null ? new Station(stationDetails[0], stationDetails[1]) : currentStation;
                if (prevStation != null) {
                    prevStation.addNeighbourStation(currentStation);
                    currentStation.addNeighbourStation(prevStation);
                }
                routeMap.addStation(currentStation);
                prevStation = currentStation;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Check the path");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return routeMap;
    }
}
