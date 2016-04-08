package pokemon.pokemon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;





public class StatInterface extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int pokemonId1;
	public int pokemonId2;
	private int hpP1;
	private String nomPokemon1;
	private int attaqueP1;
	private int defP1;
	private int speedP1;
	private int hpP2;
	private String nomPokemon2;
	private int attaqueP2;
	private int defP2;
	private int speedP2;
	
	
	
	public StatInterface(){
		 
		
	}
	
	public void lancement() {
	repaint();	
	}
	
	
	public void paintComponent(Graphics g){
				
		if(pokemonId1!=0 && pokemonId2!=0){
			Pokemon pokemon1=new Pokemon(pokemonId1);
			Pokemon pokemon2=new Pokemon(pokemonId2);	

			//Stats Pokemon1
			hpP1=pokemon1.getHp();
			nomPokemon1=pokemon1.getName();
			attaqueP1=pokemon1.getAtt();
			speedP1=pokemon1.getSpeed();
			defP1=pokemon1.getDef();
			
			//Stats Pokemon2
			hpP2=pokemon2.getHp();
			nomPokemon2=pokemon2.getName();
			attaqueP2=pokemon2.getAtt();
			speedP2=pokemon2.getSpeed();
			defP2=pokemon2.getDef();
			
			Font f= new Font("Courrier",Font.ITALIC,15);
			g.setFont(f);
			g.setColor(Color.BLACK);
			
			g.drawString("Nom Pokemon: "+nomPokemon2,100,50);
			g.drawString("HP: "+hpP2,150,80);
			g.drawString("Attaque: "+attaqueP2,150,110);
			g.drawString("Vitesse: "+speedP2,150,140);
			g.drawString("Defense: "+defP2,150,170);
			
			g.drawString("Nom Pokemon: "+nomPokemon1,100,280);
			g.drawString("HP: "+hpP1,150,310);
			g.drawString("Attaque: "+attaqueP1,150,340);
			g.drawString("Vitesse: "+speedP1,150,370);
			g.drawString("Defense: "+defP1,150,400);
			//System.out.println("a"+ hp);
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
