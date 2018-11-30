package Gegnerfigur;

import static org.lwjgl.opengl.GL11.*;



public class Hand {
	float[] mat_amb ={1.0f,0.92f,0.89f,0.5f};
	float[] mat_dif = {1.0f,0.92f,0.89f,0.5f};
	float[] mat_spec = {1.0f,0.92f,0.89f,0.5f};
	float shini;

	FacetteGegner facette1 = new FacetteGegner(mat_amb,mat_dif,mat_spec,shini);
	
	
	public void drawHand() {
		glPushMatrix();
			glRotatef(-90,1,0,0);
			facette1.drawFacetteRechteck(2,2,1.5f,1.5f);					//Deckel
		glPopMatrix();
		
		glPushMatrix();
			glRotatef(90,1,0,0);
			facette1.drawFacetteRechteck(2,2,1.5f,1.5f);					//Boden
		glPopMatrix();
		
		glPushMatrix();
			glRotatef(180,0,1,0);
			facette1.drawFacetteRechteck(2,2,1.5f,1.5f);			//Rückseite
		glPopMatrix();
		
		glPushMatrix();
			glRotatef(-90,0,1,0);
			facette1.drawFacetteRechteck(2,2,1.5f,1.5f);				// Linke Seite	
		glPopMatrix();
		
		glPushMatrix();
			glRotatef(90,0,1,0);
			facette1.drawFacetteRechteck(2,2,1.5f,1.5f);				//Rechte Seite
		glPopMatrix();
		
		glPushMatrix();
		facette1.drawFacetteRechteck(2,2,1.5f,1.5f);				//Vorderseite
		glPopMatrix();
		
		
	}

}
