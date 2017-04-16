import java.util.List;

class FareCalculator {
    private static final float LINE_ONE_COST = 2.50f;
    private static final float LINE_TWO_COST = 2.0f;
    private static final float LINE_THREE_COST = 3.0f;
    
    FareCalculator() {
    }
    
    float getTotalFare(List<String> route) {
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
        if (stationCode.contains("A")) {
            return LINE_ONE_COST;
        } else if (stationCode.contains("B")) {
            return LINE_TWO_COST;
        } else if (stationCode.contains("C")) {
            return LINE_THREE_COST;
        }
        return 0.0f;
    }
    
}
