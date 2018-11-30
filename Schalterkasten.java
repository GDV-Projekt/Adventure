package Taschenlampe;

import static org.lwjgl.opengl.GL11.*;




public class Schalterkasten {
	
	float[] mat_amb ={0.15f,0.15f,0.15f,0.15f};
	float[] mat_dif = {0.15f,0.15f,0.15f,0.15f};
	float[] mat_spec = {0.15f,0.15f,0.15f,0.15f};
	
	Facette facette = new Facette(mat_amb,mat_dif,mat_spec,100);
	
public void drawFacette() {
	glPushMatrix();
	
	glTranslatef(0,0.98f,4.8f);
	glScalef(0.8f,0.5f,2);
	
	glRotatef(-20,1,0,0);
	
	glPushMatrix();
		glRotatef(-90,1,0,0);
		facette.drawFacetteRechteck(5, 5,0.5f,0.5f);			//Deckel
	glPopMatrix();
	
	glPushMatrix();
		glRotatef(90,1,0,0);
		facette.drawFacetteRechteck(5,5,0.5f,0.5f);			//Boden
	glPopMatrix();
	
	glPushMatrix();
		glRotatef(180,0,1,0);
		facette.drawFacetteRechteck(5,5,0.5f,0.5f);			//Rückseite
	glPopMatrix();
	
	glPushMatrix();
		glRotatef(-90,0,1,0);
		facette.drawFacetteRechteck(5,5,0.5f,0.5f);			// Linke Seite	
	glPopMatrix();
	
	glPushMatrix();
		glRotatef(90,0,1,0);
		facette.drawFacetteRechteck(5,5,0.5f,0.5f);			//Rechte Seite
	glPopMatrix();
	
	
	glPushMatrix();
		facette.drawFacetteRechteck(5,5,0.5f,0.5f);				//Vorderseite
	glPopMatrix();
	
	glPopMatrix();
		
	}

}
