package Stein;

import static org.lwjgl.opengl.GL11.*;

import org.joml.Vector3f;

public class Stein {
	float facettenhoehe;
	float facettenbreite;
	float du;
	float dv;
	
	int zufallsfarbe;
	
	public Stein(float facettenhoehe, float facettenbreite, int zufallsfarbe) {
		this.facettenhoehe = facettenhoehe;
		this.facettenbreite = facettenbreite;
		this.du = (ur - ul)/facettenhoehe;
		this.dv = (vr - vl)/facettenbreite;
		this.zufallsfarbe = zufallsfarbe;
	}
	
	float ul = 0;
	float ur =  (float)Math.PI;
	float vl = 0;
	float vr = 2*(float)Math.PI;
	
	float radius1;
	float radius2;
	float radius3;
	
	boolean zufallszahlSTOP=false;
	
	Vector3f Xdu = new Vector3f();
	Vector3f Xdv = new Vector3f();
	Vector3f kp = new Vector3f();
	
	float [] mat_amb1 = {0.23f,0.23f,0.23f,0.53f};
	float [] mat_dif1 = {0.23f,0.23f,0.23f,0.53f};
	float [] mat_spec1 = {0.23f,0.23f,0.23f,0.53f};
	
	float [] mat_amb2 = {0.25f,0.25f,0.25f,0.53f};
	float [] mat_dif2 = {0.25f,0.25f,0.25f,0.53f};
	float [] mat_spec2 = {0.25f,0.25f,0.25f,0.53f};
	
	float [] mat_amb3 = {0.28f,0.28f,0.28f,0.53f};
	float [] mat_dif3 = {0.28f,0.28f,0.28f,0.53f};
	float [] mat_spec3 = {0.28f,0.28f,0.28f,0.53f};
	
	private float shini = (float) 5;
	
	
	float skalierung = 0.3f;
	

	public void drawStein(){
		
			berechneZufallsradien();
			drawFacette();
		
		
	}
	
	
	private void berechneZufallsradien() {
		if(zufallszahlSTOP == false) {
			
		radius1 = (float)(Math.random()*6 +0.2f);
		radius2 = (float)(Math.random()*6 +0.2f);
		radius3 = (float)(Math.random()*6 +0.2f);
		}
		zufallszahlSTOP =true;
		
		
	}


	public float x(float u, float v) {
		return skalierung*radius1*(float)Math.sin(u)*(float)Math.cos(v);
	}
	public float y(float u, float v) {
		return skalierung*radius2*(float)Math.sin(u)*(float)Math.sin(v);
	}
	public float z(float u, float v) 
	{
		return skalierung*radius3*(float)Math.cos(u);
	}
	
	public void drawFacette()
	{
		
		
		for(int i=0;i<facettenhoehe;i++) {
			for(int j=0; j<facettenbreite;j++) {
				Normalvektor(ul + i*du,vl +j*dv);
				glBegin(GL_POLYGON);
				if(zufallsfarbe ==0) {
					glMaterialfv(GL_FRONT,GL_AMBIENT, mat_amb1);
				glMaterialfv(GL_FRONT,GL_DIFFUSE, mat_dif1);
				glMaterialfv(GL_FRONT,GL_SPECULAR, mat_spec1);
				glMaterialf(GL_FRONT, GL_SHININESS, shini);
				}
				if(zufallsfarbe ==1) {
					glMaterialfv(GL_FRONT,GL_AMBIENT, mat_amb2);
				glMaterialfv(GL_FRONT,GL_DIFFUSE, mat_dif2);
				glMaterialfv(GL_FRONT,GL_SPECULAR, mat_spec2);
				glMaterialf(GL_FRONT, GL_SHININESS, shini);
				}
				if(zufallsfarbe ==2) {
					glMaterialfv(GL_FRONT,GL_AMBIENT, mat_amb3);
				glMaterialfv(GL_FRONT,GL_DIFFUSE, mat_dif3);
				glMaterialfv(GL_FRONT,GL_SPECULAR, mat_spec3);
				glMaterialf(GL_FRONT, GL_SHININESS, shini);
				}
				
				
				glNormal3f(-kp.x,-kp.y,kp.z);
					glVertex3f(x(ul + i*du		, vl +j*dv)			,y(ul + i*du		, vl +j*dv)			,z(ul + i*du		,vl + j*dv));
					glVertex3f(x(ul + (i+1)*du	, vl +j*dv)			,y(ul + (i+1)*du	, vl +j*dv)			,z(ul + (i+1)*du	,vl + j*dv));
					glVertex3f(x(ul + (i+1)*du	, vl +(j+1)*dv)		,y(ul + (i+1)*du	, vl +(j+1)*dv)		,z(ul + (i+1)*du	,vl + (j+1)*dv));
					glVertex3f(x(ul + i*du		, vl + (j+1)*dv)	,y(ul + i*du		, vl + (j+1)*dv)	,z(ul + i*du		,vl + (j+1)*dv));
				glEnd();
			}
		}
	}
	private void Normalvektor(float u, float v) {
		Xdu.x = (float) 1;
		Xdu.y = (float) -2*0.043f*u;
		Xdu.z = (float) 0;
		
		Xdv.x = (float) 0;
		Xdv.y = (float) 0;
		Xdv.z = (float) 5.5f;
		
		kp.x = (Xdu.y * Xdv.z) - (Xdu.z * Xdv.y);
		kp.y = (Xdu.z * Xdv.x) - (Xdu.x * Xdv.z);
		kp.z = (Xdu.x * Xdv.y) - (Xdu.y * Xdv.x);
	}
	

}
