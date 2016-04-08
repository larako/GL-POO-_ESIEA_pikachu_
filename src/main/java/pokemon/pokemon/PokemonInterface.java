package pokemon.pokemon;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PokemonInterface extends JPanel implements ActionListener{
	public int boule1;
	public int pokemonID1;
	public String nomPokemon1;
	public int boule2;
	public int pokemonID2;
	public String nomPokemon2;
	StatInterface stat;
	JFrame frame=new JFrame();
	public static Pokemon pokemon1;
	public static Pokemon pokemon2;
	public static Pokemon attackPokemon;
	private String name;
	public String attack1;
	public String attack2;
	public String attack3;
	public String attack4;
	public MoteurDeJeu jeu;
	private boolean gameOver=false;

	public PokemonInterface(){
		  EuromillionDAO eurom= new EuromillionDAO();
		  
			boule1=eurom.boule1Aleatoire();
			boule2=eurom.boule2Aleatoire();
			
			pokemonID1=boule1%12+1;
			pokemonID2=boule2%12+1;
		
	    pokemon1=new Pokemon(pokemonID1);
		pokemon2=new Pokemon(pokemonID2);
		attackPokemon=new Pokemon(pokemonID1);
		stat=new StatInterface(pokemon1,pokemon2);
		frame.setSize(1200,600);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);    
        
		JPanel container = new JPanel();
		container.setLayout(new GridLayout(1,2));
	    container.add(this);
	    container.add(stat);
	    frame.add(container);
        
	    attack1=attackPokemon.getAtta().get(0).getName();
		attack2=attackPokemon.getAtta().get(1).getName();
		attack3=attackPokemon.getAtta().get(2).getName();
		attack4=attackPokemon.getAtta().get(3).getName();

		this.setLayout(null);
		
		JButton nomAttack1= new JButton(""+attack1);
		nomAttack1.addActionListener(this);
		nomAttack1.setBounds(200,450,140,20);
		nomAttack1.setActionCommand("1"); 
		this.add(nomAttack1);
	    this.setVisible(true);
	    
	    JButton nomAttack2= new JButton(""+attack2);
		nomAttack2.addActionListener(this);
		nomAttack2.setBounds(200,420,140,20);
		nomAttack2.setActionCommand("2");
	    this.add(nomAttack2);
	    this.setVisible(true);
	    
	    JButton nomAttack3= new JButton(""+attack3);
		nomAttack3.addActionListener(this);
		nomAttack3.setActionCommand("3");
		nomAttack3.setBounds(350,420,140,20);
	    this.add(nomAttack3);
	    this.setVisible(true);
	    
	    JButton nomAttack4= new JButton(""+attack4);
		nomAttack4.addActionListener(this);
		nomAttack4.setActionCommand("4");
		nomAttack4.setBounds(350,450,140,20);
	    this.add(nomAttack4);
	    this.setVisible(true);
			
		repaint();
		jeu=new MoteurDeJeu(pokemon1,pokemon2);	
	}
	
	public Pokemon getPokemon(int number){
    	if (number==1) return pokemon1;
    	else return pokemon2;
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
		
		
		this.nomPokemon1=pokemon1.getName();
		this.nomPokemon2=pokemon2.getName();
		
	//	System.out.println("aa"+pokemonID2+" "+nomPokemon1+" "+nomPokemon2);
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
	public void actionPerformed(ActionEvent  e) {	
		if(e.getActionCommand().equals("1") && !gameOver){
			
			System.out.println("attaque 1");
			jeu.choiceAttaque(attackPokemon.getAtta().get(0)); 
			if(jeu.gameOver()) gameOver=true;;
		}
		if(e.getActionCommand().equals("2") && !gameOver){
			System.out.println("attaque 2");
			jeu.choiceAttaque(attackPokemon.getAtta().get(1)); 
			if(jeu.gameOver()) gameOver=true;;
		}
		if(e.getActionCommand().equals("3") && !gameOver){
			System.out.println("attaque 3");
			jeu.choiceAttaque(attackPokemon.getAtta().get(2));
			if(jeu.gameOver()) gameOver=true;;
		}
		if(e.getActionCommand().equals("4") && !gameOver){
			System.out.println("attaque 4");
			jeu.choiceAttaque(attackPokemon.getAtta().get(3));
			if(jeu.gameOver()) gameOver=true;;
		}
		
	}

}

	