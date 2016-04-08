package pokemon.pokemon;


public class MoteurDeJeu {
	
    public Pokemon joueur;
    public Pokemon IA;
    public static Pokemon start;
    public static Pokemon turn;
    private int boule1,boule2;
    private int pokemonID1,pokemonID2;
	private Attack a;
	private Attack IAattack;
	public boolean gameOver=false;
	
    public MoteurDeJeu(Pokemon pokemon1,Pokemon pokemon2){
    	
			this.joueur=pokemon1;
			this.IA=pokemon2;
			System.out.println(joueur);
		    start=whoStart();
		    
	}       	
    
    public boolean RapportSpeed(){
    	double result=0;
    	result=(double) joueur.getSpeed()/IA.getSpeed();
    	int random= (int)Math.random()*10;
    	if(random<result) return true;
    	else return false;
    }
 
    
    public Attack IARandomAttack(){
    	int random=(int) Math.random()*4;
    	return IA.getAtta().get(random);    	
    }
	
    public void attaquer(Attack chosen,Pokemon pok1,Pokemon pok2){
    	int division= chosen.getValue() / pok1.getAtt();
    	int somme;
    	
    	if(division<1)
    	somme= Math.abs(division*10-pok2.getDef());
    	
    	else somme=Math.abs(division-pok2.getDef());
    	
    	chosen.setPp(chosen.getPp()-1);
    	int hp=pok2.getHp();
    	pok2.setHp(hp-somme);
    	if(pok2.getHp()<=0){
    		gameOver=true;
    	}
    }
    
    public void choiceAttaque(Attack a){    	
           this.a=a;;
           JoueurPlay();
    }
    
    public Pokemon whoStart(){
    	 boolean startI;
    	Pokemon startP;
        /*pokemon qui commence*/
        
        startI=RapportSpeed();
        if(startI) startP=joueur;
        else startP=IA;
        
        System.out.println("Pokemon start "+startP);
        turn=startP;
        if(startP==IA) JoueurPlay();
        return startP;
    	
    }
    
    public void JoueurPlay(){   
    	
        if(turn==joueur){
        	
    		System.out.println("Voici les différentes attaques. Choisissez en une");
    		System.out.println(joueur.getAttacks());
    	

    		System.out.println("Vous avez Choisi"+ a);
    		attaquer(a,joueur,IA);
    		System.out.println("HP de l'IA: "+ IA.getHp());
    		turn=IA;
    		JoueurPlay();
        }
        
        
        
        else{
        	IAattack=IARandomAttack();
        	attaquer(IAattack,IA,joueur);
        	turn=joueur;
        }
    }
    
}
