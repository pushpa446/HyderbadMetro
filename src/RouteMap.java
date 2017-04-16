import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.corba.se.impl.orbutil.graph.GraphImpl;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import sun.security.provider.certpath.Vertex;

public class RouteMap {
    LinkedList<Station> line1 = new LinkedList<>();
    LinkedList<Station> line2 = new LinkedList<>();
    LinkedList<Station> line3 = new LinkedList<>();
    LinkedList<Station> crossStations = new LinkedList<>();
    Graph some = new GraphImpl();
    
    public void addStation(Station station) {
        if (station != null) {
            LinkedList<Station> line = getLineByName(station.getLine());
            if (line != null) {
                addToLine(line, station);
            }
        }
    }
    
    public Station getStationByLine(String lineName) {
        LinkedList<Station> line = getLineByName(lineName);
        Station station = (line != null && line.size() != 0) ? line.getFirst() : null;
        while (station != null) {
            if (station.getLine().equals(lineName)) {
                return station;
            }
            station = station.getNextStation();
        }
        return null;
    }
    
    private LinkedList<Station> getLineByName(String lineName) {
        if (lineName.startsWith("A")) {
            return line1;
        } else if (lineName.startsWith("B")) {
            return line2;
        } else if (lineName.startsWith("C")) {
            return line3;
        } else if (lineName.startsWith("X")) {
            return crossStations;
        }
        return null;
    }
    
    private void addToLine(LinkedList<Station> line, Station station) {
        Station existingStation = getStationByLine(station.getLine());
        if(line.size() == 0){
            line.addFirst(station);
        }
        else {
            Station lastStation = line.getLast();
            if (lastStation != null) {
                lastStation.setNextStation(station);
                station.setPreviousStation(lastStation);
            }
            line.addLast(station);
        }
    }
    
    public void display(String lineName){
        for (Station station :
                getLineByName(lineName)) {
            System.out.println(station.getLine() + "\t" + station.getStationName());
        }
    }
    
}
