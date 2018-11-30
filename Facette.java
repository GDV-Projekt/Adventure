package Taschenlampe;

import static org.lwjgl.opengl.GL11.GL_AMBIENT;
import static org.lwjgl.opengl.GL11.GL_DIFFUSE;
import static org.lwjgl.opengl.GL11.GL_FILL;
import static org.lwjgl.opengl.GL11.GL_FRONT;
import static org.lwjgl.opengl.GL11.GL_POLYGON;
import static org.lwjgl.opengl.GL11.GL_SHININESS;
import static org.lwjgl.opengl.GL11.GL_SPECULAR;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glMaterialf;
import static org.lwjgl.opengl.GL11.glMaterialfv;
import static org.lwjgl.opengl.GL11.glNormal3f;
import static org.lwjgl.opengl.GL11.glPolygonMode;
import static org.lwjgl.opengl.GL11.glVertex3f;

public class Facette {


	float [] mat_amb = new float[4];
	float [] mat_dif = new float[4];
	float [] mat_spec = new float[4];
	private float shini = (float) 5;
	
	public Facette(float[]mat_amb,float[]mat_dif,float[]mat_spec, float shini) {
		
		for(int i=0;i < this.mat_amb.length;i++) {
			this.mat_amb[i] = mat_amb[i];
			this.mat_dif[i] = mat_dif[i];
			this.mat_spec[i] = mat_spec[i];
		}
		
		this.shini = shini;
	}
	
	public void drawFacetteRechteck(float n, float m, float b, float h) {
		glPolygonMode(GL_FRONT,GL_FILL);
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				glBegin(GL_POLYGON);
				glMaterialfv(GL_FRONT,GL_AMBIENT, mat_amb);
				glMaterialfv(GL_FRONT,GL_DIFFUSE, mat_dif);
				glMaterialfv(GL_FRONT,GL_SPECULAR, mat_spec);
				glMaterialf(GL_FRONT, GL_SHININESS, shini);
				glNormal3f(0.0f,0.0f,1.0f);
					glVertex3f(-b / 2 + b / m * i, -b / 2 + h / n * j, b / 2);
					glVertex3f(-b / 2 + b / m * (i + 1), -b / 2 + h / n * j, b / 2);
					glVertex3f(-b / 2 + b / m * (i + 1), -b / 2 + h / n * (j + 1), b / 2);
					glVertex3f(-b / 2 + b / m * i, -b / 2 + h / n * (j + 1), b / 2);
				glEnd();

			}

		}
	}
	

	


}
