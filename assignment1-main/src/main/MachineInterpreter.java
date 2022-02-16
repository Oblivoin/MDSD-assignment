package main;

import java.util.List;
import java.util.Map;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class MachineInterpreter {
	private Machine machine;
	private State currentState;

	public void run(Machine m) {
		// TODO Auto-generated method stub
		this.machine = m;
		currentState = m.getInitialState();
	}

	public State getCurrentState() {
		// TODO Auto-generated method stub
		return currentState;
	}

	public void processEvent(String string) {
		// TODO Auto-generated method stub
		List<Transition> list = currentState.getTransitions();
		for(Transition t: list) {
			if(t.getEvent().equals(string)) {
				if(t.shouldHandle()) {
					currentState = t.getTarget();
					t.effect();
					return;
				}
				
			}
		}
	}

	public int getInteger(String string) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> map = machine.getMap();
		int i = map.get(string);
		return i;
	}

}
