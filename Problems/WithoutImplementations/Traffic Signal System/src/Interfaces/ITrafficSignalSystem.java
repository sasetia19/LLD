package Interfaces;

import Implementations.Road;

public interface ITrafficSignalSystem {
    public void changeSignal(Road road, Integer duration);
}
