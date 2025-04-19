package Implementations;

import Enums.Signal;
import Interfaces.IState;

public class GreenState implements IState {
    IState nextState;
    Integer nextDurationInSec;

    public GreenState(Integer nextDurationInSec){
        nextState = new RedState();
        this.nextDurationInSec = nextDurationInSec;
    }

    @Override
    public Signal getNextSignal() {
        return Signal.Red;
    }

    @Override
    public IState getNextState() {
        return nextState;
    }

    @Override
    public Integer getNextDuration() {
        return nextDurationInSec;
    }
}
