package pokemon.pokemon;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Window(){
		
		this.setTitle("Pokemon");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
		GraphicalInterface inter= new GraphicalInterface();
		this.add(inter, BorderLayout.CENTER);
		//inter.lancement();
		
	}
	
	

}
