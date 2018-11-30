package Gegnerfigur;

import static org.lwjgl.opengl.GL11.*;

public class Gegnerfigur {
	
	Kopf kopf1 = new Kopf();
	Hals hals1 = new Hals();
	Hand hand1 = new Hand();
	Arm arm1 = new Arm();
	Armgelenk armgelenk1 = new Armgelenk();
	Oberkörper oberkörper1 = new Oberkörper();
	Bein bein1 = new Bein();
	Fuß fuß1 = new Fuß();

	
	public void drawGegnerfigur() {
		
	
		glPushMatrix();
		glTranslatef(7.7f,6.3f,0);  	// Hand links
		hand1.drawHand();
	glPopMatrix();
	glPushMatrix();
		glTranslatef(0,6.3f,0);  	// Hand links
		hand1.drawHand();
	glPopMatrix();

		glPushMatrix();
		glTranslatef(7.8f,6,0);			//Arm links
		arm1.drawArm();
	glPopMatrix();
	glPushMatrix();
		glTranslatef(0.1f,6,0);			//Arm links
		arm1.drawArm();
	glPopMatrix();
	glPushMatrix();
		glTranslatef(7f,11.51f,0);
		armgelenk1.drawArmgelenk();			//Armgelenk rechts
	glPopMatrix();
		
	glPushMatrix();
		glTranslatef(0.89f,11.5f,0);
		armgelenk1.drawArmgelenk();			//Armgelenk links
	glPopMatrix();

		
		
	glPushMatrix();
		glTranslatef(4,14.65f,0);
		glScalef(1,0.7f,1);
		kopf1.drawKopf();					//Kopf
	glPopMatrix();
	glPushMatrix();
		glTranslatef(4,13.19f,0);			//Hals
		hals1.drawHals();
	glPopMatrix();
	
	glPushMatrix();
		glTranslatef(4,9.49f,0);			// 	Oberkörper         //y-versch -14
		oberkörper1.drawOberkörper();
	glPopMatrix();
	glPushMatrix();
		glTranslatef(5.8f,-0.51f,0);			// 	Bein rechts
		bein1.drawBein();
	glPopMatrix();
	glPushMatrix();
		glTranslatef(2.2f,-0.51f,0);			// Bein links
		bein1.drawBein();
	glPopMatrix();
	glPushMatrix();
		glScalef(0.8f,0.7f,1f);
		glTranslatef(5.8f+1.4f,0,0.8f);
		fuß1.drawFuß();						// FUß rechts
	glPopMatrix();
	glPushMatrix();
		glScalef(0.8f,0.7f,1f);
		glTranslatef(2.2f+0.6f,0,0.8f);
		fuß1.drawFuß();						// FUß links
	glPopMatrix();
	
	
	glTranslatef(4,0,0);
	}
}
