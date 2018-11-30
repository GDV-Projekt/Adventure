package Gegnerfigur;

import static org.lwjgl.opengl.GL11.*;


public class Fu� {
	float[] mat_amb ={1.0f,0.92f,0.89f,0.5f};
	float[] mat_dif = {1.0f,0.92f,0.89f,0.5f};
	float[] mat_spec = {1.0f,0.92f,0.89f,0.5f};
	
	FacetteGegner facette1 = new FacetteGegner(mat_amb,mat_dif,mat_spec,5);
	
public void drawFu�() {
			
		glPushMatrix();
		glTranslatef(0,-1,0);
			glRotatef(-90,1,0,0);
			facette1.drawFacetteRechteck(5, 5, 3f, 3f);			//Deckel
		glPopMatrix();
		
		glPushMatrix();
			glRotatef(90,1,0,0);
			facette1.drawFacetteRechteck(5,5,3f,3f);			//Boden
		glPopMatrix();
		
		glPushMatrix();
			glRotatef(180,0,1,0);
			facette1.drawFacetteRechteck(5,5,3f,2f);			//R�ckseite
		glPopMatrix();
		
		glPushMatrix();
			glRotatef(-90,0,1,0);
			facette1.drawFacetteRechteck(5,5,3f,2f);			// Linke Seite	
		glPopMatrix();
		
		glPushMatrix();
			glRotatef(90,0,1,0);
			facette1.drawFacetteRechteck(5,5,3f,2f);			//Rechte Seite
		glPopMatrix();
		
		
		glPushMatrix();
		facette1.drawFacetteRechteck(5,5,3f,2f);				//Vorderseite
		glPopMatrix();
		
	}

}
