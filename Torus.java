package Taschenlampe;

import static org.lwjgl.opengl.GL11.*;

public class Torus {


	
	float ul = 0;
	float ur =  2*(float)Math.PI;
	float vl = 0;
	float vr =  2*(float)Math.PI;
	
	float r1 = 1f;
	float r2= 0.08f;
	
	int m    = 	20;
	int n    =  20;
	
	float du = (ur - ul)/m; 
	float dv = (vr - vl)/n;
	
	float [] mat_amb = {0.1f,0.1f,0.1f,1.0f};
	float [] mat_dif = {0.1f,0.1f,0.1f,1.0f};
	float [] mat_spec = {0.1f,0.1f,0.1f,1.0f};
	private float shini = (float) 128;
	
	

	public float x(float u, float v) {
		
		return (r1 + r2*(float)Math.cos(u))*(float)Math.cos(v);
	}
	public float y(float u, float v) {
		
		return (r1 + r2*(float)Math.cos(u))*(float)Math.sin(v);
	}
	public float z(float u, float v) 
	{
		return r2*(float)Math.sin(u);
		
	}
	

	public void drawFacette()
	{
		glPushMatrix();
		glTranslatef(0,0,5);
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
		glPopMatrix();
	}
	
	
			
		
	


}
