package Objekte;
import static org.lwjgl.opengl.GL11.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils; // to create a float buffer 

public class Viereck {
	float rot = 1, gruen = 1, blau = 1;
	boolean raster = true;
	float [] mat_amb = {0.33f,0.22f,0.3f,1.0f};
	float [] mat_dif = {0.78f,0.57f,0.11f,1.0f};
	float [] mat_spec = {0.99f,0.94f,0.81f,1.0f};
	// Materialeigenschaften
	
	
	
	private void drawViereck(float höhe, float breite, float m, float n) {
//		glColor3f(rot, gruen, blau);
		
		glMaterialfv(GL_FRONT,GL_AMBIENT, mat_amb);
		glMaterialfv(GL_FRONT,GL_DIFFUSE, mat_dif);
		glMaterialfv(GL_FRONT,GL_SPECULAR, mat_spec);
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				glBegin(GL_POLYGON);
				glNormal3f(0.0f,0.0f,1.0f);
				glVertex3f(-breite / 2 + breite / m * i, -höhe / 2 + höhe / n * j, breite / 2);
				glVertex3f(-breite / 2 + breite / m * (i + 1), -höhe / 2 + höhe / n * j, breite / 2);
				glVertex3f(-breite / 2 + breite / m * (i + 1), -höhe / 2 + höhe / n * (j + 1), breite / 2);
				glVertex3f(-breite / 2 + breite / m * i, -höhe / 2 + höhe / n * (j + 1), breite / 2);

				glEnd();
			}
		}
	}

	public void draw() {

		drawViereck(5, 5, 30, 30);
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
