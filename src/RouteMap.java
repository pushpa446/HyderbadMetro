import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RouteMap {
    LinkedList<Station> stations = new LinkedList<>();
    List<List<String>> paths = new ArrayList<>();
    
    public RouteMap() {
    }
    
    public void addStation(Station station){
        stations.add(station);
    }
    
    public void display(){
        this.stations.stream().forEach(station -> {
            System.out.println(station.getStationCode()+"\t"+station.getStationName());
        });
    }
    
    public Station getStationByCode(String stationCode){
        for (Station station :
               stations ) {
            if(station.getStationCode().equals(stationCode)){
                return station;
            }
        }
        return null;
    }
    
    public List<String> getPath(String source, String destination) {
      getAllPaths(getStationByCode(source), getStationByCode(destination),new HashMap<>(),new ArrayList<>());
        List<String> shortestPath = paths.get(0);
        for (List<String> path:
             paths) {
            if(path.size() < shortestPath.size()){
                shortestPath = path;
            }
        }
        paths.clear();
        return shortestPath;
    }
    
    private void getAllPaths(Station source, Station destination, Map<String, Boolean> visitedStations, List<String> path) {
        visitedStations.put(source.getStationCode(), true);
        path.add(source.getStationCode());
        if(source.equals(destination)){
            List<String> route = new ArrayList<>();
            route.addAll(path);
            paths.add(route);
        }
        else {
            Set<Station> neighbourStations = source.getNeighbourStations();
            for (Station station :
                    neighbourStations) {
                if (visitedStations.get(station.getStationCode()) == null) {
                    getAllPaths(station,destination,visitedStations,path);
                }
            }
        }
        path.remove(path.size()-1);
        visitedStations.remove(source.getStationCode());
    }
}
