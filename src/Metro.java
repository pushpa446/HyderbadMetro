import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Metro {
    public static void main(String[] args) throws IOException {
        RouteMap routeMap = new RouteMap();
        try {
            Station prevStation = null;
            String currentLine;
            FileReader fileReader = new FileReader(new File("").getAbsolutePath() + "/resources/stations.csv");
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Source Station Code:");
        String source = bufferedReader.readLine();
        System.out.println("Enter Destination Station Code:");
        String destination = bufferedReader.readLine();
        List<String> route = routeMap.getPath(source, destination);
        FareCalculator calculator = new FareCalculator();
        System.out.println(calculator.getTotalFare(route));
        
    }
}
