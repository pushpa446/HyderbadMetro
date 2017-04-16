package com.metro.admin;

public class Admin {
    private RouteMap routeMap;
    
    public Admin(){
        routeMap = InputParser.prepareRouteMap("stations.csv");
    }
    
    public RouteMap getRouteMap(){
        return routeMap;
    }
}
