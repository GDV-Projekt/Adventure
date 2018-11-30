package Haus;

import static org.lwjgl.opengl.GL11.*;

import org.joml.Vector3f;

public class Dach {
	
	float ul = -6.3f; 							
	float ur =  6.3f;
	float vl = 0;
	float vr =  1;
	int m    = 	20;
	int n    =  20;
	float du = (ur - ul)/m;
	float dv = (vr - vl)/n;
	
	Vector3f Xdu = new Vector3f();
	Vector3f Xdv = new Vector3f();
	Vector3f kp = new Vector3f();
	
	float [] mat_amb = {0.4f,0.17f,0.1f,0.5f};
	float [] mat_dif = {0.4f,0.17f,0.1f,0.5f};
	float [] mat_spec = {0.4f,0.17f,0.1f,0.5f};
	private float shini = (float) 5;
	
	public void drawDach(){
		glPushMatrix();
			glRotatef(180,0,1,0);
			verschiebeDreieck();
		glPopMatrix();
		glPushMatrix();
			glRotatef(-90,0,1,0);
			verschiebeDreieck();
		glPopMatrix();
		glPushMatrix();
			glRotatef(90,0,1,0);
			verschiebeDreieck();
		glPopMatrix();
		glPushMatrix();
			verschiebeDreieck();
		glPopMatrix();
	}
	public void drawDreieck() {
		
		for(int i=0;i<m;i++) {
			for(int j=0; j<n;j++) {
				Normalvektor(ul + i*du,vl +j*dv);
				glBegin(GL_POLYGON);
				glMaterialfv(GL_FRONT,GL_AMBIENT, mat_amb);
				glMaterialfv(GL_FRONT,GL_DIFFUSE, mat_dif);
				glMaterialfv(GL_FRONT,GL_SPECULAR, mat_spec);
				glMaterialf(GL_FRONT, GL_SHININESS, shini);
					glNormal3f(kp.x,kp.y,kp.z);
					glVertex3f(x(ul + i*du		, vl +j*dv)			,y(ul + i*du		, vl +j*dv)			,z(ul + i*du		,vl + j*dv));
					glVertex3f(x(ul + (i+1)*du	, vl +j*dv)			,y(ul + (i+1)*du	, vl +j*dv)			,z(ul + (i+1)*du	,vl + j*dv));
					glVertex3f(x(ul + (i+1)*du	, vl +(j+1)*dv)		,y(ul + (i+1)*du	, vl +(j+1)*dv)		,z(ul + (i+1)*du	,vl + (j+1)*dv));
					glVertex3f(x(ul + i*du		, vl + (j+1)*dv)	,y(ul + i*du		, vl + (j+1)*dv)	,z(ul + i*du		,vl + (j+1)*dv));
				glEnd();
			}
		}
	}
	public void verschiebeDreieck() {
		glTranslatef(-5f,3.7f,6.3f);
		glRotatef(-39,1,0,0);
		glColor3f(0.61f,0.412f,0.12f);
		drawDreieck();
	}
	public float x(float u, float v) {
		return u+5 -u*v;
	}
	public float y(float u, float v) {
		return 10*v;
	}
	public float z(float u, float v) 
	{
		return 0;
	}
	private void Normalvektor(float u, float v) {
		Xdu.x = (float) -v +1;
		Xdu.y = (float) 0;
		Xdu.z = (float) 0;
		
		Xdv.x = (float) -u;
		Xdv.y = (float) 10;
		Xdv.z = (float) 0;
		
		kp.x = (Xdu.y * Xdv.z) - (Xdu.z * Xdv.y);
		kp.y = (Xdu.z * Xdv.x) - (Xdu.x * Xdv.z);
		kp.z = (Xdu.x * Xdv.y) - (Xdu.y * Xdv.x);
	}
}
