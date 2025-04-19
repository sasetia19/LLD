package Implementations;

import Enums.Signal;
import Interfaces.IState;


public class RedState implements IState {
    IState nextState;

    public RedState(){
        nextState = new YellowState();
    }

    @Override
    public Signal getNextSignal() {
        return Signal.Yellow;
    }

    @Override
    public IState getNextState() {
        return nextState;
    }
}
