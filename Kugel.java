package Objekte;

import static org.lwjgl.opengl.GL11.*;

import org.joml.Vector3f;

import MatheOperationen.NormalV;

public class Kugel {
	int m = 100;
	int n = 100;
	float r  = 50;

	float alpha = 0;
	float beta = 0;
	
	Vector3f Xdu = new Vector3f();
	Vector3f Xdv = new Vector3f();
	Vector3f kp = new Vector3f();
	
	float [] mat_amb = {0.25f,0.25f,0.25f,1.0f};
	float [] mat_dif = {0.40f,0.40f,0.40f,1.0f};
	float [] mat_spec = {0.77f,0.77f,0.77f,1.0f};
	private float shini = (float) 100;
//	float rot = 1, gruen = 1, blau = 1;
	boolean raster = true;
    
	private void drawKugel() {

		float u_l = 0;
		float u_r = (float) ( Math.PI);
		float v_l = (float) (0);
		float v_r = (float) (2*Math.PI);
		float u_i, v_j, u_i_1, v_j_1;
		float deltaX = (u_r - u_l) / m, deltaY = (v_r - v_l) / m;
		for (int i = 0; i < m; i++) {
			u_i = u_l + deltaX * i;
			u_i_1 = u_i + deltaX;
			for (int j = 0; j < n; j++) {
				v_j = v_l + deltaY * j;
				v_j_1 = v_j + deltaY;
				Normalvektor(u_i,v_j);
				glBegin(GL_TRIANGLE_FAN);
				glMaterialfv(GL_FRONT,GL_AMBIENT, mat_amb);
				glMaterialfv(GL_FRONT,GL_DIFFUSE, mat_dif);
				glMaterialfv(GL_FRONT,GL_SPECULAR, mat_spec);
				glMaterialf(GL_FRONT, GL_SHININESS, shini);
					glNormal3f(kp.x,kp.y,kp.z);
					glVertex3f(x(u_i, v_j), y(u_i, v_j), z(u_i, v_j));
					glVertex3f(x(u_i_1, v_j), y(u_i_1, v_j), z(u_i_1, v_j));
					glVertex3f(x(u_i_1, v_j_1), y(u_i_1, v_j_1), z(u_i_1, v_j_1));
					glVertex3f(x(u_i, v_j_1), y(u_i, v_j_1), z(u_i, v_j_1));
				glEnd();
			}
		}

	}
	// Methode zum zeichnen der Kugel
	public void draw() {
		drawKugel();
	}
	//Methoden zur Berechnung der Funktionswerte
	private float x(float u, float v) {
		return (float) (r*Math.sin(u)*Math.cos(v));
	}

	private float y(float u, float v) {
		return (float) (r*Math.sin(u)*Math.sin(v));
	}

	private float z(float u, float v) {
		return(float) (r*Math.cos(u));
	}
	//Methoden zur Berechnung der Ableitung
	private void Normalvektor(float u, float v) {
		Xdu.x = (float) (r*Math.cos(u)*Math.cos(v));
		Xdu.y = (float) (r*Math.cos(u)*Math.sin(v));
		Xdu.z = (float) (-r*Math.sin(u));
		
		Xdv.x = (float) (-r*Math.sin(u)*Math.sin(v));
		Xdv.y = (float) (r*Math.sin(u)*Math.cos(v));
		Xdv.z = (float) 0;
		
		kp.x = (Xdu.y * Xdv.z) - (Xdu.z * Xdv.y);
		kp.y = (Xdu.z * Xdv.x) - (Xdu.x * Xdv.z);
		kp.z = (Xdu.x * Xdv.y) - (Xdu.y * Xdv.x);
	}

	
	
	public void setRaster(boolean x) {
		raster = x;
		if (x) {
			glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
		} else {
			glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
		}

	}
}
