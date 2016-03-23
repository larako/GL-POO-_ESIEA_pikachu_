package pokemon.pokemon;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class StatInterface extends JPanel{
	public int pokemonId1;
	public int pokemonId2;
	
	public StatInterface(){
	}
	
	public void lancement() {
	repaint();	
	}
	
	public void paintComponent(Graphics g){
		try {
			Image imgPokemon1 = ImageIO.read(new File("images/pikachuDos.png"));
			g.drawImage(imgPokemon1, -150, 220, this);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//System.out.println("a"+ pokemonId1);
	
	}
	
	public void setPokemonID1 (int pokemonID1){
		pokemonId1=pokemonID1;
	}
	public void setPokemonID2 (int pokemonID2){
		pokemonId2=pokemonID2;
	}
	
}
