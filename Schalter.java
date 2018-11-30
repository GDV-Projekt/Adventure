package Taschenlampe;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;

public class Schalter {

	
	float[] mat_amb ={0.5f,0.15f,0.15f,0.15f};
	float[] mat_dif = {0.5f,0.15f,0.15f,0.15f};
	float[] mat_spec = {0.5f,0.15f,0.15f,0.15f};
	
	Facette facette = new Facette(mat_amb,mat_dif,mat_spec,100);
	
	boolean schalterAufAn = false;
	
public void drawFacette() {
	glPushMatrix();
	
	glTranslatef(0,1.05f,4.6f);
	
	if(schalterAufAn == true) {
		glRotatef(-15,1,0,0);
	}

	glRotatef(-7,1,0,0);
	glScalef(0.2f,0.5f,0.7f);

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

public void setSchalterAufAn() {
		this.schalterAufAn = true;
}
public void setSchalterAufAus() {
	this.schalterAufAn = false;
}


}
