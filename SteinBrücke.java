package Br�cke;

import static org.lwjgl.opengl.GL11.*;

public class SteinBr�cke {
	
	public float breite=2;
	public float h�he=1;
	public float facettebreite=3;
	public float facetteh�he=3;
	
	Facette facette = new Facette();
	
	public void drawStein() {
		
		glPushMatrix();
			glTranslatef(h�he,breite*0.5f,0);
			glTranslatef(0,-1,0);
			glRotatef(-90,1,0,0);
			facette.drawFacetteRechteck(facettebreite,facetteh�he,breite,h�he);				//Deckel
		glPopMatrix();
		glPushMatrix();
			glTranslatef(h�he,breite*0.5f,0);
			glTranslatef(0,0,1);
			glRotatef(90,1,0,0);
			facette.drawFacetteRechteck(facettebreite,facetteh�he,breite,h�he);				//Boden
		glPopMatrix();
		glPushMatrix();
			glTranslatef(h�he,breite*0.5f,0);
			glTranslatef(0,0,1);
			glRotatef(180,0,1,0);
			facette.drawFacetteRechteck(facettebreite,facetteh�he,breite,h�he);				//R�ckseite
		glPopMatrix();
		glPushMatrix();
			glTranslatef(h�he,breite*0.5f,0);
			glTranslatef(0,0,breite*0.25f);
			glScalef(1,1,0.5f);
			glRotatef(-90,0,1,0);
			facette.drawFacetteRechteck(facettebreite,facetteh�he,breite,h�he);					// Linke Seite	
		glPopMatrix();
		glPushMatrix();
			glTranslatef(h�he,breite*0.5f,0);
			glTranslatef(0,0,breite*0.25f);
			glScalef(1,1,0.5f);
			glRotatef(90,0,1,0);
			facette.drawFacetteRechteck(facettebreite,facetteh�he,breite,h�he);				//Rechte Seite
		glPopMatrix();
		glPushMatrix();
			glTranslatef(h�he,breite*0.5f,0);
			facette.drawFacetteRechteck(facettebreite,facetteh�he,breite,h�he);				//Vorderseite
		glPopMatrix();
		
		
	}

}
