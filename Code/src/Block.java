import java.awt.Polygon;
import java.awt.Shape;

public class Block {
	boolean visible;
	//XY is center point
	//X Forward
	//Y Left/Right

	int x;
	int y;
	static final int HALF_BLOCK = 50;
	static final int FULL_BLOCK = 100;
	static final int SCREEN_WIDTH = 800;
	static final int SCREEN_HEIGHT = 600;
	
	Block(int x, int y){
		super();
		this.x = x;
		this.y = y;
	}
	
	Polygon drawTopFace(int XView, int YView, int ZView) {
		
		Polygon p = new Polygon();
		
		
		p.addPoint( (int) XClose, (int) YCloseLeft);
		p.addPoint( (int) XClose, (int) YCloseRight);
		p.addPoint( (int) XFar, (int) YFarRight);
		p.addPoint( (int) XFar, (int) YFarLeft);
		
		System.out.println( XClose + " " + YCloseLeft);
		System.out.println( XClose + " " + YCloseRight);
		System.out.println( XFar + " " + YFarRight);
		System.out.println( XFar + " " + YFarLeft);
		
		return p;
		
	}
}
