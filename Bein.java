package Gegnerfigur;

import static org.lwjgl.opengl.GL11.*;

import org.joml.Vector3f;

public class Bein {
	
	float ul = 0;
	float ur =  2*(float)Math.PI;
	float vl = 0;
	float vr = 1;
	
	int m    = 	8;
	int n    =  8;
	
	float du = (ur - ul)/m;
	float dv = (vr - vl)/n;
	

	Vector3f Xdu = new Vector3f();
	Vector3f Xdv = new Vector3f();
	Vector3f kp = new Vector3f();
	
	float [] mat_amb = {0.25f,0.25f,0.25f,1.0f};
	float [] mat_dif = {0.40f,0.40f,0.40f,1.0f};
	float [] mat_spec = {0.77f,0.77f,0.77f,1.0f};
	private float shini = (float) 20;
	
	public void drawBein(){
		drawFacette();
		
	}
	
	public float x(float u, float v) {
		return 0.7f*(float)Math.cos(u);
	}
	public float y(float u, float v) {
		return 8*v;
	}
	public float z(float u, float v) 
	{
		return 0.7f*(float)Math.sin(u);
	}
	
	public void drawFacette()
	{
		for(int i=0;i<m;i++) {
			for(int j=0; j<n;j++) {
				Normalvektor(ul + i*du	,vl +j*dv);
				glBegin(GL_POLYGON);
				glMaterialfv(GL_FRONT,GL_AMBIENT, mat_amb);
				glMaterialfv(GL_FRONT,GL_DIFFUSE, mat_dif);
				glMaterialfv(GL_FRONT,GL_SPECULAR, mat_spec);
				glMaterialf(GL_FRONT, GL_SHININESS, shini);
				glNormal3f(-kp.x,kp.y,-kp.z);
					glVertex3f(x(ul + i*du		, vl +j*dv)			,y(ul + i*du		, vl +j*dv)			,z(ul + i*du		,vl + j*dv));
					glVertex3f(x(ul + (i+1)*du	, vl +j*dv)			,y(ul + (i+1)*du	, vl +j*dv)			,z(ul + (i+1)*du	,vl + j*dv));
					glVertex3f(x(ul + (i+1)*du	, vl +(j+1)*dv)		,y(ul + (i+1)*du	, vl +(j+1)*dv)		,z(ul + (i+1)*du	,vl + (j+1)*dv));
					glVertex3f(x(ul + i*du		, vl + (j+1)*dv)	,y(ul + i*du		, vl + (j+1)*dv)	,z(ul + i*du		,vl + (j+1)*dv));
					
				glEnd();
			}
		}
	}
	private void Normalvektor(float u, float v) {
		Xdu.x = (float) -0.7f*(float)Math.sin(u);
		Xdu.y = (float) 0;
		Xdu.z = (float) 0.7f*(float)Math.cos(u);
		
		Xdv.x = (float) 0;
		Xdv.y = (float) 5;
		Xdv.z = (float) 0;
		
		kp.x = (Xdu.y * Xdv.z) - (Xdu.z * Xdv.y);
		kp.y = (Xdu.z * Xdv.x) - (Xdu.x * Xdv.z);
		kp.z = (Xdu.x * Xdv.y) - (Xdu.y * Xdv.x);
	}

}
