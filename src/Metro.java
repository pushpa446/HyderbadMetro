import com.metro.admin.Admin;
import com.metro.admin.RouteMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Metro {
    
    public static void main(String[] args) throws IOException {
        Admin admin = new Admin();
        RouteMap routeMap = admin.getRouteMap();
        FareCalculator calculator = new FareCalculator();
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Source Station Code:");
        String source = bufferedReader.readLine();
        System.out.println("Enter Destination Station Code:");
        String destination = bufferedReader.readLine();
        
        List<String> route = routeMap.getPath(source, destination);
        System.out.println("Source : " + routeMap.getStationNameByCode(source));
        System.out.println("Destination : " + routeMap.getStationNameByCode(destination));
        System.out.println("Distance (stations) : " + (route.size() - 1));
        System.out.println("Cost : " + calculator.getTotalFare(route));
    }
}
