package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class StateMachine {
	private Machine m;
	private List<State> states = new ArrayList<>();
	private State initialState;
	private Map<String, Integer> integers = new HashMap<>();
	
	private State newState;
	private Transition newTransition;
	

	public Machine build() {
		// TODO Auto-generated method stub
		m = new Machine();
		m.createStates(states);
		m.setInitialState(initialState);
		m.setIntegers(integers);
		return m;
	}

	public StateMachine state(String string) {
		// TODO Auto-generated method stub
		newState = new State();
		newState.setName(string);
		states.add(newState);
		return this;
	}

	public StateMachine initial() {
		// TODO Auto-generated method stub
		initialState = states.get(states.size()-1);
		return this;
	}

	public StateMachine when(String string) {
		// TODO Auto-generated method stub
		//State state = states.get(states.size()-1);
		newTransition = new Transition();
		newTransition.addEvent(newState);
		newTransition.setTransitionsName(string);
		newState.addTransition(newTransition);
		return this;
	}

	public StateMachine to(String string) {
		// TODO Auto-generated method stub
		//State state = states.get(states.size()-1);
		//List<Transition> transitions = newState.getTransitions();
		//Transition transition = transitions.get(transitions.size()-1);
		newTransition.addTaget(string);
		return this;
	}

	public StateMachine integer(String string) {
		// TODO Auto-generated method stub
		integers.put(string, 0);
		return this;
	}

	public StateMachine set(String string, int i) {
		// TODO Auto-generated method stub
		//State state = states.get(states.size()-1);
		//List<Transition> transitions = state.getTransitions();
		//Transition transition = transitions.get(transitions.size()-1);
		newTransition.addSet(string, i);
		return this;
	}

	public StateMachine increment(String string) {
		// TODO Auto-generated method stub
		//State state = states.get(states.size()-1);
		//List<Transition> transitions = state.getTransitions();
		//Transition transition = transitions.get(transitions.size()-1);
		newTransition.addIncrement(string);
		return this;
	}

	public StateMachine decrement(String string) {
		// TODO Auto-generated method stub
		//State state = states.get(states.size()-1);
		//Transition transition = transitions.get(transitions.size()-1);
		//List<Transition> transitions = state.getTransitions();
		newTransition.addDecrement(string);
		return this;
	}

	public StateMachine ifEquals(String string, int i) {
		// TODO Auto-generated method stub
		//State state = states.get(states.size()-1);
		//List<Transition> transitions = state.getTransitions();
		//Transition transition = transitions.get(transitions.size()-1);
		newTransition.addConEqual(string, i);
		return this;
	}

	public StateMachine ifGreaterThan(String string, int i) {
		// TODO Auto-generated method stub
		//State state = states.get(states.size()-1);
		//List<Transition> transitions = state.getTransitions();
		//Transition transition = transitions.get(transitions.size()-1);
		newTransition.addConMore(string, i);
		return this;
	}

	public StateMachine ifLessThan(String string, int i) {
		// TODO Auto-generated method stub
		//State state = states.get(states.size()-1);
		//List<Transition> transitions = state.getTransitions();
		//Transition transition = transitions.get(transitions.size()-1);
		newTransition.addConLess(string, i);
		return this;
	}

}
