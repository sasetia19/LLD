package Interfaces;

import Enums.Signal;

public interface IState {
    public Signal getNextSignal();
    public IState getNextState();
    public Integer getNextDuration();
}
