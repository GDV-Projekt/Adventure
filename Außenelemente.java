package Haus;
import static org.lwjgl.opengl.GL11.*;
public class Außenelemente {
	
	float[] mat_ambF = {0.5f,0.5f,0.7f,0.5f,};
	float[] mat_difF = {0.5f,0.5f,0.7f,0.5f,};
	float[] mat_specF = {0.5f,0.5f,0.7f,0.5f,};
	
	float[] mat_ambT = {0.8f,0.8f,0.8f,0.5f,};
	float[] mat_difT = {0.8f,0.8f,0.8f,0.5f,};
	float[] mat_specT = {0.8f,0.8f,0.8f,0.5f,};
	
	float shini = 5;
	FacetteHaus fenster = new FacetteHaus(mat_ambF,mat_difF,mat_specF,shini);
	FacetteHaus türe = new FacetteHaus(mat_ambT,mat_difT,mat_specT,shini);
	public void drawAußenelemente() {
	
		glPushMatrix();	
			glTranslatef(-0.08f,0,-1.1f);
			glRotatef(270,0,1,0);
			glTranslatef(0,1.9f,0);
			glScalef(2f,2.25f,1f);
			drawFenster();								//Fenster Seite links
		glPopMatrix();
		glPushMatrix();	
			glTranslatef(-0.08f,0,1);
			glRotatef(270,0,1,0);
			glTranslatef(0,1.9f,0);
			glScalef(2f,2.25f,1f);
			drawFenster();								//Fenster Seite links
		glPopMatrix();
		glPushMatrix();	
			glTranslatef(0.08f,0,-1.1f);
			glRotatef(90,0,1,0);
			glTranslatef(0,1.9f,0);
			glScalef(2f,2.25f,1f);
			drawFenster();								//Fenster Seite rechts
		glPopMatrix();
		glPushMatrix();	
			glTranslatef(0.08f,0,1);
			glRotatef(90,0,1,0);
			glTranslatef(0,1.9f,0);
			glScalef(2f,2.25f,1f);
			drawFenster();								//Fenster Seite rechts
		glPopMatrix();
		glPushMatrix();		
			glTranslatef(1.8f,1.9f,0.08f);
			glScalef(1.75f,2.25f,1f);
			drawFenster();								//Fenster vorne		
		glPopMatrix();
		glPushMatrix();	
			glTranslatef(0,1.9f,0.08f);
			glScalef(1.75f,2.25f,1f);
			drawFenster();								//Fenster vorne
		glPopMatrix();
		glPushMatrix();		
			glTranslatef(-3,0.5f,0.05f);
			glScalef(2f,5f,1f);
			drawTüre();							//Türe
		glPopMatrix();
	
	}
	
	public void drawFenster(){
		glTranslatef(0,0,4.51f);
		fenster.drawFacetteRechteck(5, 5, 1, 1);
	}
	public void drawTüre(){
		glTranslatef(0,0,4.51f);
		türe.drawFacetteRechteck(5, 5, 1, 1);
	}

}
