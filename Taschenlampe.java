package Taschenlampe;
import static org.lwjgl.opengl.GL11.*;

public class Taschenlampe {
	
	H�lle h�lle = new H�lle();
	Reflektor reflektor = new Reflektor();
	Schalterkasten schalterkasten = new Schalterkasten();
	Torus torus = new Torus();
	Schalter schalter = new Schalter();
	Lampe lampe = new Lampe();
	Boden boden = new Boden();
	
	public void drawTaschenlampe() {
		glPushMatrix();
		
			h�lle.drawFacette();
			reflektor.drawFacette();
			schalterkasten.drawFacette();
			torus.drawFacette();
			schalter.drawFacette();
			lampe.drawFacette();
			boden.drawFacette();
		glPopMatrix();
	}

	public void kippSchalter(boolean an) {
		if(an == true) {
			schalter.setSchalterAufAn();
		}
		else {
			schalter.setSchalterAufAus();
		}
	}
	
}
