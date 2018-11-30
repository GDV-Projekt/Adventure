package Taschenlampe;

import static org.lwjgl.opengl.GL11.*;

public class Lampe {


// 0.5f*(float)Math.PI
	
	float ul = -0.5f*(float)Math.PI;
	float ur =  0.5f*(float)Math.PI;
	float vl = -(float)Math.PI;
	float vr =  0;
	
	float r=1.3f;
	
	int m    = 	20;
	int n    =  20;
	
	float du = (ur - ul)/m; 
	float dv = (vr - vl)/n;
	
	float [] mat_amb = {1f,1f,1f,1.0f};
	float [] mat_dif = {1f,1f,1f,1.0f};
	float [] mat_spec = {1f,1f,1f,1.0f};
	
	private float shini = (float) 128;
	
	

	public float x(float u, float v) {
		
		return r*(float)Math.cos(v)*(float)Math.sin(u);
	}
	public float y(float u, float v) {
		
		return r*(float)Math.sin(u)*(float)Math.sin(v);
	}
	public float z(float u, float v) 
	{
		return 0.7f*r*(float)Math.cos(u);
		
	}
	

	public void drawFacette()
	{
		glPushMatrix();
		glTranslatef(0,0,5.33f);
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
