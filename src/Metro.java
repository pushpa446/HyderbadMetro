import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Metro {
    public static void main(String[] args) {
        RouteMap routeMap = new RouteMap();
        try {
            String currentLine;
            FileReader fileReader = new FileReader(new File("").getAbsolutePath() + "/resources/stations.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] stationDetails = currentLine.split(",");
                routeMap.addStation(new Station(stationDetails[0], stationDetails[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Check the path");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        routeMap.display("A");
        routeMap.display("B");
        routeMap.display("C");
        routeMap.display("X");
    }
}
