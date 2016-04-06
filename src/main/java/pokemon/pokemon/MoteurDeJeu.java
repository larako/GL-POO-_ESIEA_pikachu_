package pokemon.pokemon;

import java.util.ArrayList;
import java.util.Scanner;

public class MoteurDeJeu {
    public Pokemon joueur;
    public Pokemon IA;
    
  /*  private String Jname;
	private int Jhp;
	private int Jatt;
	private int Jdef;
	private int Jspeed;
	private ArrayList<Attack> Jattacks;
	private String Jattack;
	private String Jsprite;
	
	private String IAname;
	private int IAhp;
	private int IAatt;
	private int IAdef;
	private int IAspeed;
	private String IAattack;
	private ArrayList<Attack> IAattacks;
	private String IAsprite;*/
    
    private int boule1,boule2;
    private int pokemonID1,pokemonID2;
	
    public MoteurDeJeu(Pokemon pokemon1,Pokemon pokemon2){
    	
			this.joueur=pokemon1;
			this.IA=pokemon2;
			System.out.println(joueur);
		    JoueurPlay();
	}
    
    
	
    public double RapportSpeedBegin(){
    	double result=0;
    	result=(double) joueur.getSpeed()/IA.getSpeed();
    	return result;
    }
    
    public boolean RapportSpeed(){
    	double result=0;
    	result=(double) joueur.getSpeed()/IA.getSpeed();
    	int random= (int)Math.random()*10;
    	if(random<result) return true;
    	else return false;
    }
    
    public Pokemon tour(int n, Pokemon begin){
    	if(n==0) return begin;
    	else{
    		if(begin==joueur) return IA;
    		else return joueur;
    	}
    }
    
    public Attack IARandomAttack(){
    	int random=(int) Math.random()*4;
    	return IA.getAtta().get(random);    	
    }
	
    public void attaquer(Attack chosen,Pokemon pok1,Pokemon pok2){
    	int somme= chosen.getValue() + pok1.getAtt()-pok2.getDef();
    	chosen.setPp(chosen.getPp()-1);
    	pok2.setHp(somme);
    }
    
    public void JoueurPlay(){
        int n=0;
        double startI=0;
        Pokemon startP;
        
        /*pokemon qui commence*/
        /*
        startI=RapportSpeedBegin();
        if(startI>1) startP=joueur;
        else startP=IA;
        
        System.out.println("Pokemon start "+startP);*/
        
        
        
        
        
/* test choix d'attaque + attaque*/
    	Scanner scan = new Scanner(System.in); 
    	System.out.println("Voici les différentes attaques. Choisissez en une");
    	System.out.println(joueur.getAttacks());
    	int choice = scan.nextInt(); 
    	Attack a = joueur.getAtta().get(choice);
    	System.out.println("Vous avez Choisi"+ a);
    	attaquer(a,joueur,IA);
    	System.out.println("HP de l'IA: "+ IA.getHp());
    	
    }
    
}
