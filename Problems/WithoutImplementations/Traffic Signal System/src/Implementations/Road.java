package Implementations;

import Interfaces.IRoad;

public class Road implements IRoad {
    String name;
    Integer id;
    TrafficSignal trafficSignal;

    public Road(String name, Integer id, TrafficSignal trafficSignal){
        this.id = id;
        this.name = name;
        this.trafficSignal = trafficSignal;
    }
}
