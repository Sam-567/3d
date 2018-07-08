import javax.swing.JFrame;
import javax.swing.JPanel;

public class Host extends JFrame implements Runnable{
	
	render draw;
	
	public static void main(String[] args) {
		new Host();
	}
	
	Host(){
		this.setSize(800, 600);
		draw = new render();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.add(draw);
		
		this.setVisible(true);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
