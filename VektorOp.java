package Objekte;

import org.joml.Vector3f;

public class VektorOp {


	
	
	 public Vector3f KreuzP (Vector3f a, Vector3f b) {
		 Vector3f kreuzp = new Vector3f();
		 kreuzp.x = (a.y * b.z) - (a.z*b.y);
		 kreuzp.y = (a.z*b.x)-(a.x*b.z);
		 kreuzp.z = (a.x*b.y) - (a.y*b.x);
		 
		 return kreuzp;
	 }
	public double Norm (Vector3f n) {
		return Math.sqrt(n.x*n.x + n.y*n.y + n.z*n.z);
	}
}
