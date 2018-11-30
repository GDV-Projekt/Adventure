package Stein;
import static org.lwjgl.opengl.GL11.*;
public class Steinhaufen {
	
	
	
	private int anzSteineImHaufen;

	public Steinhaufen(int anzSteineImHaufen) {
		this.anzSteineImHaufen = anzSteineImHaufen;
	}
	
	public void drawSteinhaufen() {
		
		for(int i=0; i<anzSteineImHaufen;i++) {
				
					glTranslatef((float)Math.cos(i*2*Math.PI/anzSteineImHaufen),0,(float)Math.sin(i*2*Math.PI/anzSteineImHaufen));
			
			
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	int m= (int) (Math.random()*4 +3);
//	int n = (int) (Math.random()*5 +3);
//	
//	
//	private int anzSteineImHaufen;
//	private int[] zufallszahlen = new int[getAnzSteineImHaufen()];
//	
//	Stein stein0,stein1,stein2,stein3,stein4,stein5,stein6,stein7,stein8,stein9,stein10,stein11,stein12,stein13,stein14,stein15,stein16,stein17,stein18,stein19,stein20,stein21,stein22,stein23,stein24,stein25,stein26,stein27,stein28,stein29;
//	Stein[] steinhaufen = {stein0,stein1,stein2,stein3,stein4,stein5,stein6,stein7,stein8,stein9,stein10,stein11,stein12,stein13,stein14,stein15,stein16,stein17,stein18,stein19,stein20,stein21,stein22,stein23,stein24,stein25,stein26,stein27,stein28,stein29};
//	
//	
//	public Steinhaufen(int anzSteineImHaufen) {
//		this.anzSteineImHaufen = anzSteineImHaufen;
//	}
//	public void erzeugeSteineImSteinhaufen() {
//		boolean stop = false;
//		if(stop == false) {
//			for(int i = 0; i<30;i++) {
//			steinhaufen[i] = new Stein(m,n);
//		}	
//		stop = true;
//		}
//	}
//	public void drawSteinhaufen() {
//		erzeugeSteineImSteinhaufen();
//		erzeugeZufallszahlen();
//		for(int i=0;i<anzSteineImHaufen-2;i++) {
//			glTranslatef(0.3f*i,0,0);
//			steinhaufen[getZufallszahl(i)].drawStein();
//		}
//	}
//	public void erzeugeZufallszahlen() {
//		boolean stop = false;
//		if(stop == false) {
//		for(int i=0; i < anzSteineImHaufen-2;i++) {
//			zufallszahlen[i] =(int)(Math.random()*29);
//		}
//		stop = true;
//		}
//		}
//
//	
//	// Getter / Setter
//	public void setAnzSteineImHaufen(int anzSteineImHaufen) {
//		this.anzSteineImHaufen = anzSteineImHaufen;
//	}
//	public int getAnzSteineImHaufen() {
//		return anzSteineImHaufen;
//	}
//	public int getZufallszahl(int i) {
//		
//		return zufallszahlen[i];
//	}
	}

