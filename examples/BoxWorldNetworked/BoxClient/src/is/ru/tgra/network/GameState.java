package is.ru.tgra.network;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GameState {
	
	private static GameState instance;
	private HashMap<String, Box> boxes;
	public String clientNickName;
	
	public static GameState instance(){
		if(instance == null)
			instance = new GameState();
		return instance;
	}
	
	private GameState() {
		this.boxes = new HashMap<String, Box>();
	}
	
	public synchronized void removeBox(String name){
		this.boxes.remove(name);
	}
	
	public synchronized void addBox(String name) {
		this.boxes.put(name, new Box());
	}

	public void updateBox(String name, float x, float y, float z) {
		if(this.boxes.containsKey(name))
			this.boxes.get(name).update(x, y, z);
	}
	
	public synchronized List<Box> getBoxes(){
		LinkedList<Box> boxes = new LinkedList<>();
		for(Box b : this.boxes.values())
			boxes.add(b);
		return boxes;
	}
}
