import java.util.HashSet;
import java.util.Set;

public class Station {
    private String stationCode;
    private String stationName;
    private Set<Station> neighbourStations = new HashSet<>();
    
    public Station(String stationCode, String stationName) {
        this.stationCode = stationCode;
        this.stationName = stationName;
    }
    
    public String getStationCode() {
        return stationCode;
    }
    
    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }
    
    public String getStationName() {
        return stationName;
    }
    
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
    
    public Set<Station> getNeighbourStations() {
        return neighbourStations;
    }
    
    public void setNeighbourStations(Set<Station> neighbourStations) {
        this.neighbourStations = neighbourStations;
    }
    
    public void addNeighbourStation(Station station) {
        this.neighbourStations.add(station);
    }
    
    @Override
    public boolean equals(Object otherStation) {
        if (this == otherStation) return true;
        if (!(otherStation instanceof Station)) return false;
        
        Station station = (Station) otherStation;
    
        return getStationCode().equals(station.getStationCode());
    
    }
}