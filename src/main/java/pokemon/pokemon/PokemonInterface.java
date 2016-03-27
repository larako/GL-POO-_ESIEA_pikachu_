package pokemon.pokemon;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PokemonInterface extends JPanel{
	public int boule1;
	public int pokemonID1;
	public String nomPokemon1;
	public int boule2;
	public int pokemonID2;
	public String nomPokemon2;
	StatInterface stat= new StatInterface();
	JFrame frame=new JFrame();
	
	public PokemonInterface(){
		
		frame.setSize(1000,500);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(1,2));
	    container.add(this);
	    container.add(stat);
	    frame.add(container);
			
		repaint();
	}
	
	
	public void paintComponent (Graphics g){
	
		
		try {

			Image arrierePlan = ImageIO.read(new File("images/desert.png"));
			g.drawImage(arrierePlan, 0, 0, this);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EuromillionDAO eurom= new EuromillionDAO();
		boule1=eurom.boule1Aleatoire();
		boule2=eurom.boule2Aleatoire();
		
		pokemonID1=boule1%12+1;
		pokemonID2=boule2%12+1;
		//on va chercher le pokemon a l'id pokemon1
		
		Pokemon pokemon1=new Pokemon(pokemonID1);
		Pokemon pokemon2=new Pokemon(pokemonID2);
		
		nomPokemon1=pokemon1.getName();
		nomPokemon2=pokemon2.getName();
		
		System.out.println("aa"+pokemonID2+" "+nomPokemon1+" "+nomPokemon2);
		try {
			Image imgPokemon1 = ImageIO.read(new File("images/"+nomPokemon1+"Dos.png"));
			g.drawImage(imgPokemon1, -150, 220, this);
			Image imgPokemon2 = ImageIO.read(new File("images/"+nomPokemon2+".png"));
			g.drawImage(imgPokemon2, 100, -150, this);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stat.setPokemonID1(pokemonID1);
		stat.setPokemonID2(pokemonID2);
		stat.lancement();
		
	}	
	

}

