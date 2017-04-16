public class Station {
    private String line;
    private String stationName;
    private Station previousStation;
    private Station nextStation;
    
    public Station(String line, String stationName) {
        this.line = line;
        this.stationName = stationName;
    }
    
    public String getLine() {
        return line;
    }
    
    public void setLine(String line) {
        this.line = line;
    }
    
    public String getStationName() {
        return stationName;
    }
    
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
    
    public Station getPreviousStation() {
        return previousStation;
    }
    
    public void setPreviousStation(Station previousStation) {
        this.previousStation = previousStation;
    }
    
    public Station getNextStation() {
        return nextStation;
    }
    
    public void setNextStation(Station nextStation) {
        this.nextStation = nextStation;
    }
}