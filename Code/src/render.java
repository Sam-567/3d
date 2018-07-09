import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Arrays;

import javax.swing.JPanel;

public class render extends JPanel{
	
	final static int ToScreen = 100;
	render(){
		super();
		
	}
	
	@Override
	public void paintComponent(Graphics G){
		Graphics2D g = (Graphics2D) G;
		super.paintComponent(G);
		
		Polygon p = new Polygon();
		g.drawPolygon( p );
	}

	
	public Polygon drawFace(int SFront, int SBack, int Width) {
	}
	
	public int[] PointOnScreen(int[] points) {
		int x = points[0];
		int y = points[1];
		int z = points[2];
		
		int[] loc = new int[2];
		
		double centerDistance = Math.tan( OutwardsAngle(points)) * ToScreen;
		
		loc[0] = x;
		loc[1] = y;
		
		return loc;
	}
	

	public double RadialAngle(int[] points) {
		int x = points[0];
		int y = points[1];
		int z = points[2];
		
		double angle = Math.atan( x /y );
		return angle;
	}
	
	public double OutwardsAngle(int[] points) {
		int x = points[0];
		int y = points[1];
		int z = points[2];
		
		double opp = Math.sqrt(x^2 + y^2);
		double angle = Math.atan(opp/z);
		
		return angle;
	}
	
	public void testPolygon() {
		
	}
}
