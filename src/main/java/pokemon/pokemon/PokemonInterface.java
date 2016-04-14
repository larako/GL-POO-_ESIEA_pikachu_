package pokemon.pokemon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

public class PokemonInterface extends JPanel implements ActionListener{
	
	private static final Logger LOGGER = Logger.getLogger(PokemonInterface.class);
	
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
	private boolean deplacementPok1=false;
	private boolean deplacementPok2=false;
	private int x1=-150;
	private int x2=100;
	private int y1=420;
	private int y2=-50;
	public MoteurDeJeu jeu;
	private boolean test= false;
	private boolean gameOver=false;
	private Attack a;
	private int lifeMax1 = 0;
	private int lifeMax2 = 0;

	public PokemonInterface(){
		  EuromillionDAO eurom= new EuromillionDAO();
		  
			boule1=eurom.boule1Aleatoire();
			boule2=eurom.boule2Aleatoire();
			
			
			pokemonID1=boule1%12+1;
			pokemonID2=boule2%12+1;
		
	    pokemon1=new Pokemon(pokemonID1);
		pokemon2=new Pokemon(pokemonID2);
		attackPokemon=new Pokemon(pokemonID1);
		
		stat = new StatInterface(pokemon1,pokemon2);
		
		frame.setSize(800,840);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);    
        
		JPanel container = new JPanel();
		container.setLayout(new GridLayout());
	    container.add(this);
	    //container.add(stat);
	    frame.add(container);
        
	    attack1=attackPokemon.getAtta().get(0).getName();
		attack2=attackPokemon.getAtta().get(1).getName();
		attack3=attackPokemon.getAtta().get(2).getName();
		attack4=attackPokemon.getAtta().get(3).getName();

		this.setLayout(null);
		
		JButton nomAttack1= new JButton(""+attack1);
		nomAttack1.addActionListener(this);
		nomAttack1.setBounds(200,650,140,20);
		nomAttack1.setActionCommand("1"); 
		this.add(nomAttack1);
	    this.setVisible(true);
	    
	    JButton nomAttack2= new JButton(""+attack2);
		nomAttack2.addActionListener(this);
		nomAttack2.setBounds(200,620,140,20);
		nomAttack2.setActionCommand("2");
	    this.add(nomAttack2);
	    this.setVisible(true);
	    
	    JButton nomAttack3= new JButton(""+attack3);
		nomAttack3.addActionListener(this);
		nomAttack3.setActionCommand("3");
		nomAttack3.setBounds(350,620,140,20);
	    this.add(nomAttack3);
	    this.setVisible(true);
	    
	    JButton nomAttack4= new JButton(""+attack4);
		nomAttack4.addActionListener(this);
		nomAttack4.setActionCommand("4");
		nomAttack4.setBounds(350,650,140,20);
	    this.add(nomAttack4);
	    this.setVisible(true);
	    lifeMax1 = pokemon1.getHp();
	    lifeMax2 = pokemon2.getHp();
			
		repaint();
		jeu = new MoteurDeJeu(pokemon1,pokemon2);	
	}
	
	public Pokemon getPokemon(int number){
    	if (number==1) return pokemon1;
    	else return pokemon2;
    }
	
	/*-----*/
	
	
	
	public void life(Graphics g){

		if ((pokemon1.getHp()*2)>lifeMax1)g.setColor(Color.GREEN);
		else g.setColor(Color.RED);
		g.fillRoundRect(210, 501, (100*pokemon1.getHp())/lifeMax1, 9 ,10, 10);
		
		if ((pokemon2.getHp()*2)>lifeMax2)g.setColor(Color.GREEN);
		else g.setColor(Color.RED);
		g.fillRoundRect(570, 171, (100*pokemon2.getHp())/lifeMax2, 9, 10, 10);
		
		
		g.setColor(Color.black);
		g.drawRoundRect(210, 500, 100, 10, 10, 10);
		g.drawRoundRect(570, 170, 100, 10, 10, 10);
	}
	
	/*------*/
	
	public void paintComponent (Graphics g){	
		
		
		if (deplacementPok1){
			if (x1 < -100){
				x1 = x1 + 60;
			}
			else{
				deplacementPok1 = false;
				deplacementPok2 = true; //ensuite on fait se deplacer l'IA 1s apres 	
				x1 = -150;
			}
		}		
		
		
		try {

			Image arrierePlan = ImageIO.read(new File("images/desert.png"));
			g.drawImage(arrierePlan, 0, 0,800,840, this);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.nomPokemon1 = pokemon1.getName();
		this.nomPokemon2 = pokemon2.getName();
		
	//	System.out.println("aa"+pokemonID2+" "+nomPokemon1+" "+nomPokemon2);
		try {
			Image imgPokemon1 = ImageIO.read(new File("images/"+nomPokemon1+"Dos.png"));
			g.drawImage(imgPokemon1, x1, y1, this);
			Image imgPokemon2 = ImageIO.read(new File("images/"+nomPokemon2+".png"));
			g.drawImage(imgPokemon2, x2, y2, this);
				
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		life(g);
		stat.setPokemonID1(pokemonID1);
		stat.setPokemonID2(pokemonID2);
		stat.paintComponent(g);
		//stat.lancement();
		
		if (deplacementPok2){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			if (x2>50){
			x2=x2-60;
		}
		else{
			deplacementPok2=false;
			x2=100;		
		}		
			
	}
		if(gameOver)
		{
			
			setBackground(Color.black);
			Font font = new Font("Courier", Font.BOLD, 20);
			g.setFont(font);
			g.setColor(Color.red);
			int x = this.getWidth() / 2;
			int y = this.getHeight() / 2;
			g.drawString("Game Over", x, y);
			g.drawString("the Winner is : "+jeu.Winner().getName(),x,y+30);
			//default title and icon
			
			//JOptionPane.showMessageDialog(frame, "Game Over"+" the Winner is : "+jeu.Winner().getName());
			//System.exit(0); 
		}
		
		if(a!=null){
		Font font = new Font("Arial", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.black);
		
		if(a.getPp()==0){
			g.drawString("L'attaque n'est plus disponible! ",200,750);
			
		}
		else {
		if(a.getValue()>0)
		g.drawString("Vous avez choisi l'attaque: "+a.getName()+" d'une valeur de: "+a.getValue(),100,750);
		else
			g.drawString("Vous avez choisi l'attaque: "+a.getName(),200,750);
		}
		}
		
		else{
			Font font = new Font("Arial", Font.BOLD, 20);
			g.setFont(font);
			g.setColor(Color.black);
			g.drawString("Vous avez : "+pokemon1.getName()+" et vous affrontez: "+pokemon2.getName(),150,750);
		}
		repaint();
				
			
	}
	public void actionPerformed(ActionEvent  e) {	
		if(e.getActionCommand().equals("1") && !gameOver){
			
			deplacementPok1=true;
			repaint();
			LOGGER.debug("attaque 1");
			jeu.choiceAttaque(attackPokemon.getAtta().get(0));
			a=attackPokemon.getAtta().get(0);
			if(jeu.gameOver()) gameOver=true;;
			
			
		}
		if(e.getActionCommand().equals("2") && !gameOver){
			
			deplacementPok1=true;
			repaint();
			LOGGER.debug("attaque 2");
			jeu.choiceAttaque(attackPokemon.getAtta().get(1)); 
			a=attackPokemon.getAtta().get(1);
			if(jeu.gameOver()) gameOver=true;;
		}
		if(e.getActionCommand().equals("3") && !gameOver){
						
			deplacementPok1=true;
			repaint();
			LOGGER.debug("attaque 3");
			jeu.choiceAttaque(attackPokemon.getAtta().get(2));
			a=attackPokemon.getAtta().get(2);
			if(jeu.gameOver()) gameOver=true;;
		}
		if(e.getActionCommand().equals("4") && !gameOver){
			
			deplacementPok1=true;
			repaint();
			LOGGER.debug("attaque 4");
			jeu.choiceAttaque(attackPokemon.getAtta().get(3));
			a=attackPokemon.getAtta().get(3);
			if(jeu.gameOver()) gameOver=true;;
		}
		
	}

}

	