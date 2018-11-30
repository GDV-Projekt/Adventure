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
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex3f;

public class Boden {



	// 0.5f*(float)Math.PI
		
		float ul = 0;
		float ur =  (float)Math.PI;
		float vl = 0;
		float vr =  2*(float)Math.PI;
		float schwarz = 0.1f;
		float r=1.0f;
		
		int m    = 	20;
		int n    =  20;
		
		float du = (ur - ul)/m; 
		float dv = (vr - vl)/n;
		
		float [] mat_amb = {schwarz,schwarz,schwarz,1.0f};
		float [] mat_dif = {schwarz,schwarz,schwarz,1.0f};
		float [] mat_spec = {schwarz,schwarz,schwarz,1.0f};
		
		private float shini = (float) 128;
		
		

		public float x(float u, float v) {
			
			return r*(float)Math.cos(v)*(float)Math.sin(u);
		}
		public float y(float u, float v) {
			
			return r*(float)Math.sin(u)*(float)Math.sin(v);
		}
		public float z(float u, float v) 
		{
			return 0.1f*r*(float)Math.cos(u);
			
		}
		

		public void drawFacette()
		{
			glPushMatrix();
			glTranslatef(0,0,0f);
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
