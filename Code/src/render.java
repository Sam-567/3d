import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Arrays;

import javax.swing.JPanel;

public class render extends JPanel{
	
	final static int ToScreen = 50;
	render(){
		super();
		
	}
	
	@Override
	public void paintComponent(Graphics G){
		Graphics2D g = (Graphics2D) G;
		super.paintComponent(G);
		
		drawGridFloor(g);
		
		//testPoints();
	}

	public void drawGridFloor(Graphics2D g) {
		
		int[] points= new int[3];
		int x = 0;
		int y = -50;
		int z = 100;
		/*
		z = 100;
		points[0] = x;
		points[1] = y;
		points[2] = z;
		g.drawPolygon( drawSquare(points, 50) );
		
		z = 200;
		points[0] = x;
		points[1] = y;
		points[2] = z;
		g.drawPolygon( drawSquare(points, 50) );
		*/
		while (x < 100) {
			while (z < 300) {
				points[0] = x;
				points[1] = y;
				points[2] = z;
				g.drawPolygon( drawSquare(points, 50) );
				
				z+= 100;
			}
			x+= 100;
			z = 0;
		}
	}
	
	public Polygon drawSquare(int[] center, int width) {
		Polygon p = new Polygon();
		
		int TopRight[] = { center[0]+width, center[1], center[2]+width };
		int ViewTopRight[] = PointOnScreen(TopRight);
		p.addPoint( ViewTopRight[0], ViewTopRight[1]);
		
		int TopLeft[] = { center[0]-width, center[1], center[2]+width };
		int ViewTopLeft[] = PointOnScreen(TopLeft);
		p.addPoint( ViewTopLeft[0], ViewTopLeft[1]);
		
		int BottomLeft[] = { center[0]-width, center[1], center[2]-width };
		int ViewBottomLeft[] = PointOnScreen(BottomLeft);
		p.addPoint( ViewBottomLeft[0], ViewBottomLeft[1]);
		
		int BottomRight[] = { center[0]+width, center[1], center[2]-width };
		int ViewBottomRight[] = PointOnScreen(BottomRight);
		p.addPoint( ViewBottomRight[0], ViewBottomRight[1]);
		
		return p;
	}

	public void testPoints() {
		int[] points = new int[3];
		points[0] = 50;
		points[1] = 50;
		points[2] = 100;
		//System.out.println( "Top Right: " + Arrays.toString(PointOnScreen(points)) );
		PointOnScreen(points);
		
		points[0] = -50;
		//System.out.println( "Top Left: " + Arrays.toString(PointOnScreen(points)) );
		PointOnScreen(points);
		
		points[1] = -50;
		//System.out.println( "Bottom Left: " + Arrays.toString(PointOnScreen(points)) );
		PointOnScreen(points);
		
		points[0] = 50;
		//System.out.println( "Bottom Right: " + Arrays.toString(PointOnScreen(points)) );
		PointOnScreen(points);
		
	}
	
	public int[] PointOnScreen(int[] points) {
		//TODO account for things out of FOV
		int[] loc = new int[2];
		
		double centerDistance = Math.tan( OutwardsAngle(points)) * ToScreen;
		
		double RadialAngle = RadialAngle( points );		
		double x = centerDistance * Math.cos(RadialAngle);
		double y = centerDistance * Math.sin(RadialAngle);
		
		//account for sin/cos ignoring values more than 90* (left side of unit circle)
		if ( points[0] < 0) {
			x *= -1;
			y *= -1;
		}
		

		System.out.println("Points | x:  " + x + " Y: " + y + "\n");

		//Center
		x += 400;
		y += 300;
		
		loc[0] = (int) x;
		loc[1] = (int) y;
		
		
		return loc;
	}
	
	public double RadialAngle(int[] points) {
		int x = points[0];
		int y = points[1];
		int z = points[2];
		
		double angle = Math.atan( x / y );
		System.out.println("Rad angle: " + angle + " | x: " + x + " | y: " + y);
		return angle;
	}
	
	public double OutwardsAngle(int[] points) {
		int x = points[0];
		int y = points[1];
		int z = points[2];
		
		double opp = Math.sqrt(x*x + y*y);
		double angle = Math.atan(opp/z);

		System.out.println("Out angle: " + angle);
		return angle;
	}
	
	public void testPolygon() {
		
	}
}
