package pokemon.pokemon;

import java.util.ArrayList;

public class Pokemon {
	
	private String name;
	private int hp;
	private int att;
	private int def;
	private int speed;
	private ArrayList<Attack> attacks;
	private String sprite;
	
	// Génération du pokemon avec son ID BDD
	public Pokemon(int id) {
		ArrayList<String> info = SQLPokemon.getPokemonInfo(id);
		if (info.isEmpty()) System.out.println("FATAL ERROR: can't get pokemon info, id = " + id);
		this.name = info.get(0);
		this.sprite = info.get(1);
		this.attacks = getAttacks(info.get(2));
		this.hp = Integer.parseInt(info.get(3));
		this.att = Integer.parseInt(info.get(4));
		this.def = Integer.parseInt(info.get(5));
		this.speed = Integer.parseInt(info.get(6));
		
	}
	
	/*
	 * Getter
	 */
	
	public String getName() {
		return this.name;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public int getAtt() {
		return this.att;
	}

	
	public int getDef() {
		return this.def;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public String getStringAttacks(){
		String attacks = "\t";
		for (Attack attack : this.attacks) {
			attacks += attack + "\n\t";
		}
		return attacks;
	}
	
	public ArrayList<Attack> getAtta(){
		return this.attacks;
	}
	
	public String getSprite() {
		return this.sprite;
	}
	
	public ArrayList<Attack> getAttacks() {
		return this.attacks;
	}
	
	/*
	 * Setter
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void setAtt(int att) {
		this.att = att;
	}
	
	public void setDef(int def) {
		this.def = def;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	/*
	 * Affichage info pokemon
	 * 
	 */
	
	public String toString() {
		return "Nom: " + getName() + "\n" + "Hp: " + getHp() + "\n" + "Def: " 
				+ getDef() + "\n" + "Speed: " + getSpeed() + "\n"
				+ "Attacks: \n" + getAttacks();
	}
	
	/*
	 * Les attaques sont stockées sous forme de chaine de caractères,
	 * séparées par des virugules.
	 * On split la String pour récupérer les attaques
	 * 
	 */
	public ArrayList<Attack> getAttacks(String attacks) {
		ArrayList<Attack> attacksList = new ArrayList<Attack>();
		for(String attack : attacks.split(",")) {
			attacksList.add(new Attack(Integer.parseInt(attack)));
		}
		return attacksList;
	}
	
	
}
