package Main;

//Imports
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import java . nio . FloatBuffer ;
import org . joml . Matrix4f ;
import org.joml.Vector3f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import Environment.Landschaft;
import Environment.MyLight;
import MatheOperationen.Camera;
import Objekte.*;
import Wasser.*;
import Brücke.*;
import Gegnerfigur.*;
import Haus.*;
import Taschenlampe.*;
import Stein.*;

public class MyScene {
	// private Variablen
float[]n = new float [16]; // Variable zum Zwischenspeichern einer Matrix
boolean raster = true; // Rasteranzeige

	// Beleuchtungsvariablen

private float zLicht = 2;
private float shini = 50;
private float spotExpo = 67;

private MyLight l1 = new MyLight(GL_LIGHT1);
private MyLight l2 = new MyLight(GL_LIGHT2);

	// Bewegungsvariablen
int phi = 0;
int mü = 90;
int müMin = 0;
int müMax = 180;
int höhe = 2;
private int xStart=0,yStart=0;
float velocity =0.08f;			// Bewegungsgeschwindigkeit
boolean sprint = false;
float sprintfaktor = 1.9f; 		//50% schneller laufen

private Vector3f Blickrichtung = new Vector3f();
private Vector3f Position = new Vector3f();
private Vector3f up = new Vector3f();

// Erzeugung der Objekte
Wuerfel wurfel = new Wuerfel();
Viereck a = new Viereck();
Camera c = new Camera(Blickrichtung,Position,up);
Kugel kugel = new Kugel();
Wasser wasser = new Wasser();
Brücke brücke = new Brücke();
Gegnerfigur gegnerfigur = new Gegnerfigur();
Haus haus = new Haus();

Grundebene grundebene = new Grundebene();
Berge berge = new Berge();

Taschenlampe taschenlampe = new Taschenlampe();
boolean taschenLampeAn = false;

InitialisiereSteine init = new InitialisiereSteine(20,-8);
InitialisiereSteine init2 = new InitialisiereSteine(22,-8);
InitialisiereSteine init3 = new InitialisiereSteine(24, -8);

	// Buffer-Erzeugung
FloatBuffer fb = BufferUtils.createFloatBuffer(16);
Matrix4f m = new Matrix4f();

	public void initGLState() {
		glEnable(GL_NORMALIZE);
		glEnable(GL_DEPTH_TEST); 
//		glDisable(GL_COLOR_MATERIAL);
		
		glMatrixMode(GL_PROJECTION);
	// Projektionstransormation ab hier
		m.setPerspective((float)Math.PI/2, 1, (float) 0.001, 150);
		
		
		glLoadIdentity(); 
		m.get(fb);
		glLoadMatrixf(fb);

	// Model-Transformation ab hier
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		
		// Hintergrundfarbe definieren
		glClearColor(0, 0, 0, 0);
		
		

	    /* Smooth-Shading soll benutzt werden */
	    glShadeModel(GL_SMOOTH);
	    
	    initLighting();
	}
    
	private void initLighting()
	{
//	     Setup the Light
		
		//Taschenlampe
	    float light1_position [] = { 0.0f, 0.0f, zLicht, 1.0f };
	    float light1_diff_spec [] = { 0.914f, 0.914f, 0.914f, 1.0f };
	    float light1_direction [] = { 0, 0, -1, 1};
	    float light1_ambient [] = {0, 0, 0, 1};

	    // globale (paralelle) Beleuchtung
	    float light2_position [] = { 1.0f, 0.9f, 0, 0f };
	    float light2_diff_spec [] = { 0.14f, 0.14f, 0.14f, 1.0f };	    
	    float light2_ambient [] = {0, 0, 0, 1};
	    
	    
	    float lmodel_ambient [] = { 0.05f, 0.05f, 0.05f, 1.0f };

	    // Hintergrundbeleuchtung definieren
	    glLightModelfv(GL_LIGHT_MODEL_AMBIENT, lmodel_ambient);
	    
	    // Eine weitere Lichtquellen definieren
	    l1.setPosition(light1_position);
	    l1.setDirection(light1_direction);
	    l1.setDiffAndSpek(light1_diff_spec);
	    l1.setAmbient(light1_ambient);
	    l1.setCutoff(14f);
	    l1.setExponent(spotExpo);
	    
	    
	    l2.setPosition(light2_position);
	    l2.setDiffAndSpek(light2_diff_spec);
	    l2.setAmbient(light2_ambient);
	    glEnable(GL_LIGHTING);
	    


	}
	
	public void renderLoop() {
		// Lichtdefinition
	l2.setPosition(1, 1, 1);
	l2.ein();
	
	if(taschenLampeAn == true) {
		l1.ein();
	}
	// Kameraposition wird festgelegt
		
	m.setLookAt(c.getPos(),c.getBlick(),c.getUp());
	m.get(fb);
//	glPushMatrix();
		glLoadMatrixf(fb);
		
//	glPopMatrix();
	//Erstellung der Grundfläche
//		glPushMatrix();
//		ebene.draw();
//		glPopMatrix();
//		glScalef(20,20,20);
		
//		glTranslatef(0,(float)3,0);
//		glTranslatef((float)-20,0,(float)0);
//    	wurfel.draw();  
//    	glTranslatef(50,10,0);
//    	wurfel.draw();
//    glPopMatrix();
//    glPushMatrix();
//    	glLoadMatrixf(fb);
//    //Erstellung Mond
//    	glTranslatef(0,50,10);
//    	kugel.draw();
//    	glTranslatef(0,20,0);
//    glPopMatrix();
//    
// glPushMatrix();
// 	glScalef(0.5f,1f,0.5f);
//    	wasser.drawWasser();
//   glPopMatrix();
   
//   glPushMatrix();
//   	glTranslatef(20,0,20);
//   		haus.drawHaus();
//   glPopMatrix();
//   
//  glPushMatrix();
//  glTranslatef(0,-1,0);
//   	brücke.drawBrücke();
//   glPopMatrix();
//		
//		glPushMatrix();
//		glScalef(0.13f,0.16f,0.16f);
//		gegnerfigur.drawGegnerfigur();
//		glPopMatrix();
	
		
		
		// +++++ Hier fängt die Generierung der "richtigen" Welt an. ++++++
		
	
	//Grundebene ++++++++++++
		
//		glPushMatrix();
//			grundebene.drawFacette();
//		glPopMatrix();	
//		
//		
//		//Wasser + Schale
//		
//		glPushMatrix();
//			wasser.drawWasser();
//		glPopMatrix();
//		
//		//Häuser
//		glPushMatrix();
//			glTranslatef(20,0,20);
//			haus.drawHaus();
//		glPopMatrix();
//		
//		//Stein
//		renderSteine();
		
		
		// Taschenlampe
//		glPushMatrix();
////		glTranslatef(10,0,10);
////		glScalef(0.1f,0.1f,0.1f);
		taschenlampe.drawTaschenlampe();
//		glPopMatrix();
		

		
    l1.aus();
    l2.aus();
	
	}
	// Definition der Action-Listener für die Bewegungsrichtung
	
	private void left() {
		
		Position.x = (float) (Position.x + velocity*Math.sin(Math.toRadians(phi+90)));
		Position.z = (float) (Position.z + velocity*Math.cos(Math.toRadians(phi+90)));
		c.setPos(Position.x, höhe, Position.z);

	}
	private void right() {
		
		Position.x = (float) (Position.x + velocity*Math.sin(Math.toRadians(phi-90)));
		Position.z = (float) (Position.z +velocity*Math.cos(Math.toRadians(phi-90)));
		c.setPos(Position.x, höhe, Position.z);

	}
	private void up()
	{

		Position.x = (float) (Position.x + velocity*Math.sin(Math.toRadians(phi)));
		Position.z = (float) (Position.z + velocity*Math.cos(Math.toRadians(phi)));
		c.setPos(Position.x, höhe,Position.z);
	}
	
	private void down()
	{
		Position.x = (float) (Position.x - velocity*Math.sin(Math.toRadians(phi)));
		Position.z = (float) (Position.z - velocity*Math.cos(Math.toRadians(phi)));
		c.setPos((float)(Position.x), höhe,Position.z);
	}
	//Mouse-Handling
	public void mouse(double x, double y) {
		int xPos, yPos;
		int OffsetX, OffsetY;
		
		xPos=(int)x;
		yPos=(int)y;
		
		OffsetX = xPos - xStart;
		OffsetY = yPos - yStart;
		
		phi -= OffsetX;
		mü -=  OffsetY;
		
		xStart = xPos;
		yStart = yPos;
		
		
		
		if(phi != 0 || mü != 0 ) {
		System.out.println(mü + "  " );
			if(mü > 1000 || mü < -1000) {
				mü = 90;
				
			}
			if(mü >= 180) {

				c.setBlick((float)(100000*Math.sin(Math.toRadians(phi))),
						   (float)(400000*Math.cos(Math.toRadians(müMax))),
						   (float)(100000*Math.cos(Math.toRadians(phi))));
				mü = müMax;
				}
			if(mü <= 0) {
				c.setBlick((float)(100000*Math.sin(Math.toRadians(phi))),
				       (float)(400000*Math.cos(Math.toRadians(müMin))),
				       (float)(100000*Math.cos(Math.toRadians(phi))));
				mü = müMin;
			}
			else {
				c.setBlick((float)(100000*Math.sin(Math.toRadians(phi))),
					       (float)(400000*Math.cos(Math.toRadians(mü))),
					       (float)(100000*Math.cos(Math.toRadians(phi))));
			}
		}
	
	}
	// Keyboard-Handling
	public void keyboard(int key, int action)
	{	
		if ( key == GLFW_KEY_A && action == GLFW_PRESS || key == GLFW_KEY_A && action == GLFW_REPEAT) // Taste links gedrückt
			left();
        if ( key == GLFW_KEY_D && action == GLFW_PRESS || key == GLFW_KEY_D && action == GLFW_REPEAT ) // Taste rechts gedrückt und/oder gehalten
        	right();
        if (key == GLFW_KEY_W && action == GLFW_REPEAT || key == GLFW_KEY_W && action == GLFW_PRESS) 
        	up();
        if (key == GLFW_KEY_S && action == GLFW_REPEAT || key == GLFW_KEY_S && action == GLFW_PRESS)
        	down();
        if (key == GLFW_KEY_R && action == GLFW_RELEASE) // Taste "R" losgelassen
//        	ef.setColor(1, 0, 1);
        if (key == GLFW_KEY_G && action == GLFW_RELEASE) // Taste "G" losgelassen
//        	k1.setColor(0, 1, 0);
        if ( key == GLFW_KEY_F && action == GLFW_PRESS) // Taste "F" gedrückt
        	setRaster(true);
        if ( key == GLFW_KEY_L && action == GLFW_PRESS) // Taste "L" gedrückt
            setRaster(false);
        
        // Sprint-Test
        
        if(key == GLFW_KEY_LEFT_SHIFT && action == GLFW_PRESS ) {
        	if(sprint == false) {
        		sprint = true;
        		velocity = velocity*sprintfaktor;
        	}
        	
        }
        if(key == GLFW_KEY_CAPS_LOCK && action == GLFW_PRESS) {
        	if(sprint == true) {
        		sprint = false;
        	velocity = velocity* (1/sprintfaktor);
        	}
        	
        }
        
        //Taschenlampe An/Aus
        
        //an
        if(key == GLFW_KEY_T && action == GLFW_PRESS ) {
        	
        		l1.ein();
        		taschenlampe.kippSchalter(true);
        		taschenLampeAn = true;
        	}
        //aus
        if(key == GLFW_KEY_U && action == GLFW_PRESS ) {
        		l1.aus();
        		taschenlampe.kippSchalter(false);
        		taschenLampeAn = false;
        		
        }
	}
	// Anzeige des Objekts
    public void setRaster(boolean x) {
    	raster = x;
    	if(x) {
    		glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
    	}
    	else {
    		glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
    	}
        
    }
    public void renderSteine() {
    	init.initialisiereSteine();
    	init2.initialisiereSteine();
    	init3.initialisiereSteine();
    }
   
}