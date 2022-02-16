package main.metamodel;

import java.util.Map;

public class Transition {
	private State originalState;
	private String taget;
	private String transition;
	private String variableName;
	private int setTaget;
	private boolean setOperater =  false;
	private boolean incOperater =  false;
	private boolean decOperater =  false;
	
	private String conName;
	private int conTaget;
	private boolean isEqual = false;
	private boolean isLess = false;
	private boolean isMore = false;
	
	public Object getEvent() {
		// TODO Auto-generated method stub
		return transition;
	}
	
	public void setTransitionsName(String name) {
		this.transition = name;
	}
	
	public void addEvent(State event) {
		this.originalState = event;
	}

	public State getTarget() {
		// TODO Auto-generated method stub
		Machine m = originalState.getMachine();
		
		return m.getState(taget);
	}
	public void addTaget(String taget) {
		this.taget = taget;
	}

	public boolean hasSetOperation() {
		// TODO Auto-generated method stub
		return setOperater;
	}

	public boolean hasIncrementOperation() {
		// TODO Auto-generated method stub
		return incOperater;
	}

	public boolean hasDecrementOperation() {
		// TODO Auto-generated method stub
		return decOperater;
	}

	public Object getOperationVariableName() {
		// TODO Auto-generated method stub
		return variableName;
	}

	public boolean isConditional() {
		// TODO Auto-generated method stub
		return isEqual||isLess||isMore;
	}

	public Object getConditionVariableName() {
		// TODO Auto-generated method stub
		return conName;
	}

	public Integer getConditionComparedValue() {
		// TODO Auto-generated method stub
		return conTaget;
	}

	public boolean isConditionEqual() {
		// TODO Auto-generated method stub
		return isEqual;
	}

	public boolean isConditionGreaterThan() {
		// TODO Auto-generated method stub
		return isMore;
	}

	public boolean isConditionLessThan() {
		// TODO Auto-generated method stub
		return isLess;
	}

	public boolean hasOperation() {
		// TODO Auto-generated method stub
		return setOperater||decOperater||incOperater;
	}
	
	public void addIncrement(String string) {
		incOperater = true;
		variableName = string;
	}
	
	public void addDecrement(String string) {
		decOperater = true;
		variableName = string;
	}
	
	public void addSet(String string, int taget) {
		setOperater = true;
		variableName = string;
		setTaget = taget;
	}
	
	public void addConMore(String string, int taget) {
		isMore = true;
		conName = string;
		conTaget = taget;
	}
	
	public void addConLess(String string, int taget) {
		isLess = true;
		conName = string;
		conTaget = taget;
	}
	
	public void addConEqual(String string, int taget) {
		isEqual = true;
		conName = string;
		conTaget = taget;
	}

	public void effect() {
		if (!shouldHandle()) {
			return;
		}
		run();
		
	}
	
	public boolean shouldHandle() {
		if (isEqual||isMore||isLess) {
			if (isEqual) {
				System.out.print("h1");
				Map<String, Integer> map = originalState.getMachine().getMap();
				System.out.print(map.get(conName) == conTaget);
				return map.get(conName) == conTaget;
			} else if (isMore) {
				System.out.print("h2");
				Map<String, Integer> map = originalState.getMachine().getMap();
				System.out.print(map.get(conName) > conTaget);
				return map.get(conName) > conTaget;
			} else if (isLess) {
				System.out.print("h3");
				Map<String, Integer> map = originalState.getMachine().getMap();
				System.out.print(map.get(conName) < conTaget);
				return map.get(conName) < conTaget;
			} else {
				System.out.println("should run");
				return true;
			}
			
		} 
		return true;
		
	}
	private void run() {
		if (setOperater) {
			Map<String, Integer> map = originalState.getMachine().getMap();
			map.put(variableName, setTaget);
		} else if(incOperater) {
			Map<String, Integer> map = originalState.getMachine().getMap();
			int val = map.get(variableName);
			val++;
			map.put(variableName, val);
		} else if(decOperater) {
			Map<String, Integer> map = originalState.getMachine().getMap();
			int val = map.get(variableName);
			val--;
			map.put(variableName, val);
		}
	}
}
