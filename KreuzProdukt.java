package MatheOperationen;

import org.joml.Vector3f;

public class KreuzProdukt {

	Vector3f kp0 = new Vector3f();
	Vector3f kp1 = new Vector3f();


	public KreuzProdukt(Vector3f a, Vector3f b) {
		kp0.x = (a.y * b.z) - (a.z * b.y);
		kp0.y = (a.z * b.x) - (a.x * b.z);
		kp0.z = (a.x * b.y) - (a.y * b.x);
	}

}
