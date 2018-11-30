package Br�cke;
import static org.lwjgl.opengl.GL11.*;

public class Br�cke {
	
		float anzSteineSeitenteil=25;
		float verschiebungX =1.2f;
		float verschiebungY =0.8f;
		float verschiebungZ =1.2f;
		
		SteinBr�cke stein1 = new SteinBr�cke();
		Br�ckenbogen br�ckenbogen = new Br�ckenbogen();
	
	public void drawBr�cke() {
	
		glPushMatrix();
			drawSeitenteil();
			glTranslatef(-verschiebungX*(anzSteineSeitenteil-1),0,5);		
			drawSeitenteil();
		glPopMatrix();
		glPushMatrix();
			glTranslatef(15.6f,0,0);
			glLightModeli(GL_LIGHT_MODEL_TWO_SIDE, GL_TRUE);
			br�ckenbogen.drawBr�ckenbogen();
			glLightModeli(GL_LIGHT_MODEL_TWO_SIDE, GL_FALSE) ;
		glPopMatrix();
	}
	public void drawSeitenteil() {
		stein1.drawStein();
		for(int i=0; i <anzSteineSeitenteil;i++) {
			if(i<10) {
				glTranslatef(verschiebungX,verschiebungY,0);
				stein1.drawStein();	
			}
			if(i >=10 && i < 15) {
				glTranslatef(1,0,0);
				stein1.drawStein();
			}
			if(i>=15 && i<25) {
				glTranslatef(verschiebungX,-verschiebungY,0);
				stein1.drawStein();
			}
		}
	}
	
	
}
