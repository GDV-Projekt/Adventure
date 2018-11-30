package Gegnerfigur;

import static org.lwjgl.opengl.GL11.*;

public class Armgelenk {
	float[] mat_amb ={1.0f,0.92f,0.89f,0.5f};
	float[] mat_dif = {1.0f,0.92f,0.89f,0.5f};
	float[] mat_spec = {1.0f,0.92f,0.89f,0.5f};
	float shini;
	
	FacetteGegner facette1 = new FacetteGegner(mat_amb,mat_dif,mat_spec,shini);
	
	public void drawArmgelenk() {
		glPushMatrix();
			glRotatef(-90,1,0,0);
			facette1.drawFacetteRechteck(1,1,1f,1f);				//Deckel
		glPopMatrix();
		
		glPushMatrix();
			glRotatef(90,1,0,0);
			facette1.drawFacetteRechteck(1,1,1f,1f);				//Boden
		glPopMatrix();
		
		glPushMatrix();
			glRotatef(180,0,1,0);
			facette1.drawFacetteRechteck(1,1,1f,1f);				//Rückseite
		glPopMatrix();
		
		glPushMatrix();
			glRotatef(-90,0,1,0);
			facette1.drawFacetteRechteck(1,1,1f,1f);				// Linke Seite	
		glPopMatrix();
		
		glPushMatrix();
			glRotatef(90,0,1,0);
			facette1.drawFacetteRechteck(1,1,1f,1f);				//Rechte Seite
		glPopMatrix();
		
		glPushMatrix();
			facette1.drawFacetteRechteck(1,1,1f,1f);				//Vorderseite
		glPopMatrix();
	}

}
