package Haus;
import static org.lwjgl.opengl.GL11.*;

public class Haus {
	
	// Erzeugung der Hausbausteine: Außenwände,Dach und Außenelemente
	Außenwände unterteil1 = new Außenwände();
	Dach dach1 = new Dach();
	Außenelemente außenelemente = new Außenelemente();
	
	public void drawHaus() {
		glPushMatrix();
			unterteil1.drawUnterteil();
			dach1.drawDach();
			außenelemente.drawAußenelemente();
		glPopMatrix();
	}

}
