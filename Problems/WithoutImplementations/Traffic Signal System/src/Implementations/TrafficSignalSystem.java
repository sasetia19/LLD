package Implementations;

import Interfaces.ITrafficSignalSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TrafficSignalSystem implements ITrafficSignalSystem{
    Map<Road,TrafficSignal> roadsSignals;
    private static ITrafficSignalSystem trafficSignalSystem;

    private TrafficSignalSystem(){
        roadsSignals = new ConcurrentHashMap<Road,TrafficSignal>();
    }

    public synchronized static ITrafficSignalSystem getInstance(){
        if(trafficSignalSystem == null){
            trafficSignalSystem = new TrafficSignalSystem();
        }
        return trafficSignalSystem;
    }
    public void changeSignal(Road road, Integer duration){
        TrafficSignal trafficSignal = roadsSignals.get(road);
        trafficSignal.ChangeSignal();

    }

}
