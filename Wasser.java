package Wasser;
import static org.lwjgl.opengl.GL11.*;
public class Wasser {
	
	Welle1 welle1 = new Welle1();
	Welle2 welle2 = new Welle2();
	WasserSchale wasserschale = new WasserSchale();
	
	public void drawWasser() {
		//Schale worin Wasser "liegt"
		
		glPushMatrix();
			glTranslatef(0,0,0);
			wasserschale.drawUmgebung();
		glPopMatrix();

//		Wasser
		glPushMatrix();
			glTranslatef(0,-2,-42);
			welle1.drawWelle();
		glPopMatrix();
		glPushMatrix();
			glRotatef(90,0,1,0);
			glTranslatef(0,-2,-42);
			welle2.drawWelle();
		glPopMatrix();
	
	}

}
