package Objekte;

import static org.lwjgl.opengl.GL11.*;

public class Grundebene {

	
	float ul = 0;
	float ur =  2*(float)Math.PI;
	float vl = 0;
	float vr =  1;
	
	float r1 = 70;
	float r2= 19.5f;
	
	int m    = 	40;
	int n    =  40;
	
	float du = (ur - ul)/m; 
	float dv = (vr - vl)/n;
	
	float [] mat_amb = {0.25f,0.55f,0.25f,1.0f};
	float [] mat_dif = {0.40f,0.50f,0.40f,1.0f};
	float [] mat_spec = {0.77f,0.57f,0.77f,1.0f};
	private float shini = (float) 128;
	
	

	public float x(float u, float v) {
		
		return (float)Math.cos(u)*(r1 + v*(r2-r1));
	}
	public float y(float u, float v) {
		
		return 0;
	}
	public float z(float u, float v) 
	{
		return (float)Math.sin(u)*(r1 + v*(r2-r1));
		
	}
	

	public void drawFacette()
	{
		
		
		
		for(int i=0;i<m;i++) {
			for(int j=0; j<n;j++) {
				
				glBegin(GL_TRIANGLE_FAN);
				glMaterialfv(GL_FRONT,GL_AMBIENT, mat_amb);
				glMaterialfv(GL_FRONT,GL_DIFFUSE, mat_dif);
				glMaterialfv(GL_FRONT,GL_SPECULAR, mat_spec);
				glMaterialf(GL_FRONT, GL_SHININESS, shini);
				
				glNormal3f(0.0f,1.0f,0.0f);
					glVertex3f(x(ul + i*du		, vl +j*dv)			,y(ul + i*du		, vl +j*dv)			,z(ul + i*du		,vl + j*dv));
					glVertex3f(x(ul + (i+1)*du	, vl +j*dv)			,y(ul + (i+1)*du	, vl +j*dv)			,z(ul + (i+1)*du	,vl + j*dv));
					glVertex3f(x(ul + (i+1)*du	, vl +(j+1)*dv)		,y(ul + (i+1)*du	, vl +(j+1)*dv)		,z(ul + (i+1)*du	,vl + (j+1)*dv));
					glVertex3f(x(ul + i*du		, vl + (j+1)*dv)	,y(ul + i*du		, vl + (j+1)*dv)	,z(ul + i*du		,vl + (j+1)*dv));
					
				glEnd();
			}
		}
	}
	
	
			
		
	
}
