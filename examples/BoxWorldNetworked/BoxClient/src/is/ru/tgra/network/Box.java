package is.ru.tgra.network;

import is.ru.tgra.Point3D;

public class Box {
	public Point3D position;

	public Box(){
		this.position = new Point3D(0,0,0);
	}
	
	public void update(float x, float y, float z){
		this.position.x = x;
		this.position.y = y;
		this.position.z = z;
	}
	
}
