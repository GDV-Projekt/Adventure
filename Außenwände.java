package Haus;
import static org.lwjgl.opengl.GL11.*;
public class Außenwände {
	
	int breite =10;
	int höhe=10;
	int positionX = breite/2;
	int positionY =-breite/2;
	int poitionnZ =-breite/2;
	float[] mat_amb = {0.5f,0.5f,0.5f,0.5f,};
	float[] mat_dif = {0.5f,0.5f,0.5f,0.5f,};
	float[] mat_spec = {0.5f,0.5f,0.5f,0.5f,};
	float shini = 5;
	
	
	FacetteHaus facette1 = new FacetteHaus(mat_amb,mat_dif,mat_spec,shini);

	public void drawUnterteil() {
		
		glPushMatrix();
			glRotatef(180,0,1,0);
			drawRechteck();
		glPopMatrix();
		
		glPushMatrix();
			glRotatef(-90,1,0,0);
			drawRechteck();
		glPopMatrix();
	
		glPushMatrix();
			glRotatef(90,1,0,0);
			drawRechteck();
		glPopMatrix();
	
		glPushMatrix();
			glRotatef(-90,0,1,0);
			drawRechteck();
		glPopMatrix();
			
		glPushMatrix();
			glRotatef(90,0,1,0);
			drawRechteck();
		glPopMatrix();
	
		glPushMatrix();
			drawRechteck();
		glPopMatrix();
	}
	public void drawRechteck() {
		
		facette1.drawFacetteRechteck(20, 20, breite,höhe);
		
	}
	
}
