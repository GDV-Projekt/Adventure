package MatheOperationen;

import org.joml.Vector3f;

public class NormalV {
// Vektorvariablen
	Vector3f ab = new Vector3f();
	Vector3f bc = new Vector3f();
	Vector3f cd = new Vector3f();
	Vector3f da = new Vector3f();
	Vector3f ba = new Vector3f();
	Vector3f cb = new Vector3f();
	Vector3f dc = new Vector3f();
	Vector3f ad = new Vector3f();

	Vector3f kp0 = new Vector3f();
	Vector3f kp1 = new Vector3f();
	Vector3f kp2 = new Vector3f();
	Vector3f kp3 = new Vector3f();
	
// Berechnung der Richtungsvektoren, des Kreuzprodukts und der Norm des Vektors
	public NormalV(Vector3f v0, Vector3f v1, Vector3f v2, Vector3f v3) {
	
// Definition der Vektoren zur Berechnung der Normalen
		ab.x = v0.x-v1.x;
		ab.y = v0.y-v1.y;
		ab.z = v0.z-v1.z;
		
		ba.x = -ab.x;
		ba.y = -ab.y;
		ba.z = -ba.z;

		bc.x = v1.x-v2.x;
		bc.y = v1.y-v2.y;
		bc.z = v1.z-v2.z;
		
		cb.x = -bc.x;
		cb.y = -bc.y;
		cb.z = -cb.z;
		
		cd.x = v2.x-v3.x;
		cd.y = v2.y-v3.y;
		cd.z = v2.z-v3.z;
		
		dc.x = -cd.x;
		dc.y = -cd.y;
		dc.z = -cd.z;
		
		da.x = v3.x-v0.x;
		da.y = v3.y-v0.y;
		da.z = v3.z-v0.z;
		
		ad.x = -da.x;
		ad.y = -da.y;
		ad.z = -da.z;
		
// Berechnung der Kreuzprodukte zur Bestimmung der Normalvektoren
		
		kp0.x = ((ab.y * ad.z) - (ab.z * ad.y));
		kp0.y = ((ab.z * ad.x) - (ab.x * ad.z));
		kp0.z = ((ab.x * ad.y) - (ab.y * ad.x));

		kp1.x = ((ba.y * bc.z) - (ba.z * cb.y));
		kp1.y = ((ba.z * cb.x) - (ba.x * cb.z));
		kp1.z = ((ba.x * cb.y) - (ba.y * cb.x));

		kp2.x = ((cd.y * cb.z) - (cd.z * cb.y));
		kp2.y = ((cd.z * cb.x) - (cd.x * cb.z));
		kp2.z = ((cd.x * cb.y) - (cd.y * cb.x));

		kp3.x = ((da.y * dc.z) - (da.z * dc.y));
		kp3.y = ((da.z * dc.x) - (da.x * dc.z));
		kp3.z = ((da.x * dc.y) - (da.y * dc.x));	
		
// Berechnung der Länge der Normalvektoren
		
		float kp0n = (float)(1/(Math.sqrt((double)(kp0.x*kp0.x + kp0.y*kp0.y + kp0.z*kp0.z))));
		float kp1n = (float)(1/(Math.sqrt((double)(kp1.x*kp1.x + kp1.y*kp1.y + kp1.z*kp1.z))));
		float kp2n = (float)(1/(Math.sqrt((double)(kp2.x*kp2.x + kp2.y*kp2.y + kp2.z*kp2.z))));
		float kp3n = (float)(1/(Math.sqrt((double)(kp3.x*kp3.x + kp3.y*kp3.y + kp3.z*kp3.z))));
		
// Normierung der Normalvektoren
		
		kp0.x = kp0.x*kp0n;
		kp0.y = kp0.y*kp0n;
		kp0.z = kp0.z*kp0n;
		
		kp1.x = kp1.x*kp1n;
		kp1.y = kp1.y*kp1n;
		kp1.z = kp1.z*kp1n;
		
		kp2.x = kp2.x*kp2n;
		kp2.y = kp2.y*kp2n;
		kp2.z = kp2.z*kp2n;
		
		kp3.x = kp3.x*kp3n;
		kp3.y = kp3.y*kp3n;
		kp3.z = kp3.z*kp3n;
	}
	
	public Vector3f getN0 () {
		return kp0;
	}
	public Vector3f getN1 () {
		return kp1;
	}
	public Vector3f getN2 () {
		return kp2;
	}
	public Vector3f getN3 () {
		return kp3;
	}
}
