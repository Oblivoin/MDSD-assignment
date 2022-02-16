package main.metamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Machine {
	
	private List<State> states = new ArrayList<>();
	private State initialState;
	private Map<String, Integer> integers = new HashMap<>();

	public List<State> getStates() {
		// TODO Auto-generated method stub
		return states;
	}
	
	public void createStates(List<State> states) {
		this.states = states;
		for (State state: this.states) {
			state.setMachine(this);
		}
	}

	public State getInitialState() {
		// TODO Auto-generated method stub
		return initialState;
	}
	
	public void setInitialState(State state) {
		initialState = state;
	}
	
	public State getState(String string) {
		// TODO Auto-generated method stub
		for (State state: states) {
			if (state.getName() == string) {
				return state;
			}
		}
		return null;
	}

	public int numberOfIntegers() {
		// TODO Auto-generated method stub
		return integers.size();
	}

	public boolean hasInteger(String string) {
		// TODO Auto-generated method stub
		return integers.containsKey(string);
	}

	public void setIntegers(Map<String, Integer> integers){
		this.integers = integers;
	}
	
	public Map<String, Integer> getMap() {
		return integers;
	}
}
