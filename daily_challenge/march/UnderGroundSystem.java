class UndergroundSystem {
    HashMap<Integer, CheckInNode> checkInMap;
    HashMap<String, AverageNode> averageMap;
    public UndergroundSystem() {
        checkInMap = new HashMap<Integer, CheckInNode>();
        averageMap = new HashMap<String, AverageNode>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInNode(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInNode checkIn = checkInMap.get(id);
        String key = checkIn.name+"_"+stationName;
        int diff = t - checkIn.startTime;
        if(averageMap.containsKey(key)){
            AverageNode avgNode = averageMap.get(key);
            double newVal = ((avgNode.average * avgNode.n)+diff)/(avgNode.n+1);
            averageMap.put(key, new AverageNode(newVal,(avgNode.n+1)) );
        }
        else{
            averageMap.put(key,new AverageNode( diff,1));
        }
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return averageMap.get(startStation+"_"+endStation).average;
    }
}

class CheckInNode{
    String name;
    int startTime;
    CheckInNode(String name, int startTime){
        this.name = name;
        this.startTime = startTime;
    }
}

class AverageNode{
    double average;
    int n;
    AverageNode(double average, int n){
        this.average = average;
        this.n = n;
    }
}


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
