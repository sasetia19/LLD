package Implementations;

import Enums.Signal;
import Interfaces.IState;

public class YellowState implements IState {
    IState nextState;

    public YellowState(){
        nextState = new GreenState();
    }

    @Override
    public Signal getNextSignal() {
        return Signal.Green;
    }

    @Override
    public IState getNextState() {
        return nextState;
    }
}
