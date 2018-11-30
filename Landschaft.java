package Environment;

import static org.lwjgl.opengl.GL11.*;


public class Landschaft {
//	
//	// Darstellungsvariablen
////	float rot = 1, blau = 1, gruen = 1;
//	boolean raster = true;
//	float länge = 2f;
//	float breite = 2f;
//	float höhe = 20f;
//	float x;
//	float z;
//	
//	//Materialeigenschaften
//	
//	float [] mat_amb = {0.2f,0.17f,0.2f,0.5f};
//	float [] mat_dif = {0.8f,0.61f,0.8f,0.5f};
//	float [] mat_spec = {0.63f,0.73f,0.63f,0.5f};
//	
//	// Methoden zum Aufrufen der Funktionswerte
//	private float x (float x, float z) {
//		return x;
//	}
//	private float z(float x, float z) {
//		return z;
//	}
//	private float y(float x, float z) {
//		float y =(float) (-2/5*Math.pow(x, 2)+ 5/2*Math.cos(x) + 4*Math.log(x+1)+Math.pow(z, 3)+ 1/10 * Math.pow(z, 3*x) + 5*Math.cos(z));
////	    float y = (float)(-2/5*Math.pow(x, 2)+4*Math.log(x+1)+Math.pow(z, 3)+1/10*Math.pow(z, 3*x)+5*Math.cos(z)+5/2*Math.cos(x));
//		return y;
//	}
//	private void drawLandschaft() {
//	
//		//Zuweisung der Materialeigenschaften
//		
//		glMaterialfv(GL_FRONT,GL_AMBIENT, mat_amb);
//		glMaterialfv(GL_FRONT,GL_DIFFUSE, mat_dif);
//		glMaterialfv(GL_FRONT,GL_SPECULAR, mat_spec);
//		
//		// Variablen zum zeichnen der Funktion
//		int m = 10;
//		int n = 10;
//		float u_l = -2;
//		float u_r = 2;
//		float v_l = -2;
//		float v_r = 2;
//		
//		float u_i,v_j,u_i_1,v_j_1;
//		float delta_u = (u_r - u_l)/m;
//		float delta_v = (v_r - v_l)/n;
//	
//		//Zeichnen der Landschaft
//		for (int i = 0 ; i<m ; i++) {
//			u_i = u_l + delta_u * i;
//			u_i_1 = u_i + delta_u;
//			
//			for(int j = 0; j<n; j++) {
//				v_j = v_l + delta_v *j;
//				v_j_1 = v_j + delta_v;
//				
//				glBegin(GL_TRIANGLE_FAN);
//					glNormal3f(0.0f,1.0f,0.0f);
//					glVertex3f(x(u_i,v_j),y(u_i,v_j),z(u_i,v_j));
//					glVertex3f(x(u_i_1,v_j),y(u_i_1,v_j),z(u_i_1,v_j));
//					glVertex3f(x(u_i_1,v_j_1),y(u_i_1,v_j_1),z(u_i_1,v_j_1));
//					glVertex3f(x(u_i,v_j_1),y(u_i,v_j_1),z(u_i,v_j_1));
//				glEnd();
//			}
//		}	
//	}
//	
//	public void draw() {
//		drawLandschaft();
//	}
//
////	// Setzen der Objektfarbe
////	public void setColor(float r, float g, float b) 
////	{
////		rot = r;
////		gruen = g;
////		blau = b;
////	}
//	public void setRaster(boolean x) {
//	    raster = x;
//	    if(x) {
//	    	glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
//	    }
//	    else {
//	    	glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
//	    }       
//	}
	

	float ul = 0;
	float ur =  (float)Math.PI;
	float vl = -(float)Math.PI;
	float vr = 0;
	int m    = 	25;
	int n    = 10;
	int r = 40;
	
	float du = (ur - ul)/m;
	float dv = (vr - vl)/n;
	
	public void drawUmgebung(){
		drawFacette();
	}
	
	public float x(float u, float v) {
		return r*(float)Math.sin(u)*(float)Math.cos(v) ;
	}
	public float y(float u, float v) {
		return r*(float)Math.sin(u)*(float)Math.sin(v) ;	
	}
	public float z(float u, float v) {
		return r*(float)Math.cos(u) ;
	}
	public void drawFacette(){
		glPolygonMode(GL_FRONT_AND_BACK,GL_FILL);
		for(int i=0;i<m;i++) {
			for(int j=0; j<n;j++) {
				
				glBegin(GL_TRIANGLE_FAN );
					glVertex3f(x(ul + i*du		, vl +j*dv)			,y(ul + i*du		, vl +j*dv)			,z(ul + i*du		,vl + j*dv));
					glVertex3f(x(ul + (i+1)*du	, vl +j*dv)			,y(ul + (i+1)*du	, vl +j*dv)			,z(ul + (i+1)*du	,vl + j*dv));
					glVertex3f(x(ul + (i+1)*du	, vl +(j+1)*dv)		,y(ul + (i+1)*du	, vl +(j+1)*dv)		,z(ul + (i+1)*du	,vl + (j+1)*dv));
					glVertex3f(x(ul + i*du		, vl + (j+1)*dv)	,y(ul + i*du		, vl + (j+1)*dv)	,z(ul + i*du		,vl + (j+1)*dv));				
				glEnd();
			}
		}
	}
	
	
	
	
	
	
	
	
}
