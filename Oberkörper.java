package Gegnerfigur;

import static org.lwjgl.opengl.GL11.*;

public class Oberkörper {
	float[] mat_amb ={1.0f,0.92f,0.89f,0.5f};
	float[] mat_dif = {1.0f,0.92f,0.89f,0.5f};
	float[] mat_spec = {1.0f,0.92f,0.89f,0.5f};
	float shini = 128;
	
	FacetteGegner facette1 = new FacetteGegner(mat_amb,mat_dif,mat_spec,shini);
	
	public void draw() {
		
		glPushMatrix();
		glScalef(1,1,0.6f);
		glPushMatrix();
			glRotatef(-90,1,0,0);
			facette1.drawFacetteRechteck(5,5,7.5f,7.5f);				//Deckel
		glPopMatrix();
		
		glPushMatrix();
			glRotatef(90,1,0,0);
			facette1.drawFacetteRechteck(5,5,7.5f,7.5f);			//Boden
		glPopMatrix();
		
		glPushMatrix();
			glRotatef(180,0,1,0);
			facette1.drawFacetteRechteck(5,5,7.5f,7.5f);				//Rückseite
		glPopMatrix();
		
		glPushMatrix();
			glRotatef(-90,0,1,0);
			facette1.drawFacetteRechteck(5,5,7.5f,7.5f);			// Linke Seite	
		glPopMatrix();
		
		glPushMatrix();
			glRotatef(90,0,1,0);
			facette1.drawFacetteRechteck(5,5,7.5f,7.5f);			//Rechte Seite
		glPopMatrix();
		
		glPushMatrix();
			facette1.drawFacetteRechteck(5,5,7.5f,7.5f);				//Vorderseite
		glPopMatrix();
		
		glPopMatrix();
	}
	
	public void drawOberkörper() {
		glScalef(0.7f,1,0.9f);
		draw();
	}

}
