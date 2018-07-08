import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Arrays;

import javax.swing.JPanel;

public class render extends JPanel{
	
	Block one, two;
	render(){
		super();
		one = new Block(100, 0);
		two = new Block(200, 0);
		
	}
	
	@Override
	public void paintComponent(Graphics G){
		Graphics2D g = (Graphics2D) G;
		super.paintComponent(G);
		
		Polygon p = new Polygon();
		p.addPoint(200, 200);
		p.addPoint(200, 400);
		p.addPoint(300, 400);
		p.addPoint(300, 200);
		g.drawPolygon(p);

		Polygon close = drawFace (100, 200, 100);
		Polygon far = drawFace (200, 300, 100);
		
		g.drawPolygon( close );
		g.drawPolygon( far );
		g.drawPolygon( drawFace (300, 400, 100) );
		/*g.drawPolygon( drawFace (400, 500, 100) );
		g.drawPolygon( drawFace (500, 600, 100) );
		g.drawPolygon( drawFace (600, 700, 100) );
		g.drawPolygon( drawFace (700, 800, 100) );*/
		
		
	}

	
	public Polygon drawFace(int SFront, int SBack, int Width) {
		assert(false);
		
		int ZHeight = 50;
		double Scale = 300/Math.PI;
		//Assuming looking forward
		
		double MFront = Math.atan( SFront / ZHeight ) * Scale;
		double MBack = Math.atan( SBack / ZHeight ) * Scale;
		
		double RealFront = Math.sqrt(SFront^2 + ZHeight^2);
		double RealBack = Math.sqrt(SBack^2 + ZHeight^2);
		
		double FrontLeft = Math.atan( -Width / (2*RealFront) ) * Scale;
		double FrontRight = Math.atan( Width / (2*RealFront) ) * Scale;
		
		double BackLeft = Math.atan( -Width / (2*RealBack) ) * Scale;
		double BackRight = Math.atan( Width / (2*RealBack) ) * Scale;
		
		Polygon p = new Polygon();
		p.addPoint( (int) FrontLeft + 400, (int) MFront + 200);
		p.addPoint( (int) FrontRight + 400, (int) MFront + 200);
		p.addPoint( (int) BackRight + 400, (int) MBack + 200);
		p.addPoint( (int) BackLeft + 400, (int) MBack + 200);
		
		System.out.println( "X points " + Arrays.toString(p.xpoints) );
		System.out.println( "Y points " + Arrays.toString(p.ypoints) );
		System.out.println("Next \n");
		
		return p;
	}
	
	public void testPolygon() {
		
	}
}
