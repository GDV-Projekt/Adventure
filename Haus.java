package Haus;
import static org.lwjgl.opengl.GL11.*;

public class Haus {
	
	// Erzeugung der Hausbausteine: Au�enw�nde,Dach und Au�enelemente
	Au�enw�nde unterteil1 = new Au�enw�nde();
	Dach dach1 = new Dach();
	Au�enelemente au�enelemente = new Au�enelemente();
	
	public void drawHaus() {
		glPushMatrix();
			unterteil1.drawUnterteil();
			dach1.drawDach();
			au�enelemente.drawAu�enelemente();
		glPopMatrix();
	}

}
