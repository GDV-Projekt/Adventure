package Stein;
import static org.lwjgl.opengl.GL11.*;

public class InitialisiereSteine {
	
	
	Stein stein1= new Stein(12,8,0);
	Stein stein2= new Stein(12,8,2);
	Stein stein3= new Stein(12,8,1);
	Stein stein4= new Stein(12,8,1);
	Stein stein5= new Stein(12,8,0);
	Stein stein6= new Stein(12,8,2);
	Stein stein7= new Stein(12,8,2);
	Stein stein8= new Stein(12,8,0);
	Stein stein9= new Stein(12,8,1);
	Stein stein10= new Stein(12,8,2);
	Stein stein11= new Stein(12,8,0);
	Stein stein12= new Stein(12,8,2);
	Stein stein13= new Stein(12,8,2);
	Stein stein14= new Stein(12,8,1);
	Stein stein15= new Stein(12,8,1);
	Stein stein16= new Stein(12,8,0);
	Stein stein17= new Stein(12,8,2);
	Stein stein18= new Stein(12,8,1);
	Stein stein19= new Stein(12,8,1);
	Stein stein20= new Stein(12,8,0);
	
	float posX;
	float posZ;
	
	
	
	Stein[] steine = {stein1,stein2,stein3,stein4,stein5,stein6,stein7,stein8,stein9,stein10,stein11,stein12,stein13,stein14,stein15,stein16,stein17,stein18,stein19,stein20};
	public InitialisiereSteine(float posX, float posZ){
		this.posX = posX;
		this.posZ = posZ;
	}
	public void initialisiereSteine() {
		for(int i=0;i<19;i++) {
			if(i<5) {
				glPushMatrix();
				glTranslatef(posX,0,posZ -i/2);
				steine[i].drawStein();
			glPopMatrix();
			}
			if(i>=5 && i <10) {
				glPushMatrix();
					glTranslatef(posX +1,0,posZ - i/2);
					steine[i].drawStein();
				glPopMatrix();
			}
			if(i>=10 && i <19) {
				glPushMatrix();
				glTranslatef(posX +2,0,posZ - i/2);
				steine[i].drawStein();
				glPopMatrix();
			}
			
		}
		
		
//		stein2.drawStein();
//		stein3.drawStein();
//		stein4.drawStein();
//		stein5.drawStein();
//		stein6.drawStein();
//		stein7.drawStein();
//		stein8.drawStein();

	}
	

}
