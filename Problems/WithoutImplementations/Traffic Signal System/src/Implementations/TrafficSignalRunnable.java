package Implementations;

import Interfaces.ITrafficSignal;

public class TrafficSignalRunnable implements Runnable{

    ITrafficSignal trafficSignal;

    public TrafficSignalRunnable(ITrafficSignal trafficSignal){
        this.trafficSignal = trafficSignal;
    }
    @Override
    public void run() {
        Integer duration = trafficSignal.getCurrentDuration();
        try {
            Thread.sleep(duration*1000);
            trafficSignal.ChangeSignal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
