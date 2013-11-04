package is.ru.tgra;

public class Point3D {
	public float x;
	public float y;
	public float z;
	
	public Point3D(float xx, float yy, float zz) {
		x = xx;
		y = yy;
		z = zz;
	}
	
	public void set(float xx, float yy, float zz) {
		x = xx;
		y = yy;
		z = zz;
	}
	
	public void add(Vector3D v) {
		x += v.x;
		y += v.y;
		z += v.z;
	}
	
	public static Point3D lerp(Point3D p1, Point3D p2, float t){
		
		Float ratio = 1 - t;
		return new Point3D(
				(p1.x*ratio) + (p2.x * t),
				(p1.y*ratio) + (p2.y * t),
				(p1.z*ratio) + (p2.z * t)
				);
	}
}
