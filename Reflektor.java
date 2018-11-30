package Taschenlampe;

import static org.lwjgl.opengl.GL11.GL_AMBIENT;
import static org.lwjgl.opengl.GL11.GL_DIFFUSE;
import static org.lwjgl.opengl.GL11.GL_FRONT;
import static org.lwjgl.opengl.GL11.GL_SHININESS;
import static org.lwjgl.opengl.GL11.GL_SPECULAR;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glMaterialf;
import static org.lwjgl.opengl.GL11.glMaterialfv;
import static org.lwjgl.opengl.GL11.glNormal3f;
import static org.lwjgl.opengl.GL11.glVertex3f;

public class Reflektor {

	
	float ul = 0;
	float ur =  2*(float)Math.PI;
	float vl = 0;
	float vr =  1;
	
	float r1 = 1;
	float r2= 2;
	
	int m    = 	20;
	int n    =  20;
	
	float du = (ur - ul)/m; 
	float dv = (vr - vl)/n;
	
	float [] mat_amb = {0.25f,0.25f,0.25f,1.0f};
	float [] mat_dif = {0.25f,0.25f,0.25f,1.0f};
	float [] mat_spec = {0.25f,0.25f,0.25f,1.0f};
	private float shini = (float) 128;
	
	

	public float x(float u, float v) {
		
		return (v+1)*(float)Math.cos(u);
	}
	public float y(float u, float v) {
		
		return (v+1)*(float)Math.sin(u);
	}
	public float z(float u, float v) 
	{
		return 5+v;
		
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
