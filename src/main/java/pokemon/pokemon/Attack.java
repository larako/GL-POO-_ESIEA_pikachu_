package pokemon.pokemon;

import java.util.ArrayList;

public class Attack {
	
	private String name;
	private String type;
	private int value;
	private int pp;
	
	public Attack(int id) {
		ArrayList<String> info = SQLPokemon.getAttackInfo(id);
		this.name = info.get(0);
		this.type = info.get(1);
		if (info.get(2).equals(""))
			this.value = -1;
		else
			this.value = Integer.parseInt(info.get(2));
		this.pp = Integer.parseInt(info.get(3));
	}
	
	public String toString() {
		return "{name : " + this.name + ", type : " + this.type
				+ ", value : " + this.value + ", value : " + this.value
				+ " number: " + this.pp + " }";
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getPp() {
		return this.pp;
	}
}
