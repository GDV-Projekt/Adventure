package MatheOperationen;

import org.joml.Vector3f;

public class Camera {

	private Vector3f Blickrichtung = new Vector3f(1000,2,1000);
	private Vector3f Position = new Vector3f(1,4f,1);
	Vector3f up = new Vector3f(0,1,0);


	
	public Camera(Vector3f pos, Vector3f blick, Vector3f up) {
		pos = Position;
		blick = Blickrichtung;
		up = this.up;
	}
	public Camera() {
		Position = getPos();
		Blickrichtung = getBlick();
	}
	public void setBlick(float x, float y, float z) {
		Blickrichtung.x = x;
		Blickrichtung.y = y;
		Blickrichtung.z = z;
	}
	public Vector3f getBlick() {
		return Blickrichtung;
	}
	public void setPos(float x, float y, float z) {
		Position.x = x;
		Position.y = y;
		Position.z = z;
	}
	public Vector3f getPos() {
		return Position;
	}
	public Vector3f getUp() {
		return up;
	}

}
