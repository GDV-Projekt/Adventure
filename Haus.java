package Haus;
import static org.lwjgl.opengl.GL11.*;

public class Haus {
	
	// Erzeugung der Hausbausteine: Auﬂenw‰nde,Dach und Auﬂenelemente
	Auﬂenw‰nde unterteil1 = new Auﬂenw‰nde();
	Dach dach1 = new Dach();
	Auﬂenelemente auﬂenelemente = new Auﬂenelemente();
	
	public void drawHaus() {
		glPushMatrix();
			unterteil1.drawUnterteil();
			dach1.drawDach();
			auﬂenelemente.drawAuﬂenelemente();
		glPopMatrix();
	}

}
