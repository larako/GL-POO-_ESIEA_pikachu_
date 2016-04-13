package pokemon.pokemon;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

import java.util.ArrayList;


public class MyPokemonTest {
	
	/*
	 * Test des catactéristiques du 1er pokemon se trouvant dans 
	 * la base de données
	 */
	
	@Test
	public void testPokemonId1() {
		Pokemon poke = new Pokemon(1);
		ArrayList<Object> exp = putAll(100, 50, 50, 30);
		ArrayList<Object> res = putAll(poke.getHp(), poke.getAtt(), poke.getDef(), poke.getSpeed());
		assertEquals(exp, res);		
	}
	
	/*
	 * Test des catactéristiques du 4eme pokemon se trouvant dans 
	 * la base de données
	 */
	
	@Test
	public void testPokemonId4() {
		Pokemon poke = new Pokemon(4);
		ArrayList<Object> exp = putAll(30, 56, 35, 72);
		ArrayList<Object> res = putAll(poke.getHp(), poke.getAtt(), poke.getDef(), poke.getSpeed());
		assertEquals(exp, res);
	}
	
	/*
	 * Test des catactéristiques de la 1ere attaque se trouvant dans
	 * la base de données
	 */
	
	@Test
	public void testAttackId1() {
		Attack att = new Attack(1);
		ArrayList<Object> exp = putAll("lance-flammes", "feu", 100, 15);
		ArrayList<Object> res = putAll(att.getName(), att.getType(), att.getValue(), att.getPp());
		assertEquals(exp, res);
	}
	
	/*
	 * Test des catactéristiques de la 12eme attaque se trouvant dans
	 * la base de données
	 */
	
	@Test
	public void testAttackId12() {
		Attack att = new Attack(12);
		ArrayList<Object> exp = putAll("megaphone", "normal", 90, 15);
		ArrayList<Object> res = putAll(att.getName(), att.getType(), att.getValue(), att.getPp());
		assertEquals(exp, res);
	}
	
	public ArrayList<Object> putAll(Object... info) {
		ArrayList<Object> array = new ArrayList<Object>();
		for (int i = 0; i < info.length; i++) {
			array.add(info[i]);
		}
		return array;
	}
	
}
