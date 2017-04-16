import java.util.List;

public class FareCalculator {
    
    public FareCalculator() {
    }
    
    public float getTotalFare(List<String> route) {
        float fare = 0f;
        int totalStations = route.size();
        fare = fare + 10.0f;
        for (int i = 4; i < totalStations; i++) {
            if(route.get(i).contains("X")){
                fare += getExtraCost(route.get(i-1));
            }
            else {
                fare += getExtraCost(route.get(i));
            }
        }
        return fare;
    }
    
    private float getExtraCost(String stationCode) {
        float cost = 0f;
        if (stationCode.contains("A")) {
            cost = 2.50f;
        } else if (stationCode.contains("B")) {
            cost = 2.0f;
        } else if (stationCode.contains("C")) {
            cost =3.0f;
        }
        return cost;
    }
    
}
