package main.metamodel;

import java.util.ArrayList;
import java.util.List;

public class State {
	
	private String name;
	private List<Transition> Transitions = new ArrayList<>();
	private Machine machine;

	public State() {
		
	}
	
	public State(String name) {
		this.name = name;
	}
	
	public Object getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Transition> getTransitions() {
		// TODO Auto-generated method stub
		return Transitions;
	}

	public Transition getTransitionByEvent(String string) {
		// TODO Auto-generated method stub
		for (Transition transition: Transitions) {
			if (transition.getEvent().equals(string)) {
				return transition;
			}
		}
		return null;
	}
	
	public void addTransition(Transition transition) {
		Transitions.add(transition);
	}
	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	public Machine getMachine() {
		return machine;
	}
}
