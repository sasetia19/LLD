package Implementations;

import Enums.Signal;
import Interfaces.IState;
import Interfaces.ITrafficSignal;
import Interfaces.ITrafficSignalSystem;

public class TrafficSignal implements ITrafficSignal {
    Road road;
    Signal currentSignal;
    Integer currentduration;
    IState currentState;
    Thread thread;
    private static ITrafficSignal trafficSignal;

    public TrafficSignal(Road road, Signal currentSignal, Integer currentduration, IState currentState)
    {
        this.road = road;
        this.currentSignal = currentSignal;
        this.currentState = currentState;
        this.currentduration = currentduration;
        thread = new Thread(new TrafficSignalRunnable(trafficSignal));
    }



    public void ChangeSignal(){
        currentSignal = currentState.getNextSignal();
        currentduration = currentState.getNextDuration();
        currentState = currentState.getNextState();


        //can also use Observer pattern here to notify the Roads associated with this signal
        // that signal has been changed so call notifyAll() here
    }

    public Integer getCurrentDuration(){
        return currentduration;
    }
}
