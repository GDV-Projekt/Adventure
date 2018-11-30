package Objekte;

import static org.lwjgl.opengl.GL11.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils; // to create a float buffer 

public class EbeneFlaeche {
	float rot = 1, blau = 1, gruen = 1;
	boolean raster = true;
	//Materialeigenschaften
	
	float [] mat_amb = {0.0f,0.17f,0.f,0.5f};
	float [] mat_dif = {0.f,0.61f,0.f,0.5f};
	float [] mat_spec = {0.f,0.73f,0.f,0.5f};
	private float shini = (float) 125;
	
	private void drawEbene(float länge, float breite, float m, float n) {
//		glColor3f(rot,gruen,blau);
	
		for (int i = 0; i < m ; i++) {
			for(int j = 0; j < n; j++) {
				glBegin(GL_TRIANGLE_FAN);
				glMaterialfv(GL_FRONT,GL_AMBIENT, mat_amb);
				glMaterialfv(GL_FRONT,GL_DIFFUSE, mat_dif);
				glMaterialfv(GL_FRONT,GL_SPECULAR, mat_spec);
				glMaterialf(GL_FRONT, GL_SHININESS, shini);
				
				glNormal3f(0.0f,1.0f,0.0f);
					glVertex3f(-breite / 2 + breite / m * i,-1, -länge / 2 + länge / n * j);
					glVertex3f(-breite / 2 + breite / m * (i + 1), -1, -länge / 2 + länge / n * j);
					glVertex3f(-breite / 2 + breite / m * (i + 1),-1, -länge / 2 + länge / n * (j + 1));
					glVertex3f(-breite / 2 + breite / m * i,-1, -länge / 2 + länge / n * (j + 1));
				glEnd();
			}
		}
	}
	
	public void draw() {
	drawEbene(1000,1000,100,100);

	}
//	public void setColor(float r, float g, float b) // Setzen der Objektfarbe
//	{
//		rot = r;
//		gruen = g;
//		blau = b;
//	}
	public void setRaster(boolean x) {
	    raster = x;
	    if(x) {
	    	glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
	    }
	    else {
	    	glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
	    }       
	}
}
