package Objekte;
import static org.lwjgl.opengl.GL11.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils; // to create a float buffer 

public class Wuerfel {
	Viereck a = new Viereck();
	Viereck b = new Viereck();
	Viereck c = new Viereck();
	Viereck d = new Viereck();
	Viereck e = new Viereck();
	Viereck f = new Viereck();
	float rot = 1, gruen = 1, blau = 1;

	private void drawWuerfel() {

		// Vorderseite
		glPushMatrix();
			a.draw();
//			a.setColor(rot, gruen, blau);
		glPopMatrix();

		// rechte Seite
		glPushMatrix();
			glRotatef(90, 0.0f, 1.0f, 0.0f);
			b.draw();
//			b.setColor(rot, gruen, blau);
		glPopMatrix();

		// Rückseite
		glPushMatrix();
			glRotatef(180, 0.0f, 1.0f, 0.0f);
			c.draw();
//			c.setColor(rot, gruen, blau);
		glPopMatrix();

		// Linke Seite
		glPushMatrix();
			glRotatef(270, 0.0f, 1.0f, 0.0f);
			d.draw();
//			d.setColor(rot, gruen, blau);
		glPopMatrix();

		// Obere Seite
		glPushMatrix();
			glRotatef(90, 1.0f, 0.0f, 0.0f);
			e.draw();
//			e.setColor(rot, gruen, blau);
		glPopMatrix();

		// Untere Seite
		glPushMatrix();
			glRotatef(270, 1.0f, 0.0f, 0.0f);
			f.draw();
//			f.setColor(rot, gruen, blau);
		glPopMatrix();

	}

//	public void setColor(float r, float g, float b) // Setzen der Objektfarbe
//	{
//		rot = r;
//		gruen = g;
//		blau = b;
//	}

	public void draw() {
		drawWuerfel();
	}
}
